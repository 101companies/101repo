var model = {};

model.headline;
model.subheadline;
model.departments;
model.total;
model.changeTo;

// ---------------------- main functions
model.getCompanyName = function() {
	model.headline = loadData(false).name;
	controller.notifyView();
}

model.getDepartmentList = function() {
	var company = loadData(false);
	var result;
	for (var i = 0; i < company.departments.length; i++) {
		if (result == null) {
			result = new Array(company.departments[i].name);
		} else {
			result.push(company.departments[i].name);
		}
	}
	return result;
}

model.getDepartmentIdForName = function(name) {
	var company = loadData(false);
	var result;
	var allDepartments = new Array();
	
	for (var i = 0; i < company.departments.length; i++) {
		allDepartments.push(company.departments[i]);
		subdeps = findAllSubDepartments(company.departments[i]);
		if (subdeps != null) {
			allDepartments = allDepartments.concat(subdeps);
		}
	}
	
	for (var i = 0; i < allDepartments.length; i++) {
		if (allDepartments[i].name == name) {
			result = allDepartments[i].id;
		}
	}
	controller.changeViewToDepartment(result);
}

model.getDepartmentName = function(id) {
	var company = loadData(false);
	var result;
	var allDepartments = new Array();
	
	for (var i = 0; i < company.departments.length; i++) {
		allDepartments.push(company.departments[i]);
		subdeps = findAllSubDepartments(company.departments[i]);
		if (subdeps != null) {
			allDepartments = allDepartments.concat(subdeps);
		}
	}
	
	for (var i = 0; i < allDepartments.length; i++) {
		if (allDepartments[i].id == id) {
			result = allDepartments[i].name;
		}
	}
	return result;
}

model.total = function() {
	var result = 0;
	var company = loadData(false);
	
	var allDepartments = new Array();
	
	for (var i = 0; i < company.departments.length; i++) {
		allDepartments.push(company.departments[i]);
		subdeps = findAllSubDepartments(company.departments[i]);
		if (subdeps != null) {
			allDepartments = allDepartments.concat(subdeps);
		}
	}
	
	for (var i = 0; i < allDepartments.length; i++) {
		for (var j = 0; j < allDepartments[i].employees.length; j++) {
			result += allDepartments[i].employees[j].salary;	
		}
	}
	return result;
}

model.getSubDepartments = function(id) {
	var result = new Array();
	subDepartmentList = getDepartment(id).subdepartments;
	for (var i = 0; i < subDepartmentList.length; i++) {
		result.push(subDepartmentList[i].name);
	}
	return result;
}

model.totalDepartment = function(id) {
	var result = 0;
	var department = getDepartment(id);
	for (var i = 0; i < department.subdepartments.length; i++) {
		result += model.totalDepartment(department.subdepartments[i].id);
	}
	
	for (var i = 0; i < department.employees.length; i++) {
		result += department.employees[i].salary;
	}
	return result;
}

model.cutDepartment = function(id) {
	var company = loadData();
	for (var i = 0; i < company.departments.length; i++) {
		company.departments[i] = cutSubDepartment(company.departments[i], company.departments[i].id == id, id);
	}
	saveData(company);
	controller.updateTotal();
}

// cuts all employees
model.cutCompany = function() {
	var company = loadData(false);
	var len = company.departments.length;
	for (var i = 0; i < len; i++) {
		company.departments[i] = cutSubDepartment(company.departments[i], true);
	}
		
	// save company
	saveData(company);
	controller.updateTotal();
}

model.reset = function() {
	loadData(true);
	controller.updateTotal();
}

model.getEmployees = function(id, manager) {
	var result = new Array();
	var company = loadData();
	for (var i = 0; i < company.departments.length; i++) {
		result = result.concat(getInnerEmployees(id, company.departments[i], manager));
	}
	return result;
}

// ----------------------------------------







model.changeName = function(name, newName) {

}

model.changeAddress = function(name, newAddress) {

}

model.changeSalary = function(name, newSalary) {

}


// ---------------------- support functions
// returns subdepartments for a given department
function findAllSubDepartments(department) {
	if (department.subdepartments.length > 0) {
		var allSubDepartments = new Array();
		
		for (var i = 0; i < department.subdepartments.length; i++) {
			allSubDepartments.push(department.subdepartments[i]);
			subdeps = findAllSubDepartments(department.subdepartments[i]);
			if (subdeps != null) {
				allSubDepartments = allSubDepartments.concat(subdeps);
			}
		}
		return allSubDepartments;
	} else {
		return null;
	}
}

// cuts a given department
function cutSubDepartment(department, blocker, id) {
	if (blocker == true) {
		for (var i = 0; i < department.subdepartments.length; i++) {
			department.subdepartments[i] = cutSubDepartment(department.subdepartments[i], true);
		}
		for (var i = 0; i < department.employees.length; i++) {
			department.employees[i] = cutEmployee(department.employees[i]);
		}
	} else {
		for (var i = 0; i < department.subdepartments.length; i++) {
			department.subdepartments[i] = cutSubDepartment(department.subdepartments[i], department.subdepartments[i].id == id, id);
		}
	}
	return department;
}

// cut single employee
function cutEmployee(employee) {
	employee.salary = employee.salary / 2;
	return employee;
}

function getDepartment(id) {
	var company = loadData(false);
	var allDepartments = new Array();
	
	for (var i = 0; i < company.departments.length; i++) {
		allDepartments.push(company.departments[i]);
		subdeps = findAllSubDepartments(company.departments[i]);
		if (subdeps != null) {
			allDepartments = allDepartments.concat(subdeps);
		}
	}
	
	for (var i = 0; i < allDepartments.length; i++) {
		if (allDepartments[i].id == id) {
			return allDepartments[i];
		}
	}
}

function getInnerEmployees(id, department, manager) {
	var result = new Array();
	if (department.id == id) {
		for (var i = 0; i < department.employees.length; i++) {
			if (department.employees[i].manager == manager) {
				result.push(department.employees[i].name);
			}
		}
	} else {
		for (var i = 0; i < department.subdepartments.length; i++) {
			result = result.concat(getInnerEmployees(id, department.subdepartments[i], manager));
		}
	}
	return result;
}