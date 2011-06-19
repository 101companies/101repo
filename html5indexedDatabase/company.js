var companies = {};

	if ( "webkitIndexedDB" in window ) {
		window.indexedDB      = window.webkitIndexedDB;
		window.IDBTransaction = window.webkitIDBTransaction;
		window.IDBKeyRange    = window.webkitIDBKeyRange;
	} else if ( "moz_indexedDB" in window ) {
		window.indexedDB = window.moz_indexedDB;
	}
	if ( !window.indexedDB ) {
		alert("IndexedDB not supported!");
	}
	
	companies.indexedDB = {};
    companies.indexedDB.db = null;

    companies.indexedDB.onerror = function(e) {
      console.log(e);
    };
	
	companies.indexedDB.open = function() {
		
		var request = indexedDB.open("101Companies");

		request.onsuccess = function(e) {
			
			var v = "1";
			companies.indexedDB.db = e.target.result;
			var db = companies.indexedDB.db;
			// We can only create Object stores in a setVersion transaction;
			if(v != db.version) {
				var setVrequest = db.setVersion(v);

				// onsuccess is the only place we can create Object Stores
				setVrequest.onfailure = companies.indexedDB.onerror;
				setVrequest.onsuccess = function(e) {
					if (db.objectStoreNames.contains("Company")) {
						db.deleteObjectStore("Company");
					}
					
					if (db.objectStoreNames.contains("Department")) {
						db.deleteObjectStore("Department");
					}
					
					if (db.objectStoreNames.contains("Employee")) {
						db.deleteObjectStore("Employee");
					}

					var companiesStore = db.createObjectStore("Company",
						{keyPath: "id"});
						
					var departmentStore = db.createObjectStore("Department",
						{keyPath: "id"});
						
					var EmployeeStore = db.createObjectStore("Employee",
						{keyPath: "id"});
				  
					companies.indexedDB.addData();
					companies.indexedDB.test();
				};
			}
			else {
				companies.indexedDB.addData();
				companies.indexedDB.test();
				
			}
		};

    request.onfailure = companies.indexedDB.onerror;
	}
	
	companies.indexedDB.addData = function() {
		var db = companies.indexedDB.db;
		var transComp = db.transaction(["Company"], IDBTransaction.READ_WRITE, 0);
		var compStore = transComp.objectStore("Company");
		var transDep = db.transaction(["Department"], IDBTransaction.READ_WRITE, 0);
		var depStore = transDep.objectStore("Department");
		var transEmp = db.transaction(["Employee"], IDBTransaction.READ_WRITE, 0);
		var empStore = transEmp.objectStore("Employee");

		var compData = {
			"company": "Meganalysis",
			"id": 0
		};
	  
		var departmentData = [
			{"department": "Research", "id": 0, "parent": null},
			{"department": "Development", "id": 1, "parent": null},
			{"department": "Dev 1", "id": 2, "parent": 1},
			{"department": "Dev 1.1", "id": 3, "parent": 1}
		];
	 
		var employeeData = [
			{"employee": "Craig", "id": 0, "address": "Redmond", "salary": 123456.0, "manager": true, "companyId": 0, "departmentId": 0},
			{"employee": "Ray", "id": 1, "address": "Redmond", "salary": 234567.0, "manager": true, "companyId": 0, "departmentId": 1},
			{"employee": "Klaus", "id": 2, "address": "Boston", "salary": 23456.0, "manager": true, "companyId": 0, "departmentId": 2},
			{"employee": "Karl", "id": 3, "address": "Riga", "salary": 2345.0, "manager": true, "companyId": 0, "departmentId": 3},
			{"employee": "Erik", "id": 4, "address": "Utrecht", "salary": 12345.0, "manager": false, "companyId": 0, "departmentId": 0},
			{"employee": "Ralf", "id": 5, "address": "Koblenz", "salary": 1234.0, "manager": false, "companyId": 0, "departmentId": 0},
			{"employee": "Joe", "id": 6, "address": "Wifi City", "salary": 2344.0, "manager": false, "companyId": 0, "departmentId": 3}
		];

		compStore.put(compData);
		for (var i = 0; i < departmentData.length; i++) {
			depStore.put(departmentData[i]);
		}
		for (var i = 0; i < employeeData.length; i++) {
			empStore.put(employeeData[i]);
		}
    };