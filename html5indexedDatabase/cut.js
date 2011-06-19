companies.indexedDB.cut = function() {
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

		result.value.salary = result.value.salary / 2;
		empStore.put(result.value);
		result.continue();
	};
	
	
	cursorRequest.onerror = companies.indexedDB.onerror;
}