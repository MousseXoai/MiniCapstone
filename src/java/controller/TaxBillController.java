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
import java.util.List;
import model.AccInfo;
import model.Account;
import model.HoaDonShop;

/**
 *
 * @author admin
 */
public class TaxBillController extends HttpServlet {
   
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
        Calendar calendar = Calendar.getInstance();
        int currentYear = calendar.get(Calendar.YEAR);
        int currentMonth = calendar.get(Calendar.MONTH) + 1;
        DAO dao = new DAO();
        HttpSession session = request.getSession();
        Account a = (Account) session.getAttribute("acc");
        int accountID = a.getuID();
        int shopID = dao.getShopIdByAccountId(accountID);
        int status = dao.getStatusByShopID(shopID);
        List<HoaDonShop> getTax = dao.getTaxByShopID(shopID);
        request.setAttribute("getTax", getTax);
        if(status == 1){
            request.getRequestDispatcher("NoBill.jsp").forward(request, response);
        } else if(getTax ==null || getTax.isEmpty()){
           request.getRequestDispatcher("NoBill.jsp").forward(request, response);
        } else{
        String shopName = dao.getShopName(shopID);
        request.setAttribute("shopName", shopName);
        List<AccInfo> shopinfo = dao.getShopInfoByShopID(shopID);
        request.setAttribute("shopinfo", shopinfo);
        List<AccInfo> admininfo = dao.getAdminInfo();
        request.setAttribute("admininfo", admininfo);
        double revenueThisMonth = dao.getRevenueCurrentMonth(shopID, currentMonth, currentYear);
        request.setAttribute("revenueThisMonth", revenueThisMonth);
        
        request.getRequestDispatcher("taxBill.jsp").forward(request, response);
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
