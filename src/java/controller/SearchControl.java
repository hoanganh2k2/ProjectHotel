package controller;

import dal.RoomDao;
import entity.Room;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author Nguyễn Hoàng Anh
 */
@WebServlet(name = "SearchControl", urlPatterns = {"/search"})
public class SearchControl extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String inDate = request.getParameter("indate");
        String outDate = request.getParameter("outdate");
        String cate = request.getParameter("cate");
        String adult = request.getParameter("adult");
        String children = request.getParameter("children");

        inDate = inDate.replace('/', '-');
        outDate = outDate.replace('/', '-');
        
        System.out.println("");
        
        request.setAttribute("indate", inDate);
        request.setAttribute("outdate", outDate);
        request.setAttribute("cate", cate);
        request.setAttribute("adult", adult);
        request.setAttribute("children", children);
        RoomDao dao = new RoomDao();
        ArrayList<Room> list = (ArrayList<Room>) dao.getSearchRoom(inDate, outDate, cate, adult, children);
        request.setAttribute("list", list);
        request.getRequestDispatcher("Rooms.jsp").forward(request, response);

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
        processRequest(request, response);
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
