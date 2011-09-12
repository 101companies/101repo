var controller = {};

// -------------------------------------------- init page
controller.loadTree = function() {
    treeModel.load(loadTreeStrategy, 1);
}

controller.loadCompany = function(id) {
    model = companyModel;
    view = companyView;
    document.getElementById("company").style.display = "block";
    document.getElementById("department").style.display = "none";
    document.getElementById("employee").style.display = "none";
    model.load(loadEntityStrategy, id);
}

controller.loadDepartment = function(id) {
    model = departmentModel;
    view = departmentView;
    document.getElementById("company").style.display = "none";
    document.getElementById("department").style.display = "block";
    document.getElementById("employee").style.display = "none";
    model.load(loadEntityStrategy, id);
}

controller.loadEmployee = function(id) {
    model = employeeModel;
    view = employeeView;
    document.getElementById("company").style.display = "none";
    document.getElementById("department").style.display = "none";
    document.getElementById("employee").style.display = "block";
    model.load(loadEntityStrategy, id);
}

// -------------------------------------------- cut
controller.cut = function() {
    model.cut(loadEntityStrategy);
}

// -------------------------------------------- save
controller.saveEntity = function() {
    model.saveEntity(saveEntityStrategy, view.getValues());
}

// -------------------------------------------- Strategies
// load tree
var loadTreeStrategy = {};
loadTreeStrategy.update = function() {
    treeModel.response = requestUnit.response;
    treeView.refresh();
}
loadTreeStrategy.error = function() { /* stub */ }

// load entity
var loadEntityStrategy = {};
loadEntityStrategy.update = function() {
    model.response = requestUnit.response;
    view.refresh();
}
loadEntityStrategy.error = function() { /* stub */ }

// save entity
var saveEntityStrategy = {};
saveEntityStrategy.update = function() {
    treeModel.load(loadTreeStrategy, 1);
    view = null;
    document.getElementById("company").style.display = "none";
    document.getElementById("department").style.display = "none";
    document.getElementById("employee").style.display = "none";
}
saveEntityStrategy.error = function() {
    model.error = requestUnit.error;
    view.error();
}
