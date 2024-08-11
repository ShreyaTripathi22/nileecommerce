
<%@page import="java.util.List"%>
<%@page import="com.mycompany.ecommerce5.entities.product"%>
<%@page import="com.mycompany.ecommerce5.entities.category"%>
<%@page import="com.mycompany.ecommerce5.dao.CategoryDao"%>
<%@page import="com.mycompany.ecommerce5.dao.ProductDao"%>
<%@page import="com.mycompany.ecommerce5.helper.FactoryProvider"%>
<%@page import="com.mycompany.ecommerce5.helper.Helper"%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html"; charset="UTF-8">
        <title>Ecommerce-home</title>
         <%@include file ="components/common_css_js.jsp" %>
        
      
    </head>
<body>
    
     <%@include file="components/navbar.jsp"  %>   
    
   <%
	    String cat=request.getParameter("category");
	
		ProductDao dao = new ProductDao(FactoryProvider.getFactory());
		List<product> list=null;
			
                if(cat==null ||cat.trim().equals("all"))
		{
			list =dao.getAllProducts();
		}
		else{
			int cid=Integer.parseInt(cat.trim());
			list=dao.getAllProductsById(cid);
		}
	
		CategoryDao cdao = new CategoryDao(FactoryProvider.getFactory());
		List<category> clist = cdao.getCategories();
	%>
           
        <div class="container mt-3">
        <div class="row">
            <div class="col-md-3">
          <div class="list-group">
  <a href="index.jsp?category=all" class="list-group-item list-group-item-action active">
    All categories
  </a>
  

            <%
                for(category c: clist){
                
                
                %>
                <a href="index.jsp?category=<%=c.getCategoryid()%>" class="list-group-item list-group-item-action"><%= c.getCategoryTitle()%></a>
       
                
                <%
                
                }
                
                
                %>
                
                </div>  
        </div>
       
           	<!-- //show products -->
		<div class="col-md-25">

			<!-- row -->
	      <div class="row mt-2">
	      	<div class="offset-md-4 col-md-12">
	      	  		
	      	  	<div class="card-columns">
	      	  	
	      	  	<!--   traversing product -->
	      	  	
	      	  	<%
	      	  	
	      	  	for(product p:list)
	      	  	{
	      	    %>
	      	    <div class="card mb-3">
	      	    	<div class="container text-center">
	      	    	<img alt="..." style="max-height:200px; max-width:100px; width:auto;" src="img/product/<%= p.getpPhoto()%>" class="card-img-top m-2">		
	      	   
	      	    	
	      	    	</div>
	      	    	 	<div class="class-body">
	      	    		<h5 class="card-title ml-2"><%=p.getpName() %></h5>
	      	    	    <p class="card-text ml-2"><%=Helper.get10Words(p.getpDesc()) %></p>
	      	    	</div>
	      	    	
	      	    <div class="card-footer text-center">
	      	    	 <button class="btn custom-bg text-white" onclick="add_to_card(<%=p.getpId() %>,'<%=p.getpName() %>','<%=p.getpPrice() %>')">Add to Cart</button>

	      	    	 <button class="btn btn-outline-success"><%=p.getpPrice()%> </button>
	      	    </div>	
	      	     
	      	    </div>
	      	    
	      	    
	      	    <%		
	      	  	}
	      	  	
	      	  	
	      	  	if(list.size()==0)
	      	  	{
	      	  		out.println("<h3>No item in this category</h3>");
	      	  	}
	      	  	
	      	  	
	      	  	
	      	  	%>
	      	  	
	      	  	</div>	
	      	
	      	</div>
	      
	      
	      </div>

				

		</div>

	</div>
			
                        <%@include file="components/common_modals.jsp" %>  


</body>
</html>
