package geflo.pattern;

public class LineMatchingNotSupportedException
		extends RuntimeException {
	
	private static final long serialVersionUID = -3642046630155155267L;
	
	public LineMatchingNotSupportedException() {
		super("This pattern class could not be used as line number matcher!");
	}

}
