public class MyMathLibrary {
  // Compute greatest common divisor
  public static int gcd(int x, int y) {
    // This version requires positive integers.
    assert x > 0 && y > 0;
    while (x != y) { 
      if (x > y) 
        x = x - y; 
      else 
        y = y - x; 
    }
    return x;
  }
}
