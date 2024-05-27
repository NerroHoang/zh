<%-- 
    Document   : user
    Created on : Mar 17, 2024, 4:19:36 PM
    Author     : MSI
--%>

<%@page contentType="text/html" import="model.*,controller.*,java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>User List</h2>
        <table border="1">
            <tr>
                <th>Username</th>
                <th>Password</th>
                <th>email</th>
                <th>phone</th>
                <th>type</th>
            </tr>


            <%
                           ArrayList<User> users = DB.listAllUser();
                           for (User user : users) {

            %>
            <tr>
                <td><%= user.getUserName() %></td>
                <td><%= user.getPassword() %></td>
                <td><%= user.getEmail() %></td>                
                <td><%= user.getPhone() %></td>
                <td><%= user.getType() %></td>

                <td>
                    <form action="UpdateUserServlet" method="post">
                        <input type="hidden" name="username" value="<%= user.getUserName() %>">
                        <input type="hidden" name="password" value="<%= user.getPassword() %>">
                        <input type="hidden" name="email" value="<%= user.getEmail() %>">
                        <input type="hidden" name="phone" value="<%= user.getPhone() %>">          

                 
                        <%
                            String valueName;
                            String setType;
                            if (user.getType().equals("admin")) {
                                valueName = "setToUser";
                                setType = "user";
                            } else {
                                valueName = "setToAdmin";  
                                setType = "admin";
                            }
                        %>
                        
                       
                        <input type="submit" value="<%= valueName %>">
                    </form>
                </td>
            </tr>
            <%
    }
            %>
        </table>
    </body>
</html>