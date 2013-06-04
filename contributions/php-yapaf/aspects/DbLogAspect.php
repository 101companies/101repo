<?php

class DbLogAspect {

	/**
	 * @Call(class="Db", method="getCompany")
	 * @Call(class="Db", method="getDepartment")
	 * @Call(class="Db", method="getEmployees")
	 * @Call(class="Db", method="update")
	 * @Call(class="Db", method="insert")
	 * @Call(class="Db", method="delete")
	 * @Call(class="Db", method="cutSalary")
	 * @Call(class="Db", method="cutCompanySalary")
	 * @Call(class="Db", method="companyTotal")
	 * @Call(class="Db", method="refreshDepartmentManager")
	 */
	public function log() {
		$file = fopen('/tmp/101companiesDbLog.txt', 'a');
		fwrite($file, __METHOD__ . ': ' . print_r(func_get_args(), true));
		fclose($file);
	}
}