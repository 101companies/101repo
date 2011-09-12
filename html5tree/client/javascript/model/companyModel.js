var companyModel = {};

companyModel.url = 'server/companyServer.php';

// init request-parameter
companyModel.initCompany = function(id) {
    companyModel.company = {};
    companyModel.company.id = id;
    companyModel.company.table = "company";
}

// load data for company
companyModel.load = function(strategy, id) {
    companyModel.initCompany(id);
    companyModel.company.action = "load";

    requestUnit.sendRequest(strategy, companyModel.url, companyModel.company);
}

// cut company
companyModel.cut = function(strategy) {
    companyModel.initCompany(companyModel.response.id);
    companyModel.company.action = "cut";
    
    requestUnit.sendRequest(strategy, companyModel.url, companyModel.company);
}

companyModel.saveEntity = function(strategy, data) {
     if (data.name == '' || data.name == null) {
        requestUnit.error = {};
        requestUnit.error.error = true;
        requestUnit.error.failures = {};
        requestUnit.error.failures.name = errors.name;
        strategy.error();
    } else {
        companyModel.initCompany(companyModel.response.id);
        companyModel.company.name = data.name;
        companyModel.company.action = "save";

        requestUnit.sendRequest(strategy, companyModel.url, companyModel.company);
    }
}