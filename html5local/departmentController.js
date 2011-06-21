var controller = {};

// notifies the gui to update itself
controller.notifyView = function() {
	gui.update();
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