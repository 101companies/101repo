<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
<title>101Companies</title>
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
<h1>This is the Struts2 implementation of 101companies.</h1> <br/>


<p>This implementation uses struts2 and struts2-convention-plugin so that its navigation process is 
based on name conventions, instead of xml file configurations. Please, take a look at:</p>  

<ul>
<li>http://struts.apache.org/2.1.6/docs/convention-plugin.html</li>
</ul>

<s:form action="list-all-companies">
	<s:submit label="View all companies" />
</s:form>

</body>

</html>
