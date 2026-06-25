package org.softlang.features;

import org.softlang.company.*;

/**
 * Check constraints for mentoring
 */
public class Mentoring {

	public static boolean check(Company company) {
		return company.getDepts().stream().allMatch(Mentoring::check);
	}

	public static boolean check(Department dept) {
		return dept.getEmployees().stream().allMatch(Mentoring::check)
		& dept.getSubdepts().stream().allMatch(Mentoring::check);
	}

	public static boolean check(Employee employee) {
		return (    employee.getMentor() == null
				||  employee.getMentor() != employee 
				&& (employee.getMentor().getMentor() == null
				||  employee.getMentor().getMentor() != employee));	
	}

}
