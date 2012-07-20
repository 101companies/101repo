<?php

include_once 'src/geshi.php';

$ifilename = $argv[1];
$ofilename = $argv[2];
$language = $argv[3];

$text = file_get_contents($ifilename) or die("can't open input file");

$geshi = new GeSHi();
$geshi->set_source($text);
$geshi->set_language($language); 
$geshi->enable_line_numbers(GESHI_NORMAL_LINE_NUMBERS);
$geshi->enable_classes();
$geshi->enable_ids(true);

$output = $geshi->parse_code();
$ofile = fopen($ofilename, 'w') or die("can't open output file");
fwrite($ofile, $output);
fclose($ofile);

?>

