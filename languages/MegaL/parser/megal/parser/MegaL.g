grammar MegaL;

options {
  k = 5;
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

megal : decl* block* EOF;

block : BLOCKCMT decl+;

decl : ( entity | relationship ) '.' DECLCMT?;

entity
    : 'Language' idbin
    | 'Languages' idbin (',' idbin)+
    | artifact idbin
    | artifacts idbin (',' idbin)+
    | 'Function' idfun
    | 'Functions' idfun (',' idfun)+
    ;

idbin : ID (bin ID)?;

idfun : ID fun?;

artifact
    : 'Artifact'
    | 'File'
    | 'Fragment'
    | 'ObjectGraph'
    | 'Program'
    | 'Library'
    ;

artifacts
    : 'Artifacts'
    | 'Files'
    | 'Fragments'
    | 'ObjectGraphs'
    | 'Programs'
    | 'Libraries'
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

ID       :   ('a'..'z'|'A'..'Z') ('a'..'z'|'A'..'Z'|'0'..'9')* ;
STRING   :   '"' (~'"')* '"';
WS       :   (' '|'\r'? '\n'|'\t')+ { skip(); };
DECLCMT  :   '-' '-' (~('\n'|'\r'))*;
BLOCKCMT :   '{' '-' ((~'-')|'-'~'}')* '-' '}';
