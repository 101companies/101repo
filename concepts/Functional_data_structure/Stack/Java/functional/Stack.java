// Source: Chapter 40: Functional Data Structures by C. Okasaki. In: Handbook of Data Structures and Applications. Chapman & Hall/CRC.

public class Stack {
  private int elem;
  private Stack next;
  public static final Stack empty = null;
  public static Stack push(int x,Stack s) {
    return new Stack(x,s);
  }
  public static int top(Stack s) { return s.elem; }
  public static Stack pop(Stack s) { return s.next; }
  private Stack(int elem, Stack next) {
    this.elem = elem;
    this.next = next;
  }
}
