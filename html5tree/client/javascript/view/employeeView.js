var employeeView = {};

employeeView.refresh = function() {
    document.querySelector('#headline').innerHTML = "<h3> Employee </h3>";

    document.employee.name.value = model.response.name;
    document.employee.address.value = model.response.address;
    document.employee.total.value = model.response.salary;
}