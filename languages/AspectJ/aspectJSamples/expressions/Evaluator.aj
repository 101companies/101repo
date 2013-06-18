package expressions;

/**
 * An operation for expression evaluation
 */
public aspect Evaluator {
	
	public abstract int Expr.evaluate();
	
	public int Lit.evaluate() {
		return getInfo();
	}
	
	public int Add.evaluate() {
		return left.evaluate() + right.evaluate();
	}
	
	public int Neg.evaluate() {
		return - expr.evaluate();
	}
}
