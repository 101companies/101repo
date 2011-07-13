var model = {};

model.name;
model.subdepartments;
model.manager;
model.employees;
model.totalValue;
model.nextDepartment;
model.nextEmployee;

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
	model.totalValue = company.response.total;
	
	controller.notifyTotal();
}

model.selectDepartment = function(name) {
	var xhr = new XMLHttpRequest();
	xhr.open('POST', 'company.php', true);
	xhr.setRequestHeader("action", "selectDepartment");
	xhr.setRequestHeader("table", "company");
	xhr.setRequestHeader("id", "1");
	
	xhr.onload = function(e) {
		if (this.status == 200) {
			model.nextDepartment = xhr.responseText;
			controller.changeToDepartment();
		}
	}
	xhr.send(name);

}

model.selectEmployee = function(name) {
	var xhr = new XMLHttpRequest();
	xhr.open('POST', 'company.php', true);
	xhr.setRequestHeader("action", "selectEmployee");
	xhr.setRequestHeader("table", "company");
	xhr.setRequestHeader("id", "1");
	
	xhr.onload = function(e) {
		if (this.status == 200) {
			model.nextEmployee = xhr.responseText;
			controller.changeToEmployee();
		}
	}
	xhr.send(name);
}

model.selectManager = function(name) {
	model.selectEmployee(name);
}

model.cut = function() {	
	var xhr = new XMLHttpRequest();
	xhr.open('POST', 'company.php', true);
	xhr.setRequestHeader("action", "cut");
	xhr.setRequestHeader("table", "department");
	xhr.setRequestHeader("id", model.id);
	
	xhr.onload = function(e) {
		if (this.status == 200) {
			var temp = xhr.responseText;
			model.totalValue = temp;
			controller.notifyTotal();
		}
	}
	xhr.send();
}

model.changeName = function(newName) {	
	model.execute("save", newName);
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