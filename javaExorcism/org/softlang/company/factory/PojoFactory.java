package org.softlang.company.factory;

import org.softlang.company.*;
import org.softlang.company.impl.pojo.*;

/**
 * A factory that constructs POJPs
 */
public class PojoFactory implements Factory {
	public Company mkCompany() { return new CompanyImpl(); }
	public Department mkDepartment() { return new DepartmentImpl(); }
	public Employee mkEmployee() { return new EmployeeImpl(); }
}
