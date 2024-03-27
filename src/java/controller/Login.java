/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dal.DAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import model.Account;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author Tosaka
 */
public class Login extends HttpServlet {

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
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Login</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Login at " + request.getContextPath() + "</h1>");
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
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        DAO d = new DAO();
        HttpSession session = request.getSession();
        if(action.equals("Face")){
            String username = request.getParameter("name");
            String email = request.getParameter("email");
            String id = request.getParameter("id");
            Account a = d.check(username);
            try{
            if(a == null || (a.getPass().trim().equals(id)) == false) {
                    a = new Account(0, username, id, 0, 0, 0, 0);
                    d.addFacebookAccount(a);
                    int uID = d.getUidByName(a);
                    d.addEmailByUid(email, uID);
                    session.setAttribute("acc", a);
                    response.sendRedirect("home");
                } else {
                    session.setAttribute("acc", a);
                    response.sendRedirect("home");
                }
            } catch(Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
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
        String u = request.getParameter("user");
        String p = request.getParameter("pass");
        String r = request.getParameter("rem");
        System.out.println(u);
        Cookie cu = new Cookie("cuser",u);
        Cookie cp = new Cookie("cpass",p);
        Cookie cr = new Cookie("crem",r);
        if(r!=null){
            cu.setMaxAge(60*60*24);
            cp.setMaxAge(60*60*24);
            cr.setMaxAge(60*60*24);
            
        } else {
            cu.setMaxAge(0);
            cp.setMaxAge(0);
            cr.setMaxAge(0);
        }
        response.addCookie(cu);
        response.addCookie(cp);
        response.addCookie(cr);
        DAO d = new DAO();
        Account a = d.check(u);
        
        if (a == null || (BCrypt.checkpw(p, a.getPass().trim() ) == false)) {
            request.setAttribute("errorMessage", "username or password invalid! ");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } else {
//co roi
            HttpSession session = request.getSession();
            session.setAttribute("acc", a);
            if (a.getIsSell() == 1) {
                response.sendRedirect("statistic");
            } else if (a.getIsAdmin() == 1) {
                response.sendRedirect("Admin");
            } else if (a.getIsShip() == 1) {
                response.sendRedirect("ship");
            } else if (a.getIsCheck()== 1) {
                response.sendRedirect("check");
            } else {
                response.sendRedirect("home");
            }
            

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