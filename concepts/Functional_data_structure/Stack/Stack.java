public class Stack {
  private int element;
  private Stack next;
  public static final Stack empty = null;
  public static Stack push(int x,Stack s) {
    return new Stack(x,s);
  }
  public static int top(Stack s) {
    return s.element;
  }
  public static Stack pop(Stack s) {
    return s.next;
  }
  private Stack(int element, Stack next) {
    this.element = element;
    this.next = next;
  }
}
