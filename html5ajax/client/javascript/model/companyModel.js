// server for company-manipulation
model.url = '../server/companyServer.php';

// init request-parameter
model.initCompany = function() {
    model.company = {};
    model.company.id = 1;
    model.company.table = "company";
}

// load data for company
model.loadData = function(strategy) {
    model.initCompany();
    model.company.action = "load";

    model.sendRequest(strategy, model.company);
}

// save company name
model.saveData = function(strategy, newName) {
    model.initCompany();
    model.company.action = "save";
    
    if (newName == '' || newName == null) {
        model.error = {};
        model.error.error = true;
        model.error.failures = {};
        model.error.failures.name = "Enter a valid name, please.";
        strategy.error();
    } else {
        model.company.newName = newName;
    
        model.sendRequest(strategy, model.company);
    }
}

// cut company
model.cut = function(strategy) {
    model.initCompany();
    model.company.action = "cut";
    
    model.sendRequest(strategy, model.company);
}

// select department
model.selectDepartment = function(strategy, departmentName) {
    model.initCompany();
    model.company.action = "selectDepartment";
    model.company.departmentName = departmentName;
    
    model.sendRequest(strategy, model.company);
}