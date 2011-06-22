var model = {};

model.name;
model.subdepartments;
model.manager;
model.employees;
model.totalValue;
model.nextDepartment;
model.nextEmployee;

model.loadData = function() {
	companies.indexedDB.open();
}

model.getDepartmentName = function(id) {
	var db = companies.indexedDB.db;
	var transDep = db.transaction(["Department"], IDBTransaction.READ_WRITE, 0);
	var depStore = transDep.objectStore("Department");
	
	var request = depStore.get(id);
	request.onsuccess = function(e) {
		var result = request;
		model.name = result;
		controller.notifyDepartment();
	}
	
	
	request.onerror = companies.indexedDB.onerror;
}

model.getEmployees = function(id) {
	model.employees = new Array();
	var db = companies.indexedDB.db;
	var transEmp = db.transaction(["Employee"], IDBTransaction.READ_WRITE, 0);
	var empStore = transEmp.objectStore("Employee");
	
	var keyRange = IDBKeyRange.lowerBound(0);
	var cursorRequest = empStore.openCursor(keyRange);

	cursorRequest.onsuccess = function(e) {
		var result = e.target.result;
		if(!!result == false) {
			controller.notifyEmployees();
			return;
		}
		
		if (result.value.departmentId == id) {
			if (result.value.manager == true) {
				model.manager = result.value.employee;
			} else {
				model.employees.push(result.value.employee);
			}
		}
		result.continue();
	};
	
	cursorRequest.onerror = companies.indexedDB.onerror;
}

model.getSubdepartments = function(id) {
	model.subdepartments = new Array();
	var db = companies.indexedDB.db;
	var transDep = db.transaction(["Department"], IDBTransaction.READ_WRITE, 0);
	var depStore = transDep.objectStore("Department");
	
	var keyRange = IDBKeyRange.lowerBound(0);
	var cursorRequest = depStore.openCursor(keyRange);

	cursorRequest.onsuccess = function(e) {
		var result = e.target.result;
		if(!!result == false) {
			controller.notifySubdepartments();
			return;
		}
		
		if (result.value.parent == id) {
			model.subdepartments.push(result.value.department);
		}
		result.continue();
	};
	
	cursorRequest.onerror = companies.indexedDB.onerror;
}

model.total = function(id) {
	var allDeps = new Array();
	var db = companies.indexedDB.db;
	var transDep = db.transaction(["Department"], IDBTransaction.READ_WRITE, 0);
	var depStore = transDep.objectStore("Department");
	
	var keyRange = IDBKeyRange.lowerBound(0);
	var cursorRequest = depStore.openCursor(keyRange);

	cursorRequest.onsuccess = function(e) {
		var result = e.target.result;
		if(!!result == false) {
			model.getAllSubdepartmentsForTotal(id, allDeps);
			return;
		}

		result.continue();
	};
	
	cursorRequest.onerror = companies.indexedDB.onerror;
}