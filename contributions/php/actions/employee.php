<?php
$data = array();
$data['name'] = get_input('name');
$data['address'] = get_input('address');
$data['salary'] = get_input('salary');
$data['manager'] = get_input('manager');

if (get_input('did') != "")
	$data['did'] = get_input('did');

if ($data['manager'] == 1){
	refreshDepartmentManager($data['did']);
}	
	
$data['cid'] = 1;

if (get_input('cut') == 'cut'){
	cutSalary(get_input('eid', 0));
	back();
}
if (get_input('delete') == 'delete'){
	delete('employee', get_input('eid', 0));
	header('Location: '.BASE_URL.'?section=department&did='.get_input('did'));
	die();
}

if ($data['name'] == ''){
	back();
}else{
	if (get_input('eid') == '0'){
		if (insert('employee', $data)){
			header('Location: '.BASE_URL.'?section=department&did='.get_input('did'));
			die();
		}else{
			// TODO: add error messages here
			back();
		}
	}else{
		if (update('employee', get_input('eid', 0), $data)){
			back();
		}else{
			// TODO: add error messages here
			back();
		}
	}
}