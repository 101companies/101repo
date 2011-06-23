<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s" %>

<html>
<head>
<title>101companies - Employee Details</title>
</head>

<body>

<h2>Employee details</h2>



<s:if test="message != null">
 <h2><s:property value="message"/>  </h2>
</s:if>


<s:form action="employee.update" >

<s:textfield label="Name" value="%{employee.name}"  name="employee.name" /> 
<s:textfield label="Salary" value="%{employee.salary}" name="employee.salary" /> 
<s:textfield label="Address" value="%{employee.address}" name="employee.address" /> 

<s:hidden name="employee.id" value="%{employee.id}"/>
<s:hidden name="deptId" value="%{deptId}"/>

<s:submit label="Save" value="Save" />

</s:form>

</body>
</html>