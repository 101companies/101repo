package org.softlang.company;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.SequenceFile;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.WritableComparable;

public class Company implements WritableComparable<Company> {

	private Text name;
	private List<Department> depts;

	public Company() {
		depts = new LinkedList<Department>();
	}

	public Text getName() {
		return name;
	}

	public void setName(Text name) {
		this.name = name;
	}

	public void setName(String name) {
		if (this.name == null)
			this.name = new Text();
		this.name.set(name);
	}

	public List<Department> getDepts() {
		return depts;
	}

	/**
	 * Read (say, deserialize) a company
	 */
	@Override
	public void readFields(DataInput in) throws IOException {
		name = new Text();
		name.readFields(in);
		depts = new LinkedList<Department>();
		int noDepts = in.readInt();
		for (int i = 0; i < noDepts; i++) {
			Department dpt = new Department();
			dpt.readFields(in);
			depts.add(dpt);
		}
	}

	/**
	 * Write (say, serialize) an object.
	 */
	@Override
	public void write(DataOutput out) throws IOException {
		name.write(out);
		out.writeInt(depts.size());
		for (int i = 0; i < depts.size(); i++) {
			depts.get(i).write(out);
		}
	}

	@Override
	public int compareTo(Company that) {
		if (that.name.compareTo(this.name) != 0)
			return (that.name.compareTo(this.name)) > 0 ? 1 : -1;
		if (that.depts.size() != this.depts.size())
			return (that.depts.size() - this.depts.size()) > 0 ? 1 : -1;
		for (int i = 0; i < this.depts.size(); i++) {
			if (that.depts.get(i).compareTo(this.depts.get(i)) != 0)
				return (that.depts.get(i).compareTo(this.depts.get(i))) > 0 ? 1 : -1;
		}
		return 0;
	}

	/**
	 * Write (say, serialize) this Company object to disk, along with all its
	 * corresponding Departments and Employees.
	 */
	public void writeObject(String filename) {

		Configuration conf = new Configuration();
		FileSystem fs;

		Path companyFile = new Path(filename + "/companies");
		Path departmentFile = new Path(filename + "/departments");
		Path employeeFile = new Path(filename + "/employees");

		try {
			fs = companyFile.getFileSystem(conf);
			SequenceFile.Writer companyWriter = SequenceFile.createWriter(fs, conf,
					companyFile, Text.class, Company.class);
			companyWriter.append(this.getName(), this);
			companyWriter.close();

			SequenceFile.Writer departmentWriter = SequenceFile.createWriter(fs,
					conf, departmentFile, Text.class, Department.class);
			Set<Employee> employeeSet = new HashSet<Employee>();
			for (Department d : this.getDepts()) {
				departmentWriter.append(d.getName(), d);
				d.getEmployeesRecursive(employeeSet); // in case the same employee is
																							// assigned to different
																							// departments
			}
			departmentWriter.close();

			SequenceFile.Writer employeeWriter = SequenceFile.createWriter(fs, conf,
					employeeFile, Text.class, Employee.class);
			for (Employee e : employeeSet) {
				employeeWriter.append(e.getName(), e);
			}
			employeeWriter.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static Company readObject(String filename) {

		Configuration conf = new Configuration();
		FileSystem fs;

		Path companyFile = new Path(filename + "/companies");
		Path departmentFile = new Path(filename + "/departments");
		Path employeeFile = new Path(filename + "/employees");

		try {
			fs = companyFile.getFileSystem(conf);
			SequenceFile.Reader companyReader = new SequenceFile.Reader(fs,
					companyFile, conf);
			Company retVal = new Company();
			companyReader.next(new Text(), retVal);
			return retVal;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
