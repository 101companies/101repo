<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>    
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<!--link href="<s:url value='/index.css'/>" rel="stylesheet" type="text/css" / -->
<title>Company</title>
</head>
<body>
<h2><s:text name="company.name" /></h2>

<h3>Total salaries: <s:property value="%{company.total()}"/> </h3>

<s:form action="cutCompanySalaries" method="post">
 <s:submit value="Cut salaries" />
</s:form>

<br><br>
<table class="outline" border="1" width="50%">	
	<tr>
		<th>Department</th>
		<th>Department details</th>
	</tr>
	<s:iterator value="depts" status="status">
		<tr>
			<td class="nowrap"><s:property value="name" /></td>
			<td class="nowrap">
				<s:url action="DEP" id="link">
					<s:param name="department.name" value="name" />
				</s:url> 
				<a href="<s:property value="#link"/>">Detail</a>
			</td>
		</tr>
	</s:iterator>

</table>
<br>


</body>
</html>