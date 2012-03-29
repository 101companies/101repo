package org.softlang.company;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.WritableComparable;

public class Company implements WritableComparable<Company> {

	private Text name;

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

	/**
	 * Read (say, deserialize) a company
	 */
	@Override
	public void readFields(DataInput in) throws IOException {
		name = new Text();
		name.readFields(in);

	}

	/**
	 * Write (say, serialize) an object.
	 */
	@Override
	public void write(DataOutput out) throws IOException {
		name.write(out);
	}

	@Override
	public int compareTo(Company that) {
		if (that.name.compareTo(this.name) != 0)
			return (that.name.compareTo(this.name)) > 0 ? 1 : -1;
		return 0;
	}

}
