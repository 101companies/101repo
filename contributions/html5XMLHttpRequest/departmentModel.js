var model = {};

model.name;
model.subdepartments;
model.manager;
model.employees;
model.totalValue;
model.nextDepartment;
model.nextEmployee;
model.isManager;

model.id;

model.loadData = function() {
	company.loadData();
}

model.getDepartmentName = function(id) {
	model.id = id;
	
	var departmentList = company.response.documentElement.getElementsByTagName("Department");
	for (var i = 0; i < departmentList.length; i++) {
		if (departmentList[i].getElementsByTagName("id")[0].childNodes[0].nodeValue == id) {
			model.name = departmentList[i].getElementsByTagName("Name")[0].childNodes[0].nodeValue;
		}
	}

	controller.notifyDepartment();
}

model.getEmployees = function(id) {
	model.employees = new Array();
	
	var departments = company.response.documentElement.getElementsByTagName("Department");
	var departmentIds = new Array();
	for (var i = 0; i < departments.length; i++) {
		departmentIds.push(departments[i].getElementsByTagName("id")[0]);
	}
	var department;
	
	for (var i = 0; i < departmentIds.length; i++) {
		if (departmentIds[i].childNodes[0].nodeValue == id) {
			department = departmentIds[i].parentNode;
		}
	}
	
	model.manager = department.getElementsByTagName("Manager")[0].getElementsByTagName("Name")[0].childNodes[0].nodeValue;
	
	var employeeList = department.getElementsByTagName("Employees")[0].getElementsByTagName("Name");
	
	for (var i = 0; i < employeeList.length; i++) {
		model.employees.push(employeeList[i].childNodes[0].nodeValue);
	}
		
	controller.notifyEmployees();
}

model.getSubdepartments = function(id) {
	model.subdepartments = new Array();

	var departments = company.response.documentElement.getElementsByTagName("Department");
	var departmentIds = new Array();
	for (var i = 0; i < departments.length; i++) {
		departmentIds.push(departments[i].getElementsByTagName("id")[0]);
	}
	var department;
	
	for (var i = 0; i < departmentIds.length; i++) {
		if (departmentIds[i].childNodes[0].nodeValue == id) {
			department = departmentIds[i].parentNode;
		}
	}
	
	var departmentList = department.getElementsByTagName("SubDepartments")[0].childNodes;
	
	for (var i = 0; i < departmentList.length; i++) {
		if (departmentList[i].nodeType == 1) {
			model.subdepartments.push(departmentList[i].childNodes[3].childNodes[0].nodeValue);
		}
		
	}
	controller.notifySubdepartments();
}

model.total = function(id) {
	model.totalValue = 0;

	var departments = company.response.documentElement.getElementsByTagName("Department");
	var departmentIds = new Array();
	for (var i = 0; i < departments.length; i++) {
		departmentIds.push(departments[i].getElementsByTagName("id")[0]);
	}
	var department;
	
	for (var i = 0; i < departmentIds.length; i++) {
		if (departmentIds[i].childNodes[0].nodeValue == id) {
			department = departmentIds[i].parentNode;
		}
	}
	
	var salaryList = department.getElementsByTagName("Salary");
	
	for (var i = 0; i < salaryList.length; i++) {
		model.totalValue += parseFloat(salaryList[i].childNodes[0].nodeValue);
	}
	
	controller.notifyTotal();
}

model.selectDepartment = function(name) {
	var departmentList = company.response.documentElement.getElementsByTagName("Department");
	for (var i = 0; i < departmentList.length; i++) {
		if (departmentList[i].getElementsByTagName("Name")[0].childNodes[0].nodeValue == name) {
			model.nextDepartment = departmentList[i].getElementsByTagName("id")[0].childNodes[0].nodeValue;
		}
	}

	controller.changeToDepartment();
}

model.selectEmployee = function(name) {
	model.isManager = false;

	var employeeList = company.response.documentElement.getElementsByTagName("Employee");
	for (var i = 0; i < employeeList.length; i++) {
		if (employeeList[i].getElementsByTagName("Name")[0].childNodes[0].nodeValue == name) {
			model.nextEmployee = employeeList[i].getElementsByTagName("id")[0].childNodes[0].nodeValue;
		}
	}
	
	controller.changeToEmployee();
}

model.selectManager = function(name) {
	model.isManager = true;

	var employeeList = company.response.documentElement.getElementsByTagName("Manager");
	for (var i = 0; i < employeeList.length; i++) {
		if (employeeList[i].getElementsByTagName("Name")[0].childNodes[0].nodeValue == name) {
			model.nextEmployee = employeeList[i].getElementsByTagName("id")[0].childNodes[0].nodeValue;
		}
	}
	
	controller.changeToEmployee();
}

model.cut = function() {	
	var departments = company.response.documentElement.getElementsByTagName("Department");
	var departmentIds = new Array();
	for (var i = 0; i < departments.length; i++) {
		departmentIds.push(departments[i].getElementsByTagName("id")[0]);
	}
	var department;
	
	model.totalValue = 0;
	
	for (var i = 0; i < departmentIds.length; i++) {
		if (departmentIds[i].childNodes[0].nodeValue == model.id) {
			department = departmentIds[i].parentNode;
		}
	}
	
	var salaryList = department.getElementsByTagName("Salary");
	
	for (var i = 0; i < salaryList.length; i++) {
		salaryList[i].childNodes[0].nodeValue = parseFloat(salaryList[i].childNodes[0].nodeValue) / 2;
		model.totalValue += parseFloat(salaryList[i].childNodes[0].nodeValue);
	}
	company.saveData(company.response);
	
	controller.notifyTotal();
}

model.changeName = function(id, newName) {	
	var departmentList = company.response.documentElement.getElementsByTagName("Department");
	
	for (var i = 0; i < departmentList.length; i++) {
		if (departmentList[i].getElementsByTagName("id")[0].childNodes[0].nodeValue == id) {
			departmentList[i].getElementsByTagName("Name")[0].childNodes[0].nodeValue = newName;
		}
	}
	company.saveData(company.response);
}