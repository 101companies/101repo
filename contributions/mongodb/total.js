function totalmap() {
    emit("salary", this.salary);
}

function totalreduce(key, salaries) {
    var result = 0;
    salaries.forEach(function(value) {
        result += value;
    });
    return result;
}

var result =
    db.employees.mapReduce(totalmap, totalreduce, {"out" : {"inline" : 1}});
printjson(result);
