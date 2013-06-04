public class Program {
  // An imperative definition of the factorial function
  public static int factorial(int n) {
    // n and result use method scope
    int result = 1;
    // i uses the for loop as scope
    for (int i=n; i>1; i--) 
      result = result * i;
    return result;
  }
  public static void main(String[] args) {
    System.out.println(factorial(5));
  }
}
