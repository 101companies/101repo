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
import org.softlang.company.Department;
import org.softlang.company.Employee;
import org.softlang.operations.Total.TotalReducer;




public class Cut extends Configured{
	
	public static final Log LOG = LogFactory.getLog(Cut.class);
	
	private static Class<? extends WritableComparable<?>> getOutputFormat(Class<? extends Mapper> mapperClass) {
		if(mapperClass.equals(CutMapper.DepartmentMapper.class)){
			return Department.class;
		}else{
			return Employee.class;
		}
	}
	
	public static Job createJob(Class<? extends Mapper> mapperClass, String name, String in, String out) throws IOException{
		Configuration conf = new Configuration();
		conf.set(Total.QUERIED_NAME, name);
		Job job = Job.getInstance(new Cluster(conf), conf);
	    job.setJarByClass(Total.class);
	    
	    Class<? extends WritableComparable<?>> outputFormat = getOutputFormat(mapperClass);
	    
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
	    job.setMapOutputValueClass(outputFormat);
	    
	    //reduce
	    job.setCombinerClass(TotalReducer.class);
	    job.setReducerClass(TotalReducer.class);
	    	    
	    //out
	    SequenceFileOutputFormat.setOutputPath(job, new Path(out + "/tmp"));
	    job.setOutputFormatClass(SequenceFileOutputFormat.class);
	    job.setOutputKeyClass(Text.class);		
	    job.setOutputValueClass(outputFormat);		
	    
	    return job;
	}
	
	public void cut(Class<? extends Mapper> mapperClass, String name, String in, String out) throws Exception{
		Job job = createJob(mapperClass, name, in, out);
		job.setNumReduceTasks(0);
	    boolean success = job.waitForCompletion(true);
	    
	    if(success){
	    	//replace input with output
	    	Path output = FileOutputFormat.getOutputPath(job);
	    	FileSystem fs = output.getFileSystem(job.getConfiguration());
	    	Path[] inputs = FileInputFormat.getInputPaths(job);
	    	for(int i = 0; i < inputs.length; i++){
	    		fs.delete(inputs[i], true);
	    	}
	    	fs.rename(output, inputs[0]);
	    }
	}	
	
	public static void printUsage() {
		System.out.println("Usage: Cut <in> [employee <name>]");
		System.out.println("Usage: Cut <in> [department <name>]");
		System.out.println("Usage: Cut <in> [company <name>]");
	    return;
	}
	
	public static void run(String[] args) throws Exception {
		if(args.length < 2){
			printUsage();
			System.exit(1);
		}
		String in = args[0];
		String out = args[0];
		Cut c = new Cut();
		
		String name = Total.ALL;
		if(args.length > 3)
			name = args[3];
		
		if(args[2].equals("employee")){
			c.cut(CutMapper.EmployeeMapper.class, name, in, out);
		}else if(args[2].equals("department")){
			c.cut(CutMapper.DepartmentMapper.class, name, in, out);
		}else if(args[2].equals("company")){
			c.cut(CutMapper.CompanyMapper.class, name, in, out);
		}else{
			printUsage();
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		run(args);
	}
	
}
