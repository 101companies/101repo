var companyView = {};

companyView.refresh = function() {
    document.querySelector('#headline').innerHTML = "<h3> Company </h3>";
    
    document.company.name.value = model.response.name;
    document.company.total.value = model.response.total;
}

companyView.error = function() {
    if (model.error.failures.other != null) {
        alert(model.error.failures.other);
    } else {
        document.querySelector('#companyNameLabel').innerHTML = "Name:<error>*</error>";
        document.querySelector('#namefailureComp').innerHTML = "<error>" + model.error.failures.name + "</error>";
    }
}