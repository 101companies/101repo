application webDSL

imports company				// model
imports meganalysis		// model instance 

var deptStack := DeptStack{list := List<Dept>()}

	define page root(){
		title{output(meganalysis.name)}
		includeCSS("style.css")
		 
		block[class := "headline"]{"Company WebDSL WebApp"}
		
		block[class := "content"]{
			block[class := "viewTitleC"]{output(meganalysis.name)}
			block[class := "infoComp"]{
				"Top Departments :"
				for (dept:Dept in meganalysis.depts){
					block[class:="listE" ] {
						submit  
							action{
								deptStack.clear(); 
								return deptView(dept);} 
							{output(dept.name)}
					}	
				}
			}
			block[class := "tac"]{
				output("Total = " + meganalysis.total() + " $ ")
				submit 
					action{
						meganalysis.cut();} 
					{"Cut"}
			} 
		}
	}
	
	define page deptView(d : Dept){
		 title{output(d.name)}
		 includeCSS("style.css")
		 block[class := "headline"]{"Company WebDSL WebApp"}
		 block[class := "content"]{
		     block[class := "back"]{
			     submit 
			     	action{
				     	if(deptStack.isEmpty()){
				     		return root();
				   		}
				   		else {
				   			return deptView(deptStack.pop());	
				   		}
			   		} 
			   		{"Back"}
		     }
		     
		     block[class := "viewTitle"] {output(d.name)}
		     
		     
			 block[class := "infoComp"]{
				 "Manager :"
				 block[class:="listE" ]{
				 	submit 
				 		action{
				 			deptStack.push(d); 
				 			return employeeView(d.manager);} 
				 	 	{output(d.manager.name)}
				 }
			 }
			 
			 block[class := "infoComp"]{
				 "Employees : "
				 for (employee:Employee in d.employees){
				 	block[class:="listE" ] {
				 		submit 
				 			action{
				 				deptStack.push(d); 
				 				return employeeView(employee);} 
				 			{output(employee.name)}
				 	}
				 }
			 }
		 
			 block[class := "infoComp"]{
				 "Sub Departments :"
				 for (subDept:Dept in d.subDepts){
				 	block[class:="listE" ] {
				 		submit 
				 			action{
				 				deptStack.push(d); 
				 				return deptView(subDept);} 
				 			{output(subDept.name)}}
				 }
			 }
			 
			 block[class := "tac"]{
				output("Total = " + d.total() + " $ ")
				submit 
					action{
						d.cut();} 
					{"Cut"}
			} 
		 }	 
	}
		
	define page employeeView(e : Employee){
	    title{output(e.name)}
	    includeCSS("style.css")
	    
	    block[class := "headline"]{"Company WebDSL WebApp"}
	    
	    block[class := "content"]{
			block[class := "back"]{
				submit 
					action{ 
						return deptView(deptStack.pop());} 
					{"Back"}
			}
										
			block[class := "viewTitle"] {output(e.name)}
				
			block[class := "empInfo"]{
				block[class:= "empInfoText"] {"Name : "}
				block[class:= "empInfoValue"] {output(e.name)}
			}
			block[class := "empInfo"]{
				block[class:= "empInfoText"] {"Address : "}
				block[class:= "empInfoValue"] {output(e.address)}
			}	
			block[class := "empInfo"]{
				block[class:= "empInfoText"] {"Salary : "}
				block[class:= "empInfoValue"] {
					output(e.total() + " $ ")
					submit 
						action{
							e.cut();} 
						{"Cut"}
				}
			}
		}
	}
