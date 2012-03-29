package org.softlang.company;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class Company extends Basic implements Serializable {

	private static final long serialVersionUID = -200889592677165250L;
	private String name;
	private List<Department> depts;

	public Company() {
		depts = new LinkedList<Department>();
	}

	/**
	 * Read (say, deserialize) a company
	 */
	public static Company readObject(String filename) {

		Object o = null;

		try {
			FileInputStream fis = new FileInputStream(filename);
			ObjectInputStream in = new ObjectInputStream(fis);
			o = in.readObject();
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return (Company) o;
	}

	/**
	 * Write (say, serialize) an object.
	 */
	public boolean writeObject(String filename) {

		FileOutputStream fos = null;
		ObjectOutputStream out = null;

		try {
			fos = new FileOutputStream(filename);
			out = new ObjectOutputStream(fos);
			out.writeObject(this);
			out.close();
			return true;
		} catch (IOException ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Department> getDepts() {
		return depts;
	}
	
	/**
	 * This method returns the name for the tree-view.
	 */
	@Override
	public String toString(){
		return this.getName();
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.softlang.company.Basic#isCompany()
	 */
	@Override
	public boolean isCompany() {
		return true;
	}
}
