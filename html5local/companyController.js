var controller = {};

// change name of the company
controller.changeName = function(newName) {
	model.changeName(newName);
}

// cut salaries
controller.cut = function() {
	model.cut();
}

// reset database
controller.reset = function() {
	model.reset();
}

// select department
controller.selectDepartment = function(name) {
	model.selectDepartment(name);
}

// notifies the gui to update itself
controller.notifyView = function() {
	gui.update();
}

// notifies the gui to update the total value
controller.notifyTotal = function() {
	gui.updateTotal();
}

// change page to department view
controller.changePage = function() {
	location.href = "department.html?departmentId=" + model.changeTo;
}