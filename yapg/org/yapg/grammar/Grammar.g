grammar Grammar;
options { k = 4; }

@header {
package org.yapg.grammar;
import java.util.List;
import java.util.LinkedList;
}

@lexer::header {
package org.yapg.grammar;
}
@members {

	// Throw if any error was emitted
	public boolean error = false;

	@Override
	public void emitErrorMessage(String msg)
	{
	  error = true;
	  super.emitErrorMessage(msg);
	}
}
parseGrammar returns [Grammar result] : 
	{ List<Production> prodsList = new LinkedList<Production>(); }
	( prods=parseProduction { prodsList.add($prods.result); } )*
	{ $result = new Grammar(); $result.prods = prodsList; }
;
parseProduction returns [Production result] : 
	lhs=parseId
	':'
	rhs=parseExpression
	';'
	{ $result = new Production(); $result.lhs = $lhs.result; $result.rhs = $rhs.result; }
;
parseExpression returns [Expression result] : 
		parseSequence { $result = $parseSequence.result; }
	|	parseChoice { $result = $parseChoice.result; }
;
parseSequence returns [Sequence result] : 
	{ List<Atom> listList = new LinkedList<Atom>(); }
	( list=parseAtom { listList.add($list.result); } )*
	{ $result = new Sequence(); $result.list = listList; }
;
parseChoice returns [Choice result] : 
	first=parseId
	{ List<Option> restList = new LinkedList<Option>(); }
	( rest=parseOption { restList.add($rest.result); } )*
	{ $result = new Choice(); $result.first = $first.result; $result.rest = restList; }
;
parseAtom returns [Atom result] : 
		parseTerminal { $result = $parseTerminal.result; }
	|	parseNonterminal { $result = $parseNonterminal.result; }
	|	parseMany { $result = $parseMany.result; }
;
parseTerminal returns [Terminal result] : 
	symbol=parseQString
	{ $result = new Terminal(); $result.symbol = $symbol.result; }
;
parseNonterminal returns [Nonterminal result] : 
	label=parseId
	'='
	symbol=parseId
	{ $result = new Nonterminal(); $result.label = $label.result; $result.symbol = $symbol.result; }
;
parseOption returns [Option result] : 
	'|'
	symbol=parseId
	{ $result = new Option(); $result.symbol = $symbol.result; }
;
parseMany returns [Many result] : 
	elem=parseNonterminal
	'*'
	{ $result = new Many(); $result.elem = $elem.result; }
;
parseId returns [String result] :
	ID
	{ $result = $ID.text; }
	;

parseQString returns [String result] :
	QSTRING
	{ $result = $QSTRING.text.substring(1,$QSTRING.text.length()-1); }
	;

parseQqString returns [String result] :
	QQSTRING
	{ $result = $QQSTRING.text.substring(1,$QQSTRING.text.length()-1); }
	;

parseNumber returns [Number result] :
	NUMBER
	{ $result = Double.parseDouble($NUMBER.text); }
	;

WS : (' '|'\r'? '\n'|'\t')+ { skip(); };
ID	: ('a'..'z'|'A'..'Z') ('a'..'z'|'A'..'Z'|'0'..'9'|'_')*;
QSTRING : '\'' (~'\'')* '\'';
QQSTRING : '"' (~'"')* '"';
NUMBER : ('0'..'9')+ ('.' ('0'..'9')+)?;