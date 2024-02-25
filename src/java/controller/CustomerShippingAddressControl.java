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
import java.util.ArrayList;
import model.Account;
import model.ShippingAddress;

/**
 *
 * @author Tosaka
 */
public class CustomerShippingAddressControl extends HttpServlet {

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
            out.println("<title>Servlet CustomerShippingAddressControl</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CustomerShippingAddressControl at " + request.getContextPath() + "</h1>");
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
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            DAO dao = new DAO();
            HttpSession session = request.getSession();
            Account a = (Account) session.getAttribute("acc");
            if (a == null) {
                response.sendRedirect("login.jsp");
            } else {
                int accountID = a.getuID();
                ArrayList<ShippingAddress> list = dao.getShippingAddress(accountID);
                request.setAttribute("list", list);
                request.getRequestDispatcher("ShippingAddress.jsp").forward(request, response);
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
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            String fullname = request.getParameter("fullname").replaceAll("\\s+", " ").trim();
            String address = request.getParameter("address").replaceAll("\\s+", " ").trim();
            String phonenum = request.getParameter("phonenum").replaceAll("\\s", "").trim();
            String email = request.getParameter("email").replaceAll("\\s", "").trim();
            DAO dao = new DAO();
            String err = "", err2 = "", err3 = "", err4 = "", err5 = "";
            HttpSession session = request.getSession();
            Account a = (Account) session.getAttribute("acc");
            if (a == null) {
                response.sendRedirect("login.jsp");
            } else {
                int accountID = a.getuID();
                if (fullname.isEmpty() || address.isEmpty() || phonenum.isEmpty() || email.isEmpty()) {
                    err = getServletContext().getInitParameter("messErrorEditProfileCustomer");
                } else if (!fullname.matches("[\\p{L}\\s]+")) {
                    err2 = getServletContext().getInitParameter("messErrorInvalidName");
                } else if (phonenum.length() != 10 || !phonenum.matches("\\d+")) {
                    err3 = getServletContext().getInitParameter("messErrorPhoneNum");
                } else if (!email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")) {
                    err4 = getServletContext().getInitParameter("messErrorInvalidEmail");
                } else if (fullname.length() > 50 || email.length() > 50) {
                    err5 = getServletContext().getInitParameter("messErrorNameAndEmail");
                }

                if (!err.isEmpty() || !err2.isEmpty() || !err3.isEmpty() || !err4.isEmpty() || !err5.isEmpty()) {
                    request.setAttribute("err", err);
                    request.setAttribute("err2", err2);
                    request.setAttribute("err3", err3);
                    request.setAttribute("err4", err4);
                    request.setAttribute("err5", err5);
                    request.getRequestDispatcher("NewShippingAddress.jsp").forward(request, response);
                } else {
                    dao.insertShippingAddress(accountID, fullname, email, address, phonenum);
                    response.sendRedirect("shippingaddress");
                }
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
