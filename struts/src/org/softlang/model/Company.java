package org.softlang.model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class Company implements Serializable {

	private static final long serialVersionUID = -200889592677165250L;
	private String name;
	private List<Dept> depts;

	public Company() {
		depts = new LinkedList<Dept>();
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

	public List<Dept> getDepts() {
		return depts;
	}

	public Double total() {
		double total = 0;
		for (Dept d : getDepts())
			total += d.total();
		return total;
	}

	public void cut() {
		for (Dept d : getDepts())
			d.cut();
	}
}
