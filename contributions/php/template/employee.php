<h2>Employee Information</h2>
<form enctype="application/x-www-form-urlencoded" action="<?php echo BASE_URL;?>?type=action&action=employee" method="post">
<input type='hidden' name='eid' value='<?php echo $eid;?>'>
<dl>
	<dt><label for="name" class="required">Name</label></dt>
	<dd>
		<input type="text" name="name" id="name" class='round' value="<?php if (isset($employeeInfo[0])){ echo $employeeInfo[0]['name']; }?>">
	</dd>
	<dt><label for="address" class="optional">Address</label></dt>
	<dd>
		<input type="text" name="address" id="address" class='round' value="<?php if (isset($employeeInfo[0])){ echo $employeeInfo[0]['address']; }?>">
	</dd>
	<dt><label for="salary" class="optional">Salary</label></dt>
	<dd>
		<input type="text" name="salary" id="salary" class='round' value="<?php if (isset($employeeInfo[0])){ echo $employeeInfo[0]['salary']; }?>">
	</dd>
	<dt><label for="manager" class="optional">Is Manager</label></dt>
	<dd>
		<input type="checkbox" name="manager" id="manager" class='round' value="1" <?php if (isset($employeeInfo[0]) && $employeeInfo[0]['manager'] == '1'){ echo 'checked'; }?>>
	</dd>
</dl>
<input type='hidden' name='did' value='<?php if (isset($employeeInfo[0])){ echo $employeeInfo[0]['did']; }?>'>
<input type='submit' class='button round' value='save'>
<input type='submit' class='button round' value='cut' name='cut'>
<input type='submit' class='button round' value='delete' name='delete' onclick="return confirm('Do you really want to delete this employee?');">
<input type='button' onclick="document.location.assign('<?php echo BASE_URL;?>?section=department&did=<?php if (isset($employeeInfo[0])){ echo $employeeInfo[0]['did']; }?>')" class='button round' value='back'>
</form>