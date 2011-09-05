// server for company-manipulation
model.url = 'server/tree.php';

// init request-parameter
model.initCompany = function(id) {
    model.company = {};
    model.company.id = id;
    model.company.table = "company";
}

// load data for company
model.loadTree = function(strategy, id) {
    model.initCompany(id);
    model.company.action = "load";

    model.sendRequest(strategy, model.company);
}


