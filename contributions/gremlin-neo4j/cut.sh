#!/bin/bash

CUTCODE="g.V.outE%28%27EMPLOYED%27%29.sideEffect%7Bit.salary+%3D+%28double%29it.salary+%2F+2.0%7D"
NEO4JHOST="http://localhost:7474/db/data/ext/GremlinPlugin/graphdb/execute_script"

QUERY="curl -d \"script=$CUTCODE\" $NEO4JHOST"

echo -e "Sending Gremlin Query: $CUTCODE to $NEO4JHOST..."

RESULT=`eval $QUERY`

echo -e "Result is: $RESULT"
