var departmentCreationModel = {};

// load data for department
departmentCreationModel.load = function(strategy) {
    departmentCreationModel.department = {};
    departmentCreationModel.department.action = "blank";

    requestUnit.sendRequest(strategy, departmentModel.url, departmentCreationModel.department);
}

// save new department
departmentCreationModel.saveEntity = function(strategy, data) {
    if (data.name == '' || data.name == null) {
        requestUnit.error = {};
        requestUnit.error.error = true;
        requestUnit.error.failures = {};
        requestUnit.error.failures.name = errors.name;
        strategy.error();
    } else {
        departmentCreationModel.department = {};
        departmentCreationModel.department.name = data.name;
        departmentCreationModel.department.manager = data.manager;
        departmentCreationModel.department.parent = data.parent;
        departmentCreationModel.department.action = "create";

        requestUnit.sendRequest(strategy, departmentModel.url, departmentCreationModel.department);
    }
}