<h2>Company Information</h2>
<dl>
	<dt id="name-label"><label for="name" class="required">Name</label></dt>
	<dd id="name-element">
		<form id="company" enctype="application/x-www-form-urlencoded" action="<?php echo BASE_URL;?>?type=action&action=company" method="post">
			<input type="hidden" name="cid" value="1" id="id">
			<input type="text" name="name" id="name" class='round' value="<?php if (isset($companyInfo[0])){ echo $companyInfo[0]['name']; }?>">
			<input type="submit" name="save" id="submitbutton" value="save" class="round button">
		</form>
	</dd>
	<dt id="departments-label"><label for="departments" class="optional">Departments</label></dt>
	<dd id="departments-element">
		<form id="company" enctype="application/x-www-form-urlencoded" action="<?php echo BASE_URL;?>?section=department">
<!--			<input type="hidden" name="cid" value="1" id="id">-->
			<input type='hidden' name='section' value='department'>
			<select name="did" id="did">
				<?php if(isset($departments) && is_array($departments)){?>
					<?php foreach($departments as $department){?>
						<option value='<?php echo $department['id']?>'><?php echo $department['name']?></option>
					<?php }?>
				<?php }?>
			</select>
			<input type="submit" id="submitbutton" class='round button' value="select">
		</form>
	</dd>
	<dt id="total-label"><label for="total" class="optional">Total</label></dt>
	<dd id="total-element">
		<form id="company" enctype="application/x-www-form-urlencoded" action="<?php echo BASE_URL;?>?type=action&action=company" method='post'>
			<input type="text" name="total" id="total" value="<?php echo $total['total']?>" readonly="readonly" class='round'>
			<input type="submit" name="cut" id="submitbutton" class='round button' value="cut">
		</form>
	</dd>
</dl>