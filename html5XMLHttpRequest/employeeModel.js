var model = {};

model.name;
model.address;
model.salary;
model.employeeId;
model.isManager;

model.setId = function(id) {
	model.employeeId = id;
}

model.setManager = function(isManager) {
	model.isManager = isManager;
}

model.loadData = function() {
	company.loadData();
}

// load data for department
model.getEmployee = function() {
	var employeeList;
	if (model.isManager == "true") {
		employeeList = company.response.documentElement.getElementsByTagName("Manager");
	} else {
		employeeList = company.response.documentElement.getElementsByTagName("Employee");
	}
	
	for (var i = 0; i < employeeList.length; i++) {
		if (employeeList[i].getElementsByTagName("id")[0].childNodes[0].nodeValue == model.employeeId) {
			model.name = employeeList[i].getElementsByTagName("Name")[0].childNodes[0].nodeValue;
			model.address = employeeList[i].getElementsByTagName("Address")[0].childNodes[0].nodeValue;
			model.salary = employeeList[i].getElementsByTagName("Salary")[0].childNodes[0].nodeValue;
		}
	}
	controller.notifyView();
}

model.save = function(id, newName, newAddress, newSalary) {
	var employeeList;
	if (model.isManager == "true") {
		employeeList = company.response.documentElement.getElementsByTagName("Manager");
	} else {
		employeeList = company.response.documentElement.getElementsByTagName("Employee");
	}
	
	for (var i = 0; i < employeeList.length; i++) {
		if (employeeList[i].getElementsByTagName("id")[0].childNodes[0].nodeValue == model.employeeId) {
			employeeList[i].getElementsByTagName("Name")[0].childNodes[0].nodeValue = newName;
			employeeList[i].getElementsByTagName("Address")[0].childNodes[0].nodeValue = newAddress;
			employeeList[i].getElementsByTagName("Salary")[0].childNodes[0].nodeValue = parseFloat(newSalary);
		}
	}
	company.saveData(company.response);
}