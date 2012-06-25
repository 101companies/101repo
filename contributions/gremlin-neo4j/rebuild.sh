#!/bin/bash

GRAPHMLFILE="`pwd`/graphml/meganalysis.graphml"

DELETECODE="g.V.sideEffect{g.removeVertex(it)}"
INSERTCODE="g.loadGraphML(%22$GRAPHMLFILE%22)"
NEO4JHOST="http://localhost:7474/db/data/ext/GremlinPlugin/graphdb/execute_script"

function sendscript() {

    QUERY="curl -d \"script=$1\" $NEO4JHOST"

    echo -e "Sending Query: $1 to $NEO4JHOST..."

    RESULT=`eval $QUERY`

    echo -e "Result is: $RESULT"
}

sendscript $DELETECODE
sendscript $INSERTCODE

echo -e "Done."
