<%-- 
    Document   : attacking
    Created on : Mar 18, 2024, 1:52:58 AM
    Author     : hoang
--%>

<%@page contentType="text/html" import="model.*,controller.*,java.util.*"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>about</title>
        <link rel="stylesheet" href="../css/home.css">

    </head>
    <body>
        <div class="main">
            <div class="about">
                <div class="info">
                    <p>Mannschaft - Male Squad</p>
                    <p>2023-2024</p>
                </div>
                <div class="search">
                    <div class="search_button">
                        <a class="button" href="home.jsp" >POPULAR</a>                        
                        <a class="button chosse" href="home-goalkeeper.jsp" >GOALKEEPERS</a>
                        <a class="button" href="home-defender.jsp" >DEFENDERS</a>
                        <a class="button" href="home-midfielders.jsp" >Midfielder</a>
                        <a class="button" href="home-attacking.jsp" >ATTACKERS</a>

                    </div>
                    <div class="active">
                        <div class="button">ACTIVE</div>
                        <div class="button">ALUMNI</div>
                    </div>
                </div>
                <div class="list">




                    <%
                        ArrayList<Player> players = DB.getAttackers();
                        for (Player player : players) {

                    %>

                    <div class="player">
                        <div class="about_player">
                            <img src="<%= player.getImg() %>" alt="">

                            <div class="info_player">
                                <p><%= player.getFullName() %></p>
                                <p><%= player.getPosition() %></p>
                            </div>
                        </div>
                        <div class="about_player_col2">
                            <div class="apps">
                                <span>Appearances</span>
                                <p><%= player.getAppearances() %></p> 
                            </div>
                            <div class="age">
                                <span>Age</span>
                                <p><%= player.getYearOfBirth() %></p>
                            </div>
                            <div class="number">
                                <span>Number</span>
                                <p><%= player.getNumber() %></p>
                            </div>
                            <div class="country">
                                <span>Country</span>
                                <p><%= player.getCountry() %></p>
                            </div>
                        </div>
                        <div class="view_more">
                            <div class="contract">
                                <img src="https://cdn3.iconfinder.com/data/icons/marketing-37/91/SEODevelopment__Marketing_301-256.png" alt="">
                                <p>Active contract</p>
                            </div>
                            <div class="see_more">
                                <img src="https://cdn0.iconfinder.com/data/icons/stationary-vol-01/24/eye-256.png" alt="">
                                <p>See more</p>
                            </div>
                        </div>
                    </div>
                    <%
                        }
                    %>


                </div>
            </div>
    </body>
</html>
