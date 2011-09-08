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