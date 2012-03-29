package org.softlang.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.softlang.company.Company
import org.softlang.company.Department
import org.softlang.company.Employee

class Basics {
	
	// demo company
	Company meganalysis

	@Before
	public void setUp() throws Exception {
		Employee craig = new Employee(name:"Craig", address:"Redmond", salary:123456)
		Employee erik = new Employee(name:"Erik", address:"Utrecht", salary:12345)
		Employee ralf = new Employee(name:"Ralf", address:"Koblenz", salary:1234)
		Employee ray = new Employee(name:"Ray", address:"Redmond", salary:234567)
		Employee klaus = new Employee(name:"Klaus", address:"Boston", salary:23456)
		Employee karl = new Employee(name:"Karl", address:"Riga", salary:2345)
		Employee joe = new Employee(name:"Joe", address:"Wifi City", salary:2344)
		
		Department research = new Department(name:"Research", manager:craig)
		research.employees.add erik
		research.employees.add ralf
		
		Department dev11 = new Department(name:"Dev11", manager:karl)
		dev11.employees.add joe
		
		Department dev1 = new Department(name:"Dev1", manager:klaus)
		dev1.subdepts.add dev11
		
		Department development = new Department(name:"Development", manager:ray)
		development.subdepts.add dev1
		
		meganalysis = new Company(name:"meganalysis")
		meganalysis.depts.add research
		meganalysis.depts.add development
	}

	@Test
	public void testTotal() {
		assertEquals 399747, meganalysis.total(), 0
	}

	@Test
	public void testCut() {
		meganalysis.cut()
		assertEquals 399747 / 2.0d, meganalysis.total(), 0
	}

}
