import java.util.Map; 
import java.util.HashMap; 
import java.util.Set; 
import java.util.HashSet; 

public  class  RefEmployees {
	

  private static Map<Department, Set<Employee>> mpLinks = new HashMap<Department, Set<Employee>>();

	
  
  public static void add (Department src, Employee tgt) {
    Set<Employee> sLinks = mpLinks.get (src);
    if (sLinks == null) {
      sLinks = new HashSet<Employee>();
      mpLinks.put (src, sLinks);
    }
    sLinks.add (tgt);
  }

	
  
  public static void remove (Department src, Employee tgt) {
    Set<Employee> sLinks = mpLinks.get (src);
    if (sLinks != null) {
      sLinks.remove (tgt);
      if (sLinks.isEmpty()) {
        mpLinks.remove (src);
      }
    }
  }

	
  
  public static Set<Employee> get (Department src) {
    return mpLinks.get (src);
  }


}
