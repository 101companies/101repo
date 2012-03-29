var model = {};

model.name;
model.address;
model.salary;

// load data for department
model.loadEmployee = function(id) {
	model.getData(id);
	
	controller.notifyView();
}

// retrieve data for current employee
model.getData = function(id) {
	var allDepartments = model.getAllDepartments();
	for (var i = 0; i < allDepartments.length; i++) {
		for (var j = 0; j < allDepartments[i].employees.length; j++) {
			if (allDepartments[i].employees[j].id == id) {
				model.name = allDepartments[i].employees[j].name;
				model.address = allDepartments[i].employees[j].address;
				model.salary = allDepartments[i].employees[j].salary;
			}
		}
	}
}

// get all departments of the company
model.getAllDepartments = function() {
	var company = loadData(false);
	var allDepartments = new Array();
	
	for (var i = 0; i < company.departments.length; i++) {
		allDepartments.push(company.departments[i]);
		subdeps = model.findAllSubDepartments(company.departments[i]);
		if (subdeps != null) {
			allDepartments = allDepartments.concat(subdeps);
		}
	}
	return allDepartments;
}

// load all subdepartments of a given department
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

// save employee
model.save = function(id, newName, newAddress, newSalary) {
	var company = loadData(false);
	for (var i = 0; i < company.departments.length; i++) {
		company.departments[i] = model.searchAndRename(company.departments[i], id, newName, newAddress, newSalary);
	}
	saveData(company);
}

// recursive search for an employee with the given id and rename
model.searchAndRename = function(department, id, newName, newAddress, newSalary) {

	// rename if found
	for (var i = 0; i < department.employees.length; i++) {
		var empl = department.employees[i];
		if (empl.id == id) {
			empl.name = newName;
			empl.address = newAddress;
			empl.salary = parseFloat(newSalary);
			department.employees[i] = empl;
			return department;
		}
	}

	// otherwise look at the subdepartments
	for (var i = 0; i < department.subdepartments.length; i++) {
		department.subdepartments[i] = model.searchAndRename(department.subdepartments[i], id, newName, newAddress, newSalary);
	}
	return department;
}

