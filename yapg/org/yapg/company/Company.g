grammar Company;
options { k = 4; }

@header {
package org.yapg.company;
import java.util.List;
import java.util.LinkedList;
}

@lexer::header {
package org.yapg.company;
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
parseCompany returns [Company result] : 
	'company'
	cname=parseQqString
	'{'
	{ List<Department> departmentsList = new LinkedList<Department>(); }
	( departments=parseDepartment { departmentsList.add($departments.result); } )*
	'}'
	{ $result = new Company(); $result.cname = $cname.result; $result.departments = departmentsList; }
;
parseDepartment returns [Department result] : 
	'department'
	dname=parseQqString
	'{'
	'manager'
	manager=parseEmployee
	{ List<Department> subdepartmentsList = new LinkedList<Department>(); }
	( subdepartments=parseDepartment { subdepartmentsList.add($subdepartments.result); } )*
	{ List<NonManager> employeesList = new LinkedList<NonManager>(); }
	( employees=parseNonManager { employeesList.add($employees.result); } )*
	'}'
	{ $result = new Department(); $result.dname = $dname.result; $result.manager = $manager.result; $result.subdepartments = subdepartmentsList; $result.employees = employeesList; }
;
parseNonManager returns [NonManager result] : 
	'employee'
	employee=parseEmployee
	{ $result = new NonManager(); $result.employee = $employee.result; }
;
parseEmployee returns [Employee result] : 
	name=parseQqString
	'{'
	'address'
	address=parseQqString
	'salary'
	salary=parseNumber
	'}'
	{ $result = new Employee(); $result.name = $name.result; $result.address = $address.result; $result.salary = $salary.result; }
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