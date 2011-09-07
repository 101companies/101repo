var treeModel = {};

// server for company-manipulation
treeModel.url = 'server/tree.php';

// init request-parameter
treeModel.initCompany = function(id) {
    treeModel.company = {};
    treeModel.company.id = id;
    treeModel.company.table = "company";
}

// load data for company
treeModel.loadTree = function(strategy, id) {
    treeModel.initCompany(id);
    treeModel.company.action = "load";

    requestUnit.sendRequest(strategy, treeModel.url, treeModel.company);
}


