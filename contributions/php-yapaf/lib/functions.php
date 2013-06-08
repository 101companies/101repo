<?php

/*
 * Get REQUEST variables value
 *
 * @param string $name
 * @param string $defaut - default value, if variable not set
 *
 * @return string $value;
 *
 */
function get_input($name, $default = ''){

	if (isset($_REQUEST[$name])){
		return $_REQUEST[$name];
	}else{
		return $default;
	}

}
/*
 * Redirect user to previous page
 *
 */
function back(){
	header('Location: '.REFERER);
	die();
}