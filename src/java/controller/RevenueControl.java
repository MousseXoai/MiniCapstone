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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Account;
import model.PhanLoai;
import model.SanPham;

/**
 *
 * @author admin
 */
public class RevenueControl extends HttpServlet {

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
        request.setCharacterEncoding("UTF-8");
        DAO dao = new DAO();
        HttpSession session = request.getSession();
        Account a = (Account) session.getAttribute("acc");
        if (a == null || a.getIsSell() != 1) {
            response.sendRedirect("login.jsp");
        } else {

            int accountID = a.getuID();
            int shopID = dao.getShopIdByAccountId(accountID);
            int totalItems = dao.countItemInShop(shopID);
            request.setAttribute("totalSaled", totalItems);
            double revenue = dao.calculateRevenue(shopID);
            request.setAttribute("revenue", revenue);
            int numOfCmt = dao.countNumOfCmt(shopID);
            request.setAttribute("numOfCmt", numOfCmt);
            int countTotalProduct = dao.totalProductInShop(shopID);
            request.setAttribute("countTotalProduct", countTotalProduct);
            int countNumOfInvoice = dao.countNumOfInvoice(shopID);
            request.setAttribute("countNumOfInvoice", countNumOfInvoice);
            int countNumOfOutProduct = dao.countNumOfOutProduct(shopID);
            request.setAttribute("countNumOfOutProduct", countNumOfOutProduct);
            List<SanPham> top5SPBanChay = dao.top5SpBanChayNhat(shopID);
            request.setAttribute("top5SPBanChay", top5SPBanChay);
            List<PhanLoai> getCategory = dao.getCategoryByShopID(shopID);
            request.setAttribute("getCategory", getCategory);
            List<SanPham> getOutOfProduct = dao.getOutOfProduct(shopID);
            request.setAttribute("getOutOfProduct", getOutOfProduct);
            int countNumOfRefundInvoice = dao.countNumOfRefundInvoice(shopID);
            request.setAttribute("countNumOfRefundInvoice", countNumOfRefundInvoice);
            request.getRequestDispatcher("Revenue.jsp").forward(request, response);
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
