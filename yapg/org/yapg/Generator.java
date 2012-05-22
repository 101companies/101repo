package org.yapg;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.yapg.grammar.Atom;
import org.yapg.grammar.Choice;
import org.yapg.grammar.Grammar;
import org.yapg.grammar.Many;
import org.yapg.grammar.Nonterminal;
import org.yapg.grammar.Option;
import org.yapg.grammar.Production;
import org.yapg.grammar.Sequence;
import org.yapg.grammar.Terminal;

/**
 * Code generator for Java/ANTLR code from .yapg specification
 */
public class Generator {

	public static void generate(String path, String pkg, String stem, Grammar g) throws IOException {
		generateJava(path, pkg, g);
		generateANTLR(path, pkg, stem, g);
	}
	
	private static void generateJava(String path, String pkg, Grammar g) throws IOException {
		for (Production p : g.prods) {
			FileWriter file = new FileWriter(path + File.separatorChar + p.lhs + ".java");
			PrintWriter out = new PrintWriter(file);
			out.println(
					"package "
					+ pkg 
					+ ";");
			if (p.rhs instanceof Sequence) {
				Sequence s = (Sequence)(p.rhs);
				out.println(
						"import java.util.*"
						+ ";");
				String superclass = superclass(g, p.lhs);
				out.println(
						"public class " 
						+ p.lhs
						+ (superclass == null ? "" : " extends " + superclass)
						+ " {");
				for (Atom a : s.list) {
					if (a instanceof Terminal) { 
						// no-op
					} else if (a instanceof Nonterminal) {
						Nonterminal n = (Nonterminal)a;
						out.println(
								"\tpublic "
								+ mapId(n.symbol)
								+ " " 
								+ n.label 
								+ ";");						
					} else {
						Many m = (Many)a;
						out.println(
								"\tpublic "
								+ "List<"
								+ mapId(m.elem.symbol)
								+ ">"
								+ " " 
								+ m.elem.label
								+ ";");
					}
				}					
			} else {
				@SuppressWarnings("unused")
				Choice c = (Choice)(p.rhs);
				out.println(
						"public abstract class " 
						+ p.lhs
						+ " {");
			}
			out.println("}");
			out.close();				
		}
	}

	private static void generateANTLR(String path, String pkg, String stem, Grammar g) throws IOException {
		FileWriter file = new FileWriter(path + File.separatorChar + stem + ".g");
		PrintWriter out = new PrintWriter(file);
		out.print(Template.antlrPrefix(pkg, stem));
		for (Production p : g.prods) {
			out.println("parse" + p.lhs + " returns [" +  p.lhs + " result] : ");
			if (p.rhs instanceof Sequence) {
				Sequence s = (Sequence)(p.rhs);
				for (Atom a : s.list)
					if (a instanceof Terminal) { 
						Terminal t = (Terminal)a;
						out.print("\t\'" + t.symbol + "\'\n");						
					} else if (a instanceof Nonterminal) {
						Nonterminal n = (Nonterminal)a;
						out.print("\t" + n.label + "=parse" + n.symbol + "\n");						
					} else {
						Many m = (Many)a;
						out.print(
								"\t{ " 
								+ "List<"
								+ m.elem.symbol 
								+ "> "
								+ m.elem.label 
								+ "List = new LinkedList<" 
								+ m.elem.symbol 
								+ ">(); }\n");
						out.print(
								"\t( " 
								+ m.elem.label 
								+ "=parse" 
								+ m.elem.symbol 
								+ " { " 
								+ m.elem.label 
								+ "List.add($"
								+ m.elem.label
								+ ".result); } )*\n");						
					}
				out.print("\t{ $result = new " + p.lhs + "(); ");
				for (Atom a : s.list)
					if (a instanceof Terminal) { 
						// no-op
					} else if (a instanceof Nonterminal) {
						Nonterminal n = (Nonterminal)a;
						out.print("$result." + n.label + " = $" + n.label + ".result; ");										
					} else {
						Many m = (Many)a;
						out.print("$result." + m.elem.label + " = " + m.elem.label + "List; ");										
					}				
				out.print("}\n");										
			} else {
				Choice c = (Choice)(p.rhs);
				out.print("\t" + Template.branchOfChoice(c.first));
				for (Option o : c.rest) {
					out.print("\t|" + Template.branchOfChoice(o.symbol));
				}
			}
			out.println(";");
		}
		out.print(Template.antlrPostfix);
		out.close();				
	}
		
	private static String mapId(String id) {
		return 
				id.equals("Id") ? "String" : 
					id.equals("QString") ? "String" :
						id.equals("QqString") ? "String" :
							id;
	}
	
	private static String superclass(Grammar g, String s) {
		for (Production p : g.prods)
			if (p.rhs instanceof Choice) {
				Choice c = (Choice)(p.rhs);
				if (c.first.equals(s))
					return p.lhs;
				for (Option o : c.rest)
					if (o.symbol.equals(s))
						return p.lhs;				
			}
		return null;
	}

}
