/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.DAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.Date;
import model.AccInfo;
import model.Account;

/**
 *
 * @author Acer
 */
public class FeedBackControl extends HttpServlet {

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
            out.println("<title>Servlet FeedBackControl</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet FeedBackControl at " + request.getContextPath() + "</h1>");
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
        HttpSession session = request.getSession();
        Account a = (Account) session.getAttribute("acc");
        String id = request.getParameter("pid");
        String invoiceID= request.getParameter("maHD");
        int pid = Integer.parseInt(id);
        int maHD= Integer.parseInt(invoiceID);
        if (a == null) {
            response.sendRedirect("login.jsp");
        } else {
            request.setAttribute("pid", pid);
            request.setAttribute("maHD", maHD);
            request.getRequestDispatcher("FeedBack.jsp").forward(request, response);
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
        HttpSession session = request.getSession();
        Account a = (Account) session.getAttribute("acc");

        String id = request.getParameter("pid");
        String invoiceID= request.getParameter("maHD");
        int pid = Integer.parseInt(id);
        int maHD= Integer.parseInt(invoiceID);
        if (a == null) {
            response.sendRedirect("login.jsp");
        } else {
            DAO dao = new DAO();
            AccInfo aif = dao.getAccInfo(a.getuID());
            String rate = request.getParameter("rate");
            if (isnotNumber(rate)) {
                String errorMessage = "Vui lòng nhập so nguyen";
                request.setAttribute("pid", pid);
                request.setAttribute("maHD", maHD);
                request.setAttribute("errorMessage", errorMessage);
                request.getRequestDispatcher("FeedBack.jsp").forward(request, response);
                return;
            }
            int ratep = Integer.parseInt(rate);
            if (ratep < 1 || ratep > 5) {
                String errorMessage = "Vui lòng nhập từ 1 đến 5";
                request.setAttribute("pid", pid);
                request.setAttribute("maHD", maHD);
                request.setAttribute("errorMessage", errorMessage);
                request.getRequestDispatcher("FeedBack.jsp").forward(request, response);
                return;
            }
            String message = request.getParameter("message");
            dao.addFeedBack(a.getuID(), pid, message, aif.getAvatar(), ratep, maHD);
            response.sendRedirect("order");
        }
    }

    public static boolean isnotNumber(String s) {
        try {
            Integer.parseInt(s);
            return false;
        } catch (NumberFormatException e) {
            return true;
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
