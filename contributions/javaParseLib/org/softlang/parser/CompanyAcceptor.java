package org.softlang.parser;

import static org.softlang.parser.CompanyLexer.*;
import parseLib.acceptor.*;
import parseLib.util.Input;

/**
 * A combinator-based acceptor for companies.
 */
public class CompanyAcceptor extends Acceptor {

	/** 
	 * Parse companies.
	 */
	public static Acceptor company() {
		return new Acceptor() {
			public boolean accept(Input i) {
				return (
					sequence(
						SPECIAL("company"),
						STRING,
						SPECIAL("{"),
						star(department()),
						SPECIAL("}"),						
						EOF // Test that all input has been consumed.
				)).accept(i);
			}
		};
	}

	/** 
	 * Parse departments.
	 */
	public static Acceptor department() {
		return new Acceptor() {
			public boolean accept(Input i) {
				return (
						sequence(
							SPECIAL("department"),
							STRING,
							SPECIAL("{"),
							employee("manager"),
							star(employee("employee")),
							star(department()),
							SPECIAL("}")
						)).accept(i);
			}
		};
	}
		
	/** 
	 * Parse employees.
	 */
	public static Acceptor employee(final String keyword) {
		return new Acceptor() {
			public boolean accept(Input i) {
				return (
						sequence(
							SPECIAL(keyword),
							STRING,
							SPECIAL("{"),
							SPECIAL("address"),
							STRING,
							SPECIAL("salary"),
							FLOAT,						
							SPECIAL("}")
						)).accept(i);
			}
		};
	}	
	
	/**
	 * Invoke start symbol.
	 */
	public boolean accept(Input i) {
		return company().accept(i);
	}
}
