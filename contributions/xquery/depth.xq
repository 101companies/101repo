declare default element namespace "http://www.softlang.org/company.xsd";

declare function local:dept-depth ($root as node()?) as xs:integer?
{
	(if (empty($root/*))
	    then 0
		else max($root/*/local:dept-depth(.)))
	+
	(if ($root/department)
		then 1
		else 0)
};

<result>
	{local:dept-depth(/company)}
</result>
