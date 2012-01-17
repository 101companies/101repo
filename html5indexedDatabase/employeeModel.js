var model = {};

model.name;
model.address;
model.salary;
model.employeeId;

model.setId = function(id) {
	model.employeeId = id;
}

model.loadData = function() {
	companies.indexedDB.open();
}

// load data for department
model.getEmployee = function() {
	var db = companies.indexedDB.db;
	var transEmp = db.transaction(["Employee"], IDBTransaction.READ_WRITE, 0);
	var empStore = transEmp.objectStore("Employee");
	
	var keyRange = IDBKeyRange.only(parseInt(model.employeeId));
	var cursorRequest = empStore.openCursor(keyRange);

	cursorRequest.onsuccess = function(e) {
		var result = e.target.result;
		
		model.name = result.value.employee;
		model.address = result.value.address;
		model.salary = result.value.salary;
		controller.notifyView();
	};
	
	cursorRequest.onerror = companies.indexedDB.onerror;
}

model.save = function(id, newName, newAddress, newSalary) {
	var db = companies.indexedDB.db;
	var transEmp = db.transaction(["Employee"], IDBTransaction.READ_WRITE, 0);
	var empStore = transEmp.objectStore("Employee");
	
	var keyRange = IDBKeyRange.only(parseInt(model.employeeId));
	var cursorRequest = empStore.openCursor(keyRange);

	cursorRequest.onsuccess = function(e) {
		var result = e.target.result;
		
		temp = result.value;
		
		temp.employee = newName;
		temp.address = newAddress;
		temp.salary = newSalary;
		
		empStore.put(temp);
	};
	
	cursorRequest.onerror = companies.indexedDB.onerror;
}