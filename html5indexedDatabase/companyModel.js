var model = {};

model.company;
model.departments;
model.totalValue;
model.changeTo;

model.resetData = function() {
	companies.indexedDB.addData();
}

model.getCompanyName = function() {
	var db = companies.indexedDB.db;
	var transDep = db.transaction(["Company"], IDBTransaction.READ_WRITE, 0);
	var depStore = transDep.objectStore("Company");
	
	var keyRange = IDBKeyRange.lowerBound(0);
	var cursorRequest = depStore.openCursor(keyRange);

	cursorRequest.onsuccess = function(e) {
		var result = e.target.result;
		if(!!result == false) {
			controller.notifyCompany();
			return;
		}
		
		if (result.value.id == 0) {
			model.company = result.value.company;
		}
		result.continue();
	};
	
	cursorRequest.onerror = companies.indexedDB.onerror;
}

model.getDepartments = function() {
	var departmentList = new Array();
	var db = companies.indexedDB.db;
	var transDep = db.transaction(["Department"], IDBTransaction.READ_WRITE, 0);
	var depStore = transDep.objectStore("Department");
	
	var keyRange = IDBKeyRange.lowerBound(0);
	var cursorRequest = depStore.openCursor(keyRange);

	cursorRequest.onsuccess = function(e) {
		var result = e.target.result;
		if(!!result == false) {
			model.departments = departmentList;
			controller.notifyDepartments();
			return;
		}
		
		if (result.value.parent == null) {
			departmentList.push(result.value.department);
		}
		result.continue();
	};
	
	cursorRequest.onerror = companies.indexedDB.onerror;
}

model.determineTotal = function() {
	model.totalValue = 0;
	var db = companies.indexedDB.db;
	var transEmp = db.transaction(["Employee"], IDBTransaction.READ_WRITE, 0);
	var empStore = transEmp.objectStore("Employee");
	
	var keyRange = IDBKeyRange.lowerBound(0);
	var cursorRequest = empStore.openCursor(keyRange);

	cursorRequest.onsuccess = function(e) {
		var result = e.target.result;
		if(!!result == false) {
			controller.notifyTotal();
			return;
		}

		model.totalValue += result.value.salary;
		result.continue();
	};
	
	cursorRequest.onerror = companies.indexedDB.onerror;
}

model.cut = function() {
	var db = companies.indexedDB.db;
	var transEmp = db.transaction(["Employee"], IDBTransaction.READ_WRITE, 0);
	var empStore = transEmp.objectStore("Employee");
	
	var keyRange = IDBKeyRange.lowerBound(0);
	var cursorRequest = empStore.openCursor(keyRange);

	cursorRequest.onsuccess = function(e) {
		var result = e.target.result;
		if(!!result == false) {
			model.determineTotal();
			return;
		}

		result.value.salary = result.value.salary / 2;
		empStore.put(result.value);
		result.continue();
	};
	
	cursorRequest.onerror = companies.indexedDB.onerror;
}

model.changeName = function(newName) {
	var db = companies.indexedDB.db;
	var transComp = db.transaction(["Company"], IDBTransaction.READ_WRITE, 0);
	var compStore = transComp.objectStore("Company");
	
	var keyRange = IDBKeyRange.lowerBound(0);
	var cursorRequest = compStore.openCursor(keyRange);

	cursorRequest.onsuccess = function(e) {
		var result = e.target.result;
		if(!!result == false) {
			model.getCompanyName();
			return;
		}
		
		if (result.value.id == 0) {
			result.value.company = newName;
			compStore.put(result.value);
		}
		result.continue();
	};
	
	cursorRequest.onerror = companies.indexedDB.onerror;
}

model.selectDepartment = function(name) {
	var db = companies.indexedDB.db;
	var transDep = db.transaction(["Department"], IDBTransaction.READ_WRITE, 0);
	var depStore = transDep.objectStore("Department");
	
	var keyRange = IDBKeyRange.lowerBound(0);
	var cursorRequest = depStore.openCursor(keyRange);

	cursorRequest.onsuccess = function(e) {
		var result = e.target.result;
		if(!!result == false) {
			return;
		}
		
		if (result.value.department == name) {
			model.changeTo = result.value.id;
			controller.changePage();
			return;
		}
		result.continue();
	};
	
	cursorRequest.onerror = companies.indexedDB.onerror;
}