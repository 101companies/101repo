package org.softlang.parser;

import static org.softlang.parser.CompanyLexer.*;
import parseLib.parser.*;
import static parseLib.acceptor.Acceptor.*;
import parseLib.util.*;
import javaf.prelude.Function1;
import java.util.List;

/**
 * A combinator-based parser for companies.
 * All salaries are totaled.
 */
public class CompanyParser extends Parser<Double> {

	/** 
	 * Parse companies.
	 */
	public static Parser<Double> company() {
		return new Parser<Double>() {
			public Double parse(Input i) {
				return (
						mkSnd(
							sequence(
								SPECIAL("company"),
								STRING,
								SPECIAL("{")),
							mkFst(
								mkFunction(
									mkStar(department()),
									sumList
								),
								sequence(
									SPECIAL("}"),
									EOF // Test that all input has been consumed.
						)))).parse(i);
				}
		};
	}

	/** 
	 * Parse departments.
	 */
	public static Parser<Double> department() {
		return new Parser<Double>() {
			public Double parse(Input i) {
				return (
					mkFunction(
						mkTuple3(
							mkSnd(
								sequence(
									SPECIAL("department"),
									STRING,
									SPECIAL("{")),
								employee("manager")),
							mkStar(employee("employee")),
							mkFst(
								mkStar(department()),
								SPECIAL("}"))),
						new Function1<Tuple3<Double,List<Double>,List<Double>>,Double>() {
							public Double apply(Tuple3<Double, List<Double>, List<Double>> t) {
								return sumTriplet.apply(t);
							}
						}
						)).parse(i);
			}
		};
	}
	
	/** 
	 * Parse employees.
	 */
	public static Parser<Double> employee(final String keyword) {
		return new Parser<Double>() {
			public Double parse(Input i) {
				return (
					mkSnd(
						sequence(
							SPECIAL(keyword),
							STRING,
							SPECIAL("{"),
							SPECIAL("address"),
							STRING,
							SPECIAL("salary")),
						mkFst(
							new MkDouble(FLOAT),
							SPECIAL("}")
				))).parse(i);
			}
		};
	}	
	
	/**
	 * Invoke start symbol.
	 */
	public Double parse(Input i) {
		return company().parse(i);
	}
	
	// Sum up elements in a list
	private static Function1<List<Double>,Double> sumList = 
		new Function1<List<Double>,Double>() {
			public Double apply(List<Double> l) {
				Double result = 0.0;
				for (Double d : l) result += d;
				return result;
			}
		};
		
	// Sum up elements in a triplet
	private static Function1<Tuple3<Double,List<Double>,List<Double>>,Double> sumTriplet =
		new Function1<Tuple3<Double,List<Double>,List<Double>>,Double>() {
			public Double apply(Tuple3<Double,List<Double>,List<Double>> t) {
				Double result = 0.0;
				result += t.proj1;
				for (Double d : t.proj2) result += d;
				for (Double d : t.proj3) result += d;
				return result;
			}
	};		
}
