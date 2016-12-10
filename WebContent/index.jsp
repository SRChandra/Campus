<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cash Less Campus</title>

    </head>

    <body background="PlainLogo.jpg">
<H1> Capgemini Cashless Campus(3C)</H1>
   
   <form action="LoginController" method="post">
Enter username :<input type="text" name="username" required="required"> <br>
Enter password :<input type="password" name="password" required="required"><br>
<input type="submit" value="Login">
 <h2><%
    if(null!=request.getAttribute("errorMessage"))
    {
        out.println(request.getAttribute("errorMessage"));
    }
%>
 </h2>
      <a href="forgotPin.jsp">Forgot your password?</a>
</form>
 <H2><a href="register.jsp">Register</a><H2>
    </body>
</html>