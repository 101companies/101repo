public class Employee {
	public float getSalary() { return 0; }
	public void setSalary(float salary) {}
	
	public void cutSalary() {
		setSalary (getSalary() / 2);
	}
}
