var controller = {};

controller.selectDepartment = function(name) {
	location.href = "departmentView.html?departmentName=" + name;
}

controller.cut = function() {
	model.cutCompany();
}

controller.cutDepartment = function(name) {
	model.cutDepartment(name);
}

controller.selectEmployee = function(name) {
	
}

controller.updateTotal = function(value) {
	refreshTotal(value);
}