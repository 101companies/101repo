var controller = {};

// -------------------------------------------- init page
controller.loadTree = function(id) {
    model.loadTree(loadTreeStrategy, id);
}

// -------------------------------------------- Strategies
// load
var loadTreeStrategy = {};
loadTreeStrategy.update = function() {
    view.refresh();
}
loadTreeStrategy.error = function() { /* stub */ }
