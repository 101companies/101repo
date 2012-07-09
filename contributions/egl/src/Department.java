import java.util.Set;

public class Department {

	public Employee getManager() {
		return manager;
	}

	public Set<Employee> getEmployees() {
		return RefEmployees.get(this);
	}

	public void cutSalary() {
		getManager().cutSalary();
		for (Employee e : getEmployees()) {
			e.cutSalary();
		}
	}

	private Employee manager;

	public void setManager(Employee manager) {
		this.manager = manager;
	}

	public void addToEmployees(Employee employees) {
		RefEmployees.add(this, employees);
	}

	public void removeFromEmployees(Employee employees) {
		RefEmployees.remove(this, employees);
	}

	public Set<Department> getSubdepartments() {
		return RefSubdepartments.get(this);
	}

	public void addToSubdepartments(Department subdepartments) {
		RefSubdepartments.add(this, subdepartments);
	}

	public void removeFromSubdepartments(Department subdepartments) {
		RefSubdepartments.remove(this, subdepartments);
	}

	private java.lang.String name;

	public java.lang.String getName() {
		return name;
	}

	public void setName(java.lang.String name) {
		this.name = name;
	}

	private float totalSalary;

	public float getTotalSalary() {
		return totalSalary;
	}

}
