<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
<title>Blah</title>
</head>
<body>
<h1>This is the Struts2 implementation of 101companies.</h1> <br/>

<hr/>

This implementation uses struts2 and struts2-convention-plugin so that its navigation process is 
based on name conventions, instead of xml file configurations. Please, take a look at 

<ul>
<li>http://struts.apache.org/2.1.6/docs/convention-plugin.html</li>
</ul>

<hr/>

<s:form action="list-all-companies">
	<s:submit label="View all companies" />
</s:form>
</body>
</html>
