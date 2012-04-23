<?php
// Include configs and functions
include_once('lib/config.php');
include_once('lib/functions.php');

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
$companyInfo = getCompany();
$departments = getDepartment();

switch(get_input('section')){
	case 'department':
		$did = get_input('did');
		$total = companyTotal($did);
		if (get_input('add') == 'add'){
			$pdid = get_input('pdid', 0);
			include('template/newdepartment.php');
		}else{
			$employees = getEmployees($did);
			$departmentInfo = getDepartment($did);
			$subDepartments = getDepartment($did, true);
			include('template/department.php');
		}
		break;
	case 'employee':
		$eid = get_input('eid');
		$employeeInfo = getEmployees($eid, true);
		if (get_input('add') == 'add'){
			$employeeInfo = array();
			$eid = 0;
			$employeeInfo[0]['did'] = get_input('did');
		}
		include('template/employee.php');
		break;	
	default:
		$total = companyTotal();
		include('template/company.php');
		break;
}

//include page header
include_once('template/footer.php');
