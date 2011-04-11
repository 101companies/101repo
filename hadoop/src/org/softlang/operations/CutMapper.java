package org.softlang.operations;

import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Mapper.Context;
import org.softlang.company.Department;
import org.softlang.company.Employee;

public class CutMapper {

	/**
	 * Mapper that reads Employee objects and writes the queried Employee's salary.
	 */
	public static class EmployeeMapper extends Mapper<Text, Employee, Text, Employee>{
		private static String name;
		private static boolean allValues;
		
		protected void setup(Context context) throws IOException, InterruptedException {
			name = context.getConfiguration().get(Total.QUERIED_NAME);
			if(name.equals(Total.ALL))
				allValues = true;
				
		}
		
		protected void map(Text key, Employee value, Context context) throws IOException, InterruptedException {
			if(allValues || value.getName().toString().equals(name))
				value.setSalary(value.getSalary().get()/2);
			//copy all Employees
			context.write(key, value);
		}
	}

	/**
	 * Mapper that reads Department objects and writes all Employee's salary for the queried Department.
	 */
	public static class DepartmentMapper extends Mapper<Text, Department, Text, Department>{
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
					e.setSalary(e.getSalary().get()/2);
				}
			}	
			//copy all Departments
			context.write(value.getName(), value);
		}
	}
	
	/**
	 * Mapper that reads Company objects and writes all Employee's salary for the queried Company.
	 */
	public static class CompanyMapper extends Mapper<Text, Employee, Text, Employee>{
		private static String name;
		private static boolean allValues;
		
		protected void setup(Context context) throws IOException, InterruptedException {
			name = context.getConfiguration().get(Total.QUERIED_NAME);
			if(name.equals(Total.ALL))
				allValues = true;
		}
		
		protected void map(Text key, Employee value, Context context) throws IOException, InterruptedException {
			if(allValues || value.getCompany().toString().equals(name))
				value.setSalary(value.getSalary().get()/2);
			//copy all Employees
			context.write(key, value);
		}
	}	
}
