declare default element namespace "http://www.softlang.org/company.xsd";

declare function local:cut-salary($element as element()) as element()
{
	element
	{node-name($element)}
	{
		$element/@*,
		for $child in $element/node()
		return
			if ($child/local-name()='salary')
			then <salary>{$child/text() div 2}</salary>
			else
				if ($child instance of element())
				then local:cut-salary($child)
				else $child
	}
};

<company>
{
	for $dept in //dept
	return local:cut-salary($dept)
}
</company>
