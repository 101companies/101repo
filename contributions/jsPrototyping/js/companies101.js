/**
 * 101companies - JavaScript-Prototyping implementation
 * 
 *	This code demonstrates how to realize the features
 *	of 101companies with prototype-oriented javascript
 *	code. There are examples for using packages, private
 *	and public methods and inheritance.
 *	Some common pitfalls are explained, too.
 * 
 * 
 * Indentation: by tabs (size=4)
 * 
 * @author {Marius Rackwitz}
 * @version {1.0}
 */


/**
 * Collection of util functions, definitely inspired by
 * and very similar to popular JS frameworks like jQuery
 * and Prototype.
 *
 * The sense of reinventing the wheel is that these are
 * very simple but handy functions, which are relatively
 * easy to understand, so that novice programmers profit
 * if the source code is provided. Also a further advantage,
 * will be, that these code is not coupled to jQuery, which
 * is a frontend-framework. So this is fully-capable to be used
 * on server-side with Node.js.
 *
 */
var util = {
	
	/**
	 * Utility for objects, which makes them easier to iterate.
	 *
	 * NOTE:
	 *	Never extend the prototype of Object! This will lead to
	 *	unexpected results and side effects. E.g. if you iterate
	 *	over the properties of any(!) object, there will be a
	 *	property for your new defined method!
	 *
	 */
	each: function(obj, doForEach) {
		for (var key in obj) {
			var item = obj[key];
			doForEach(key, item);
		}
	},
	
	/**
	 * Do nothing but only not causing exceptions
	 * by calling undefined variables.
	 */
	noop: function() {},
	
	/**
	 * Counts the number of own properties, which
	 * will be the size of the object if it is used
	 * to handle an associative array.
	 *
	 * ATTENTION:
	 *	This is not equal to size()-function provided in jQuery!
	 */
	size: function(obj) {
		var size = 0;
		for (var key in obj) {
			if (obj.hasOwnProperty(key)) {
				size++;
			}
		}
		return size;
	},
	
};


/**
 * Util extension for arrays, which makes it easier
 * to iterate over them.
 * 
 * Also a nice demonstration of the dynamic extensibility
 * of default types in JS.
 * 
 * @this{Array}
 */
Array.prototype.each = function(doForEach) {
	for (var i=0; i<this.length; i++) {
		var item = this[i];
		doForEach(i, item);
	}
}; // Pay attention: this is a statement!


/**
 * Util extension for arrays, which makes it easier
 * to test whether a specific element is contained
 * in the array.
 * 
 * @this{Array}
 */
Array.prototype.contains = function(obj) {
	return this.indexOf(obj) > -1;
};


/**
 * Util extension for arrays, which makes a flat clone and
 * would be used in getters of private collection properties.
 * 
 * NOTE:
 *	This will be used comparable with the following code in Java:
 *	<code>
 *		List<SomeType> getPrivateListField() {
 *			return Collections.unmodifableList(privateListField);
 *		}
 *	</code>
 * 
 * @this{Array}
 */
Array.prototype.clone = function() {
	return this.slice(0, this.length);
};



/**
 * Package for the 101companies data model
 *	This contains the following types:
 *		- Nameable:		abstract private base type
 *		+ Company:		see 101companies-wiki
 *		+ Department:	see 101companies-wiki
 *		+ Employee:		see 101companies-wiki
 */
var companies101 = new (function($, undefined) {
	/* NOTE:
	 *	The second argument will not be set
	 *	when this function is called. So the
	 *	name "undefined" becomes a defined
	 *	variable of undefined value.
	 *
	 *	That's a trick for well-defined dynamic
	 *	type checking without using strings,
	 *	because JS is lacking a defined constant
	 *	for type compares.
	 */
	
	
	/*
	 * This reference to "this" is used to have
	 * a proper reference to the actual object
	 * context in inner methods.
	 */
	var companies101 = this;
	
	
	/**
	 * Nameable
	 *	Pseudo-abstract private base prototype,
	 *	to show "inheritance" with js.
	 *
	 * @this{Nameable}
	 */
	function Nameable(name) {
		this.name = name;
	}
	
	// Public methods which use public fields
	Nameable.prototype.getName = function() {
		return this.name;
	}
	
	Nameable.prototype.setName = function(name) {
		this.name = name;
	}
	
	Nameable.prototype.toString = function(name) {
		return [typeof this,"[name=",this.name,"]"].join("");
	}
	
	
	
	/**
	 * Company
	 *	A composition of departments
	 *
	 * @this{Company}
	 */
	function Company(name) {
		Nameable.call(this, name);
		
		// Private fields
		var _departments = [];
		
		// Public methods, which use private fields
		this.getDepartments = function() {
			return _departments.clone();
		};
		
		this.addDepartment = function(dep) {
			if (!(dep instanceof Department)) {
				throw "The first argument must be a Department!";
			}
			_departments.push(dep);
		};
	};
	
	// Move into a package and apply inheritance
	companies101.Company = Company;
	companies101.Company.prototype = new Nameable();
	
	
	// Public methods, which use only public fields or methods
	companies101.Company.prototype.toString = function() {
		/* NOTE:
		 *	Building strings by joining arrays
		 *	is more efficient then concatenating
		 *	strings! Therefore an array is used
		 *	as string builder.
		 */
		var s = [];
		this.getDepartments().each(function(i, dep) {
				s.push(dep.toString());
			});
		
		return [
				"Company[",
				"name=",this.getName(),", ",
				"departments=",s.join(","),
				"]"
			].join("");
	};
	
	companies101.Company.prototype.cut = function() {
		this.getDepartments().each(function(i, dep) {
				dep.cut();
			});
	};
	
	companies101.Company.prototype.total = function() {
		var total = 0;
		this.getDepartments().each(function(i, dep) {
				total += dep.total();
			});
		return total;
	};
	
	// Public method, which could be used statically
	companies101.Company.deserializeFromJson = function(data) {
		var company = new companies101.Company(data.name);
		$.each(data.departments, function(name, depData) {
				var dep = companies101.Department.deserializeFromJson(name, depData);
				company.addDepartment(dep);
			});
		return company;
	};
	
	
	
	/**
	 * Department
	 *	A composition of departments and employees
	 *
	 * @this{Department}
	 */
	function Department(name) {
		Nameable.call(this, name);
		
		// Private fields
		var _subDepartments	= [];
		var _employees		= [];
		
		// Public methods, which use private fields
		this.getSubDepartments = function() {
			return _subDepartments.clone();
		};
		
		this.addSubDepartment = function(dep) {
			if (!(dep instanceof Department)) {
				throw "The first argument must be a Department!";
			}
			_subDepartments.push(dep);
		};
		
		this.getEmployees = function() {
			return _employees.clone();
		};
		
		this.addEmployee = function(emp) {
			if (!(emp instanceof Employee)) {
				throw "The first argument must be a Employee!";
			}
			_employees.push(emp);
		};
	};
	
	// Move into a package and apply inheritance
	companies101.Department = Department;
	companies101.Department.prototype = new Nameable();
	
	
	// Public methods, which use only public fields or methods
	companies101.Department.prototype.toString = function() {
		var sd = [];
		this.getSubDepartments().each(function(i, dep) {
				sd.push(dep.toString());
			});
		
		var se = [];
		this.getEmployees().each(function(i, emp) {
				se.push(emp.toString());
			});
		
		return [
				"Department[",
				"name=",this.getName(),", ",
				"subDepartments=",sd.join(","),", ",
				"employees=",se.join(","),
				"]"
			].join("");
	};
	
	companies101.Department.prototype.cut = function() {
		this.getSubDepartments().each(function(i, dep) {
				dep.cut();
			});
		
		this.getEmployees().each(function(i, emp) {
				emp.cut();
			});
	};
	
	companies101.Department.prototype.total = function() {
		var total = 0;
		
		this.getSubDepartments().each(function(i, dep) {
				total += dep.total();
			});
		
		this.getEmployees().each(function(i, emp) {
				total += emp.total();
			});
		
		return total;
	};
	
	
	// Public method, which could be used statically
	companies101.Department.deserializeFromJson = function(name, data) {
		var department = new companies101.Department(name);
		
		if (data["departments"] != undefined) {
			$.each(data.departments, function(name, depData) {
					var dep = companies101.Department.deserializeFromJson(name, depData);
					department.addSubDepartment(dep);
				});
		}
		
		if (data["employees"] != undefined) {
			$.each(data.employees, function(name, salary) {
					var emp = companies101.Employee.deserializeFromJson(name, salary);
					department.addEmployee(emp);
				});
		}
		
		return department;
	};
	
	
	
	/**
	 * Employee
	 *	A composition of a name and a salary
	 *
	 * @this{Employee}
	 */
	function Employee(name, city, salary) {
		Nameable.call(this, name);
		
		// Public fields
		this.city = city;
		
		// Private fields
		var _salary = (salary != undefined) ? salary : 0;
		
		// Public methods, which use private fields
		this.getSalary = function() {
			return _salary;
		};
		
		this.setSalary = function(salary) {
			_salary = salary;
		};
	};
	
	// Move into a package and apply inheritance
	companies101.Employee = Employee;
	companies101.Employee.prototype = new Nameable();
	
	// Public methods, which use only public fields or methods
	companies101.Employee.prototype.toString = function() {
		return [
				"Employee[",
				"name=",this.getName(),", ",
				"city=",this.getCity(),", ",
				"salary=",this.getSalary(),"]"
			].join("");
	};
	
	companies101.Employee.prototype.getCity = function() {
		return this.city;
	}
	
	companies101.Employee.prototype.setCity = function(city) {
		this.city = city;
	}
	
	companies101.Employee.prototype.cut = function() {
		this.setSalary(this.getSalary() / 2);
	};
	
	companies101.Employee.prototype.total = function() {
		return this.getSalary();
	};
	
	
	// Public method, which could be used statically
	companies101.Employee.deserializeFromJson = function(name, data) {
		return new companies101.Employee(name, data.city, data.salary);
	};
	
})(util);



// Define some example data, which will be used for testing
companies101.meganalysis = {};
companies101.meganalysis.json = {
		name: "meganalysis",
		departments: {
			"research": {
				employees: {
					"Craig":	{ city: "Redmond",	salary: 123456	},
					"Erik":		{ city: "Utrecht",	salary: 12345	},
					"Ralf":		{ city: "Koblenz",	salary: 1234	},
				},
			},
			
			"dev": {
				employees: {
					"Ray": { city: "Redmond", salary: 234567 },
				},
				departments: {
					"dev1": {
						employees: {
							"Klaus": { city: "Boston", salary: 23456 },
						},
						departments: {
							"dev1.1": {
								employees: {
									"Karl": { city: "Riga",			salary: 2345 },
									"Joe":	{ city: "Wifi City",	salary: 2344 }
								}
							}
						}
					}
				}
			}
		}
	};

companies101.meganalysis.object = companies101.Company.deserializeFromJson(companies101.meganalysis.json);



// Setup a test suite
companies101.testSuite = new test.TestSuite({
	
	before: function() {
		this.testCompany = companies101.Company
				.deserializeFromJson(companies101.meganalysis.json);
	},
	
	testCases: {
	
		/**
		 * Testing the test framework
		 */
		"Meta tests (assertTrue, assertEquals, assertFail, assertFailWith)": new test.TestCase(function() {
			var testObj = {};
			test.assertTrue(true);
			test.assertEquals(true, true);
			test.assertEquals(1, 1);
			test.assertEquals(testObj, testObj);
			test.assertFail(function() { throw false; });
			test.assertFailWith("test", function() { throw "test"; });
		}),
		
		/**
		 * Testing the 101companies feature "Total"
		 */
		"companies101.Company.total()": new test.TestCase(function() {
			test.assertEquals(399747, this.testCompany.total());
		}),
		
		/**
		 * Testing the 101companies feature "Cut"
		 */
		"companies101.Company.cut()": new test.TestCase(function() {
			var totalBeforeCut = this.testCompany.total();
			this.testCompany.cut();
			test.assertEquals(totalBeforeCut/2, this.testCompany.total());
		}),
		
		/**
		 * Testing type-checks of companies101.Company
		 */
		"companies101.Company.addDepartment()": new test.TestCase(function() {
			var testDep = new companies101.Department('Test-Dep');
			this.testCompany.addDepartment(testDep);
			test.assertTrue(this.testCompany.getDepartments().contains(testDep));
			test.assertFail(function() { this.testCompany.addDepartment({}); });
		}),
		
		/**
		 * Testing type-checks of companies101.Department
		 */
		"companies101.Department.addSubDepartment()": new test.TestCase(function() {
			var testDep		= this.testCompany.getDepartments()[0];
			var testSubDep	= new companies101.Department('Test-Dep');
			testDep.addSubDepartment(testSubDep);
			test.assertTrue(testDep.getSubDepartments().contains(testSubDep));
			test.assertFail(function() { testDep.addSubDepartment({}); });
		}),
		
		/**
		 * Testing type-checks of companies101.Employee
		 */
		"companies101.Employee.addEmployee()": new test.TestCase(function() {
			var testDep	= this.testCompany.getDepartments()[0];
			var testEmp	= new companies101.Employee('Test-Emp', 42);
			testDep.addEmployee(testEmp);
			test.assertTrue(testDep.getEmployees().contains(testEmp));
			test.assertFail(function() { testDep.addEmployee({}); });
		}),
		
	},
	
});