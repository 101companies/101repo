package org.softlang.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="TB_101_COMPANY")
public class Company implements Subunit {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String name;

	@OneToMany(mappedBy="company")
	private List<Department> depts;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void setDepts(List<Department> depts) {
		this.depts = depts;
	}

	public List<Department> getDepts() {
		return depts;
	}
	
	public void cut() {
		for (Department dept : depts) {
			dept.cut();
		}
	}
	
	public double total() {
		double total = 0;
		for (Department dept : depts) {
			total += dept.total();
		}
		return total;
	}


}
