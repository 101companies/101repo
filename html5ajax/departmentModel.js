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

model.loadData = function(id) {
	model.id = id;
	model.execute("load");
}

model.getDepartmentName = function() {
	model.name = company.response.name;

	controller.notifyDepartment();
}

model.getEmployees = function() {
	model.manager = company.response.manager;
	model.employees = company.response.employees;
		
	controller.notifyEmployees();
}

model.getSubdepartments = function() {
	model.subdepartments = company.response.departments;
	
	controller.notifySubdepartments();
}

model.total = function() {
	model.total = company.response.total;
	
	controller.notifyTotal();
}

model.selectDepartment = function(name) {
	

	controller.changeToDepartment();
}

model.selectEmployee = function(name) {
	
	
	controller.changeToEmployee();
}

model.selectManager = function(name) {
	
	
	controller.changeToEmployee();
}

model.cut = function() {	
	
}

model.changeName = function(id, newName) {	
	
}

model.execute = function(action, param) {
	var xhr = new XMLHttpRequest();
	xhr.open('POST', 'company.php', true);
	xhr.setRequestHeader("action", action);
	xhr.setRequestHeader("table", "department");
	xhr.setRequestHeader("id", model.id);
	
	xhr.onload = function(e) {
		if (this.status == 200) {
			var temp = xhr.responseText;
			company.response = JSON.parse(temp);
			controller.loadInner();
		}
	}
	xhr.send(param);	
}