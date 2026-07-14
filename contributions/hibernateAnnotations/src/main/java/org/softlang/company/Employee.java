package org.softlang.company;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * An employee has a name, an address, and a salary.  
 */
@Entity
@Table(name="employee")
public class Employee {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="address")
	private String address;
	
	@Column(name="salary")
	private double salary;
	
	@Column(name="manager")
	private boolean manager;
	
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="mentor")
	private Employee mentor;

	public long getId() {
		return id;
	}

	@SuppressWarnings("unused")
	private void setId(long id) {
		this.id = id;
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

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public boolean getManager() {
		return manager;
	}

	public void setManager(boolean manager) {
		this.manager = manager;
	}
	
	public Employee getMentor() {
		return mentor;
	}
	
	public void setMentor(Employee mentor) {
		this.mentor = mentor;
	}
}
