package org.softlang.company;

/**
 * A person has a name and an address
 * 
 */
public class Person {

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
