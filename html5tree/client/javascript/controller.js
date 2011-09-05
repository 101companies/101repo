var controller = {};

// -------------------------------------------- init page
controller.loadTree = function(id) {
    model.loadTree(loadTreeStrategy, id);
}

controller.loadCompany = function(id) {
    model.loadCompany(loadCompanyStrategy, id);
}

controller.loadDepartment = function(id) {
    model.loadDepartment(loadDepartmentStrategy, id);
}

controller.loadEmployee = function(id) {
    model.loadEmployee(loadEmployeeStrategy, id);
}

// -------------------------------------------- Strategies
// load tree
var loadTreeStrategy = {};
loadTreeStrategy.update = function() {
    treeView.refresh();
}
loadTreeStrategy.error = function() { /* stub */ }

// load company
var loadCompanyStrategy = {};
loadCompanyStrategy.update = function() {
    companyView.createGUI();
    //companyView.refresh();
}