package expressions;

/**
 * The expression form of "literals" (i.e., constants)
 */
public class Lit extends Expr {
	private int info;
	public int getInfo() { return info; }
	public void setInfo(int info) { this.info = info; }
}
