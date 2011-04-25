package org.softlang.operations;

import java.io.IOException;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Mapper.Context;
import org.softlang.company.Department;
import org.softlang.company.Employee;

public class TotalMapper {
	/**
	 * Mapper that reads Employee objects and writes the queried Employee's salary.
	 */
	public static class EmployeeMapper extends Mapper<Text, Employee, Text, DoubleWritable>{
		private static String name;
		private static boolean allValues;
		
		protected void setup(Context context) throws IOException, InterruptedException {
			name = context.getConfiguration().get(Total.QUERIED_NAME);
			if(name.equals(Total.ALL))
				allValues = true;
				
		}
		
		protected void map(Text key, Employee value, Context context) throws IOException, InterruptedException {
			if(allValues || value.getName().toString().equals(name))
				context.write(value.getName(), value.getSalary());
		}
	}

	/**
	 * Mapper that reads Department objects and writes all Employee's salary for the queried Department.
	 */
	public static class DepartmentMapper extends Mapper<Text, Department, Text, DoubleWritable>{
		private static String name;
		private static boolean allValues;
		
		protected void setup(Context context) throws IOException, InterruptedException {
			name = context.getConfiguration().get(Total.QUERIED_NAME);
			if(name.equals(Total.ALL))
				allValues = true;
		}
		
		protected void map(Text key, Department value, Context context) throws IOException, InterruptedException {
			if(allValues || value.getName().toString().equals(name)){
				for(Employee e : value.getEmployees()){
					context.write(value.getName(), e.getSalary());
				}
			}	
		}
	}
	
	/**
	 * Mapper that reads Company objects and writes all Employee's salary for the
	 * queried Company.
	 */
	public static class CompanyMapper extends
			Mapper<Text, Employee, Text, DoubleWritable> {
		private static String name;
		private static boolean allValues;

		protected void setup(Context context) throws IOException,
				InterruptedException {
			name = context.getConfiguration().get(Total.QUERIED_NAME);
			if (name.equals(Total.ALL))
				allValues = true;
		}

		protected void map(Text key, Employee value, Context context)
				throws IOException, InterruptedException {
			if (allValues || value.getCompany().toString().equals(name))
				context.write(value.getCompany(), value.getSalary());
		}
	}
}
