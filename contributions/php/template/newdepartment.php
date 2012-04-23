<h2>Department Information</h2>
<dl>
	<dt><label for="name" class="required">Name</label></dt>
	<dd>
		<form enctype="application/x-www-form-urlencoded" action="<?php echo BASE_URL;?>?type=action&action=department" method="post">
			<input type="hidden" name="pdid" value="<?php echo $pdid?>" id="did">
			<input type="text" name="name" id="name" class='round' value="<?php if (isset($departmentInfo[0])){ echo $departmentInfo[0]['name']; }?>">
			<input type="submit" id="submitbutton" value="add" name='add' class="button round">
		</form>
	</dd>
</dl>