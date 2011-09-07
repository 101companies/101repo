var controller = {};

// -------------------------------------------- init page
controller.loadTree = function(id) {
    treeModel.loadTree(loadTreeStrategy, id);
}

controller.loadCompany = function(id) {
    //model = companyModel;
    document.getElementById("company").style.display = "block";
    document.getElementById("department").style.display = "none";
    document.getElementById("employee").style.display = "none";
    //model.loadCompany(loadCompanyStrategy, id);
}

controller.loadDepartment = function(id) {
    document.getElementById("company").style.display = "none";
    document.getElementById("department").style.display = "block";
    document.getElementById("employee").style.display = "none";
    //model.loadDepartment(loadDepartmentStrategy, id);
}

controller.loadEmployee = function(id) {
    document.getElementById("company").style.display = "none";
    document.getElementById("department").style.display = "none";
    document.getElementById("employee").style.display = "block";
    //model.loadEmployee(loadEmployeeStrategy, id);
}

// -------------------------------------------- Strategies
// load tree
var loadTreeStrategy = {};
loadTreeStrategy.update = function() {
    treeModel.response = requestUnit.response;
    treeView.refresh();
}
loadTreeStrategy.error = function() { /* stub */ }

// load company
var loadCompanyStrategy = {};
loadCompanyStrategy.update = function() {
    //companyView.refresh();
}