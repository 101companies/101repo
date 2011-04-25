package org.softlang.operations;

import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.mapreduce.Cluster;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.SequenceFileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.SequenceFileOutputFormat;
import org.softlang.company.Company;
import org.softlang.company.Department;
import org.softlang.company.Employee;
import org.softlang.operations.Total.TotalReducer;

public class SimplerCut extends Configured {

	public static final Log LOG = LogFactory.getLog(SimplerCut.class);

	/**
	 * Cuts the salary for each {@link Employee} in a {@link Department}.
	 * Recursively called for each sub-department.
	 * 
	 * @param dept
	 */
	private static void cutDept(Department dept) {
		cutEmpl(dept.getManager());
		for (Employee e : dept.getEmployees()) {
			cutEmpl(e);
		}
		for (Department subDept : dept.getSubdepts()) {
			cutDept(subDept);
		}
	}

	/**
	 * Cuts the salary of this {@link Employee}.
	 * 
	 * @param e
	 */
	private static void cutEmpl(Employee e) {
		e.setSalary(e.getSalary().get() / 2);
	}

	/**
	 * Mapper that reads Company objects and writes all Employee's salary for the
	 * queried Company.
	 */
	public static class CutMapper extends Mapper<Text, Company, Text, Company> {
		protected void map(Text key, Company value, Context context)
				throws IOException, InterruptedException {
			for (Department d : value.getDepts()) {
				cutDept(d);
			}
			context.write(key, value);
		}
	}

	public static Job createJob(String in, String out) throws IOException {
		Configuration conf = new Configuration();
		Job job = Job.getInstance(new Cluster(conf), conf);
		job.setJarByClass(SimplerCut.class);

		// in
		SequenceFileInputFormat.addInputPath(job, new Path(in));
		job.setInputFormatClass(SequenceFileInputFormat.class);

		// map
		job.setMapperClass(CutMapper.class);
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(Company.class);

		// out
		SequenceFileOutputFormat.setOutputPath(job, new Path(out + "/tmp"));
		job.setOutputFormatClass(SequenceFileOutputFormat.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(Company.class);

		return job;
	}

	public void cut(String in, String out) throws Exception {
		Job job = createJob(in, out);
		job.setNumReduceTasks(0);
		boolean success = job.waitForCompletion(true);

		if (success) {
			// replace input with output
			Path output = FileOutputFormat.getOutputPath(job);
			FileSystem fs = output.getFileSystem(job.getConfiguration());
			Path[] inputs = FileInputFormat.getInputPaths(job);
			for (int i = 0; i < inputs.length; i++) {
				fs.delete(inputs[i], true);
			}
			fs.rename(output, inputs[0]);
		}
	}

	public static void printUsage() {
		System.out.println("Usage: Cut <in>");
		return;
	}

	public static void run(String[] args) throws Exception {
		if (args.length < 2) {
			printUsage();
			System.exit(1);
		}
		String in = args[0];
		String out = args[0];
		SimplerCut c = new SimplerCut();

		String name = Total.ALL;
		if (args.length > 3)
			name = args[3];

		c.cut(in, out);

	}

	public static void main(String[] args) throws Exception {
		run(args);
	}

}
