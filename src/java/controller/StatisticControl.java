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
import java.util.Calendar;
import model.Account;

/**
 *
 * @author admin
 */
public class StatisticControl extends HttpServlet {

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
            int countNumOfInvoice = dao.countNumOfInvoice(shopID);
            request.setAttribute("countNumOfInvoice", countNumOfInvoice);

            // Lấy thứ của ngày hiện tại
            Calendar calendar = Calendar.getInstance();
            double calculateRevenueDay1 = dao.calculateRevenueDay(1, shopID);
            double calculateRevenueDay2 = dao.calculateRevenueDay(2, shopID);
            double calculateRevenueDay3 = dao.calculateRevenueDay(3, shopID);
            double calculateRevenueDay4 = dao.calculateRevenueDay(4, shopID);
            double calculateRevenueDay5 = dao.calculateRevenueDay(5, shopID);
            double calculateRevenueDay6 = dao.calculateRevenueDay(6, shopID);
            double calculateRevenueDay7 = dao.calculateRevenueDay(7, shopID);

            request.setAttribute("calculateRevenueDay1", calculateRevenueDay1);
            request.setAttribute("calculateRevenueDay2", calculateRevenueDay2);
            request.setAttribute("calculateRevenueDay3", calculateRevenueDay3);
            request.setAttribute("calculateRevenueDay4", calculateRevenueDay4);
            request.setAttribute("calculateRevenueDay5", calculateRevenueDay5);
            request.setAttribute("calculateRevenueDay6", calculateRevenueDay6);
            request.setAttribute("calculateRevenueDay7", calculateRevenueDay7);

            // Lấy năm hiện tại
            int currentYear = calendar.get(Calendar.YEAR);

// Mảng để lưu trữ doanh thu của từng tháng trong năm hiện tại
            double[] calculateRevenueMonths = new double[12];

// Tính toán doanh thu cho từng tháng trong năm hiện tại
            for (int i = 0; i < 12; i++) {
                calculateRevenueMonths[i] = dao.calculateRevenueMonth(i + 1, currentYear, shopID); // Tháng được tính từ 1 đến 12
            }

// Gửi dữ liệu xuống lớp giao diện người dùng (UI)
            for (int i = 0; i < 12; i++) {
                request.setAttribute("calculateRevenueMonth" + (i + 1), calculateRevenueMonths[i]); // Gửi dữ liệu của từng tháng xuống UI
            }

            request.getRequestDispatcher("dashboard.jsp").forward(request, response);
            PrintWriter out = response.getWriter();

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
