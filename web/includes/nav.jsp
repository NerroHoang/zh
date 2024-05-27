<%-- 
    Document   : nav
    Created on : Mar 12, 2024, 5:55:41 AM
    Author     : MSI
--%>

<%@page contentType="text/html" import="Model.*,java.util.*"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>nav</title>
        <link rel="stylesheet" href="../css/home.css">
    </head>
    <body>
        <div class="main">
            <div class="nav">
                <div class="logo">
                    <img src="https://e0.pxfuel.com/wallpapers/274/792/desktop-wallpaper-manchester-city-logo-2017-manchester-city-logo.jpg" alt="">
                    <p>Manchester City</p>
                </div>
                    <form class="nav_search" action="searchServlet" method="get">
                    <input type="text" name="keyword" placeholder="Search for player ...">
                    <!--<button type="submit">Tìm kiếm</button>-->
                    </form>
                <div class="infoself">
                    <p>${sessionScope.username}</p>
                    </c:if></p>
                    <img src="https://upload.wikimedia.org/wikipedia/commons/9/9e/Male_Avatar.jpg" alt="">
                </div>
            </div>
        </div>
    </body>
</html>