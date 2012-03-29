package org.softlang.company.factory;

import org.softlang.company.Company;
import org.softlang.company.Department;
import org.softlang.company.Employee;

/**
 * The factory interface for constructing all possible company objects
 */
public interface Factory {
	Company mkCompany();
	Department mkDepartment();
	Employee mkEmployee();
}
