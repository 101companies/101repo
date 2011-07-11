<?php
	$con = establishConnection();

	// retrieve parameters
	if($_SERVER['HTTP_TABLE'] != "" && $id = $_SERVER['HTTP_ID'] != "") {
		
		$table = $_SERVER['HTTP_TABLE'];
		$id = $_SERVER['HTTP_ID'];
		
		if ($_SERVER['HTTP_ACTION'] == "load") {
			loadData($table, $id);
		} else if ($_SERVER['HTTP_ACTION'] == "cut") {
			cut($table, $id);
			loadData($table, $id);
		} else if ($_SERVER['HTTP_ACTION'] == "reset") {
			resetCompany();
			loadData($table, $id);
		} else if ($_SERVER['HTTP_ACTION'] == "save") {
			if ($table == "company") {
				saveCompany($id, $HTTP_RAW_POST_DATA);
			} else if ($table == "department") {
			
			} else {
			
			}
			loadData($table, $id);
		} else if ($_SERVER['HTTP_ACTION'] == "changePage") {
			getIdForName($HTTP_RAW_POST_DATA);
		}
	}
	
	// get id for department with a given name
	function getIdForName($name) {
		$request = "SELECT id FROM department WHERE name = \"$name\"";
		$result = mysql_query($request);
		$row = mysql_fetch_object($result);
		$id = "$row->id";
		
		echo $id;
	}
	
	// load data for company, department or employee
	function loadData($table, $id) {
		if ($table == "company") {
			company($id);
		} else if ($table == "department") {
			department($id);
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
	function company($id) {
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
	function department($id) {
		$department = "{";
		
		// name
		$request = "SELECT * FROM department WHERE id = $id";
		$result = mysql_query($request);
		$row = mysql_fetch_object($result);

		$name = "$row->name";
		$department = $department . "\"name\": \"" . $name . "\",";
		
		// employees
		$department = $department . "\"employees\":[";
		$request = "SELECT * FROM employee WHERE did = $id";
		$result = mysql_query($request);
		$count = mysql_num_rows($result);
		while($row = mysql_fetch_object($result)) {
			if ("$row->manager" == "1") {
				$manager = "$row->name";
			} else {
				$emp = "$row->name";
				$department = $department . "\"" . $emp . "\",";
			}
		}
		
		if ($count > 1) {
			$department = substr($department, 0, strlen($department) - 1);
		}
		
		
		$department = $department . "],";
		$department = $department . "\"manager\": \"" . $manager . "\",";
		
		
		// departments
		$department = $department . "\"departments\":[";
		
		$request = "SELECT * FROM department WHERE did = $id";
		$result = mysql_query($request);
		$count = mysql_num_rows($result);
		while($row = mysql_fetch_object($result)) {
			$subdep = "$row->name";
			$department = $department . "\"" . $subdep . "\",";
		}
		
		if ($count > 0) {
			$department = substr($department, 0, strlen($department) - 1);
		}
		$department = $department . "]";
		
		$department = $department . "}";
		echo $department;
	}
	
	// load employee
	function employee($id) {
	
	}
	
	function saveCompany($id, $newName) {
		$request = "UPDATE company SET name = \"$newName\" WHERE id = $id";
		mysql_query($request);
	}
	
	// cut company, department or employee
	function cut($table, $id) {
		if ($table == "company") {
			$request = "UPDATE employee SET salary = salary / 2 WHERE cid = $id";
			mysql_query($request);
		} else if ($table == "department") {
			
		} else {
			$request = "UPDATE employee SET salary = salary / 2 WHERE id = $id";
			mysql_query($request);
		}
	}
	
	function resetCompany() {

	}
?>
