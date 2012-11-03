<?php
// Include configs and functions
include_once('lib/config.php');
include_once('lib/functions.php');
include_once('lib/Db.php');
$db = new Db();

if (get_input('type') == 'action'){
	switch(get_input('action')){
		case 'company':
			include('actions/company.php');
			back();
			break;
		case 'department':
			include('actions/department.php');
			back();
			break;
		case 'employee':
			include('actions/employee.php');
			back();
			break;
		default:
			header('Location: '.BASE_URL);
			die();
			break;
	}
}

//include page header
include_once('template/header.php');

//get Company information
$companyInfo = $db->getCompany();
$departments = $db->getDepartment();

switch(get_input('section')){
	case 'department':
		$did = get_input('did');
		$total = $db->companyTotal($did);
		if (get_input('add') == 'add'){
			$pdid = get_input('pdid', 0);
			include('template/newdepartment.php');
		}else{
			$employees = $db->getEmployees($did);
			$departmentInfo = $db->getDepartment($did);
			$subDepartments = $db->getDepartment($did, true);
			include('template/department.php');
		}
		break;
	case 'employee':
		$eid = get_input('eid');
		$employeeInfo = $db->getEmployees($eid, true);
		if (get_input('add') == 'add'){
			$employeeInfo = array();
			$eid = 0;
			$employeeInfo[0]['did'] = get_input('did');
		}
		include('template/employee.php');
		break;
	default:
		$total = $db->companyTotal();
		include('template/company.php');
		break;
}

//include page header
include_once('template/footer.php');
