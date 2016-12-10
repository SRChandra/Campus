package com.cg.mycampus.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cg.mycampus.Bean.Employee;
import com.cg.mycampus.Bean.Transaction;
import com.cg.mycampus.Impl.RegistrationImpl;
import com.cg.mycampus.Impl.TransactionImpl;

/**
 * Servlet implementation class UserDataServlet
 */
public class TransactionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Employee employee = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TransactionController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Long lObj = new Long(10);
		String str = lObj.toString();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String vendorid = request.getParameter("vendorid");
		Long employeeid = Long.parseLong(request.getParameter("employeeid"));
		String items = request.getParameter("items");
		String amount = request.getParameter("amount");
		String pin = request.getParameter("pin");

		if (vendorid.toString().isEmpty() || employeeid.toString().isEmpty() || items.isEmpty() || amount.isEmpty()
				|| !RegistrationImpl.validateEmployeePin(employeeid, pin)) {
			request.setAttribute("errorMessage", "Invalid Details Entered Try again");
			RequestDispatcher rd = request.getRequestDispatcher("/transactionEntryForm.jsp");
			rd.forward(request, response);
		} else {
			Transaction transaction = new Transaction();
			transaction.setEmployeeid(employeeid);
			transaction.setVendorid(Long.parseLong(vendorid));
			transaction.setItems(items);
			transaction.setAmount(Double.parseDouble(amount.toString()));
			TransactionImpl reg = new TransactionImpl();
			reg.addTransaction(transaction);
			
			RequestDispatcher rd = request.getRequestDispatcher("transactionDetails.jsp");
			out.println("<font color=red>Please fill all the fields</font>");
			rd.forward(request, response);

		}

	}
}