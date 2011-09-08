var departmentView = {};

departmentView.refresh = function() {
    document.querySelector('#headline').innerHTML = "<h3> Department </h3>";

    document.department.name.value = model.response.name;
    document.department.total.value = model.response.total;
}


