package expressions;

/**
 * An operation for pretty printing
 */
public aspect PrettyPrinter {
	
	public abstract String Expr.prettyPrint();
	
	public String Lit.prettyPrint() {
		return Integer.toString(getInfo());
	}
	
	public String Add.prettyPrint() {
			return left.prettyPrint() + " + " + right.prettyPrint();
	}
	
	public String Neg.prettyPrint() {
		return "- (" + expr.prettyPrint() + ")";
	}
}
