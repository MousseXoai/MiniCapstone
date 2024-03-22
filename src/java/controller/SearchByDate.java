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
import java.util.List;
import model.AccInfo;
import model.Account;
import model.HoaDon;
import model.OrderLine;
import model.SanPham;

/**
 *
 * @author Acer
 */
public class SearchByDate extends HttpServlet {

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
            out.println("<title>Servlet SearchByDate</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SearchByDate at " + request.getContextPath() + "</h1>");
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
            int trangthaiid = Integer.parseInt(trangthaiid1);
            int accountID = a.getuID();
            String date1 = request.getParameter("date1");
            String date2 = request.getParameter("date2");
            if (date1.isEmpty() && date2.isEmpty()) {
                request.getParameter("trangthaiid");
                request.getRequestDispatcher("oderwaitting").forward(request, response);
            } else {
                if (date1.isEmpty()) {
                    date1 = "2020-01-01";
                }
                if (date2.isEmpty()) {
                    date2 = "2029-01-01";
                }
                Date datea = Date.valueOf(date1);
                Date dateb = Date.valueOf(date2);
                List<SanPham> listAllSP = dao.getListAllSanPham();
                List<HoaDon> listHoaDon = dao.listHoaDon(accountID, trangthaiid, datea, dateb);
                List<OrderLine> ListOrderLine = dao.getListOrderLine();
                AccInfo acc = dao.getAccInfo(accountID);
                request.setAttribute("datea", datea);
                request.setAttribute("dateb", dateb);
                request.setAttribute("acc", acc);
                request.setAttribute("listAllSP", listAllSP);
                request.setAttribute("ListOrderLine", ListOrderLine);
                request.setAttribute("listHoaDon", listHoaDon);
                request.getRequestDispatcher("OrderWaitting.jsp").forward(request, response);
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
