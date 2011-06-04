package org.softlang.company.factory;

import org.softlang.company.*;
import org.softlang.company.impl.bean.*;

/**
 * A factory that constructs (a kind of) "beans" as opposed to POJPs
 */
public class BeanFactory implements Factory {
	public Company mkCompany() { return new CompanyImpl(); }
	public Department mkDepartment() { return new DepartmentImpl(); }
	public Employee mkEmployee() { return new EmployeeImpl(); }
}
