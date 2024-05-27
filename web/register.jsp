
<%@page contentType="text/html" import="model.*,includes.*,java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>register form</title>

        <!-- custom css file link  -->
        <link rel="stylesheet" href="css/login.css">

    </head>
    <body>

        <div class="form-container">

            <form action="RegisterServlet" method="post">
                <h3>register now</h3>
                <input type="text" name="username" required placeholder="Enter your name">
                <input type="email" name="email" required placeholder="Enter your email">
                <input type="phone" name="phone" required placeholder="Enter your phone">
                <input type="password" name="password" required placeholder="Enter your password">
                <input type="password" name="cpassword" required placeholder="Confirm your password">
                <input type="submit" name="submit" value="register now" class="form-btn">
                <p>Already have an account? <a href="login.jsp">login now</a></p>
            </form>

        </div>

    </body>
</html>