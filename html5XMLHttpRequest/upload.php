<?php
	$uploaddir = "";
	
	if($_SERVER['HTTP_X_FILE_NAME']!="") {

		$nomefile=$_SERVER['HTTP_X_FILE_NAME'];

		$fh = fopen($uploaddir.$nomefile, 'w') or die("<h1 style='color:red;'>Upload failed</h1>");

		fwrite($fh, $HTTP_RAW_POST_DATA);

		fclose($fh);

		echo "<h1>success uploaded</h1>.\n";
	}
?>
