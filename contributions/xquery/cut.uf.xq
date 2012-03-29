declare default element namespace "http://www.softlang.org/company.xsd";

copy $copy := .
modify 
	for $salary in $copy//salary 
	return replace value of node $salary with $salary div 2 
return $copy

