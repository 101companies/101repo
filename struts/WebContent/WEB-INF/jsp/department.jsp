<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>    
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:set name="depInfo" value="%{'Department information'}"/>
<html>
<head>
<link href="<s:url value='/index.css'/>" rel="stylesheet" type="text/css" />
<style> td { white-space: nowrap; } </style>
<title>Department information</title>
</head>
<body>
<div class="titleDiv"><s:text name="Department" /></div>
<br><br>
<h1><s:property value="#depInfo" /></h1>
<s:form action="DEP!save.action" method="post">
	<s:textfield name="department.name" value="%{department.name}" label="department name" size="30" />
	<s:textfield name="department.manager.person.name" value="%{department.manager.person.name}" label="manager name" size="30" />
	<s:textfield name="department.manager.person.address" value="%{department.manager.person.address}" label="manager address" size="30" />
	<s:textfield name="department.manager.salary" value="%{department.manager.salary}" label="manager salary" size="15" />
	<s:hidden name="empName" value="%{department.manager.person.name}" />
	<s:hidden name="deptName" value="%{department.name}" />
	<s:submit value="Submit and back to root" />
	<s:submit value="Cancel" name="redirect-action:index" />
</s:form>
<a href="javascript:history.go(-1)" >Go to previous page</a>

<h1><s:text name="Total" /></h1>
<p><strong><s:property value="%{department.total()}"/> $</strong></p>
<br><br>
<h1><s:text name="Subdepartments" /></h1>
<table class="outline">
	<tr>
		<th><s:text name="Name" /></th>
		<th>&nbsp;</th>
	</tr>
	<s:iterator value="department.subunits" status="status">
	<tr>
		<s:if test="du!=null">
			<td class="nowrap"><s:property value="du.name" /></td>
			<td class="nowrap">
				<s:url action="DEP!input" id="link">
					<s:param name="department.name" value="du.name" />
				</s:url> 
				<a href="<s:property value="#link"/>">Edit</a>
			</td>
		</s:if>
	</tr>
	</s:iterator>
</table>
<br><br>
<h1><s:text name="Employees" /></h1>
<table class="outline">
	<tr>
		<th><s:text name="Name" /></th>
		<th>&nbsp;</th>
	</tr>
	<s:iterator value="department.subunits" status="status">
	<tr>
		<s:if test="pu!=null">
			<td class="nowrap"><s:property value="pu.person.name" /></td>
			<td class="nowrap">
				<s:url action="EMP!input" id="link">
					<s:param name="employee.person.name" value="pu.person.name" />
				</s:url> 
				<a href="<s:property value="#link"/>">Edit</a>
			</td>
		</s:if>
	</tr>
	</s:iterator>
</table>

</body>
</html>