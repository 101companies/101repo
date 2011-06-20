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

<h2>Employee details</h2>



<s:if test="message != null">
 <h2><s:property value="message"/>  </h2>
</s:if>


<s:form action="employee.update" >



<s:textfield label="Name" value="%{employee.name}"  name="employee.name" /> 
<s:textfield label="Salary" value="%{employee.salary}" name="employee.salary" /> 
<s:textfield label="Address" value="%{employee.address}" name="employee.address" /> 

<s:hidden name="employee.id" value="%{employee.id}"/>

<s:submit label="Update" value="Update" />
</s:form>

</body>
</html>