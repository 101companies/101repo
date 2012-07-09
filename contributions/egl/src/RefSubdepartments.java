import java.util.Map; 
import java.util.HashMap; 
import java.util.Set; 
import java.util.HashSet; 

public  class  RefSubdepartments {
	

  private static Map<Department, Set<Department>> mpLinks = new HashMap<Department, Set<Department>>();

	
  
  public static void add (Department src, Department tgt) {
    Set<Department> sLinks = mpLinks.get (src);
    if (sLinks == null) {
      sLinks = new HashSet<Department>();
      mpLinks.put (src, sLinks);
    }
    sLinks.add (tgt);
  }

	
  
  public static void remove (Department src, Department tgt) {
    Set<Department> sLinks = mpLinks.get (src);
    if (sLinks != null) {
      sLinks.remove (tgt);
      if (sLinks.isEmpty()) {
        mpLinks.remove (src);
      }
    }
  }

	
  
  public static Set<Department> get (Department src) {
    return mpLinks.get (src);
  }


}
