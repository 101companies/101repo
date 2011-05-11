package org.softlang.features;

import org.softlang.company.*;

/**
 * Get the company depth
 * 
 */
public class Depth {

	public static int depth(Company company) {
		int maxDepth = 0;
		for (Department dept : company.getDepts())
			maxDepth = 1 + Math.max(maxDepth, depth(dept));
		return maxDepth;
	}

	public static int depth(Department dept) {
		int maxDepth = 0;
		for (Department subDepartment : dept.getSubDepartments())
			maxDepth = 1 + Math.max(maxDepth, depth(subDepartment));
		return maxDepth;
	}

}
