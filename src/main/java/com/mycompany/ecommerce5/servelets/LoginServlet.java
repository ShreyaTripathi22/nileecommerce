package com.mycompany.ecommerce5.servelets;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import com.mycompany.ecommerce5.dao.UserDao;
import com.mycompany.ecommerce5.entities.user;
import com.mycompany.ecommerce5.helper.FactoryProvider;


public class LoginServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            	
		String email= request.getParameter("email");
		String password= request.getParameter("password");
		
		UserDao userDao=new UserDao(FactoryProvider.getFactory());
        user user=userDao.getUserByEmailAndPassword(email, password);
		
        HttpSession httpSession=request.getSession();
           // System.out.print("user");
           
           if(user ==null) 
           {
        	
			httpSession.setAttribute("message","*Invalid Details !! Try with another one*");
			response.sendRedirect("login.jsp");
			return;
            }
           else
           {
              httpSession.setAttribute("current-user", user);
            
            // Debug: Print user type
            System.out.println("User Type: " + user.getUserType());

            if ("admin".equals(user.getUserType())) {
                // admin: admin.jsp
                response.sendRedirect("admin.jsp");
            } else if ("normal".equals(user.getUserType())) {
                // normal: normal.jsp
                response.sendRedirect("normal.jsp");
            } else {
                httpSession.setAttribute("message", "We have not identified user type !!!");
                response.sendRedirect("login.jsp");
                return;
            }
               
           }
           
      

        }
        
}

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
  