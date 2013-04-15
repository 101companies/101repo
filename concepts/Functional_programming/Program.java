public class Program {
  // An imperative definition of the factorial function
  public static int factorial(int n) {
    int result = 1;
    for (int i=n; i>1; i--) 
      result = result * i;
    return result;
  }
  public static void main(String[] args) {
    System.out.println(factorial(5));
  }
}
