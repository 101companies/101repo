public class Demo {
   public static void main(String[] args) {
       // Build a list with three elements
       List list = new List();
       list.add(1);
       list.add(2);
       list.add(3);
       // Walk the linked list and print it
       for (List.Node i=list.first; i!=null; i=i.next)
	   System.out.print(i.info + " ");
       System.out.println();
   }
}
