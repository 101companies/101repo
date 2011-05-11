package org.softlang.company;

import org.softlang.util.SimpleFlaggedList;
import org.softlang.util.ObjectFactory;

/**
 * A department has a name, a manager and a list of subunits
 * 
 */
public class Department implements Persistable {

	private int deptid;
	private String name;
	private Employee manager;
	private SimpleFlaggedList<Department> subDepartments;
	private SimpleFlaggedList<Employee> employees;
	private boolean changed;
	private boolean loaded;
	private ObjectFactory objectFactory;

	public Department() {
		deptid = 0;
		subDepartments = new SimpleFlaggedList<Department>();
		employees = new SimpleFlaggedList<Employee>();
		changed = true;
		loaded = true;
	}

	public Department(int deptid) {
		this.deptid = deptid;
		subDepartments = new SimpleFlaggedList<Department>();
		employees = new SimpleFlaggedList<Employee>();
		loaded = false;
	}

	public ObjectFactory getObjectFactory() {
		return objectFactory;
	}

	public void setObjectFactory(ObjectFactory objectFactory) {
		this.objectFactory = objectFactory;
	}

	public void setLoaded(boolean loaded) {
		this.loaded = loaded;
	}

	public void load() {
		if (objectFactory != null && !loaded) {
			objectFactory.loadDept(this);
			loaded = true;
		}
	}

	public int getDeptid() {
		return deptid;
	}

	public void setDeptid(int deptid) {
		if (this.deptid == 0)
			this.deptid = deptid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		changed = true;
	}

	public Employee getManager() {
		manager.load();
		return manager;
	}

	public void setManager(Employee manager) {
		if (this.manager != null)
			this.manager.setChanged(true);
		this.manager = manager;
		changed = true;
		manager.setChanged(true);
	}

	public SimpleFlaggedList<Department> getSubDepartments() {
		return subDepartments;
	}

	public SimpleFlaggedList<Employee> getEmployees() {
		return employees;
	}

	public void setChanged(boolean changed) {
		this.changed = true;
	}

	public boolean isChanged() {
		if (this.changed)
			return true;
		if (employees.isChanged() || subDepartments.isChanged())
			return true;
		for (Employee employee : employees)
			if (employee.isChanged())
				return true;
		for (Department dept : subDepartments)
			if (dept.isChanged())
				return true;
		return false;
	}

	@Override
	public boolean equals(Object o) {
		Department otherDept = (Department) o;
		if (!this.getName().equals(otherDept.getName())
				|| !this.getManager().equals(otherDept.getManager())
				|| this.getSubDepartments().size() != otherDept
						.getSubDepartments().size()
				|| this.getEmployees().size() != otherDept.getEmployees()
						.size())
			return false;
		for (int i = 0; i < this.getSubDepartments().size(); i++)
			if (!this.getSubDepartments().get(i)
					.equals(otherDept.getSubDepartments().get(i)))
				return false;
		for (int i = 0; i < this.getEmployees().size(); i++)
			if (!this.getEmployees().get(i)
					.equals(otherDept.getEmployees().get(i)))
				return false;
		return true;
	}
}
