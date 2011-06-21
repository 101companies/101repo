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
controller.changePage = function() {
	//document.querySelector('#test').innerHTML = model.changeTo;
	location.href = "department.html?departmentId=" + model.changeTo;
}