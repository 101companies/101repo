#!/bin/bash

TOTALCODE="g.V.outE('EMPLOYED').collect{it.salary}.flatten().sum()"
NEO4JHOST="http://localhost:7474/db/data/ext/GremlinPlugin/graphdb/execute_script"

QUERY="curl -d \"script=$TOTALCODE\" $NEO4JHOST"

echo -e "Sending Gremlin Query: $TOTALCODE to $NEO4JHOST..."

RESULT=`eval $QUERY`

echo -e "Result is: $RESULT"
