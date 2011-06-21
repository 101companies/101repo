var controller = {};

// notifies the gui to update itself
controller.notifyView = function() {
	gui.update();
}

// notifies the gui to update the total value
controller.notifyTotal = function() {
	gui.updateTotal();
}