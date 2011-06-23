<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
<title>101companies - all companies</title>
 
</head>

<body>

<s:push value="company">
 <h2><s:property value="name"/>  </h2>
 <h3>Total salaries: <s:property value="total"/> </h3>
</s:push>

<table id="box-table-a" summary="Employee Pay Sheet" border="1px" width="45%">
    <thead>
    	<tr>
            <th scope="col">Name</th>
            <th scope="col">Total Salary</th>
	    <th scope="col">Cut salaries</th>
	    <th scope="col">Show details</th>
        </tr>
    </thead>
    <tbody> 
		    <s:iterator value="company.depts">
  	    	    <tr>
			<td><s:property value="name"/></td>
    		<td><s:property value="total"/></td>
			<td>
 			  <s:url id="cutURL" action="company.cutSalariesOfDepartment">
  			   <s:param name="dptId" value="%{id}"/>
 			   <s:param name="cmpId" value="company.id"/>
			  </s:url>
 			  <s:a href="%{cutURL}">Cut</s:a>
                        </td>
			<td>
 			  <s:url id="detailURL" action="department.detail">
  			   <s:param name="dptId" value="%{id}"/>
 			  </s:url>
 			  <s:a href="%{detailURL}">Detail</s:a>
                        </td>
  	    	    </tr>
 		    </s:iterator>
    </tbody>	
</table> 


</body>
</html>