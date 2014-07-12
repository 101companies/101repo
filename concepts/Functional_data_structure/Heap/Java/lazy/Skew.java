// Source: Chapter 40: Functional Data Structures by C. Okasaki. In: Handbook of Data Structures and Applications. Chapman & Hall/CRC.

public class Skew {
    private int elem;
    private Skew left,right;
    private boolean pendingMerge;
    public static final Skew empty = null;
    public static Skew insert(int x,Skew s) {
	return merge(new Skew(x,null,null),s); 
    } 
    public static int findMin(Skew s) {
	executePendingMerge(s);
	return s.elem; 
    }
    public static Skew deleteMin(Skew s) {
	executePendingMerge(s);
	return merge(s.left,s.right);
    }
    public static Skew merge(Skew s,Skew t) {
	if (t == null) return s;
	else if (s == null) return t;
	else return new Skew(s,t); // create a pending merge
    }
    private Skew(int elem, Skew left, Skew right) {
	this.elem = elem; 
	this.left = left; 
	this.right = right;
	pendingMerge = false;
    }
    private Skew(Skew left,Skew right) { // create a pending merge
	this.left = left; 
	this.right = right;
	pendingMerge = true;
    }
    private static void executePendingMerge(Skew s) {
	if (s != null && s.pendingMerge) {
	    Skew s1 = s.left, s2 = s.right;
	    executePendingMerge(s1);
	    executePendingMerge(s2);
	    if (s2.elem < s1.elem) { 
		Skew tmp = s1;
		s1 = s2; s2 = tmp; 
	    } s.elem = s1.elem;
	    s.left = merge(s2,s1.right);
	    s.right = s1.left;
	    s.pendingMerge = false;
	} 
    }
}
