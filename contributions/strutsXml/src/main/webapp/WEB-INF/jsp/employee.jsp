<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>    
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<!--   link href="<s:url value='/index.css'/>" rel="stylesheet" type="text/css" / -->
</head>
<body>
<h2>Employee details</h2>

<s:form action="EMP!save.action" method="post">
    <s:textfield name="employee.person.name" value="%{employee.person.name}" label="Name" size="30"/>
    <s:textfield name="employee.person.address" value="%{employee.person.address}" label="Address" size="30"/>
    <s:textfield name="employee.salary" value="%{employee.salary}" label="Salary" size="15"/>
   	<s:hidden value="%{employee.person.name}" name="empName"/>
    <s:submit value="Save" />
    <s:submit value="Cut" action="cutSalaries"/>
    <s:submit value="Company details" action="index" />
</s:form>
</body>
</html>