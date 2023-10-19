package com;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		final String adminEmail = "babitagurung03101998@gmail.com";
		final String adminPassword = "test@123";
		DataBaseUtil dbu= new DataBaseUtil();
		dbu.createConnection();
		if(dbu.deleteUsingEmail(email)>0) {
			request.setAttribute("email",adminEmail);
			//request.setAttribute("test@123","password");
			request.setAttribute("password",adminPassword);
			request.getRequestDispatcher("AdminLoginServletDelete").forward(request, response);
			dbu.closeConnection();
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
