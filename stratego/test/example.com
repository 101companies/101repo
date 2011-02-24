company meganalysis {		// This is a comment.
	dept Research {
		manager Craig { 
			address Redmond
			salary 123456
		}
		employee Erik { 
			address Utrecht 
			salary 12345
		} 
		employee Ralf { 
			address Koblenz 
			salary 1234
		}
	}  
	dept Development { 	 		/* This is 
								   another comment. */
		manager Ray {
			address Redmond 
			salary 234567 
		}
		dept Dev1 {
			manager Klaus {
				address Boston 
				salary 23456
			} 
			dept Dev11 { 
				manager Karl {
					address Riga  
					salary 2345  
				} 
				employee Joe{
					address Wifi_City 
					salary 2344
				}			
			}
		}
	}
}