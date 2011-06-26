var controller = {};

controller.loadDepartment = function(id) {
	controller.departmentId = id;
	gui.generateFormular();
	model.loadData();
}

controller.loadInner = function() {
	model.getDepartmentName(controller.departmentId);
	//model.getEmployees(controller.departmentId);
	//model.getSubdepartments(controller.departmentId);
	//model.total(controller.departmentId);
}

controller.cut = function(id) {
	model.cut(id);
}

controller.selectEmployee = function(name) {
	model.selectEmployee(name);
}

controller.selectDepartment = function(name) {
	model.selectDepartment(name);
}

controller.changeName = function(id, newName) {
	model.changeName(id, newName);
}

controller.notifyEmployees = function() {
	gui.updateManager();
	gui.updateEmployees();
}

controller.notifyDepartment = function() {
	gui.updateDepartment();
}

controller.notifySubdepartments = function() {
	gui.updateSubdepartments();
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