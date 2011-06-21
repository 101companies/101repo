var model = {};

model.headline;
model.departments;
model.totalValue;
model.changeTo;

// load data for company
model.loadCompany = function() {
	model.getCompanyName();
	model.getDepartmentList();
	
	controller.notifyView();
	model.total();
}

// load company name
model.getCompanyName = function() {
	model.headline = loadData(false).name;
}

// load department list
model.getDepartmentList = function() {
	// load company
	var company = loadData(false);
	var result;
	
	// run through the departments and extract the department names
	for (var i = 0; i < company.departments.length; i++) {
		if (result == null) {
			result = new Array(company.departments[i].name);
		} else {
			result.push(company.departments[i].name);
		}
	}
	
	// array of department names
	model.departments = result;
}

// determine total value for all departments in the company
model.total = function() {
	var result = 0;
	
	// load company
	var company = loadData(false);
	
	// get all departments in the company
	var allDepartments = new Array();
	
	for (var i = 0; i < company.departments.length; i++) {
		allDepartments.push(company.departments[i]);
		subdeps = model.findAllSubDepartments(company.departments[i]);
		if (subdeps != null) {
			allDepartments = allDepartments.concat(subdeps);
		}
	}
	
	// run through all departments and all employees and add the salaries
	for (var i = 0; i < allDepartments.length; i++) {
		for (var j = 0; j < allDepartments[i].employees.length; j++) {
			result += allDepartments[i].employees[j].salary;	
		}
	}
	
	// total value
	model.totalValue = result;
	
	// notify gui
	controller.notifyTotal();
}

// cut all employees in the company
model.cut = function() {

	// load company
	var company = loadData(false);
	
	// run through all departments and cut all departments
	var len = company.departments.length;
	for (var i = 0; i < len; i++) {
		company.departments[i] = model.cutSubDepartment(company.departments[i]);
	}
		
	// save company
	saveData(company);
	model.total();
	
	// notify gui
	controller.notifyTotal();
}

// cuts a given department
model.cutSubDepartment = function(department) {
	// cut the subdepartments
	for (var i = 0; i < department.subdepartments.length; i++) {
		department.subdepartments[i] = model.cutSubDepartment(department.subdepartments[i]);
	}
	// cut the employees of this department
	for (var i = 0; i < department.employees.length; i++) {
		department.employees[i] = model.cutEmployee(department.employees[i]);
	}
	return department;
}

// cut single employee
model.cutEmployee = function(employee) {
	employee.salary = employee.salary / 2;
	return employee;
}

// return all subdepartments, subsubdepartments, subsubsub ... of a given department
model.findAllSubDepartments = function(department) {
	if (department.subdepartments.length > 0) {
		var allSubDepartments = new Array();
		
		for (var i = 0; i < department.subdepartments.length; i++) {
			allSubDepartments.push(department.subdepartments[i]);
			subdeps = model.findAllSubDepartments(department.subdepartments[i]);
			if (subdeps != null) {
				allSubDepartments = allSubDepartments.concat(subdeps);
			}
		}
		return allSubDepartments;
	} else {
		return null;
	}
}

// select department by id
model.selectDepartment = function(name) {
	// load company
	var company = loadData(false);
	var result;
	
	// load all departments
	var allDepartments = new Array();
	
	for (var i = 0; i < company.departments.length; i++) {
		allDepartments.push(company.departments[i]);
		subdeps = model.findAllSubDepartments(company.departments[i]);
		if (subdeps != null) {
			allDepartments = allDepartments.concat(subdeps);
		}
	}
	
	// find the id by using the given department name
	for (var i = 0; i < allDepartments.length; i++) {
		if (allDepartments[i].name == name) {
			result = allDepartments[i].id;
		}
	}
	
	model.changeTo = result;
	
	// notify gui
	controller.changePage();
}

// change name of the company
model.changeName = function(name) {
	var company = loadData(false);
	company.name = name;
	saveData(company);
}

// reset data model
model.reset = function() {
	loadData(true);
	model.loadCompany();
}