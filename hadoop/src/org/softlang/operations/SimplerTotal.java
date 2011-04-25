package org.softlang.operations;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Cluster;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.SequenceFileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.SequenceFileOutputFormat;
import org.softlang.company.Company;
import org.softlang.company.Department;
import org.softlang.company.Employee;

public class SimplerTotal extends Configured {
	public static final String ALL = "uniko.all.values";
	public static final String QUERIED_NAME = "uniko.queried.name";

	/**
	 * Mapper that reads Company objects and writes all Employee's salary for the
	 * queried Company.
	 */
	public static class TotalMapper extends
			Mapper<Text, Company, Text, DoubleWritable> {

		private void writeEmployees(Text companyName, Department d, Context context)
				throws IOException, InterruptedException {
			context.write(companyName, d.getManager().getSalary());
			// System.out.println("manager: " + d.getManager().getSalary());
			for (Employee e : d.getEmployees()) {
				context.write(companyName, e.getSalary());
				// System.out.println("employee: " + e.getSalary());
			}
			for (Department subDept : d.getSubdepts()) {
				writeEmployees(companyName, subDept, context);
			}
		}

		protected void map(Text key, Company value, Context context)
				throws IOException, InterruptedException {
			for (Department d : value.getDepts()) {
				writeEmployees(value.getName(), d, context);
			}
		}
	}

	/**
	 * Reducer that sums up all values for a given key.
	 */
	public static class TotalReducer extends
			Reducer<Text, DoubleWritable, Text, DoubleWritable> {

		protected void reduce(Text key, Iterable<DoubleWritable> values,
				Context context) throws IOException, InterruptedException {
			double total = 0;
			for (DoubleWritable value : values) {
				total += value.get();
			}
			context.write(key, new DoubleWritable(total));
		}
	}

	public static Job createJob(String in, String out) throws IOException {
		Configuration conf = new Configuration();
		Job job = Job.getInstance(new Cluster(conf), conf);
		job.setJarByClass(SimplerTotal.class);

		// in
		SequenceFileInputFormat.addInputPath(job, new Path(in));
		job.setInputFormatClass(SequenceFileInputFormat.class);

		// map
		job.setMapperClass(TotalMapper.class);
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(DoubleWritable.class);

		// reduce
		job.setCombinerClass(TotalReducer.class);
		job.setReducerClass(TotalReducer.class);

		// out
		SequenceFileOutputFormat.setOutputPath(job, new Path(out));
		job.setOutputFormatClass(SequenceFileOutputFormat.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(DoubleWritable.class);

		return job;
	}

	public void total(String in, String out) throws Exception {
		Job job = createJob(in, out);
		job.waitForCompletion(true);
	}

	public static void printUsage() {
		System.out.println("Usage: Total <in> <out>");
		return;
	}

	public static void run(String[] args) throws Exception {
		if (args.length < 2) {
			printUsage();
			System.exit(1);
		}
		String in = args[0];
		String out = args[1];
		SimplerTotal t = new SimplerTotal();

		t.total(in, out);

	}

	public static void main(String[] args) throws Exception {
		run(args);
	}

}
