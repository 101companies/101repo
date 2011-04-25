package org.softlang.company;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.WritableComparable;

/**
 * A department has a name, a manager and a list of subunits
 * 
 */
public class Department implements WritableComparable<Department> {

	private Text name;
	private Employee manager;
	private List<Department> subdepts;
	private List<Employee> employees;

	public Department() {
		subdepts = new LinkedList<Department>();
		employees = new LinkedList<Employee>();
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

	public Employee getManager() {
		return manager;
	}

	public void setManager(Employee manager) {
		this.manager = manager;
	}

	public List<Department> getSubdepts() {
		return subdepts;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public Set<Employee> getEmployeesRecursive(Set<Employee> set) {
		set.addAll(employees);
		set.add(manager);
		for (Department d : subdepts) {
			d.getEmployeesRecursive(set);
		}
		return set;
	}

	/**
	 * Read (say, deserialize) a department
	 */
	@Override
	public void readFields(DataInput in) throws IOException {
		name = new Text();
		name.readFields(in);
		manager = new Employee();
		manager.readFields(in);

		subdepts = new LinkedList<Department>();
		int noSubDepts = in.readInt();
		for (int i = 0; i < noSubDepts; i++) {
			Department subDept = new Department();
			subDept.readFields(in);
			subdepts.add(subDept);
		}

		employees = new LinkedList<Employee>();
		int noEmployees = in.readInt();
		for (int i = 0; i < noEmployees; i++) {
			Employee e = new Employee();
			e.readFields(in);
			employees.add(e);
		}

	}

	/**
	 * Write (say, serialize) an department.
	 */
	@Override
	public void write(DataOutput out) throws IOException {
		name.write(out);
		manager.write(out);

		out.writeInt(subdepts.size());
		for (int i = 0; i < subdepts.size(); i++) {
			subdepts.get(i).write(out);
		}

		out.writeInt(employees.size());
		for (int i = 0; i < employees.size(); i++) {
			employees.get(i).write(out);
		}
	}

	@Override
	public int compareTo(Department that) {
		if (that.name.compareTo(this.name) != 0)
			return (that.name.compareTo(this.name)) > 0 ? 1 : -1;
		if (that.manager.compareTo(this.manager) != 0)
			return (that.manager.compareTo(this.manager)) > 0 ? 1 : -1;

		if (that.subdepts.size() != this.subdepts.size())
			return (that.subdepts.size() - this.subdepts.size()) > 0 ? 1 : -1;
		for (int i = 0; i < this.subdepts.size(); i++) {
			if (that.subdepts.get(i).compareTo(this.subdepts.get(i)) != 0)
				return (that.subdepts.get(i).compareTo(this.subdepts.get(i))) > 0 ? 1
						: -1;
		}

		if (that.employees.size() != this.employees.size())
			return (that.employees.size() - this.employees.size()) > 0 ? 1 : -1;
		for (int i = 0; i < this.employees.size(); i++) {
			if (that.employees.get(i).compareTo(this.employees.get(i)) != 0)
				return (that.employees.get(i).compareTo(this.employees.get(i))) > 0 ? 1
						: -1;
		}
		return 0;
	}
}
