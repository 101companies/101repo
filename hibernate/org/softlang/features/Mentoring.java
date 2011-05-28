package org.softlang.features;

import org.softlang.company.*;

/**
 * Check constraints for mentoring
 */
public class Mentoring {

	public static boolean check(Company company) {
		for (Department dept : company.getDepts())
			if (!check(dept))
				return false;
		return true;
	}

	public static boolean check(Department dept) {
		for (Employee employee : dept.getEmployees())
			if (!check(employee))
				return false;
		for (Department subdept : dept.getSubdepts())
			if (!check(subdept))
				return false;
		return true;
	}

	public static boolean check(Employee employee) {
		return (    employee.getMentor() == null
				||  employee.getMentor() != employee 
				&& (employee.getMentor().getMentor() == null
				||  employee.getMentor().getMentor() != employee));	
	}

}
