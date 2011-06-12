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

<s:form>

<h2>Department details</h2>

<s:textfield label="Name" value="%{department.name}"  /> 
<s:textfield label="Manager" value="%{department.manager.name}"  /> 
<s:textfield label="Total salaries" value="%{department.total}" readonly="true"  /> 

<s:submit label="Update" action="department.update" />

<table id="hor-minimalist-a" summary="Subunits">
    <thead>
    	<tr>
            <th scope="col">Name</th>
            <th scope="col">Total Salary</th>
	    <th scope="col">Cut salaries</th>
	    <th scope="col">Show details</th>
        </tr>
    </thead>
    <tbody> 
		    <s:iterator value="department.subunits">
  	    	    <tr>
			<td><s:property value="name"/></td>
    			<td><s:property value="total"/></td>
			<td>
 			  <s:url id="detailURL" action="subunit.cutSalaries">
  			     <s:param name="name" value="%{name}"/>
 			     <s:param name="parentId" value="%{department.id}" />
			  </s:url>
 			  <s:a href="%{detailURL}">Cut</s:a>
                        </td>
			<td>
  			 <s:if test="%{isDepartment()}">
 			    <s:url id="detailURL" action="department.detail">
  			     <s:param name="dptId" value="%{id}"/>
 			    </s:url>
 			    <s:a href="%{detailURL}">Detail</s:a>
			 </s:if>
			 <s:else>
    			  -
			 </s:else>
			</td>
  	    	    </tr>
 		    </s:iterator>
    </tbody>	
</table> 
</s:form>

</body>
</html>