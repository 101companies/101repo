public class Department {
	public Employee getManager() { return null; }
	public Set<Employee> getEmployees() { return null; }
	
	public void cutSalary() {
		getManager().cutSalary();
		for (Employee e: getEmployees()) {
			e.cutSalary();
		}
	}
}
