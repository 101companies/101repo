// Map function to build department trees, essentially emits pairs
// {ancestor, dept} for each dept and each of its ancestors
function deptsMapfunc() {
    if (this.ancestors != null) {
        for(var i in this.ancestors) {
            emit(this.ancestors[i], {"subdepts" : [this._id]});
        }
    } emit(this._id, {"subdepts" : []});
}

// Reduce function to build department trees, just gathers all the
// pairs from the map function into {dept, [list of depts in subtree]}
function reducefunc(key, values) {
    var result = {"subdepts" : []};
    for(var i in values) {
        if (values[i] != null) {
            if (values[i].subdepts != null) {
                result.subdepts = result.subdepts.concat(values[i].subdepts);
            }
        }
    }
    return result;
}

// Executes the MapReduce call
function buildDeptTree() {
    return db.depts.mapReduce(deptsMapfunc, reducefunc, {"out" : {"inline" : 1}});
}

// Goes over the department subtrees and adds the relevant employees to
// every entry.
// TODO: Look for a way to do this more efficient
function associateEmployees(resultObj) {
    var result = [];
    resultObj.results.forEach(function(elem) {
        var deptsToSearch = elem.value.subdepts.concat(elem._id);
        var singleResult = {
                "_id" : elem._id,
                "employees" : [],
                "subdepts" : elem.value.subdepts
            }; // Build return object
        db.employees.find({"dept" : {$in : deptsToSearch}}).forEach(
            function(ele) {
                singleResult.employees = singleResult.employees.concat(ele._id);
            }
        );
        result = result.concat(singleResult); // Find matching employees and add them to the result
    });
    return result;
}

// Main
var result = associateEmployees(buildDeptTree());

db.subtrees.drop();
db.createCollection("subtrees");

result.forEach(function(e) {
    db.subtrees.insert(e);
});

result.forEach(function(e) {
    printjson(e);
});
