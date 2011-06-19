var total;

companies.indexedDB.test = function() {
	//testTotal(399747.0);
	//testCut();
}

function testTotal(expected) {
	total = 0;
	companies.indexedDB.total();
	window.setTimeout("result(" + expected + ")", 500);
}

function testCut() {
	total = 0;
	companies.indexedDB.cut();
	window.setTimeout("testTotal(199873.5)", 500);
}

function result(re) {
	var b = total == re;
	document.getElementById("total").innerHTML += b;
}

companies.indexedDB.getAllCompanies = function() {
		
		var db = companies.indexedDB.db;
		var transComp = db.transaction(["Company"], IDBTransaction.READ_WRITE, 0);
		var compStore = transComp.objectStore("Company");
		

		// Get everything in the store;
		var keyRange = IDBKeyRange.lowerBound(0);
		var cursorRequest = compStore.openCursor(keyRange);

		cursorRequest.onsuccess = function(e) {
			var result = e.target.result;
			if(!!result == false)
				return;

			document.getElementById("test").innerHTML += result.value.company + "<br>";
			result.continue();
		};

		cursorRequest.onerror = companies.indexedDB.onerror;
	};
	
	companies.indexedDB.getAllDepartments = function() {
		
		var db = companies.indexedDB.db;
		var transDep = db.transaction(["Department"], IDBTransaction.READ_WRITE, 0);
		var depStore = transDep.objectStore("Department");
		

		// Get everything in the store;
		var keyRange = IDBKeyRange.lowerBound(0);
		var cursorRequest = depStore.openCursor(keyRange);

		cursorRequest.onsuccess = function(e) {
			var result = e.target.result;
			if(!!result == false)
				return;

			document.getElementById("test").innerHTML += result.value.department + "<br>";
			result.continue();
		};

		cursorRequest.onerror = companies.indexedDB.onerror;
	};
	
	companies.indexedDB.getAllEmployees = function() {
		
		var db = companies.indexedDB.db;
		var transEmp = db.transaction(["Employee"], IDBTransaction.READ_WRITE, 0);
		var empStore = transEmp.objectStore("Employee");
		

		// Get everything in the store;
		var keyRange = IDBKeyRange.lowerBound(0);
		var cursorRequest = empStore.openCursor(keyRange);

		cursorRequest.onsuccess = function(e) {
			var result = e.target.result;
			if(!!result == false)
				return;

			document.getElementById("test").innerHTML += result.value.employee + "<br>";
			result.continue();
		};

		cursorRequest.onerror = companies.indexedDB.onerror;
	};