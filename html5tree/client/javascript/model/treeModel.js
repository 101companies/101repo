var treeModel = {};

// treeview url
treeModel.url = 'server/treeServer.php';

// init request-parameter
treeModel.initCompany = function(id) {
    treeModel.company = {};
    treeModel.company.id = id;
    treeModel.company.table = "company";
}

// load data for company
treeModel.load = function(strategy, id) {
    treeModel.initCompany(id);
    treeModel.company.action = "load";

    requestUnit.sendRequest(strategy, treeModel.url, treeModel.company);
}


