package org.softlang.aspectJ;

import org.softlang.company.*;

public aspect Depth {

	public int Company.depth() {
		int depth = 0;
		if (getDepts().size() != 0) {
			for (Department dept : getDepts())
				depth = Math.max(depth, dept.depth());
			depth++;
		}
		return depth;
	}

	public int Department.depth() {
		int depth = 0;
		if (getSubunits().size() != 0) {
			for (Subunit subunit : getSubunits())
				depth = Math.max(depth, subunit.depth());
		}
		return depth;
	}

	public int Subunit.depth() {
		if (getDu() != null)
			return getDu().depth() + 1;
		return 0;
	}

}
