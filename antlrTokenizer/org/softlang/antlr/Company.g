lexer grammar Company;

options {
  k = 0;
}

@header {
package org.softlang.antlr;
}

@members {
  @Override
  public void reportError(RecognitionException e) {
    throw new IllegalArgumentException(e);
  }
}

COMPANY     : 'company';
DEPARTMENT  : 'department';
EMPLOYEE    : 'employee';
MANAGER     : 'manager';
ADDRESS     : 'address';
SALARY      : 'salary';
OPEN        : '{';
CLOSE       : '}';
WS          :   (' '|'\r'? '\n'|'\t')+;
STRING      :   '"' (~'"')* '"';
FLOAT       : DIGIT+ ('.' DIGIT+)?;

fragment DIGIT : ('0'..'9'); 
