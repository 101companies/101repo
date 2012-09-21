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
import org.softlang.company.Employee;

public class Total extends Configured {
	public static final String QUERIED_NAME = "uniko.queried.name";

	/**
	 * Mapper that reads Employee objects and writes all Employee's salary for the
	 * queried Company.
	 */
	public static class TotalMapper extends
			Mapper<Text, Employee, Text, DoubleWritable> {
		private static String name;

		protected void setup(Context context) throws IOException,
				InterruptedException {
			name = context.getConfiguration().get(Total.QUERIED_NAME);
		}

		protected void map(Text key, Employee value, Context context)
				throws IOException, InterruptedException {
			if (value.getCompany().toString().equals(name))
				context.write(value.getCompany(), value.getSalary());
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

	public static void total(String name, String in, String out)
			throws IOException, InterruptedException, ClassNotFoundException {
		Configuration conf = new Configuration();
		conf.set(QUERIED_NAME, name);
		Job job = Job.getInstance(new Cluster(conf), conf);
		job.setJarByClass(Total.class);

		// in
		if (!in.endsWith("/"))
			in = in.concat("/");
		in = in.concat("employees");
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

		job.waitForCompletion(true);
	}

	public static void printUsage() {
		System.out.println("Usage: Total <in> <out> <company name>");
		return;
	}

	public static void run(String[] args) throws Exception {
		if (args.length < 3) {
			printUsage();
			System.exit(1);
		}
		String in = args[0];
		String out = args[1];
		String name = args[3];

		total(name, in, out);

	}

	public static void main(String[] args) throws Exception {
		run(args);
	}

}
