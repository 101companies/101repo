package dumper;

public class Demo {

	/**
	 * Dump (print) an object's state 
	 */
	public static void main(String[] args) {
		Tree tree = new Tree();
		tree.info = 1;
		tree.left = new Tree();
		tree.left.info = 2;
		tree.right = new Tree();		
		tree.right.info = 3;
		tree.right.left = new Tree();		
		tree.right.left.info = 4;
		Dumper.dump(tree);
	}

}
