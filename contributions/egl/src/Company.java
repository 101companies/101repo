import java.util.Set;

public class Company {

	public Set<Department> getDepartments() {
		return RefDepartments.get(this);
	}

	public void cutSalary() {
		for (Department d : getDepartments()) {
			d.cutSalary();
		}
	}

	public void addToDepartments(Department departments) {
		RefDepartments.add(this, departments);
	}

	public void removeFromDepartments(Department departments) {
		RefDepartments.remove(this, departments);
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
