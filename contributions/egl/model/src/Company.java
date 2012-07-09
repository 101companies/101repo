public class Company {

	public Set<Department> getDepartments() { return null; }
	
	public void cutSalary() {
		for (Department d : getDepartments()) {
			d.cutSalary();
		}
	}
}
