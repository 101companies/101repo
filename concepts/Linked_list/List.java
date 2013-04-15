// A simple form of linked lists
public class List {
    // Nodes in a linked list
    public class Node {
	public int info;
	public Node next; 
    }
    public Node first;
    public Node last;
    public void add(int info) {
	Node node = new Node();
	node.info = info;
	if (first==null) 
	    first = node;
	if (last!=null) 
	    last.next = node;
	last = node;
    }
}
