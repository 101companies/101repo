// Source: Chapter 40: Functional Data Structures by C. Okasaki. In: Handbook of Data Structures and Applications. Chapman & Hall/CRC.

public class Skew {
    public static final Skew empty = null;
    public static Skew insert(int x,Skew s) { return merge(new Skew(x,null,null),s); } 
    public static int findMin(Skew s) { return s.elem; }
    public static Skew deleteMin(Skew s) { return merge(s.left,s.right); }
    public static Skew merge(Skew s,Skew t) { 
	if (t == null) return s;
	else if (s == null) return t;
	else if (s.elem < t.elem)
	    return new Skew(s.elem,merge(t,s.right),s.left);
	else
	    return new Skew(t.elem,merge(s,t.right),t.left); 
    }
    private int elem;
    private Skew left,right;
    private Skew(int elem, Skew left, Skew right) {
	this.elem = elem; this.left = left; this.right = right;
    } 
}
