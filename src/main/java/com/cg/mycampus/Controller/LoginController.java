package com.cg.mycampus.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cg.mycampus.Impl.RegistrationImpl;
/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String pin=request.getParameter("password");
		
		Long user = Long.parseLong(username);
		if(RegistrationImpl.validateEmployeePin(user, pin))
		{
			/*HttpSession session = request.getSession(true);	    
	          session.setAttribute("currentSessionUser",user); 
	          response.sendRedirect("userLogged.jsp"); //logged-in page
*/	         request.setAttribute("username", username);
	request.getSession().setAttribute("username", username);
			RequestDispatcher rd = request.getRequestDispatcher("/transactionEntryForm.jsp");
			rd.forward(request, response);
		}
		else
		{
            request.setAttribute("errorMessage", "Invalid user or password");
            RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
            rd.forward(request, response);
		}
	}
}