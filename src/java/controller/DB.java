package controller;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Player;
import model.SeniorCareer;
import model.User;

public class DB implements DatabaseInfo {

    public static Connection getConnect() {
        try {
            Class.forName(DRIVERNAME);
        } catch (ClassNotFoundException e) {
            System.out.println("Error loading driver" + e);
        }
        try {
            Connection con = DriverManager.getConnection(DBURL, USERDB, PASSDB);
            return con;
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return null;
    }

    public static User login(String username) throws Exception {
        User s = null;
        Connection con = getConnect();
        try {
            PreparedStatement stmt = con.prepareStatement("Select password,email,phone,type from Users where username=?");
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String password = rs.getString(1);
                String email = rs.getString(2);
                String phone = rs.getString(3);
                String type = rs.getString(4);
                s = new User(username, password, email, phone, type);
            }

        } catch (Exception ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.close();
        }
        return s;
    }

    public static String newUser(User s) {
        String kq;
        try (Connection con = getConnect()) {
            // Kiểm tra xem username, email và phone đã tồn tại trong cơ sở dữ liệu hay chưa
            PreparedStatement checkStmt = con.prepareStatement("SELECT COUNT(*) FROM Users WHERE username = ? OR email = ? OR phone = ?");
            checkStmt.setString(1, s.getUserName());
            checkStmt.setString(2, s.getEmail());
            checkStmt.setString(3, s.getPhone());
            ResultSet rs = checkStmt.executeQuery();
            if (rs.next() && rs.getInt(1) > 0) {
                // Nếu username, email hoặc phone đã tồn tại, trả về lỗi
                kq = "error";
            } else {
                // Nếu không có trùng lặp, tiếp tục thêm người dùng mới vào cơ sở dữ liệu
                PreparedStatement insertStmt = con.prepareStatement("INSERT INTO Users (username, password, email, phone, type) VALUES (?, ?, ?, ?, ?)");
                insertStmt.setString(1, s.getUserName());
                insertStmt.setString(2, s.getPassword());
                insertStmt.setString(3, s.getEmail());
                insertStmt.setString(4, s.getPhone());
                insertStmt.setString(5, s.getType());
                int rowsInserted = insertStmt.executeUpdate();
                if (rowsInserted > 0) {
                    kq = "success";
                } else {
                    kq = "error";
                }
            }
            con.close();
        } catch (Exception ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
            kq = "error";
        }
        return kq;
    }

//-----------------------------------------------------------------------------------
    public static void update(User s) {
    try (Connection con = getConnect()) {
        if (con == null) {
            throw new SQLException("Connection is null");
        }

        PreparedStatement stmt = con.prepareStatement("UPDATE Users SET type = ? WHERE username = ?");
        stmt.setString(1, s.getType());
        stmt.setString(2, s.getUserName()); // Thêm phần này để cập nhật dữ liệu cho username cụ thể
        int rowsUpdated = stmt.executeUpdate();
        if (rowsUpdated > 0) {
            System.out.println("Update successful");
        } else {
            System.out.println("Update failed");
        }
    } catch (SQLException ex) {
        Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        throw new RuntimeException("Invalid data: " + ex.getMessage()); // Thêm thông tin lỗi vào ngoại lệ
    }
}

// //--------------------------------------------------------------------------------
//         public static int delete(int id){
//          try(Connection con=getConnect()) {
//             PreparedStatement stmt=con.prepareStatement("Delete Student where id =?");
//             stmt.setInt(1, id);
//             int rc=stmt.executeUpdate();
//             con.close();
//             return rc;
//         } catch (Exception ex) {
//             Logger.getLogger(StudentDB.class.getName()).log(Level.SEVERE, null, ex);
//         }   
//         return 0;
//     }
    public static ArrayList<Player> listAll() {
        ArrayList<Player> list = new ArrayList<>();
        //Connection con = getConnect();
        try (Connection con = getConnect()) {
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM ListPlayer");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                list.add(new Player(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getString(9), rs.getString(10), rs.getInt(11)));
            }
            con.close();
            return list;
        } catch (Exception ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static ArrayList<Player> getAllPlayers() {
        ArrayList<Player> players = new ArrayList<>();
        try (Connection con = getConnect()) {
            String query = "SELECT * FROM ListPlayer";
            PreparedStatement stmt = con.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String playerId = rs.getString("player_id");
                String fullName = rs.getString("full_name");
                String img = rs.getString("img");
                String position = rs.getString("position");
                String isCaptain = rs.getString("is_captain");
                int appearances = rs.getInt("appearances");
                int number = rs.getInt("number");
                int yearOfBirth = rs.getInt("year_of_birth");
                String country = rs.getString("country");
                String img_country = rs.getString("img_country");
                int marketValue = rs.getInt("market_value");

                Player player = new Player(playerId, fullName, img, position, isCaptain, appearances, number, yearOfBirth, country, img_country, marketValue);
                players.add(player);
            }
        } catch (SQLException ex) {
        }
        return players;
    }

    public static String newPlayer(Player player) {
        String result;
        try (Connection con = getConnect()) {
            String query = "INSERT INTO ListPlayer (player_id, full_name, img, position, is_captain, appearances, number, year_of_birth, country, img_country, market_value) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, player.getPlayerId());
            stmt.setString(2, player.getFullName());
            stmt.setString(3, player.getImg());
            stmt.setString(4, player.getPosition());
            stmt.setString(5, player.getIsCaptain());
            stmt.setInt(6, player.getAppearances());
            stmt.setInt(7, player.getNumber());
            stmt.setInt(8, player.getYearOfBirth());
            stmt.setString(9, player.getCountry());
            stmt.setString(10, player.getImg_country());
            stmt.setInt(11, player.getMarketValue());

            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                result = "success";
            } else {
                result = "error";
            }
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
            result = "error";
        }
        return result;
    }

    public static ArrayList<Player> getAllPlayersWithSeniorCareers() {
        ArrayList<Player> players = new ArrayList<>();
        try (Connection con = getConnect()) {
            String query = "SELECT * FROM ListPlayer";
            PreparedStatement stmt = con.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Player player = new Player();
                player.setPlayerId(rs.getString("player_id"));
                player.setFullName(rs.getString("full_name"));
                player.setImg(rs.getString("img"));
                player.setPosition(rs.getString("position"));
                player.setIsCaptain(rs.getString("is_captain"));
                player.setAppearances(rs.getInt("appearances"));
                player.setNumber(rs.getInt("number"));
                player.setYearOfBirth(rs.getInt("year_of_birth"));
                player.setCountry(rs.getString("country"));
                player.setImg_country(rs.getString("img_country"));
                player.setMarketValue(rs.getInt("market_value"));

                // Cài đặt các thuộc tính khác của player
                players.add(player);
            }
        } catch (SQLException ex) {
        }
        return players;
    }

    public static String updatePlayer(Player player) {
        String result;
        try (Connection con = getConnect()) {
            String query = "UPDATE ListPlayer SET full_name = ?, img = ?, position = ?, is_captain = ?, appearances = ?, number = ?, year_of_birth = ?, country = ?, img_country = ?, market_value = ? WHERE player_id = ?";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, player.getFullName());
            stmt.setString(2, player.getImg());
            stmt.setString(3, player.getPosition());
            stmt.setString(4, player.getIsCaptain());
            stmt.setInt(5, player.getAppearances());
            stmt.setInt(6, player.getNumber());
            stmt.setInt(7, player.getYearOfBirth());
            stmt.setString(8, player.getCountry());
            stmt.setString(9, player.getImg_country());
            stmt.setInt(10, player.getMarketValue());
            stmt.setString(11, player.getPlayerId());

            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                result = "success";
            } else {
                result = "error";
            }
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
            result = "error";
        }
        return result;
    }

    public static String deletePlayer(String playerId) {
        String result;
        try (Connection con = getConnect()) {
            String query = "DELETE FROM ListPlayer WHERE player_id = ?";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, playerId);

            int rowsDeleted = stmt.executeUpdate();
            if (rowsDeleted > 0) {
                result = "success";
            } else {
                result = "error";
            }
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
            result = "error";
        }
        return result;
    }

    public static ArrayList<SeniorCareer> getSeniorCareersByPlayerId(String playerId) {
        ArrayList<SeniorCareer> seniorCareers = new ArrayList<>();
        try (Connection con = getConnect()) {
            String query = "SELECT * FROM SeniorCareer WHERE player_id = ?";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, playerId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                SeniorCareer seniorCareer = new SeniorCareer();
                seniorCareer.setTeamName(rs.getString("team_name"));
                seniorCareer.setJoinedDate(rs.getInt("joined_date"));
                seniorCareer.setLeftDate(rs.getInt("left_date"));

                // Cài đặt các thuộc tính khác của seniorCareer
                seniorCareers.add(seniorCareer);
            }
        } catch (SQLException ex) {
        }
        return seniorCareers;
    }

    public static User getUser(int id) {
        User s = null;
        try (Connection con = getConnect()) {
            PreparedStatement stmt = con.prepareStatement("Select username, password, email,phone,type from Users");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String userName = rs.getString(1);
                String password = rs.getString(2);
                String email = rs.getString(3);
                String phone = rs.getString(4);
                String type = rs.getString(5);
                s = new User(userName, password, email, phone, type);
            }
            con.close();
        } catch (Exception ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return s;
    }

    public static ArrayList<User> listAllUser() {
        ArrayList<User> list = new ArrayList<>();
        //Connection con = getConnect();
        try (Connection con = getConnect()) {
            PreparedStatement stmt = con.prepareStatement("Select username, password, email,phone,type from Users");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                list.add(new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
            }
            con.close();
            return list;
        } catch (Exception ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static ArrayList<Player> getMidfielders() {
        try (Connection con = getConnect()) {
            PreparedStatement stmt = con.prepareStatement("SELECT *FROM ListPlayer WHERE position like '%Midfielder%'");
            ResultSet rs = stmt.executeQuery();
            ArrayList<Player> midfielders = new ArrayList<>();
            while (rs.next()) {
                midfielders.add(new Player(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getString(9), rs.getString(10), rs.getInt(11)));
            }
            return midfielders;
        } catch (Exception ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    public static ArrayList<Player> getGoalkeepers() {
        try (Connection con = getConnect()) {
            PreparedStatement stmt = con.prepareStatement("SELECT *FROM ListPlayer WHERE position = 'Goalkeeper'");
            ResultSet rs = stmt.executeQuery();
            ArrayList<Player> goalkeeper = new ArrayList<>();
            while (rs.next()) {
                goalkeeper.add(new Player(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getString(9), rs.getString(10), rs.getInt(11)));
            }
            return goalkeeper;
        } catch (Exception ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    public static ArrayList<Player> getDefenders() {
        try (Connection con = getConnect()) {
            PreparedStatement stmt = con.prepareStatement("SELECT *FROM ListPlayer WHERE position like '%Defender%'");
            ResultSet rs = stmt.executeQuery();
            ArrayList<Player> defender = new ArrayList<>();
            while (rs.next()) {
                defender.add(new Player(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getString(9), rs.getString(10), rs.getInt(11)));
            }
            return defender;
        } catch (Exception ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    public static ArrayList<Player> getAttackers() {
        try (Connection con = getConnect()) {
            PreparedStatement stmt = con.prepareStatement("SELECT *FROM ListPlayer WHERE position like '%Attacking%'");
            ResultSet rs = stmt.executeQuery();
            ArrayList<Player> attackers = new ArrayList<>();
            while (rs.next()) {
                attackers.add(new Player(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getString(9), rs.getString(10), rs.getInt(11)));
            }
            return attackers;
        } catch (Exception ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public static void main(String[] a) {
//        ArrayList<Player> listplayer = DB.listAll();
//        for (Player player : listplayer) {
//            System.out.println(player);
//        }
//        ArrayList<SeniorCareer> list = DB.listSC();
//        for (SeniorCareer sc : list) {
//            System.out.println(sc);
//        }    
//        ArrayList<Player> list1 = DB.getAllPlayersWithSeniorCareers();
//        for (Player sc : list1) {
//            System.out.println(sc);
//        }
        ArrayList<User> list = DB.listAllUser();
        for (User sc : list) {
            System.out.println(sc);
        }
    }
}
