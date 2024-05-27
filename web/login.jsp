<%-- 
    Document   : login
    Created on : Mar 13, 2024, 4:20:31 PM
    Author     : MSI
--%>

<%@page contentType="text/html" import="model.*,includes.*,java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
   <meta charset="UTF-8">
   <meta http-equiv="X-UA-Compatible" content="IE=edge">
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
   <title>login form</title>

   <!-- custom css file link  -->
   <link rel="stylesheet" href="css/login.css">

</head>
<body>
   
<div class="form-container">

   <form action="LoginServlet" method="post">
      <h3>login now</h3>      
        <% if (request.getAttribute("error") != null) { %>
            <div class="error-message"><%= request.getAttribute("error") %></div>
        <% } %>
      <input type="username" name="username" required placeholder="Enter your username">
      <input type="password" name="password" required placeholder="Enter your password">
      <input type="submit" name="submit" value="Login now" class="form-btn">
      <p>Don't have an account? <a href="register.jsp">register now</a></p>
      
      
   </form>

</div>

</body>
</html>
