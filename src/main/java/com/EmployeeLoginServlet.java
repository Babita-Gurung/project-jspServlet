package com;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EmployeeLoginServlet")
public class EmployeeLoginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String pword = request.getParameter("password");

		DataBaseUtil dbu = new DataBaseUtil();
		dbu.createConnection();// load/register and create connection

		System.out.println("employee servlet" + dbu.loginUsingEmailPassword(email, pword));
		if (dbu.loginUsingEmailPassword(email, pword).isEmpty()) {
			request.setAttribute("unsuccess", "<h1>Sorry, either your username or password is not correct.</h1>");
			request.getRequestDispatcher("UnSuccessHomepage.jsp").forward(request, response);
			dbu.closeConnection();
		} else {
			String fullName = dbu.loginUsingEmailPassword(email, pword).get(2);
			String gender=dbu.loginUsingEmailPassword(email, pword).get(3);
			String age=dbu.loginUsingEmailPassword(email, pword).get(4);
			System.out.println(fullName);
			request.setAttribute("fullName",fullName);
			request.setAttribute("email",email);
			request.setAttribute("gender",gender);
			request.setAttribute("age",age);
			request.getRequestDispatcher("SuccessHomepage.jsp").forward(request, response);
			dbu.closeConnection();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
