<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s" %>

<html>
<head>
<title>101companies - Department Details</title>
    <style type="text/css">
       <%@ include file="../../tab-style.css" %>
    </style>
    <LINK type="text/css" rel="stylesheet" href="space.css">
    <LINK type="text/css" rel="stylesheet" href="http://cwiki.apache.org/confluence/download/resources/confluence.ext.code:code/shStyles.css">
    <STYLE type="text/css">
      .dp-highlighter {
        width:95% !important;
      }
    </STYLE>
    <STYLE type="text/css">
      .footer {
        background-image:      url('http://cwiki.apache.org/confluence/images/border/border_bottom.gif');
        background-repeat:     repeat-x;
        background-position:   left top;
        padding-top:           4px;
        color:                 #666;
      }
    </STYLE>
</head>

<body>

<h2>Department details</h2>



<s:if test="message != null">
 <h2><s:property value="message"/>  </h2>
</s:if>


<s:form action="department.update" >



<s:textfield label="Name" value="%{department.name}"  name="department.name" /> 
<s:textfield label="Manager" value="%{department.manager.name}" name="department.manager.name" /> 
<s:textfield label="Manager salary" value="%{department.manager.salary}" name="department.manager.salary" /> 
<s:textfield label="Manager address" value="%{department.manager.address}" name="department.manager.address" /> 
<s:textfield label="Total salaries" value="%{department.total}" readonly="true"  /> 

<s:hidden name="department.id" value="%{department.id}"/>

<s:submit label="Update" value="Update" />
<s:submit label="Cut" value="Cut salaries" action="department.cutSalariesOfDepartment"  />

</s:form>

<table id="box-table-a" summary="Subunits">
        <thead>
    	<tr>
        	<th scope="col" class="rounded-company">Unit</th>
            <th scope="col" class="rounded-q1">Salary</th>
            <th scope="col" class="rounded-q2">Show details</th>

        </tr>
    </thead>
    <tbody> 
    		<s:iterator value="department.subunits">
  	    	    <tr>
			<td><s:property value="name"/></td>
    		<td><s:property value="total"/></td>
  			 <s:if test="%{isDepartment()}">
  			 	<td>
 			    	<s:url id="detailURL" action="department.detail">
  			     	 <s:param name="dptId" value="%{id}"/>
 			    	</s:url>
 			    	<s:a href="%{detailURL}">Detail</s:a>
 			    </td>
			 </s:if>
			 <s:else>
    			<td>
 			    	<s:url id="detailEmployeeURL" action="employee.detail">
  			     	 <s:param name="empId" value="%{id}"/>
  			     	 <s:param name="dptId" value="%{department.id}" />
 			    	</s:url>
 			    	<s:a href="%{detailEmployeeURL}">Detail</s:a>
 			    </td>
			 </s:else>
  	    </tr>
 		</s:iterator>	
    </tbody>	
</table> 

</body>
</html>