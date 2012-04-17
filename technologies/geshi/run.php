<?php

include_once 'src/geshi.php';

$ifilename = $argv[1];

$ofilename = $argv[2];

$language = $argv[3];

$input = file_get_contents($ifilename) or die("can't open input file");

$geshi = new GeSHi($input, $language);

$output = $geshi->parse_code();

$ofile = fopen($ofilename, 'w') or die("can't open output file");

fwrite($ofile, $output);

fclose($ofile);

?>

