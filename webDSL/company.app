module company			// Companymodel

	entity Company {
		name :: String
		depts -> List<Dept>
		
		function total() : Float{
			var ttl := 0.0;
			for(dept:Dept in depts) {
				ttl := ttl + dept.total();
			}
			return ttl;
		}
		
		function cut() {
			for(dept:Dept in depts){
				dept.cut();
			}
		}
	}

	entity Dept {
		name :: String
		manager -> Employee
		employees -> List<Employee>
		subDepts -> List<Dept>
		
		function total() : Float{
			var ttl := manager.total();
			for(employee:Employee in employees) {
				ttl := ttl + employee.total();
			}
			for(subDept:Dept in subDepts) {
				ttl := ttl + subDept.total();
			}
			return ttl;
		}
		
		function cut() {
			manager.cut();
			for(employee:Employee in employees) {
				employee.cut();
			}
			for(subDept:Dept in subDepts) {
				subDept.cut();
			}
		}
	}

	entity Employee {
		name :: String
		address :: String
		salary :: Float
		
		function total() : Float {
			return salary;
		}
		
		function cut(){
			salary := salary / 2.0;
		}
	}
	
	entity DeptStack {
		list -> List<Dept>
		
		function clear() {
			list.clear();
		}
		
		function isEmpty() : Bool {
			return (list.length == 0);
		}
		
		function push(d : Dept) {
			list.add(d);
		}
		
		function pop() : Dept{
			if(!isEmpty()){
				var d := list.get(list.length - 1);
				list.remove(d);
				return d;
			}
			return null;	
		}
		
	}