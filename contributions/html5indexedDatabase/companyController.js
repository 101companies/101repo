var controller = {};

// init and open connection to database
controller.loadCompany = function() {
	gui.update();
	model.loadData();
}

// load data for gui 
controller.loadInner = function() {
	model.getCompanyName();
	model.getDepartments();
	model.determineTotal();
}

// reset database
controller.reset = function() {
	model.resetData();
	controller.loadCompany();
}

// change name of the company
controller.changeName = function(newName) {
	model.changeName(newName);
}

// cut salaries
controller.cut = function() {
	model.cut();
}

// notify the gui to update the company name
controller.notifyCompany = function() {
	gui.updateName();
}

// notify the gui to update the total value
controller.notifyTotal = function() {
	gui.updateTotal();
}

// notify the gui to update the departments
controller.notifyDepartments = function() {
	gui.updateDepartments();
}

// select department
controller.selectDepartment = function(name) {
	model.selectDepartment(name);
}

// change page to department view
controller.changePage = function() {
	location.href = "department.html?departmentId=" + model.changeTo;
}