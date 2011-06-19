companies.indexedDB.total = function() {

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

			
		total += parseFloat(result.value.salary);
		result.continue();
	};
	
	
	cursorRequest.onerror = companies.indexedDB.onerror;
}