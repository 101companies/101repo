import java.util.Map; 
import java.util.HashMap; 
import java.util.Set; 
import java.util.HashSet; 

public  class  RefDepartments {
	

  private static Map<Company, Set<Department>> mpLinks = new HashMap<Company, Set<Department>>();

	
  
  public static void add (Company src, Department tgt) {
    Set<Department> sLinks = mpLinks.get (src);
    if (sLinks == null) {
      sLinks = new HashSet<Department>();
      mpLinks.put (src, sLinks);
    }
    sLinks.add (tgt);
  }

	
  
  public static void remove (Company src, Department tgt) {
    Set<Department> sLinks = mpLinks.get (src);
    if (sLinks != null) {
      sLinks.remove (tgt);
      if (sLinks.isEmpty()) {
        mpLinks.remove (src);
      }
    }
  }

	
  
  public static Set<Department> get (Company src) {
    return mpLinks.get (src);
  }


}
