package org.softlang.features;

import org.softlang.company.*;

public aspect Depth {

	public int Company.depth() {
		int depth = 0;
		for (Department d : getDepts())
			depth = Math.max(depth, d.depth());
		return depth;
	}

	public int Department.depth() {
		int depth = 0;
		for (Department d : getSubdepts())
			depth = Math.max(depth, d.depth());
		return ++depth;
	}

	public int Employee.depth() {
		return 0;
	}

}
