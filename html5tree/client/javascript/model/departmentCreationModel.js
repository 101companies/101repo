var departmentCreationModel = {};

// load data for department
departmentCreationModel.load = function(strategy) {
    departmentCreationModel.department = {};
    departmentCreationModel.department.action = "blank";

    requestUnit.sendRequest(strategy, departmentModel.url, departmentCreationModel.department);
}

// save new department
departmentCreationModel.saveEntity = function(strategy, data) {
    departmentCreationModel.department = {};
    departmentCreationModel.department.name = data.name;
    departmentCreationModel.department.manager = data.manager;
    departmentCreationModel.department.parent = data.parent;
    departmentCreationModel.department.action = "create";
    
    requestUnit.sendRequest(strategy, departmentModel.url, departmentCreationModel.department);
}