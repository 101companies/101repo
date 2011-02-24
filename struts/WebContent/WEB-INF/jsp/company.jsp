<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>    
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<link href="<s:url value='/index.css'/>" rel="stylesheet" type="text/css" />
<title>Company</title>
</head>
<body>
<div class="titleDiv"><s:text name="Company" /></div>
<br><br>
<table class="outline">	
	<tr>
		<th><s:text name="Department" /></th>
		<th>&nbsp;</th>
	</tr>
	<s:iterator value="depts" status="status">
		<tr>
			<td class="nowrap"><s:property value="name" /></td>
			<td class="nowrap">
				<s:url action="DEP" id="link">
					<s:param name="department.name" value="name" />
				</s:url> 
				<a href="<s:property value="#link"/>">Edit</a>
			</td>
		</tr>
	</s:iterator>

</table>
<br>
<h1><s:text name="Total" /></h1>
<p><strong><s:property value="%{company.total()}"/> $</strong></p>

</body>
</html>