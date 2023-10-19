package com;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String fullName = request.getParameter("fullname");
		String gender = request.getParameter("gender");
		String age = request.getParameter("age");
		
		final String adminEmail = "babitagurung03101998@gmail.com";
		final String adminPassword = "test@123";
		
		DataBaseUtil dbu = new DataBaseUtil();
		dbu.createConnection();
		if(dbu.updateUsingID(email, password, fullName, gender, age)>0) {
			request.setAttribute("email", adminEmail);
			request.setAttribute("password", adminPassword);
			request.getRequestDispatcher("AdminLoginServletDelete").forward(request, response);
			dbu.closeConnection();
		}
//		else {
//			request.setAttribute("unsuccess", "Signup failed.");
//			request.getRequestDispatcher("UnSuccessRegistration.jsp").forward(request, response);
//			dbu.closeConnection();
//		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
