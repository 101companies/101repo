PREFIX co: <http://www.company.com/ns#>
PREFIX afn: <http://jena.hpl.hp.com/ARQ/function#>

MODIFY
DELETE
 { ?employee co:salary ?salary }
INSERT
 { ?employee co:salary ?salary }
WHERE
 { ?employee co:salary ?salary }