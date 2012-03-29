var companyView = {};

companyView.refresh = function() {
    document.querySelector('#headline').innerHTML = "<h3> Company </h3>";
    
    document.company.name.value = model.response.name;
    document.company.total.value = model.response.total;
    
    document.querySelector('#compNameFailureMessage').innerHTML = "";
    document.querySelector('#compNameFailure').innerHTML = "Name:";
}

companyView.error = function() {
    if (model.error.failures.other != null) {
        alert(model.error.failures.other);
    } else {
        document.querySelector('#companyNameLabel').innerHTML = "Name:<error>*</error>";
        document.querySelector('#namefailureComp').innerHTML = "<error>" + model.error.failures.name + "</error>";
    }
}

companyView.getValues = function() {
    var data = {};
    data.name = document.company.name.value;
    return data;
}

companyView.error = function() {
    if (model.error.failures.other != null) {
        alert(model.error.failures.other);
    } else {
        document.querySelector('#compNameFailure').innerHTML = "Name<error>*</error>";
        document.querySelector('#compNameFailureMessage').innerHTML = "<error>" + model.error.failures.name + "</error>";
    }
}