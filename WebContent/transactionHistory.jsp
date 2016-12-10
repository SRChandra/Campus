<%@page import="com.cg.mycampus.Impl.*"%>
<%@page import="com.cg.mycampus.Bean.*"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Vendor Transaction History </title>
</head>
<body background="PlainLogo.jpg">

<%String username = session.getAttribute("username").toString();
RegistrationImpl reg = new RegistrationImpl();
Employee employee = reg.getEmployee(Long.parseLong(username));
ArrayList<Transaction> transList = TransactionImpl.getTransactionsForEmployee(employee);
%>
<h1>Vendor : <%=username%></h1>
<h1>Transaction History</h1>
<table cellspacing="2" cellpadding="2" border=1 title="Transaction List">
<tr>
<th>Transaction ID</th>
<th>Employee ID</th>
<th>Items Purchased</th>
<th>Cost of Item</th>
</tr>

<%
Iterator<Transaction> iterator = transList.iterator();
while(iterator.hasNext())
{
	Transaction transBean = iterator.next();
	int curIndex = transList.indexOf(transBean);
%>
<tr>
	<td><%=curIndex + 1%></td>
	<td><%=transBean.getEmployeeid()%></td>
	<td><%=transBean.getItems()%></td> 
	<td><%=transBean.getAmount()%></td> 
</tr>
<%
}
%>
</table>

</body>
</html>