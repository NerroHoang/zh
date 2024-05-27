

<%@page contentType="text/html" import="model.*,controller.*,java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table border="1"> 

            <tr>
                <th>fullName</th>
                <th>position</th>
                <th>isCaptain</th>
                <th>appearances</th>
                <th>number</th>
                <th>yearOfBirth</th>
                <th>country</th>
                <th>marketValue</th>
            </tr>


            <%
                ArrayList<Player> players = DB.getAllPlayers();
                for (Player player : players) {

            %>
            <tr>
                <td><%= player.getFullName()%></td>
                <td><%= player.getPosition()%></td>
                <td><%= player.getIsCaptain()%></td>
                <td><%= player.getAppearances()%></td>
                <td><%= player.getNumber()%></td>
                <td><%= player.getYearOfBirth()%></td>
                <td><%= player.getCountry()%></td>
                <td><%= player.getMarketValue()%></td>
                <td> <form action="UpdatePlayerServlet" method="get">
                        <input type="hidden" name="playerId" value="<%= player.getPlayerId()%>">
                        <input type="hidden" name="fullName" value="<%= player.getFullName()%>">
                        <input type="hidden" name="img" value="<%= player.getImg()%>">
                        <input type="hidden" name="position" value="<%= player.getPosition()%>">
                        <input type="hidden" name="isCaptain" value="<%= player.getIsCaptain()%>">
                        <input type="hidden" name="appearances" value="<%= player.getAppearances()%>">
                        <input type="hidden" name="number" value="<%= player.getNumber()%>">
                        <input type="hidden" name="yearOfBirth" value="<%= player.getYearOfBirth()%>">
                        <input type="hidden" name="country" value="<%= player.getCountry()%>">
                         <input type="hidden" name="img_country" value="<%= player.getImg_country()%>">
                        <input type="hidden" name="marketValue" value="<%= player.getMarketValue()%>">
                        <input type="submit" value="update">
                    </form>
                </td>
                <td> <form action="DeletePlayerServlet" method="post">
                        <input type="hidden" name="playerId" value="<%= player.getPlayerId()%>">
                        <input type="submit" value="delete">
                    </form>
                </td>
            </tr>
            <%
                }
            %>
        </table>
    </body>
</html>
