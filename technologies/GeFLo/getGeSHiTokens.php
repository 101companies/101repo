<?php

// Search for the condiguration file 
$myself = realpath($argv[0]);
$configFile = dirname($myself).'/../../../101worker/configs/main.config.local.php' ;
echo $configFile;
if (! is_file($configFile)) {
  $configFile = dirname($myself)."/../".$configFile ;
}
require_once $configFile;

if (DEBUG > 10) echo "Using megalib from ".ABSPATH_MEGALIB."\n";
if (DEBUG > 10) echo "Using GeSHi from ".ABSPATH_SRC_GESHI_LIBRARY."\n";

require_once ABSPATH_MEGALIB.'SourceFiles.php';

if (count($argv) < 3) {
	echo "ERROR: Too few arguments!\n";
	echo "Usage info: getGeSHiTokens.php inputFileName outputFileName\n";
	exit(1);
}

$pathin = $argv[1];
$pathout = $argv[2];
if (!is_file($pathin)) {
	echo "ERROR: The first argument has to be a file!";
	exit(1);
}
$sourceFile = new SourceFile($pathin) ;
file_put_contents($pathout, json_encode($sourceFile->getSourceCode()->getTokens())) ;
exit(0);

?>