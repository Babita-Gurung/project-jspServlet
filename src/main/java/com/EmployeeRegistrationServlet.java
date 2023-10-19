package com;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EmployeeRegistrationServlet")
public class EmployeeRegistrationServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String fullName = request.getParameter("fullname");
		String gender = request.getParameter("gender");
		String age = request.getParameter("age");
		
		DataBaseUtil dbu = new DataBaseUtil();
		dbu.createConnection();
		if(dbu.insertData(email, password, fullName, gender, age)!=0) {
			request.setAttribute("fullName", fullName);
			request.getRequestDispatcher("SuccessRegistration.jsp").forward(request, response);
			dbu.closeConnection();
		}
		else {
			request.setAttribute("unsuccess", "Signup failed.");
			request.getRequestDispatcher("UnSuccessRegistration.jsp").forward(request, response);
			dbu.closeConnection();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
