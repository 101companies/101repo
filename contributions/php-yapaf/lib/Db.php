<?php

class Db {

	protected $dbConnection;

	public function __construct() {
		$db = mysql_connect(DB_HOST, DB_USER, DB_PASSWORD);
		if (!$db) {
			die('Db connection error: ' . mysql_error());
		}
		mysql_select_db(DB_NAME, $db);

		$this->dbConnection = $db;
	}

	/*
	 * Get Companie Info
	 *
	 * @return array - Company info
	 */
	function getCompany(){
		//Execute query
		$result = mysql_query('SELECT * FROM company');

		//get DB table as Array
		$data = array();
		while($row = mysql_fetch_assoc($result)){
			$data[] = $row;
		}

		return $data;
	}

	/*
	 * Get Departments
	 *
	 * @param $id - id of needed department, default = 0. If 0 - returnes all MAIN departments
	 * @param $subDepartment true|false - return subdepartments of current department or not
	 *
	 * @return array - Department info
	 */
	function getDepartment($id = 0, $subDepartments = false){

		// Generate query
		$query = 'SELECT * FROM department';

		//If we have department ID to find, then add condition to query
		if ($id != 0){
			if ($subDepartments)
				$query .= " WHERE did = {$id}";
			else
				$query .= " WHERE id = {$id}";
		}else{
			$query .= " WHERE did IS NULL";
		}

		//Execute query
		$result = mysql_query($query);

		$data = array();
		while($row = mysql_fetch_assoc($result)){
			$data[] = $row;
		}

		//get DB table as Array
		return $data;
	}

	/*
	 * Get Employees
	 *
	 * @param $id - id of needed department, default = 0. If 0 - returnes all Employees from DB.
	 * If $id = -1 - return all employees that are without department (if exists)
	 * @param $returnInfo true|false - return just user information if true
	 *
	 * @return array - Employees array
	 */
	function getEmployees($id = 0, $returnInfo = false){

		// Generate query
		$query = 'SELECT * FROM employee';

		//If we have department ID to find, then add condition to query
		if ($id != 0){
			if ($returnInfo)
				$query .= " WHERE id = {$id}";
			else
				$query .= " WHERE did = {$id}";
		}elseif($id == -1){
			$query .= " WHERE did IS NULL";
		}

		//Execute query
		$result = mysql_query($query);

		$data = array();
		while($row = mysql_fetch_assoc($result)){
			$data[] = $row;
		}

		//get DB table as Array
		return $data;
	}

	/*
	 * Update Table with needen data
	 *
	 * @param string $tableName to update;
	 * @param id $id - item ID;
	 * @param array $data - associative array with info for update
	 *
	 * @return true|false
	 */
	function update($tableName, $id, $data = array()){

		$query = "UPDATE {$tableName} SET ";
		$values = array();
		foreach ($data as $key=>$value){
			$values[] = "{$key} = '{$value}'";
		}
		$query .= implode(',', $values);
		$query .= " WHERE id = {$id}";

		if (mysql_query($query)){
			return true;
		}else{
			return false;
		}
	}

	/*
	 * Insert data to table
 	 *
	 * @param string $tableName to insert;
	 * @param array $data - associative array with info for insert
	 *
	 * @return true|false
	 */
	function insert($tableName, $data = array()){

		$query = "INSERT INTO {$tableName} SET ";
		$values = array();
		foreach ($data as $key=>$value){
			$values[] = "{$key} = '{$value}'";
		}
		$query .= implode(',', $values);

		if (mysql_query($query)){
			return true;
		}else{
			return false;
		}
	}

	function delete($tableName, $id){

		$query = "DELETE FROM {$tableName} WHERE id={$id}";
		if (mysql_query($query)){
			return true;
		}else{
			return false;
		}

	}
	/*
	 * Cut the salary for some employee
	 *
	 * @param $eid int - employee id, for cutting his salary
	 */
	function cutSalary($eid){

		$query = 'UPDATE employee SET salary = salary/2';
		$query .= " WHERE id = {$eid}";

		if (mysql_query($query)){
			return true;
		}else{
			return false;
		}

	}

	/*
	 *
	 */
	function cutCompanySalary($did = 0){

		$query = 'UPDATE employee SET salary = salary/2';
		$query .= " WHERE cid = 1";

		if ($did != 0){
			$query .= ' AND did='.$did;
		}

		if (mysql_query($query)){
			return true;
		}else{
			return false;
		}

	}

	/*
	 * Get Total salary of all company
	 *
	 * Return salary amount
	 */
	function companyTotal($did = 0){

		$query = "SELECT SUM(salary) as total FROM employee WHERE cid = 1";
		if ($did != 0){
			$query .= ' AND did='.$did;
		}
		$result = mysql_query($query);
		return mysql_fetch_assoc($result);

	}

	function refreshDepartmentManager($did){

		$query = "UPDATE employee SET manager = 0 WHERE did = ".$did;
		if (mysql_query($query)){
			return true;
		}else{
			return false;
		}
	}
}