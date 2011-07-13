var model = {};

model.name;
model.address;
model.salary;
model.employeeId;

model.setId = function(id) {
	model.employeeId = id;
}

model.loadData = function() {
	model.execute("load");
}

// load data for employee
model.getEmployee = function() {
	model.name = company.response.name;
	model.address = company.response.address;
	model.salary = company.response.salary;
	
	controller.notifyView();
}

// save data for employee
model.save = function(id, newName, newAddress, newSalary) {
	var employee = {};
	employee.name = newName;
	employee.address = newAddress;
	employee.salary = newSalary;
	var newData = JSON.stringify(employee);
	model.execute("save", newData);
}

model.execute = function(action, param) {
	var xhr = new XMLHttpRequest();
	xhr.open('POST', 'company.php', true);
	xhr.setRequestHeader("action", action);
	xhr.setRequestHeader("table", "employee");
	xhr.setRequestHeader("id", model.employeeId);
	
	xhr.onload = function(e) {
		if (this.status == 200) {
			var temp = xhr.responseText;
			company.response = JSON.parse(temp);
			controller.loadInner();
		}
	}
	xhr.send(param);
}