
<%@page contentType="text/html" import="model.*,controller.*,java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Update Player Information</h1>
        <form action="UpdatePlayerServlet" method="post">
            <label for="playerId">Player ID:</label><br>
            <input type="text" id="playerId" name="playerId" value="<%= request.getParameter("playerId") %>" required><br>

            <label for="fullName">Full Name:</label><br>
            <input type="text" id="fullName" name="fullName" value="<%= request.getParameter("fullName") %>" required><br>

            <label for="img">Image:</label><br>
            <input type="text" id="img" name="img" value="<%= request.getParameter("img") %>" required><br>

            <label for="position">Position:</label><br>
            <input type="text" id="position" name="position" value="<%= request.getParameter("position") %>" required><br>

            <label for="isCaptain">Is Captain:</label><br>
            <input type="text" id="isCaptain" name="isCaptain" value="<%= request.getParameter("isCaptain") %>" required><br>

            <label for="appearances">Appearances:</label><br>
            <input type="number" id="appearances" name="appearances" value="<%= request.getParameter("appearances") %>" required><br>

            <label for="number">Number:</label><br>
            <input type="number" id="number" name="number" value="<%= request.getParameter("number") %>" required><br>

            <label for="yearOfBirth">Year of Birth:</label><br>
            <input type="number" id="yearOfBirth" name="yearOfBirth" value="<%= request.getParameter("yearOfBirth") %>" required><br>

            <label for="country">Country:</label><br>
            <input type="text" id="country" name="country" value="<%= request.getParameter("country") %>" required><br>

            <label for="imgCountry">Country Image:</label><br>
            <input type="text" id="imgCountry" name="imgCountry" value="<%= request.getParameter("imgCountry") %>" required><br>

            <label for="marketValue">Market Value:</label><br>
            <input type="number" id="marketValue" name="marketValue" value="<%= request.getParameter("marketValue") %>" required><br>

            <input type="submit" value="Update">
        </form>
    </body>
</html>
