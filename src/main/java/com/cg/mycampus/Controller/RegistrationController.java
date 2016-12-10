package com.cg.mycampus.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cg.mycampus.Bean.Employee;
import com.cg.mycampus.Impl.RegistrationImpl;

/**
 * Servlet implementation class UserDataServlet
 */
public class RegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Employee employee  = null;  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String Name = request.getParameter("name");
		long KinId = Long.parseLong(request.getParameter("id"));
		String Email = request.getParameter("email");
		String Mobile = request.getParameter("mobile");
		
		RegistrationImpl registrationImpl=new RegistrationImpl();
		String pin =registrationImpl.generatePin();
		
		employee  = new Employee();
		employee.setId(KinId);
		employee.setName(Name);
		employee.setPin(pin);
		employee.setEmail(Email);
		employee.setMobile(Mobile);
		
		
		RegistrationImpl reg = new RegistrationImpl();
		reg.addEmployee(employee);
		System.out.println("employee id " + KinId);
		if(Name.isEmpty()||Email.isEmpty()||Mobile.isEmpty())
		{
			RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
			out.println("<font color=red>Please fill all the fields</font>");
			rd.forward(request, response);
		}
		else
		{
			request.setAttribute("pin", pin);
			RequestDispatcher rd = request.getRequestDispatcher("/home.jsp");
			rd.forward(request, response);
			
		}
	}

}
