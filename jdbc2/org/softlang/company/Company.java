package org.softlang.company;

import org.softlang.util.ObjectFactory;
import org.softlang.util.SimpleFlaggedList;

/**
 * A company is a list of departments
 * 
 */
public class Company implements Persistable {

	private int companyid;
	private String name;
	private SimpleFlaggedList<Department> depts;
	private boolean changed;
	private boolean loaded;
	private ObjectFactory objectFactory;

	public Company(String name) {
		this.name = name;
		depts = new SimpleFlaggedList<Department>();
		changed = true;
	}

	public ObjectFactory getObjectFactory() {
		return objectFactory;
	}

	public void setObjectFactory(ObjectFactory objectFactory) {
		this.objectFactory = objectFactory;
	}

	public void setLoaded(boolean loaded) {
		this.loaded = loaded;
	}

	public void load() {
		if (objectFactory != null && !loaded) {
			objectFactory.loadCompany(this);
			loaded = true;
		}
	}

	public int getCompanyid() {
		return companyid;
	}

	public void setCompanyid(int companyid) {
		if (this.companyid == 0)
			this.companyid = companyid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		changed = true;
	}

	public SimpleFlaggedList<Department> getDepts() {
		return depts;
	}

	public void setChanged(boolean changed) {
		this.changed = true;
	}

	public boolean isChanged() {
		if (this.changed)
			return true;
		boolean deptsChanged = depts.isChanged();
		if (deptsChanged)
			return true;
		for (Department dept : depts)
			if (dept.isChanged())
				return true;
		return false;
	}

	public boolean equals(Object o) {
		Company otherCompany = (Company) o;
		if (!this.getName().equals(otherCompany.getName())
				|| this.getDepts().size() != otherCompany.getDepts().size())
			return false;
		for (int i = 0; i < this.getDepts().size(); i++)
			if (!this.getDepts().get(i).equals(otherCompany.getDepts().get(i)))
				return false;
		return true;
	}
}
