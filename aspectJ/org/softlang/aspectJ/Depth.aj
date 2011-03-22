package org.softlang.aspectJ;

import org.softlang.company.*;

public aspect Depth {

	public int Company.depth() {
		int depth = 0;
		if (getDepts().size() != 0) {
			for (Department dept : getDepts())
				depth = Math.max(depth, dept.depth());
		}
		return depth;
	}

	public abstract int Subunit.depth();

	public int Department.depth() {
		int depth = 0;
		if (getSubunits().size() != 0) {
			for (Subunit subunit : getSubunits())
				depth = Math.max(depth, subunit.depth());
		}
		return ++depth;
	}

	public int Employee.depth() {
		return 0;
	}

}
