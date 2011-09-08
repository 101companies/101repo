var companyView = {};

companyView.refresh = function() {
    document.querySelector('#headline').innerHTML = "<h3> Company </h3>";
    
    document.company.name.value = model.response.name;
    document.company.total.value = model.response.total;
}