var model = {};
// ---------------------- main functions
model.getCompanyName = function() {
	var result = loadData(false);
	return result.name;
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

model.getSubDepartments = function(name) {
	var result = new Array();
	subDepartmentList = getDepartment(name).subdepartments;
	for (var i = 0; i < subDepartmentList.length; i++) {
		result.push(subDepartmentList[i].name);
	}
	return result;
}

model.totalDepartment = function(name) {
	var result = 0;
	var department = getDepartment(name);
	for (var i = 0; i < department.subdepartments.length; i++) {
		result += model.totalDepartment(department.subdepartments[i].name);
	}
	
	for (var i = 0; i < department.employees.length; i++) {
		result += department.employees[i].salary;
	}
	return result;
}

model.cutDepartment = function(name) {
	var company = loadData();
	for (var i = 0; i < company.departments.length; i++) {
		company.departments[i] = cutSubDepartment(company.departments[i], company.departments[i].name == name, name);
	}
	saveData(company);
	controller.updateTotal();
}

model.getEmployee = function(name) {
	var result = 0;

	return result;
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



model.changeName = function(name, newName) {

}

model.changeAddress = function(name, newAddress) {

}

model.changeSalary = function(name, newSalary) {

}

model.reset = function() {
	loadData(true);
	controller.updateTotal();
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
function cutSubDepartment(department, blocker, name) {
	if (blocker == true) {
		for (var i = 0; i < department.subdepartments.length; i++) {
			department.subdepartments[i] = cutSubDepartment(department.subdepartments[i], true);
		}
		for (var i = 0; i < department.employees.length; i++) {
			department.employees[i] = cutEmployee(department.employees[i]);
		}
	} else {
		for (var i = 0; i < department.subdepartments.length; i++) {
			department.subdepartments[i] = cutSubDepartment(department.subdepartments[i], department.subdepartments[i].name == name, name);
		}
	}
	return department;
}

// cut single employee
function cutEmployee(employee) {
	employee.salary = employee.salary / 2;
	return employee;
}

function getDepartment(name) {
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
		if (allDepartments[i].name == name) {
			return allDepartments[i];
		}
	}
}