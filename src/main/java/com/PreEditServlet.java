package com;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/PreEditServlet")
public class PreEditServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");

		DataBaseUtil dbu = new DataBaseUtil();
		dbu.createConnection();// load/register and create connection

		System.out.println("employee servlet" + dbu.retriveUsingEmail(email));
		if (dbu.retriveUsingEmail(email).isEmpty()) {
			request.setAttribute("unsuccess", "<h1>Sorry, something went wrong.</h1>");
			request.getRequestDispatcher("UnSuccessHomepage.jsp").forward(request, response);
			dbu.closeConnection();
		} else {
			String e = dbu.retriveUsingEmail(email).get(0);
			String password = dbu.retriveUsingEmail(email).get(1);
			String fullName = dbu.retriveUsingEmail(email).get(2);
			String gender=dbu.retriveUsingEmail(email).get(3);
			String age=dbu.retriveUsingEmail(email).get(4);
			request.setAttribute("e",e);
			request.setAttribute("password",password);
			request.setAttribute("fullName",fullName);
			request.setAttribute("email",email);
			request.setAttribute("gender",gender);
			request.setAttribute("age",age);
			request.getRequestDispatcher("Edit.jsp").forward(request, response);
			dbu.closeConnection();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
