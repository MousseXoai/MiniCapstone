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
import model.AccInfo;
import model.Account;
import model.HoaDon;

/**
 *
 * @author Tosaka
 */
public class CustomerInfoControl extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
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
            out.println("<title>Servlet CustomerInfoControl</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CustomerInfoControl at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    /**
     * Handles the HTTP <code>GET</code> method.
     *
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            DAO dao = new DAO();
            HttpSession session = request.getSession();
            Account a = (Account) session.getAttribute("acc");
            if (a == null) {
                response.sendRedirect("login.jsp");
            } else {

                int accountID = a.getuID();
                AccInfo acc = dao.getAccInfo(accountID);
                double hd = dao.getSumTongChiTieu(accountID);
                System.out.println(hd);
                request.setAttribute("acc", acc);
                request.setAttribute("hd", hd);
                request.getRequestDispatcher("UserProfile.jsp").forward(request, response);

            }
        }
    }

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            String fullname = request.getParameter("fullname").replaceAll("\\s+", " ").trim();
            String address = request.getParameter("address").replaceAll("\\s+", " ").trim();
            String phonenum = request.getParameter("phonenum").replaceAll("\\s", "").trim();
            String email = request.getParameter("email").replaceAll("\\s", "").trim();

            String err = "";

            DAO dao = new DAO();
            HttpSession session = request.getSession();
            Account a = (Account) session.getAttribute("acc");
            if (a == null) {
                response.sendRedirect("login.jsp");
            } else {

                int accountID = a.getuID();

                if (fullname.isEmpty() || address.isEmpty() || phonenum.isEmpty() || email.isEmpty()) {
                    err = getServletContext().getInitParameter("messErrorEditProfileCustomer");
                } else if (!fullname.matches("[\\p{L}\\s]+")) {
                    err = getServletContext().getInitParameter("messErrorInvalidName");
                } else if (phonenum.length() != 10 || !phonenum.matches("\\d+")) {
                    err = getServletContext().getInitParameter("messErrorPhoneNum");
                } else if (!email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")) {
                    err = getServletContext().getInitParameter("messErrorInvalidEmail");
                } else if (fullname.length() > 50 || email.length() > 50) {
                    err = getServletContext().getInitParameter("messErrorNameAndEmail");
                }

                if (!err.isEmpty()) {
                    AccInfo acc = dao.getAccInfo(accountID);
                    request.setAttribute("acc", acc);
                    request.setAttribute("err", err);
                    request.getRequestDispatcher("UserProfile.jsp").forward(request, response);
                } else {
                    dao.editAccInfo(fullname, address, phonenum, email, accountID);
                    response.sendRedirect("customerinfo");
                }
            }
        }
    }
    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
