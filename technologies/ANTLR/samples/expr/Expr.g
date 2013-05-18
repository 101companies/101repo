/*

Original version downloaded from here:

http://www.antlr.org/wiki/display/ANTLR3/Expression+evaluator

*/

grammar Expr;

@header {
package expr;
import java.util.HashMap;
}
@lexer::header {
package expr;
}

@members {
/** Map variable name to Integer object holding value */
HashMap memory = new HashMap();
}

prog:   stat+ ;
                
stat: 
        expr NEWLINE 
        { System.out.println($expr.value); }

    |   ID '=' expr NEWLINE
        { memory.put($ID.text.intern(), new Integer($expr.value)); }

    |   NEWLINE
    ;

expr returns [int value]
    :   e=multExpr {$value = $e.value;}
        (   '+' e=multExpr {$value += $e.value;}
        |   '-' e=multExpr {$value -= $e.value;}
        )*
    ;

multExpr returns [int value]
    :   e=atom { $value = $e.value; }
        ('*' e=atom { $value *= $e.value; })*
    ; 

atom returns [int value]
    :   INT 
        { $value = Integer.parseInt($INT.text); }

    |   ID
        {
        Integer v = (Integer)memory.get($ID.text);
        if ( v!=null ) $value = v.intValue();
        else System.err.println("undefined variable "+$ID.text);
        }

    |   '(' expr ')'
        { $value = $expr.value; }
    ;

ID  :   ('a'..'z'|'A'..'Z')+ ;
INT :   '0'..'9'+ ;
NEWLINE :'\r'? '\n' ;
WS  :   (' '|'\t')+ {skip();} ;
