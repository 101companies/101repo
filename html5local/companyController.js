var controller = {};

controller.notifyView = function() {
	gui.update();
}

controller.notifyTotal = function() {
	gui.updateTotal();
}

controller.changePage = function() {
	location.href = "department.html?departmentId=" + model.changeTo;
}