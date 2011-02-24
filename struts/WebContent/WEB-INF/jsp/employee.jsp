<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>    
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:set name="empInfo" value="%{'Employee information'}"/>
<html>
<head>
<link href="<s:url value='/index.css'/>" rel="stylesheet" type="text/css" />
<title>Employee information</title>
</head>
<body>
<div class="titleDiv"><s:text name="Employee"/></div>
<br><br>
<h1><s:property value="#empInfo"/></h1>
<s:form action="EMP!save.action" method="post">
    <s:textfield name="employee.person.name" value="%{employee.person.name}" label="Name" size="30"/>
    <s:textfield name="employee.person.address" value="%{employee.person.address}" label="Address" size="30"/>
    <s:textfield name="employee.salary" value="%{employee.salary}" label="Salary" size="15"/>
   	<s:hidden value="%{employee.person.name}" name="empName"/>
    <s:submit value="Submit and back to root" />
    <s:submit value="Cancel" name="redirect-action:index" />
</s:form>
<a href="javascript:history.go(-1)" >Go to previous page</a>

</body>
</html>