grammar MegaL;

options {
  k = 7;
}

@header {
package megal.parser;
}

@lexer::header {
package megal.parser;
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

megal : modelheader moduleinclude* decl* block* EOF;

modelheader : 'megamodel' simpleuri '.';

simpleuri : ID ('/' ID)+;

moduleinclude : 'include' simpleuri '.' ;

block : BLOCKCMT decl+;

decl : ( modifier? entity | relationship ) '.' DECLCMT?;

modifier : 'local' | 'variable';

entity :
      artifact '+'? idsbin (',' idsbin)*
    | 'Function' '+'? idsfun (',' idsfun)*
    ;

idsbin : ID (bin ID)?;

idsfun : ID fun?;

artifact
    : 'Artifact'
    | 'File'
    | 'Language'
    | 'Technology'
    | 'Fragment'
    | 'ObjectGraph'
    | 'Program'
    | 'Library'
    ;

relationship
    : ID bin ID
    | ID fun
    | ID '(' ID ')' '|->' ID
    ;

bin
    : ( '<'  | 'subsetOf' )
    | ( ':'  | 'elementOf' )
    | ( '@'  | 'partOf' )
    | ( '='  | 'correspondsTo' )
    | ( '~>' | 'dependsOn' | 'refersTo' )
    | ( '-|' | 'conformsTo' )
    | ( '=>' | 'realizationOf' | 'descriptionOf' | 'definitionOf' )
    ;
  
fun : ':' ID '->' ID;

ID       :   ('a'..'z'|'A'..'Z') ('_'|'a'..'z'|'A'..'Z'|'0'..'9')* ;
STRING   :   '"' (~'"')* '"';
WS       :   (' '|'\r'? '\n'|'\t')+ { skip(); };
DECLCMT  :   '-' '-' (~('\n'|'\r'))*;
BLOCKCMT :   '{' '-' ((~'-')|'-'~'}')* '-' '}';
