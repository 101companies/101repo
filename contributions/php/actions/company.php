<?php
$companyName = get_input('name');

if (get_input('cut') == 'cut'){
	cutCompanySalary();
	back();
}

if ($companyName == ''){
	back();
}else{
	if (update('company', get_input('id', 1), array('name'=>$companyName))){
		back();
	}else{
		// TODO: add error messages here
		back();
	}
}