package org.softlang.server.company;

import java.io.Serializable;

/**
 * A person has a name and an address
 * 
 */
public class Person implements Serializable {

	private static final long serialVersionUID = -200889592677165150L;

	private String name;
	private String address;

	public Person() {
		name = "";
		address = "";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
