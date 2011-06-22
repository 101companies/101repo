var controller = {};

controller.loadEmployee = function(id) {
	model.setId(id);
	gui.generateFormular();
	model.loadData();
}

controller.loadInner = function() {
	model.getEmployee();
}

// notifies the gui to update itself
controller.notifyView = function() {
	gui.setName(model.name);
	gui.setAddress(model.address);
	gui.setSalary(parseFloat(model.salary));
}

controller.save = function(id, newName, newAddress, newSalary) {
	model.save(id, newName, newAddress, parseFloat(newSalary));
}