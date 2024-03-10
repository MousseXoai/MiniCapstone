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
import model.Account;
import model.PhanLoai;
import model.SanPham;

/**
 *
 * @author admin
 */
public class RevenueByDayControl extends HttpServlet {

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
            out.println("<title>Servlet RevenueByDay</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RevenueByDay at " + request.getContextPath() + "</h1>");
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
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        DAO dao = new DAO();
        HttpSession session = request.getSession();
        Account a = (Account) session.getAttribute("acc");
        if (a == null || a.getIsSell() != 1) {
            response.sendRedirect("login.jsp");
        } else {
            String date1String = request.getParameter("date1");
            String date2String = request.getParameter("date2");
            if (date1String == null || date1String.isEmpty() || date2String == null || date2String.isEmpty()) {
                response.sendRedirect("revenue");
            } else {
                Date date1 = Date.valueOf(date1String);
                Date date2 = Date.valueOf(date2String);
                request.setAttribute("date1", date1);
                request.setAttribute("date2", date2);
                int accountID = a.getuID();
                int shopID = dao.getShopIdByAccountId(accountID);
                int countTotalProduct = dao.totalProductInShop(shopID);
                request.setAttribute("countTotalProduct", countTotalProduct);
                int countNumOfInvoice = dao.countNumOfInvoiceByDay(shopID, date1, date2);
                request.setAttribute("countNumOfInvoice", countNumOfInvoice);
                int numOfCmt = dao.countNumOfCmtByDay(shopID, date1, date2);
                request.setAttribute("numOfCmt", numOfCmt);
                double revenue = dao.calculateRevenueByDay(shopID, date1, date2);
                request.setAttribute("revenue", revenue);
                int countNumOfOutProduct = dao.countNumOfOutProduct(shopID);
                request.setAttribute("countNumOfOutProduct", countNumOfOutProduct);
                int countNumOfRefundInvoice = dao.countNumOfRefundInvoiceByDay(shopID, date1, date2);
                request.setAttribute("countNumOfRefundInvoice", countNumOfRefundInvoice);

                List<SanPham> getOutOfProduct = dao.getOutOfProduct(shopID);
                request.setAttribute("getOutOfProduct", getOutOfProduct);
                List<SanPham> top5SPBanChay = dao.top5SpBanChayNhatByDay(shopID, date1, date2);
                request.setAttribute("top5SPBanChay", top5SPBanChay);
                List<PhanLoai> getCategory = dao.getCategoryByShopID(shopID);
                request.setAttribute("getCategory", getCategory);

                request.getRequestDispatcher("Revenue.jsp").forward(request, response);
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
