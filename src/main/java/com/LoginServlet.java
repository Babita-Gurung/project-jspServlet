package com;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("uname");
		String password = request.getParameter("pword");
		if(username.equals("Bickey") && password.equals("test@123")){
			request.setAttribute("uname", "<h1>Congratulation, " +username+" you are successfully logged in.</h1>");
			request.getRequestDispatcher("SuccessHomepage.jsp").forward(request, response);;
		}else {
			request.setAttribute("unsuccess", "<h1>Sorry, either your username or password is not correct.</h1>");
			request.getRequestDispatcher("UnSuccessHomepage.jsp").forward(request,response);
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
