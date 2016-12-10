<%@page import="com.cg.mycampus.Bean.Employee.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Display</title>
<style>
table#nat{
	width: 50%;
	background-color: #c48ec5;
}
</style>
</head>
<body background="PlainLogo.jpg">  
<H1>Successfully registered you can go for cash less with only KinId in campus for any transaction</H1>
<% 	
String name =  request.getParameter("name");
	String Id = request.getParameter("id");
	String Email = request.getParameter("email");
	String Mobile = request.getParameter("mobile");
	String Pin = request.getAttribute("pin").toString(); %>
<table id ="nat">
<tr>
	<td>Full Name</td>
	<td><%= name %></td>
</tr>
<tr>
	<td>Id</td>
	<td><%= Id %></td>
</tr>
<tr>
	<td>Email</td>
	<td><%= Email %></td>
</tr>
<tr>
	<td>Mobile</td>
	<td><%= Mobile %></td>
</tr>
<tr>
	<td>Pin</td>
	<td><%= Pin %></td>
</tr>

</table>
 <a href="index.jsp">Please click here for Login</a>
</body>
</html>