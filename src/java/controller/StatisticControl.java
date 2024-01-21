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
import model.Account;

/**
 *
 * @author admin
 */
public class StatisticControl extends HttpServlet {
   
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
        request.setCharacterEncoding("UTF-8");
        DAO dao = new DAO();
        HttpSession session = request.getSession();
        Account a = (Account) session.getAttribute("acc");
        if (a == null || a.getIsSell()!=1) {
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

            double calculateRevenueMonth1 = dao.calculateRevenueMonth(1, shopID);
            double calculateRevenueMonth2 = dao.calculateRevenueMonth(2, shopID);
            double calculateRevenueMonth3 = dao.calculateRevenueMonth(3, shopID);
            double calculateRevenueMonth4 = dao.calculateRevenueMonth(4, shopID);
            double calculateRevenueMonth5 = dao.calculateRevenueMonth(5, shopID);
            double calculateRevenueMonth6 = dao.calculateRevenueMonth(6, shopID);
            double calculateRevenueMonth7 = dao.calculateRevenueMonth(7, shopID);
            double calculateRevenueMonth8 = dao.calculateRevenueMonth(8, shopID);
            double calculateRevenueMonth9 = dao.calculateRevenueMonth(9, shopID);
            double calculateRevenueMonth10 = dao.calculateRevenueMonth(10, shopID);
            double calculateRevenueMonth11 = dao.calculateRevenueMonth(11, shopID);
            double calculateRevenueMonth12 = dao.calculateRevenueMonth(12, shopID);

            request.setAttribute("calculateRevenueMonth1", calculateRevenueMonth1);
            request.setAttribute("calculateRevenueMonth2", calculateRevenueMonth2);
            request.setAttribute("calculateRevenueMonth3", calculateRevenueMonth3);
            request.setAttribute("calculateRevenueMonth4", calculateRevenueMonth4);
            request.setAttribute("calculateRevenueMonth5", calculateRevenueMonth5);
            request.setAttribute("calculateRevenueMonth6", calculateRevenueMonth6);
            request.setAttribute("calculateRevenueMonth7", calculateRevenueMonth7);
            request.setAttribute("calculateRevenueMonth8", calculateRevenueMonth8);
            request.setAttribute("calculateRevenueMonth9", calculateRevenueMonth9);
            request.setAttribute("calculateRevenueMonth10", calculateRevenueMonth10);
            request.setAttribute("calculateRevenueMonth11", calculateRevenueMonth11);
            request.setAttribute("calculateRevenueMonth12", calculateRevenueMonth12);

            request.getRequestDispatcher("dashboard.jsp").forward(request, response);
            PrintWriter out = response.getWriter();

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
        processRequest(request, response);
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
        processRequest(request, response);
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
