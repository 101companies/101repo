#!/bin/bash

set -o verbose

URL="http://127.0.0.1:8080/OneOhOneCompanies/Portal?wsdl"
DIR_CLASSFILES="artifacts/"
DIR_LIB="lib/"
JAR="OneOhOneService.jar"

/System/Library/Frameworks/JavaVM.framework/Versions/1.6/Commands/wsimport $URL -keep -d $DIR_CLASSFILES

/System/Library/Frameworks/JavaVM.framework/Versions/1.6/Commands/jar -cf $JAR -C $DIR_CLASSFILES .
mv $JAR $DIR_LIB
