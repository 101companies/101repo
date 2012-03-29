package org.softlang.client.guiinfos.tree.comparators;

import java.util.Comparator;

import org.softlang.client.guiinfos.tree.DepartmentItem;

public class DepComparator implements Comparator<DepartmentItem> {

	@Override
	public int compare(DepartmentItem o1, DepartmentItem o2) {
		return o1.getId().compareTo(o2.getId());
	}

}
