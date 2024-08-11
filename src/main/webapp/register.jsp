
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Page</title>
        <%@include file="components/common_css_js.jsp"%>
    </head>
    <body>
        <%@include file="components/navbar.jsp" %>
        
          <div class="row mt-5">
       <div class="col-md-35 offset-md- -200"> 
    
         <div class="card" style="width:35rem; margin-top: 3rem;">
         <%@include file="components/message.jsp" %>
            <div class="card-body px-5">
               <h3 class="text-center my-3">Sign Up here</h3>
               <form action="RegisterServlet" method="post">
                <div class="form-group">
                  <label for="user">User Name</label>
                  <input type="text" name="user_name" class="form-control" id="user"  placeholder="Enter name here">
                </div>
                <div class="form-group">
                  <label for="email">Email address</label>
                  <input type="email"name="user_email" class="form-control" id="email" placeholder="Enter email here">
                </div>
                <div class="form-group">
                  <label for="password">User Password</label>
                  <input type="password" name="user_password" class="form-control" id="password" placeholder="Enter password here">
                </div> 
                <div class="form-group">
                  <label for="phone">User phone</label>
                  <input type="number" name="user_phone" class="form-control" id="phone" placeholder="Enter Phone number here">
                </div>
                <div class="form-group">
                  <label for="address">User address</label>
                  <textarea name="user_address" class="form-control" style="height:200px;"placeholder="Enter your Address"></textarea>
                </div>
                <div class="container text-center">
                      <button type="submit" class="btn btn-outline-success">Submit</button>
                      <button type="reset" value="clear" class="btn btn-outline-warning">Reset</button>    
                </div> 
              </form>
                          </div>
                       </div>
                     </div>    
                  </div>
              </body>
              </html>