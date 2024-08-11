package com.mycompany.ecommerce5.servelets;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

         HttpSession httpSession=request.getSession();
         httpSession.removeAttribute("current-user");
         httpSession.setAttribute("message", "You are Successfully logout !!!");
		   
		 response.sendRedirect("login.jsp");
		
		
	}

}
