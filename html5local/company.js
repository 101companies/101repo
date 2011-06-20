/*
 * Class: Company 
 *
 * A company has a name and contains several departments.
 */
function Company(name) {
	this.name = name;
	this.departments = new Array();
}

/*
 * Class: Department 
 *
 * A department has a name and contains several employees. It is part of a company.
 */ 
function Department(name) {
	this.name = name;
	this.employees = new Array();
	this.subdepartments = new Array();
}

/*
 * Class: Employee
 *
 * An Employee has a name, address and salary. He is part of a department.
 */
function Employee(name, address, salary, manager) {
	this.name = name;
	this.address = address;
	this.salary = salary;
	this.manager = manager;
}

function loadData(reset) {
	// If the company does not exist, it must be created locally.
	if (storageObject.company == null || reset == true) {
		// create company ...
		var company = new Company("Meganalysis");

		// create departments ...
		var research = new Department("Research");
		var development = new Department("Development");
		var development1 = new Department("Dev 1");
		var development11 = new Department("Dev 1.1");

		// insert departments ...
		company.departments.push(research);
		company.departments.push(development);
		development.subdepartments.push(development1);
		development1.subdepartments.push(development11);

		// create employees ...
		var craig = new Employee("Craig", "Redmond", 123456.0, true);
		var eric = new Employee("Eric", "Utrecht", 12345.0, false);
		var ralf = new Employee("Ralf", "Koblenz", 1234.0, false);
		var ray = new Employee("Ray", "Redmond", 234567.0, true);
		var klaus = new Employee("Klaus", "Boston", 23456.0, true);
		var karl = new Employee("Karl", "Riga", 2345.0, true);
		var joe = new Employee("Joe", "Wifi City", 2344.0, false);
		
		// insert employees ...
		research.employees.push(craig);
		research.employees.push(eric);
		research.employees.push(ralf);
		
		development.employees.push(ray);
		
		development1.employees.push(klaus);
		
		development11.employees.push(karl);
		development11.employees.push(joe);

		// save company
		storageObject.setItem('company', JSON.stringify(company));
	}
	return JSON.parse(storageObject.getItem('company'));
}

function saveData(company) {
	storageObject.setItem('company', JSON.stringify(company));
}