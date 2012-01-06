package org.softlang.client.guiinfos.tree.comparators;

import java.util.Comparator;

import org.softlang.client.guiinfos.tree.EmployeeItem;

public class EmpComparator implements Comparator<EmployeeItem>{

	@Override
	public int compare(EmployeeItem o1, EmployeeItem o2) {
		return o1.getId().compareTo(o2.getId());
	}

}
