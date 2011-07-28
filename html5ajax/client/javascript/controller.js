var controller = {};

// -------------------------------------------- load data
controller.loadData = function(id) {
    model.loadData(loadStrategy, id);
}

// -------------------------------------------- save data
controller.changeName = function(newName) {
    model.saveData(saveStrategy, newName);
}

// -------------------------------------------- cut
controller.cut = function() {
    model.cut(loadStrategy);
}

// -------------------------------------------- select department
controller.selectDepartment = function(name) {
    model.selectDepartment(selectStrategy, name);
}

// -------------------------------------------- Strategies
// load
var loadStrategy = {};
loadStrategy.update = function() {
    view.refresh();
}
loadStrategy.error = function() { /* stub */ }

// save
var saveStrategy = {};
saveStrategy.update = function() { 
    view.refresh();
}
saveStrategy.error = function() {
    view.error();
}

// select department
var selectStrategy = {};
selectStrategy.update = function() {
    view.changePage();
}
selectStrategy.error = function() { /* stub */ }