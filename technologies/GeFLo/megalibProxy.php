<?php

require_once dirname(__FILE__).'/../../../101worker/configs/main.config.local.php';

if (DEBUG > 10) echo "Using megalib from ".ABSPATH_MEGALIB."\n";

if (!defined('ABSPATH_SRC_GESHI_LIBRARY')) {
	define('ABSPATH_SRC_GESHI_LIBRARY', ABSPATH_BASE.'101repo/technologies/geshi/src');
}

if (DEBUG > 10) echo "Using GeSHi from ".ABSPATH_SRC_GESHI_LIBRARY."\n";

require_once ABSPATH_MEGALIB.'SourceCode.php';
require_once ABSPATH_MEGALIB.'FileSystemMatcher.php';

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

$matcher	= new GeSHiExtensionPatternMatcher();
$fileInfo	= $matcher->matchPath('file', $path);
if (empty($fileInfo)) {
	echo "ERROR: Unknown extension for GeSHi! Can\'t parse file contents!";
	exit(1);
}

$contents	= file_get_contents($path);
$sourceCode	= new SourceCode($contents, $fileInfo['geshiLanguage']);

// Box the token array in an associative array
echo json_encode(array('tokens' => $sourceCode->getTokens()));
exit(0);