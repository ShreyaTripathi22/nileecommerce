/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.ecommerce5.servelets;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.mycompany.ecommerce5.entities.category;
import jakarta.servlet.http.HttpSession;
import com.mycompany.ecommerce5.dao.CategoryDao;
import com.mycompany.ecommerce5.dao.ProductDao;
import com.mycompany.ecommerce5.entities.product;
import com.mycompany.ecommerce5.helper.FactoryProvider;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.Part;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;


/**
 *
 * @author Shreya
 */

@MultipartConfig
public class ProductOperationServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            String op = request.getParameter("operation");
            
            if (op.trim().equals("addCategory")) {
		            
	
                
                String title = request.getParameter("catTitle");
			String description = request.getParameter("catDescription");
			
                        
			
			category category=new category();
			category.setCategoryTitle(title);
			category.setCategoryDescription(description);
                        
                        
                        CategoryDao categoryDao=new CategoryDao(FactoryProvider.getFactory());
			int catId=categoryDao.saveCategory(category);
                        //out.println("successfully saved");
			
			HttpSession httpsession= request.getSession();
			httpsession.setAttribute("message","Category added successfully:"+catId);
			response.sendRedirect("admin.jsp");
			return;
                        
			
  
            
      
        }
            else if(op.trim().equals("addProduct")){
                
                String pName=request.getParameter("pName");
			String pDesc=request.getParameter("pDesc");
			int pPrice=Integer.parseInt(request.getParameter("pPrice"));
			
			int pQuantity=Integer.parseInt(request.getParameter("pQuantity"));
			int catId=Integer.parseInt(request.getParameter("catId"));
			Part part=request.getPart("pPic");
                        
                        
                        product p=new product();
			p.setpName(pName);
			p.setpDesc(pDesc);
			p.setpPrice(pPrice);
			p.setpQuantity(pQuantity);
			p.setpPhoto(part.getSubmittedFileName());
                        
                        
                        CategoryDao cdao= new CategoryDao(FactoryProvider.getFactory());
			category category=cdao.getCategoryById(catId);
			p.setCategory(category);
			
                        ProductDao pdao=new ProductDao(FactoryProvider.getFactory());
			pdao.saveProduct(p);
                        
                        try {
				String path=request.getServletContext().getRealPath("img")+File.separator+"products"+File.separator+part.getSubmittedFileName();
				
				FileOutputStream fos= new FileOutputStream(path);
				
				InputStream is= part.getInputStream();
				
				
				byte []data=new byte[is.available()];
				is.read(data);
				
				//writing the data
				fos.write(data);
				fos.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
                        
                        HttpSession httpsession= request.getSession();
			httpsession.setAttribute("message","Product added successfully:"+catId);
			response.sendRedirect("admin.jsp");
			return;
			
                
                
            }
                
            }
        
      
}
    }
    
    
    


  