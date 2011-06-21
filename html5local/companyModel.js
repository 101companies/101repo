var model = {};

model.headline;
model.departments;
model.totalValue;
model.changeTo;

// ---------------------- main functions
model.loadCompany = function() {
	model.getCompanyName();
	model.getDepartmentList();
	model.total();
	controller.notifyView();
}

model.getCompanyName = function() {
	model.headline = loadData(false).name;
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
	model.departments = result;
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
	model.totalValue = result;
	controller.notifyTotal();
}

model.cut = function() {
	var company = loadData(false);
	var len = company.departments.length;
	for (var i = 0; i < len; i++) {
		company.departments[i] = cutSubDepartment(company.departments[i], true);
	}
		
	// save company
	saveData(company);
	model.total();
	controller.notifyTotal();
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

model.selectDepartment = function(name) {
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
	model.changeTo = result;
	controller.changePage();
}

model.reset = function() {
	loadData(true);
	model.loadCompany();
}