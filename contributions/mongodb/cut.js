db.employees.find().forEach(function(entry) {
    db.employees.update(entry, {"$set" : {"salary" : entry.salary / 2}});
});

db.employees.find().forEach(function(entry) {
    printjson(entry);
});
