<?php
	$con = establishConnection();

	// retrieve parameters
	if($_SERVER['HTTP_TABLE'] != "" && $id = $_SERVER['HTTP_ID'] != "") {
		
		$table = $_SERVER['HTTP_TABLE'];
		$id = $_SERVER['HTTP_ID'];
		
		if ($_SERVER['HTTP_ACTION'] == "cut") {
			cut($table, $id);
		} else if ($_SERVER['HTTP_ACTION'] == "reset") {
			//resetCompany();
		}
		
		if ($table == "company") {
			company($table, $id);
		} else if ($table == "department") {
		
		} else {
		
		}
	}
	
	closeConnection($con);
	
	// establish connection to database
	function establishConnection() {
		$con = mysql_connect ("localhost", "101companies", "101companies")
				or die ("Connection failed. Name or password wrong!");

		mysql_select_db("101companies") or die ("Database does not exist.");
		return $con;
	}
	
	// close connection
	function closeConnection($con) {
		mysql_close($con);
	}
	
	// load company
	function company($table, $id) {
		$company = "{";
	
		// name
		$request = "SELECT * FROM company WHERE id = $id";
		$result = mysql_query($request);
		$row = mysql_fetch_object($result);

		$name = "$row->name";
		$company = $company . "\"name\": \"" . $name . "\",";
		
		// departments
		$company = $company . "\"departments\":[";
		
		$request = "SELECT * FROM department WHERE cid = $id AND did IS NULL";
		$result = mysql_query($request);
		$count = mysql_num_rows($result);
		while($row = mysql_fetch_object($result)) {
			$department = "$row->name";
			$company = $company . "\"" . $department . "\",";
		}
		
		if ($count > 0) {
			$company = substr($company, 0, strlen($company) - 1);
		}
		
		$company = $company . "],";
		
		// total
		$request = "SELECT * FROM employee";
		$result = mysql_query($request);
		$total = 0;
		while($row = mysql_fetch_object($result)) {
			$total += "$row->salary";
		}
		
		$company = $company . "\"total\":" . $total;
		$company = $company . "}";
		
		echo $company;
	}
	
	// load department
	function department($table, $id) {
	
	}
	
	// load employee
	function employee($table, $id) {
	
	}
	
	
	
	function cut($table, $id) {
		if ($table == "company") {
			$request = "UPDATE employee SET salary = salary / 2 WHERE cid = $id";
			mysql_query($request);
		} else {
		
		}
	}
	
	function resetCompany() {
		
	}
?>
