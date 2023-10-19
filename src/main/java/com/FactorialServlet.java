package com;

import java.io.IOException;
import java.math.BigInteger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FactorialServlet")
public class FactorialServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String num = request.getParameter("num");
		int numb = Integer.parseInt(num);
		int fact  =1;
		for(int i=1; i<=numb;i++) {
			fact=fact*i;
		}
		System.out.println(fact);
		String words = "The result is : ";
		request.setAttribute("factorialData", fact);
		request.setAttribute("words", words);
		request.getRequestDispatcher("Factorial.jsp").forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
