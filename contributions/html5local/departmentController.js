var controller = {};

// notifies the gui to update itself
controller.notifyView = function() {
	gui.update();
}

controller.cut = function(id) {
	model.cut(id);
}

controller.changeName = function(id, newName) {
	model.changeName(id, newName);
}

controller.selectEmployee = function(name) {
	model.selectEmployee(name);
}

controller.selectDepartment = function(name) {
	model.selectDepartment(name);
}

// notifies the gui to update the total value
controller.notifyTotal = function() {
	gui.updateTotal();
}

// change page to department view
controller.changeToDepartment = function() {
	location.href = "department.html?departmentId=" + model.nextDepartment;
}

// change page to employee view
controller.changeToEmployee = function() {
	location.href = "employee.html?employeeId=" + model.nextEmployee;
}