/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.DAO;
import dto.ShopOrderDTO;
import dto.StatusOrderDTO;
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
public class SellerSearchOrderController extends HttpServlet {

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
            out.println("<title>Servlet SellerSearchOrderController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SellerSearchOrderController at " + request.getContextPath() + "</h1>");
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
        String sid_raw = request.getParameter("sid");
        String input = request.getParameter("input");
        String select = request.getParameter("op");
        System.out.println(select);
        int sid = Integer.parseInt(sid_raw);
        DAO dao = new DAO();
        HttpSession session = request.getSession();
        Account a = (Account) session.getAttribute("acc");
        if (a == null || a.getIsSell() != 1) {
            response.sendRedirect("login.jsp");
        } else {

            int accountID = a.getuID();
            int shopID = dao.getShopIdByAccountId(accountID);
            if (sid == 0) {
                List<HoaDon> orderList = dao.searchOrderByOrderID(shopID, input);
                List<StatusOrderDTO> statusList = dao.getOrderStatusByOrderID(shopID, input);
                List<TrangThai> statusCate = dao.getStatusCategory();
                List<ShopOrderDTO> productList = dao.getProductOrderByOrderID(shopID, input);
                List<OrderLine> orderLine = dao.getOrderLineByOrderID(shopID, input);
                List<AccInfo> accInfo = dao.getBuyerInfoByOrderWithOrderID(shopID, input);
                request.setAttribute("sid", sid);
                request.setAttribute("statusCate", statusCate);
                request.setAttribute("accInfo", accInfo);
                request.setAttribute("orderLine", orderLine);
                request.setAttribute("productList", productList);
                request.setAttribute("statusList", statusList);
                request.setAttribute("orderList", orderList);
                request.getRequestDispatcher("SellerOrderController.jsp").forward(request, response);
            } else {
                List<HoaDon> orderList = dao.getOrderByOrderIDAndStatus(shopID, sid,input);
                List<StatusOrderDTO> statusList = dao.getOrderStatusByOrderID(shopID, input);
                List<TrangThai> statusCate = dao.getStatusCategory();
                List<ShopOrderDTO> productList = dao.getProductOrderByOrderIDAndStatus(shopID, sid,input);
                List<OrderLine> orderLine = dao.getOrderLineByOrderIDAndStatus(shopID, sid,input);
                List<AccInfo> accInfo = dao.getBuyerInfoByOrderWithOrderIDAndStatus(shopID, sid,input);
                request.setAttribute("sid", sid);
                request.setAttribute("statusCate", statusCate);
                request.setAttribute("accInfo", accInfo);
                request.setAttribute("orderLine", orderLine);
                request.setAttribute("productList", productList);
                request.setAttribute("statusList", statusList);
                request.setAttribute("orderList", orderList);
                request.getRequestDispatcher("StatusPage.jsp").forward(request, response);
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
