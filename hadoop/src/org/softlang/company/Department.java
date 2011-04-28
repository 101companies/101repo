package org.softlang.company;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.BooleanWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.WritableComparable;

/**
 * A department has a name, a manager and a list of subunits
 * 
 */
public class Department implements WritableComparable<Department> {

	private Text name;
	private Text superDept;
	private Text company;

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

	public Text getSuperDept() {
		return superDept;
	}

	public void setSuperDept(Text superDept) {
		this.superDept = superDept;
	}

	public Text getCompany() {
		return company;
	}

	public void setCompany(Text company) {
		this.company = company;
	}

	/**
	 * Read (say, deserialize) a department
	 */
	@Override
	public void readFields(DataInput in) throws IOException {
		name = new Text();
		name.readFields(in);
		superDept = new Text();
		superDept.readFields(in);
		company = new Text();
		company.readFields(in);

	}

	/**
	 * Write (say, serialize) an department.
	 */
	@Override
	public void write(DataOutput out) throws IOException {
		name.write(out);
		if (superDept != null) {
			new BooleanWritable(true).write(out);
			superDept.write(out);
		} else {
			new BooleanWritable(false).write(out);
		}
		company.write(out);
	}

	@Override
	public int compareTo(Department that) {
		if (that.name.compareTo(this.name) != 0)
			return (that.name.compareTo(this.name)) > 0 ? 1 : -1;
		if (that.superDept.compareTo(this.superDept) != 0)
			return (that.superDept.compareTo(this.superDept)) > 0 ? 1 : -1;
		if (that.company != this.company)
			return (that.company.compareTo(this.company)) > 0 ? 1 : -1;
		return 0;
	}
}
