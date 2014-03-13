import java.util.LinkedList;
public class Main {
   public static void main(String[] args) {
       LinkedList<Integer> input = new LinkedList<Integer>();
       input.add(2);
       input.add(4);
       input.add(3);
       input.add(1);
       input.add(4);
       System.out.println(LinearSearch.search(input, 1)); // prints true
       System.out.println(LinearSearch.search(input, 5)); // prints false
   }
}
