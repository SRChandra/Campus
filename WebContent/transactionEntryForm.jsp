<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Transaction Entry Form</title>
</head>
<body background="PlainLogo.jpg">
<div align="center">
 login success
 please proceed to make transaction here below
 <h1>Transaction Entry Form</h1>
	<div class="ex">
		<form action="TransactionController" method="post">
			<table style="with: 50%">
				<tr>
				<%String username = session.getAttribute("username").toString(); 
				   /* request.setAttribute("username", username); */	%>
					<td>Vendor Id</td>
					<td><input type="text" name="vendorid"  value=<%= username %> readonly="readonly" ></td>
				</tr>
				<tr>
					<td>Employee Kin Id</td>
					<td><input type="text" name="employeeid" required="required"/></td>
				</tr>
				
				<tr>
					<td>Item List</td>
					<td><input type="text" name="items" required="required"/></td>
				</tr>
				<tr>
					<td>Item Cost</td>
					<td><input type="text" name="amount" required="required"/></td>
				</tr>
				
				<tr>
					<td>Enter employee pin</td>
					<td><input type="password" name="pin" required="required"/></td>
				</tr>
				
			</table>
			<input type="submit" value="Add" />
		</form>
	</div>

<h2><%
    if(null!=request.getAttribute("errorMessage"))
    {
        out.println(request.getAttribute("errorMessage"));
    }
%>
 </h2>
</div> 
</div> </body>
</html>