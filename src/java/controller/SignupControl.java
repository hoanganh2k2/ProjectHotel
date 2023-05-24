package controller;

import dal.Sign_in_upDao;
import entity.Account;
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
@WebServlet(name = "SignupControl", urlPatterns = {"/signup"})
public class SignupControl extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String user = request.getParameter("user");
        String email = request.getParameter("email");
        String pass = request.getParameter("pass");
        String re_pass = request.getParameter("re_pass");
        Sign_in_upDao dao = new Sign_in_upDao();
        ArrayList<Account> list = (ArrayList<Account>) dao.getAllAccount();
        boolean a = true;
        for (Account acc : list) {
            if (acc.getUsername().equals(user)) {
                request.setAttribute("mess", "Account already exists");
                request.getRequestDispatcher("Signup.jsp").forward(request, response);
                a = false;
            } else if (acc.getEmail().equals(email)) {
                request.setAttribute("mess", "Email already exists");
                request.setAttribute("user", user);
                request.getRequestDispatcher("Signup.jsp").forward(request, response);
                a = false;
            }
        }
        if (pass.isEmpty()) {
            request.setAttribute("mess", "Please enter your password");
            request.setAttribute("user", user);
            request.setAttribute("email", email);
            request.getRequestDispatcher("Signup.jsp").forward(request, response);
        } else if (!pass.equals(re_pass)) {
            request.setAttribute("mess", "Passwords do not match, please try again");
            request.setAttribute("user", user);
            request.setAttribute("email", email);
            request.getRequestDispatcher("Signup.jsp").forward(request, response);
        }else if(a){
            dao.addAcount(user, email, pass);
            request.setAttribute("mess", "You have successfully created an account");
            request.getRequestDispatcher("SignIn.jsp").forward(request, response);
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
