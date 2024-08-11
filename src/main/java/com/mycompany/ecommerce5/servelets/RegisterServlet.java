package com.mycompany.ecommerce5.servelets;

import com.mycompany.ecommerce5.helper.FactoryProvider;
import com.mycompany.ecommerce5.entities.user;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class RegisterServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            try {
                String userName = request.getParameter("user_name");
                String userEmail = request.getParameter("user_email");
                String userPassword = request.getParameter("user_password");
                String userPhone = request.getParameter("user_phone");
                String userAddress = request.getParameter("user_address");

                if (userName == null || userEmail == null || userPassword == null || userPhone == null || userAddress == null) {
                    throw new IllegalArgumentException("Null parameter received");
                }

                // Creating user object to store data
                user newUser = new user(userName, userEmail, userPassword, userPhone, userAddress, "normal");

                Session hibernateSession = FactoryProvider.getFactory().openSession();
                Transaction tx = hibernateSession.beginTransaction();

                int userId = (int) hibernateSession.save(newUser);

                tx.commit();
                
             hibernateSession.close();
			HttpSession httpSession=request.getSession();
			httpSession.setAttribute("message","*Registration SuccessFul !! User id is:" + userId);
			response.sendRedirect("register.jsp");
			return;
            } catch (Exception e) {
                // Log error message
                e.printStackTrace();
                out.println("Error: " + e.getMessage());
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}