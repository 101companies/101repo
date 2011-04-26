package org.softlang.company;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 * A company has a name and consists of (possibly nested) departments.
 */
public class Company implements Serializable {

	private static final long serialVersionUID = -200889592677165250L;
	private String name;
	private List<Department> depts = new LinkedList<Department>();

	/**
	 * Accept a void visitor
	 */
	public void accept(VoidVisitor v) { v.visit(this); }
	
	/**
	 * Accept a returning visitor
	 */
	public <R> R accept(ReturningVisitor<R> v) { return v.visit(this); }
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Department> getDepts() {
		return depts;
	}
}
