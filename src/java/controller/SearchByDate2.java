/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.DAO;
import dto.OrderDTO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.Date;
import java.util.List;
import model.AccInfo;
import model.Account;

/**
 *
 * @author Acer
 */
public class SearchByDate2 extends HttpServlet {

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
            out.println("<title>Servlet SearchByDate2</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SearchByDate2 at " + request.getContextPath() + "</h1>");
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
        DAO dao = new DAO();
        HttpSession session = request.getSession();
        Account a = (Account) session.getAttribute("acc");
        String trangthaiid1 = request.getParameter("trangthaiid");
        if (a == null) {
            response.sendRedirect("login.jsp");
        } else {
            String date1 = request.getParameter("date1");
            String date2 = request.getParameter("date2");
            if (date1.isEmpty() && date2.isEmpty()) {
                request.getParameter("trangthaiid");
                request.getRequestDispatcher("orderdone").forward(request, response);
            } else {
                if (date1.isEmpty()) {
                    date1 = "2020-01-01";
                }
                if (date2.isEmpty()) {
                    date2 = "2029-01-01";
                }
                Date datea = Date.valueOf(date1);
                Date dateb = Date.valueOf(date2);
                int trangthaiid = Integer.parseInt(trangthaiid1);
                int accountID = a.getuID();
                List<OrderDTO> ListOrderDone = dao.getListOrderDone(accountID, trangthaiid, datea, dateb);
                AccInfo acc = dao.getAccInfo(accountID);
                request.setAttribute("acc", acc);
                request.setAttribute("datea", datea);
                request.setAttribute("dateb", dateb);
                request.setAttribute("ListOrderDone", ListOrderDone);
                request.getRequestDispatcher("OrderDone.jsp").forward(request, response);
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
