var controller = {};

// -------------------------------------------- init page
controller.loadTree = function(id) {
    treeModel.load(loadTreeStrategy, id);
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
