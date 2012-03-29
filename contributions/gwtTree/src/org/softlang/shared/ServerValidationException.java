package org.softlang.shared;

public class ServerValidationException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3079013864962251636L;
	
	public enum Field {
		NAME,
		SALARY
	}
	
	private Field field;
	
	public ServerValidationException() {
		
	}
	
	public ServerValidationException(Field field, String message) {
		super(message);
		this.field = field;
	}

	public Field getField() {
		return field;
	}

	public void setField(Field field) {
		this.field = field;
	}
}
