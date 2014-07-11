public class Stack {
    private class Node {
	private int elem;
	private Node next;
    }
    private Node first;
    public Stack() {} // "empty"
    public void push(int x) {
	Node n = new Node();
	n.elem = x;
	n.next = first;
	first = n;
    }
    public int top() { return first.elem; }
    public void pop() { first = first.next; }
}
