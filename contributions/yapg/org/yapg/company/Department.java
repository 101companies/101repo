package org.yapg.company;
import java.util.*;
public class Department {
	public String dname;
	public Employee manager;
	public List<Department> subdepartments;
	public List<NonManager> employees;
}
