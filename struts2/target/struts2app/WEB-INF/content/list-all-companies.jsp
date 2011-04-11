<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
<title>101companies - all companies</title>
</head>
<body>

<h1>All companies</h1>

<s:iterator value="allCompanies">
  <p>company: <s:property value="name"/></p>
</s:iterator> 
</body>
</html>