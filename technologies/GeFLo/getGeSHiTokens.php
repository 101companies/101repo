<?php

// Search for the condiguration file 
$configFile = '../../../101worker/configs/main.config.local.php' ;
if (! is_file($configFile)) {
  $configFile = "../".$configFile ;
}
require_once $configFile;

if (DEBUG > 10) echo "Using megalib from ".ABSPATH_MEGALIB."\n";
if (DEBUG > 10) echo "Using GeSHi from ".ABSPATH_SRC_GESHI_LIBRARY."\n";

require_once ABSPATH_MEGALIB.'SourceFiles.php';

if (count($argv) < 2) {
	echo "ERROR: Too few arguments!\n";
	echo "Usage info: megaLProxy.php fileName\n";
	echo "Returns a JSON string with a token array.\n";
	exit(1);
}

$path = $argv[1];
if (!is_file($path)) {
	echo "ERROR: The first argument has to be a file!";
	exit(1);
}
$sourceFile = new SourceFile($path) ;
echo json_encode($sourceFile->getSourceCode()->getTokens()) ;
exit(0);