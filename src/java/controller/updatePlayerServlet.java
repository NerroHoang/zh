package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Player;
import model.SeniorCareer;

/**
 *
 * @author hoang
 */
@WebServlet("/UpdatePlayerServlet")
public class updatePlayerServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet updatePlayer</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet updatePlayer at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String playerId = request.getParameter("playerId");
        String fullName = request.getParameter("fullName");
        String img = request.getParameter("img");
        String position = request.getParameter("position");
        String isCaptain = request.getParameter("isCaptain");
        int appearances = Integer.parseInt(request.getParameter("appearances"));
        int number = Integer.parseInt(request.getParameter("number"));
        int yearOfBirth = Integer.parseInt(request.getParameter("yearOfBirth"));
        String country = request.getParameter("country");
        String imgCountry = request.getParameter("imgCountry");
        int marketValue = Integer.parseInt(request.getParameter("marketValue"));

        // Tạo đối tượng Player
        Player player = new Player(playerId, fullName, img, position, isCaptain, appearances, number, yearOfBirth,
                country, imgCountry, marketValue);
        request.setAttribute("player", player);
        request.getRequestDispatcher("update.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lấy thông tin người chơi từ request
        String playerId = request.getParameter("playerId");
        String fullName = request.getParameter("fullName");
        String img = request.getParameter("img");
        String position = request.getParameter("position");
        String isCaptain = request.getParameter("isCaptain");
        int appearances = Integer.parseInt(request.getParameter("appearances"));
        int number = Integer.parseInt(request.getParameter("number"));
        int yearOfBirth = Integer.parseInt(request.getParameter("yearOfBirth"));
        String country = request.getParameter("country");
        String imgCountry = request.getParameter("imgCountry");
        int marketValue = Integer.parseInt(request.getParameter("marketValue"));

        // Tạo đối tượng Player
        Player player = new Player(playerId, fullName, img, position, isCaptain, appearances, number, yearOfBirth,
                country, imgCountry, marketValue);

        // Gọi phương thức updatePlayer từ lớp DB để cập nhật thông tin người chơi
        String result = DB.updatePlayer(player);

        // Xử lý kết quả và chuyển hướng người dùng đến trang tương ứng
        if (result.equals("success")) {
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<script>alert('Update successful!'); window.location.href='managerPlayer.jsp';</script>");
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
