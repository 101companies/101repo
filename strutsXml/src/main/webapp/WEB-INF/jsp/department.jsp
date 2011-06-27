<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>    
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<!--  link href="<s:url value='/index.css'/>" rel="stylesheet" type="text/css" / -->
<style> td { white-space: nowrap; } </style>
</head>
<body>

<h2>Department details</h2>

<s:form action="DEP!save.action" method="post">
	<s:textfield name="department.name" value="%{department.name}" label="Name" size="30" />
	<s:textfield name="department.manager.person.name" value="%{department.manager.person.name}" label="Manager" size="30" />
	<s:textfield name="department.manager.salary" value="%{department.manager.salary}" label="Manager salary" size="15" />
	<s:textfield name="department.manager.person.address" value="%{department.manager.person.address}" label="Manager address" size="30" />
	<s:textfield value="%{department.total()}" label="Total salaries" readonly="true" size="30" />
	<s:hidden name="empName" value="%{department.manager.person.name}" />
	<s:hidden name="deptName" value="%{department.name}" />
	<s:submit value="Save" />
	<s:submit value="Cut" action="cutSalaries"/>
	<s:submit value="Company details" action="index" />
</s:form>
<br>
<h2><s:text name="Subdepartments" /></h2>
<table class="outline" border="1" width="50%">
	<tr>
		<th width="70%"><s:text name="Name" /></th>
		<th width="30%">Edit department</th>
	</tr>
	<s:iterator value="department.subunits" status="status">
	<tr>
		<s:if test="department">
			<td class="nowrap"><s:property value="name" /></td>
			<td class="nowrap">
				<s:url action="DEP!input" id="link">
					<s:param name="department.name" value="name" />
				</s:url> 
				<a href="<s:property value="#link"/>">Detail</a>
			</td>
		</s:if>
	</tr>
	</s:iterator>
</table>
<br>
<h2><s:text name="Employees" /></h2>
<table class="outline" border="1" width="50%">
	<tr>
		<th width="70%"><s:text name="Name" /></th>
		<th width="30%">Edit employee</th>
	</tr>
	<s:iterator value="department.subunits" status="status">
	<tr>
		<s:if test="!department">
			<td class="nowrap"><s:property value="person.name" /></td>
			<td class="nowrap">
				<s:url action="EMP!input" id="link">
					<s:param name="employee.person.name" value="person.name" />
				</s:url> 
				<a href="<s:property value="#link"/>">Detail</a>
			</td>
		</s:if>
	</tr>
	</s:iterator>
</table>

</body>
</html>