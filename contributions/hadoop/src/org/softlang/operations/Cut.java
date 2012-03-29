package org.softlang.operations;

import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Cluster;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.SequenceFileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.SequenceFileOutputFormat;
import org.softlang.company.Employee;

public class Cut extends Configured {

	public static final Log LOG = LogFactory.getLog(Cut.class);

	/**
	 * Mapper that reads Employee objects and cuts and writes all Employee's
	 * salary for the queried Company.
	 */
	public static class CutMapper extends Mapper<Text, Employee, Text, Employee> {
		private static String name;

		protected void setup(Context context) throws IOException,
				InterruptedException {
			name = context.getConfiguration().get(Total.QUERIED_NAME);
		}

		protected void map(Text key, Employee value, Context context)
				throws IOException, InterruptedException {
			if (value.getCompany().toString().equals(name))
				value.setSalary(value.getSalary().get() / 2);
			// copy all Employees
			context.write(key, value);
		}
	}

	public static Job createJob(String name, String base) throws IOException {
		Configuration conf = new Configuration();
		conf.set(Total.QUERIED_NAME, name);
		Job job = Job.getInstance(new Cluster(conf), conf);
		job.setJarByClass(Cut.class);

		// in
		String in = base;
		if (!base.endsWith("/"))
			in = in.concat("/");
		in = in.concat("employees");
		SequenceFileInputFormat.addInputPath(job, new Path(in));
		job.setInputFormatClass(SequenceFileInputFormat.class);

		// map
		job.setMapperClass(CutMapper.class);
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(Employee.class);

		// out
		SequenceFileOutputFormat.setOutputPath(job, new Path(base + "/tmp"));
		job.setOutputFormatClass(SequenceFileOutputFormat.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(Employee.class);

		return job;
	}

	public static void cut(String name, String in) throws Exception {
		Job job = createJob(name, in);
		job.setNumReduceTasks(0);
		boolean success = job.waitForCompletion(true);

		if (success) {
			// MapReduce reads an input and writes the result to an new location.
			// Hence it can not modify data in place, and we have to replace the input
			// with the output
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
		System.out.println("Usage: Cut <in> [<company name>]");
		return;
	}

	public static void run(String[] args) throws Exception {
		if (args.length < 2) {
			printUsage();
			System.exit(1);
		}
		cut(args[0], args[1]);

	}

	public static void main(String[] args) throws Exception {
		run(args);
	}

}
