<h2>Department Information</h2>
<dl>
	<dt><label for="name" class="required">Name</label></dt>
	<dd>
		<form enctype="application/x-www-form-urlencoded" action="<?php echo BASE_URL;?>?type=action&action=department" method="post">
<!--			<input type="hidden" name="cid" value="1" id="id">-->
			<input type="hidden" name="did" value="<?php echo $did?>" id="did">
			<input type="text" name="name" id="name" class='round' value="<?php if (isset($departmentInfo[0])){ echo $departmentInfo[0]['name']; }?>">
			<input type="submit" name="save" id="submitbutton" value="save" class="button round">
		</form>
	</dd>
	<dt><label for="departments" class="optional">Employees</label></dt>
	<dd>
		<form id="company" enctype="application/x-www-form-urlencoded" action="<?php echo BASE_URL;?>">
<!--			<input type="hidden" name="cid" value="1" id="id">-->
			<input type='hidden' name='section' value='employee'>
			<input type='hidden' name='did' value='<?php if (isset($departmentInfo[0])){ echo $departmentInfo[0]['id']; }?>'>
			<select name="eid" id="eid">
				<?php if(isset($employees) && is_array($employees)){?>
					<?php foreach($employees as $employee){?>
						<option value='<?php echo $employee['id']?>'><?php echo $employee['name']?></option>
					<?php }?>
				<?php }?>
			</select>
			<input type="submit" name="select" id="submitbutton" value="select" class='button round'>
			<input type="submit" name="add" id="submitbutton" value="add" class='button round'>
		</form>
	</dd>
	<dt><label for="departments" class="optional">Departments</label></dt>
	<dd>
		<form id="company" enctype="application/x-www-form-urlencoded" action="<?php echo BASE_URL;?>">
<!--			<input type="hidden" name="cid" value="1" id="id">-->
			<input type='hidden' name='section' value='department'>
			<input type='hidden' name='pdid' value='<?php if (isset($departmentInfo[0])){ echo $departmentInfo[0]['id']; }?>'>
			<select name="did" id="did">
				<?php if(isset($subDepartments) && is_array($subDepartments)){?>
					<?php foreach($subDepartments as $subDepartment){?>
						<option value='<?php echo $subDepartment['id']?>'><?php echo $subDepartment['name']?></option>
					<?php }?>
				<?php }?>
			</select>
			<input type="submit" id="submitbutton" value="select" class='button round'>
			<input type="submit" name="add" id="submitbutton" value="add" class='button round'>
		</form>
	</dd>
	<dt><label for="total" class="optional">Total</label></dt>
	<dd>
		<form id="company" enctype="application/x-www-form-urlencoded" action="<?php echo BASE_URL;?>">
			<input type="hidden" name="type" value="action">
			<input type="hidden" name="action" value="department">
			<input type="hidden" name="did" value="<?php echo $did?>" id="did">
			<input type="text" name="total" id="total" value="<?php echo $total['total'];?>" readonly="readonly" class='round'>
			<input type="submit" name="cut" id="submitbutton" value="cut" class='button round'>
		</form>
	</dd>
</dl>
<?php if (isset($departmentInfo[0]['did'])){?>
<input type='button' onclick="document.location.assign('<?php echo BASE_URL;?>?section=department&did=<?php if (isset($departmentInfo[0])){ echo $departmentInfo[0]['did']; }?>')" class='button round' value='back'>
<?php }else{?>
<input type='button' onclick="document.location.assign('<?php echo BASE_URL;?>');" class='button round' value='back'>
<?php }?>