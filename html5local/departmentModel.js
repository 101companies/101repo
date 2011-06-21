var model = {};

model.headline;
model.subdepartments;
model.manager;
model.employees;
model.totalValue;
model.nextDepartment;
model.nextEmployee;

// load data for department
model.loadDepartment = function(id) {
	model.getDepartmentName(id);
	model.getSubdepartmentList(id);
	model.getEmployeeList(id);
	
	controller.notifyView();
	model.total(id);
}

// load department name
model.getDepartmentName = function(id) {
	model.headline = model.getDepartment(id).name;
}

// load the subdepartments for a department with the given id
model.getSubdepartmentList = function(id) {
	var result = new Array();
	subDepartmentList = model.getDepartment(id).subdepartments;
	for (var i = 0; i < subDepartmentList.length; i++) {
		result.push(subDepartmentList[i].name);
	}
	model.subdepartments = result;
}

// load the department with the given id
model.getDepartment = function(id) {
	var allDepartments = model.getAllDepartments();
		
	for (var i = 0; i < allDepartments.length; i++) {
		if (allDepartments[i].id == id) {
			return allDepartments[i];
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

// get the employees of a department with the given id
model.getEmployeeList = function(id) {
	model.employees = new Array();
	var dep = model.getDepartment(id);
	for (var i = 0; i < dep.employees.length; i++) {
		if (dep.employees[i].manager == false) {
			model.employees.push(dep.employees[i].name);
		} else {
			model.manager = dep.employees[i].name;
		}
	}
}

// calculate total of a department with the given id
model.total = function(id) {
	model.totalValue = model.totalRecursive(id);
	controller.notifyTotal();
}

// calculate total recursively
model.totalRecursive = function(id) {
	var result = 0;
	var department = model.getDepartment(id);
	for (var i = 0; i < department.subdepartments.length; i++) {
		result += model.totalRecursive(department.subdepartments[i].id);
	}
	
	for (var i = 0; i < department.employees.length; i++) {
		result += department.employees[i].salary;
	}
	return result;
}

// select department by id
model.selectDepartment = function(name) {
	var result;
	
	// load all departments
	var allDepartments = model.getAllDepartments();
	
	// find the id by using the given department name
	for (var i = 0; i < allDepartments.length; i++) {
		if (allDepartments[i].name == name) {
			result = allDepartments[i].id;
		}
	}
	
	model.nextDepartment = result;
	
	// notify gui
	controller.changeToDepartment();
}

model.selectEmployee = function(name) {
	var result;
	
	// load all departments
	var allDepartments = model.getAllDepartments();
	
	// find the id by using the given department name
	for (var i = 0; i < allDepartments.length; i++) {
		for (var j = 0; j < allDepartments[i].employees.length; j++) {
			if (allDepartments[i].employees[j].name == name) {
			result = allDepartments[i].employees[j].id;
		}
		}
		
	}
	
	model.nextEmployee = result;
	controller.changeToEmployee();
}

// cut the salary of all employees of a department with the given id
model.cut = function(id) {
	var company = loadData();
	for (var i = 0; i < company.departments.length; i++) {
		company.departments[i] = model.cutSubDepartment(company.departments[i], company.departments[i].id == id, id);
	}
	saveData(company);
	model.total(id);
}

// cuts a given department
model.cutSubDepartment = function(department, blocker, id) {
	if (blocker == true) {
		for (var i = 0; i < department.subdepartments.length; i++) {
			department.subdepartments[i] = model.cutSubDepartment(department.subdepartments[i], true);
		}
		for (var i = 0; i < department.employees.length; i++) {
			department.employees[i] = model.cutEmployee(department.employees[i]);
		}
	} else {
		for (var i = 0; i < department.subdepartments.length; i++) {
			department.subdepartments[i] = model.cutSubDepartment(department.subdepartments[i], department.subdepartments[i].id == id, id);
		}
	}
	return department;
}

// cut single employee
model.cutEmployee = function(employee) {
	employee.salary = employee.salary / 2;
	return employee;
}

// changes the name of a department with the given id
model.changeName = function(id, newName) {
	var company = loadData(false);
	for (var i = 0; i < company.departments.length; i++) {
		company.departments[i] = model.searchAndRename(company.departments[i], company.departments[i].id == id, id, newName);
	}
	saveData(company);
}

// recursive search for the department with a given id and rename
model.searchAndRename = function(department, blocker, id, newName) {
	if (blocker == true) {
		department.name = newName;
	} else {
		for (var i = 0; i < department.subdepartments.length; i++) {
			department.subdepartments[i] = model.searchAndRename(department.subdepartments[i], department.subdepartments[i].id == id, id, newName);
		}
	}
	return department;
}