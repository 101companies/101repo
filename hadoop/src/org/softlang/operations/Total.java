package org.softlang.operations;

import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
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
import org.softlang.company.Department;
import org.softlang.company.Employee;




public class Total extends Configured{
	public static final String ALL = "uniko.all.values";
	public static final String QUERIED_NAME = "uniko.queried.name";
	
	/**
	 * Reducer that sums up all values for a given key.
	 */
	public static class TotalReducer extends Reducer<Text, DoubleWritable, Text, DoubleWritable>{
		
		protected void reduce(Text key, Iterable<DoubleWritable> values, Context context) throws IOException, InterruptedException {
			double total = 0;
			for(DoubleWritable value: values) {
				total += value.get();
			}
			context.write(key, new DoubleWritable(total));
		}	
	}
	
	public static Job createJob(Class<? extends Mapper> mapperClass, String name, String in, String out) throws IOException{
		Configuration conf = new Configuration();
		conf.set(QUERIED_NAME, name);
		Job job = Job.getInstance(new Cluster(conf), conf);
	    job.setJarByClass(Total.class);
	    
	    //in
	    if(!in.endsWith("/"))
			in = in.concat("/");
		if(mapperClass.equals(Department.class))
			in = in.concat("departments");
		else
			in = in.concat("employees");
	    SequenceFileInputFormat.addInputPath(job, new Path(in));
	    job.setInputFormatClass(SequenceFileInputFormat.class);
	    
	    //map
	    job.setMapperClass(mapperClass);
	    job.setMapOutputKeyClass(Text.class);
	    job.setMapOutputValueClass(DoubleWritable.class);
	    
	    //reduce
	    job.setCombinerClass(TotalReducer.class);
	    job.setReducerClass(TotalReducer.class);
	    	    
	    //out
	    SequenceFileOutputFormat.setOutputPath(job, new Path(out));
	    job.setOutputFormatClass(SequenceFileOutputFormat.class);
	    job.setOutputKeyClass(Text.class);		
	    job.setOutputValueClass(DoubleWritable.class);		
	    
	    return job;
	}
	
	public void total(Class<? extends Mapper> mapperClass, String name, String in, String out) throws Exception{
		Job job = createJob(mapperClass, name, in, out);
	    job.waitForCompletion(true);
	}	
	
	public static void printUsage() {
		System.out.println("Usage: Total <in> <out> [employee <name>]");
		System.out.println("Usage: Total <in> <out> [department <name>]");
		System.out.println("Usage: Total <in> <out> [company <name>]");
	    return;
	}
	
	public static void run(String[] args) throws Exception {
		if(args.length < 3){
			printUsage();
			System.exit(1);
		}
		String in = args[0];
		String out = args[1];
		Total t = new Total();
		
		String name = Total.ALL;
		if(args.length > 3)
			name = args[3];
		
		if(args[2].equals("employee")){
			t.total(TotalMapper.EmployeeMapper.class, name, in, out);
		}else if(args[2].equals("department")){
			t.total(TotalMapper.DepartmentMapper.class, name, in, out);
		}else if(args[2].equals("company")){
			t.total(TotalMapper.CompanyMapper.class, name, in, out);
		}else{
			printUsage();
		}
		
	}

	public static void main(String[] args) throws Exception {
		run(args);
	}
		
}
