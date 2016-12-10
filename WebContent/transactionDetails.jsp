<%@page import="com.cg.mycampus.Bean.Employee.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Transaction details</title>
</head>
<body>
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
<body>  
<H1>Transaction recorded successfully</H1>
<% 	
String vendorid =  request.getParameter("vendorid");
	String employeeid = request.getParameter("employeeid");
	String items = request.getParameter("items");
	String amount = request.getParameter("amount");
	 %>
<table id ="nat">
<tr>
	<td>vendorid</td>
	<td><%= vendorid %></td>
</tr>
<tr>
	<td>employeeid</td>
	<td><%= employeeid %></td>
</tr>
<tr>
	<td>Items List</td>
	<td><%= items %></td>
</tr>
<tr>
	<td>Amount</td>
	<td><%= amount %></td>
</tr>
<tr>
    <th rowspan="2">   <td><a href="transactionHistory.jsp">Transaction History</a></td></th>
    <td><a href="transactionEntryForm.jsp">Add another transaction</a></td>
  </tr>
</table>
</body>
</html>