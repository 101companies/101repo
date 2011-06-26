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
	
	var keyRange = IDBKeyRange.only(parseInt(id));
	var cursorRequest = depStore.openCursor(keyRange);

	cursorRequest.onsuccess = function(e) {
		var result = e.target.result;
				
		model.name = result.value.department;
		controller.notifyDepartment();	
	};
	
	cursorRequest.onerror = companies.indexedDB.onerror;
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
	model.cutAndTotal(id, false);
}

model.cutAndTotal = function(id, cut) {
	var allDeps = new Array();
	var db = companies.indexedDB.db;
	var transDep = db.transaction(["Department"], IDBTransaction.READ_WRITE, 0);
	var depStore = transDep.objectStore("Department");
	
	var keyRange = IDBKeyRange.lowerBound(0);
	var cursorRequest = depStore.openCursor(keyRange);

	cursorRequest.onsuccess = function(e) {
		var result = e.target.result;
		if(!!result == false) {
			model.innerCutAndTotal(id, allDeps, cut);
			return;
		}

		allDeps.push(result.value);
		result.continue();
	};
	
	cursorRequest.onerror = companies.indexedDB.onerror;
}

model.innerCutAndTotal = function(id, allDeps, cut) {
	model.totalValue = 0;
	var relevantDeps = new Array(model.getFirstDepartment(id, allDeps));
	var newDeps;
	
	do {
		newDeps = new Array();
		for (var i = 0; i < allDeps.length; i++) {
			for (var j = 0; j < relevantDeps.length; j++) {
				if (allDeps[i].parent == relevantDeps[j].id && !contains(relevantDeps, allDeps[i])) {
					newDeps.push(allDeps[i]);
				}
			}
		}
		relevantDeps = relevantDeps.concat(newDeps);
	} while (newDeps.length > 0);
	
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
		
		for (var i = 0; i < relevantDeps.length; i++) {
			if (result.value.departmentId == relevantDeps[i].id) {
				if (cut == true) {
					result.value.salary = result.value.salary / 2;
					empStore.put(result.value);
				}
				model.totalValue += result.value.salary;
			}
		}
		
		result.continue();
	};
	
	cursorRequest.onerror = companies.indexedDB.onerror;
}

model.getFirstDepartment = function(id, allDeps) {
	for (var i = 0; i < allDeps.length; i++) {
		if (allDeps[i].id == id) {
			return allDeps[i];
		}
	}
}

model.cut = function(id) {
	model.cutAndTotal(id, true);
}

model.selectEmployee = function(name) {
	var db = companies.indexedDB.db;
	var transEmp = db.transaction(["Employee"], IDBTransaction.READ_WRITE, 0);
	var empStore = transEmp.objectStore("Employee");
	
	var keyRange = IDBKeyRange.lowerBound(0);
	var cursorRequest = empStore.openCursor(keyRange);

	cursorRequest.onsuccess = function(e) {
		var result = e.target.result;
		if(!!result == false) {
			return;
		}
		
		if (result.value.employee == name) {
			model.nextEmployee = result.value.id;
			controller.changeToEmployee();
			return;
		}
		
		result.continue();
	};
	
	cursorRequest.onerror = companies.indexedDB.onerror;
}

model.selectDepartment = function(name) {
	model.subdepartments = new Array();
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
			model.nextDepartment = result.value.id;
			controller.changeToDepartment();
			return;
		}
		result.continue();
	};
	
	cursorRequest.onerror = companies.indexedDB.onerror;
}

model.changeName = function(id, name) {
	var db = companies.indexedDB.db;
	var transDep = db.transaction(["Department"], IDBTransaction.READ_WRITE, 0);
	var depStore = transDep.objectStore("Department");
	
	var keyRange = IDBKeyRange.only(parseInt(id));
	var cursorRequest = depStore.openCursor(keyRange);

	cursorRequest.onsuccess = function(e) {
		var result = e.target.result;
				
		result.value.department = name;
		depStore.put(result.value);
	};
	
	cursorRequest.onerror = companies.indexedDB.onerror;
}

// -------------------------------------------------------------------------- array help functions
function contains(array, object) {
  for(var i = 0; i < array.length; i++) {
    if(array[i] == object) {
      return true;
    }
  }
  return false;
}