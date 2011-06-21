var model = {};

model.headline;
model.subdepartments;
model.manager;
model.employees;
model.totalValue;
model.changeTo;

// load data for department
model.loadDepartment = function(id) {
	model.getDepartmentName(id);
	model.getSubdepartmentList(id);
	model.getEmployeeList(id);
	
	controller.notifyView();
	model.total(id);
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
			result = allDepartments[i];
		}
	}
	model.headline = result.name;
}

model.getSubdepartmentList = function(id) {
	var result = new Array();
	subDepartmentList = getDepartment(id).subdepartments;
	for (var i = 0; i < subDepartmentList.length; i++) {
		result.push(subDepartmentList[i].name);
	}
	model.subdepartments = result;
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

model.getEmployeeList = function(id, manager) {
	var result = new Array();
	var company = loadData();
	for (var i = 0; i < company.departments.length; i++) {
		result = result.concat(getInnerEmployees(id, company.departments[i], manager));
	}
	if (manager == true) {
		model.manager = result[0];
	} else {
		model.employees = result;
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

model.total = function(id) {
	model.totalValue = model.totalRecursive(id);
	controller.notifyTotal();
}

model.totalRecursive = function(id) {
	var result = 0;
	var department = getDepartment(id);
	for (var i = 0; i < department.subdepartments.length; i++) {
		result += model.totalRecursive(department.subdepartments[i].id);
	}
	
	for (var i = 0; i < department.employees.length; i++) {
		result += department.employees[i].salary;
	}
	return result;
}