package com;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.UserDTO;

@WebServlet("/AdminLoginServletDelete")
public class AdminLoginServletDelete extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = (String) request.getAttribute("email");
		String pword = (String) request.getAttribute("password");
		
		final String adminEmail = "babitagurung03101998@gmail.com";
		final String adminPassword = "test@123";

		DataBaseUtil dbu = new DataBaseUtil();
		dbu.createConnection();// load/register and create connection

		System.out.println("employee servlet" + dbu.loginUsingEmailPassword(email, pword));
		if (dbu.loginUsingEmailPassword(email, pword).isEmpty()
				|| (!dbu.loginUsingEmailPassword(email, pword).get(0).equals(adminEmail)
						&& !dbu.loginUsingEmailPassword(email, pword).get(1).equals(adminPassword))) {
			request.setAttribute("unsuccess", "<h1>Sorry, you are not admin.</h1>");
			request.getRequestDispatcher("UnSuccessHomepage.jsp").forward(request, response);
			dbu.closeConnection();
		} else if (dbu.loginUsingEmailPassword(email, pword).get(0).equals(adminEmail)
				&& dbu.loginUsingEmailPassword(email, pword).get(1).equals(adminPassword)) {
			List<UserDTO> al = new ArrayList<UserDTO>();
			al.addAll(dbu.retriveAll());
			request.setAttribute("all", al);
			request.getRequestDispatcher("allUsers.jsp").forward(request, response);
			dbu.closeConnection();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
