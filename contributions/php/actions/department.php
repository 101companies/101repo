<?php
$departmentName = get_input('name');

if (get_input('cut') == 'cut'){
	cutSalary(get_input('did', 0));
	back();
}

if ($departmentName == ''){
	back();
}else{
	
	if (get_input('add') == "add"){
		if (insert('department', array('name'=>$departmentName, 'did'=>get_input('pdid', NULL), 'cid'=>1))){
			header('Location: '.BASE_URL.'?section=department&did='.get_input('pdid'));
			die();
		}else{
			// TODO: add error messages here
			back();
		}
	}else{
		if (update('department', get_input('did', 1), array('name'=>$departmentName))){
			back();
		}else{
			// TODO: add error messages here
			back();
		}
	}
}