package org.yapg;

/**
 * Template for code generation in good old "printf" style.
 * The core of the code generation code lives in Generator.java.
 */
public class Template {
	
	
	/**
	 * reusable header and error handling part
	 */
	static String antlrPrefix(String pkg, String stem) {
		return
				
"grammar " + stem + ";\n" +
"options { k = 4; }\n" +
"\n" +
"@header {\n" +
"package " + pkg + ";\n" +
"import java.util.List;\n" +
"import java.util.LinkedList;\n" +
"}\n" +
"\n" +
"@lexer::header {\n" +
"package " + pkg + ";\n" +
"}\n" +
"@members {\n" +
"\n" +
"	// Throw if any error was emitted\n" +
"	public boolean error = false;\n" +
"\n" +
"	@Override\n" +
"	public void emitErrorMessage(String msg)\n" +
"	{\n" +
"	  error = true;\n" +
"	  super.emitErrorMessage(msg);\n" +
"	}\n" +
"}\n"

		;
	}
	
	/**
	 * reusable Lexer part
	 */
	static String antlrPostfix =
			
"parseId returns [String result] :\n" +
"	ID\n" +
"	{ $result = $ID.text; }\n" +
"	;\n" +
"\n" +
"parseQString returns [String result] :\n" +
"	QSTRING\n" +
"	{ $result = $QSTRING.text.substring(1,$QSTRING.text.length()-1); }\n" +
"	;\n" +
"\n" +
"parseQqString returns [String result] :\n" +
"	QQSTRING\n" +
"	{ $result = $QQSTRING.text.substring(1,$QQSTRING.text.length()-1); }\n" +
"	;\n" +
"\n" +
"parseNumber returns [Number result] :\n" +
"	NUMBER\n" +
"	{ $result = Double.parseDouble($NUMBER.text); }\n" +
"	;\n" +
"\n" +
"WS : (' '|'\\r'? '\\n'|'\\t')+ { skip(); };\n" +
"ID	: ('a'..'z'|'A'..'Z') ('a'..'z'|'A'..'Z'|'0'..'9'|'_')*;\n" +
"QSTRING : '\\'' (~'\\'')* '\\'';\n" +
"QQSTRING : '\"' (~'\"')* '\"';\n" +
"NUMBER : ('0'..'9')+ ('.' ('0'..'9')+)?;"

	;

	static String branchOfChoice(String option) {
		return "\tparse" + option + " { $result = $parse" + option + ".result; }\n";
	}

}
