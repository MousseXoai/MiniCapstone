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
import java.util.List;
import model.AccInfo;
import model.Account;
import model.HoaDon;
import model.OrderLine;
import model.SanPham;
import model.TrangThai;

/**
 *
 * @author ADMIN
 */
public class SellerOrderManagement extends HttpServlet {

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
            out.println("<title>Servlet SellerOrderManagement</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SellerOrderManagement at " + request.getContextPath() + "</h1>");
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
        request.setCharacterEncoding("UTF-8");
        int sid=0;
        DAO dao = new DAO();
        HttpSession session = request.getSession();
        Account a = (Account) session.getAttribute("acc");
        if (a == null || a.getIsSell()!=1) {
            response.sendRedirect("login.jsp");
        } else {

            int accountID = a.getuID();
            int shopID = dao.getShopIdByAccountId(accountID);
            List<HoaDon> orderList = dao.getOrderByShopID(shopID);
            List<TrangThai> statusList = dao.getOrderStatusByShopID(shopID);
            List<TrangThai> statusCate = dao.getStatusCategory();
            List<SanPham> productList = dao.getProductOrderByShopID(shopID);
            List<OrderLine> orderLine = dao.getOrderLineByShopID(shopID);
            List<AccInfo> accInfo = dao.getBuyerInfoByOrderWithShopID(shopID);
            request.setAttribute("sid", sid);
            request.setAttribute("statusCate", statusCate);
            request.setAttribute("accInfo", accInfo);
            request.setAttribute("orderLine", orderLine);
            request.setAttribute("productList", productList);
            request.setAttribute("statusList", statusList);
            request.setAttribute("orderList", orderList);
            request.getRequestDispatcher("SellerOrderController.jsp").forward(request, response);
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
        String maHD_raw = request.getParameter("maHD");
        String changeStatus_raw = request.getParameter("changeStatus");
        int maHD = Integer.parseInt(maHD_raw);
        int changeStatus = Integer.parseInt(changeStatus_raw);
        int sid=0;
        DAO dao = new DAO();
        HttpSession session = request.getSession();
        Account a = (Account) session.getAttribute("acc");
        if (a == null || a.getIsSell()!=1) {
            response.sendRedirect("login.jsp");
        } else {

            int accountID = a.getuID();
            int shopID = dao.getShopIdByAccountId(accountID);
            dao.changeOrderStatus(maHD,changeStatus);
            List<HoaDon> orderList = dao.getOrderByShopID(shopID);
            List<TrangThai> statusList = dao.getOrderStatusByShopID(shopID);
            List<TrangThai> statusCate = dao.getStatusCategory();
            List<SanPham> productList = dao.getProductOrderByShopID(shopID);
            List<OrderLine> orderLine = dao.getOrderLineByShopID(shopID);
            List<AccInfo> accInfo = dao.getBuyerInfoByOrderWithShopID(shopID);
            request.setAttribute("sid", sid);
            request.setAttribute("statusCate", statusCate);
            request.setAttribute("accInfo", accInfo);
            request.setAttribute("orderLine", orderLine);
            request.setAttribute("productList", productList);
            request.setAttribute("statusList", statusList);
            request.setAttribute("orderList", orderList);
            request.getRequestDispatcher("SellerOrderController.jsp").forward(request, response);
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
