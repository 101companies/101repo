declare default element namespace "http://www.softlang.org/company.xsd";

declare function local:dept-depth ($root as node()?) as xs:integer?
{
	if ($root/dept)
	then max($root/*/local:dept-depth(.)) + 1
	else
		if ($root/subunit/du)
		then max($root/subunit/du/local:dept-depth(.)) + 1
		else 0
};

<result>
	{local:dept-depth(/company)}
</result>
