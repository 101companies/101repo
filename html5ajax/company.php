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
		} else if ($_SERVER['HTTP_ACTION'] == "reset") {
			resetCompany();
			loadData($table, $id);
		} else if ($_SERVER['HTTP_ACTION'] == "save") {
			if ($table == "company") {
				saveCompany($id, $HTTP_RAW_POST_DATA);
			} else if ($table == "department") {
				saveDepartment($id, $HTTP_RAW_POST_DATA);
			} else {
				saveEmployee($id, $HTTP_RAW_POST_DATA);
			}
			loadData($table, $id);
		} else if ($_SERVER['HTTP_ACTION'] == "selectDepartment") {
			getIdForName("department", $HTTP_RAW_POST_DATA);
		} else if ($_SERVER['HTTP_ACTION'] == "selectEmployee") {
			getIdForName("employee", $HTTP_RAW_POST_DATA);
		}
	}
	
	closeConnection($con);
	
	// get id for department with a given name
	function getIdForName($table, $name) {
		$request = "SELECT id FROM $table WHERE name = \"$name\"";
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
			employee($id);
		}
	}
	
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
		
		// employees and manager
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
		while ($row = mysql_fetch_object($result)) {
			$subdep = "$row->name";
			$department = $department . "\"" . $subdep . "\",";
		}
		
		if ($count > 0) {
			$department = substr($department, 0, strlen($department) - 1);
		}
		$department = $department . "],";
		
		// total
		$total = totalDepartment($id);
		
		$department = $department . "\"total\":" . $total;
		
		$department = $department . "}";
		echo $department;
	}
		
	// total of a department and its subdepartments
	function totalDepartment($id) {
		$total = 0;
		$request = "SELECT * FROM department WHERE did = $id";
		$result = mysql_query($request);
		while ($row = mysql_fetch_object($result)) {
			$total += totalDepartment("$row->id");
		}
		$request = "SELECT * FROM employee WHERE did = $id";
		$result = mysql_query($request);
		while ($row = mysql_fetch_object($result)) {
			$total += "$row->salary";
		}
		return $total;
	}
	
	// cut for a department and its subdepartments
	function cutDepartment($id) {
		$request = "SELECT * FROM department WHERE did = $id";
		$result = mysql_query($request);
		while ($row = mysql_fetch_object($result)) {
			cutDepartment("$row->id");
		}
		$request = "UPDATE employee SET salary = salary / 2 WHERE did = $id";
		mysql_query($request);
	}
	
	// load employee
	function employee($id) {
		$request = "SELECT * FROM employee WHERE id = $id";
		$result = mysql_query($request);
		$row = mysql_fetch_object($result);

		$name = "$row->name";
		$address = "$row->address";
		$salary = "$row->salary";
		
		$employee = "{ \"name\": \"" . $name . "\", \"address\": \"" . $address . "\", \"salary\": " . $salary . "}";
		echo $employee;
	}
	
	// save company-name
	function saveCompany($id, $newName) {
		$request = "UPDATE company SET name = \"$newName\" WHERE id = $id";
		mysql_query($request);
	}
	
	// save department-name
	function saveDepartment($id, $newName) {
		$request = "UPDATE department SET name = \"$newName\" WHERE id = $id";
		mysql_query($request);
	}
	
	// save employee-data
	function saveEmployee($id, $data) {
		$empl = json_decode($data);
		$name = $empl->name;
		$address = $empl->address;
		$salary = $empl->salary;
		
		$request = "UPDATE employee SET name = '$name' WHERE id = $id";
		mysql_query($request);
		
		$request = "UPDATE employee SET address = '$address' WHERE id = $id";
		mysql_query($request);

		$request = "UPDATE employee SET salary = $salary WHERE id = $id";
		mysql_query($request);
	}
	
	// cut company, department or employee
	function cut($table, $id) {
		if ($table == "company") {
			$request = "UPDATE employee SET salary = salary / 2 WHERE cid = $id";
			mysql_query($request);
			
			$request = "SELECT * FROM employee";
			$result = mysql_query($request);
			$total = 0;
			while($row = mysql_fetch_object($result)) {
				$total += "$row->salary";
			}
			echo $total;
		} else if ($table == "department") {
			cutDepartment($id);
			echo totalDepartment($id);
		} else {
			$request = "UPDATE employee SET salary = salary / 2 WHERE id = $id";
			mysql_query($request);
		}
	}
	
	function resetCompany() {

	}
?>
