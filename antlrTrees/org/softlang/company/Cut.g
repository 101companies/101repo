tree grammar Cut;

options { 
  tokenVocab=Company;
  ASTLabelType=CommonTree;
  output = AST;
  filter=true;
  backtrack=true;
}

@header {
package org.softlang.company;
}
    
// START: strategy
topdown : employee;
// END: strategy
        
employee :
  ^(EMPLOYEE STRING STRING s=FLOAT)
  -> ^(EMPLOYEE STRING STRING FLOAT[Double.toString(Double.parseDouble($s.text) / 2.0d)])
  ;
