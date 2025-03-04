/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dal.DAO;
import dto.AdminShopData;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta .servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import model.AccInfo;
import model.Account;


/**
 *
 * @author dell
 */
public class Admin extends HttpServlet {
   
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
        if (a == null || a.getIsAdmin()!= 1) {
            response.sendRedirect("login.jsp");
        } else {
            
            int TotalUsers = dao.getTotalUsers();
            request.setAttribute("TotalUsers", TotalUsers);
            int TotalCustomer = dao.getTotalCustomer();
            request.setAttribute("TotalCustomer",TotalCustomer);
            int TotalSeller = dao.getTotalSeller();
            request.setAttribute("TotalSeller",TotalSeller);
            int TotalChecker = dao.getTotalChecker();
            request.setAttribute("TotalChecker",TotalChecker);
            int TotalShipper = dao.getTotalShipper();
            request.setAttribute("TotalShipper",TotalShipper);
            List<AccInfo> customertop3 = dao.getTop3CustomerRevenue() ;
           request.setAttribute("customertop3", customertop3 );
           List<AdminShopData> list = dao.getTop3ShopRevenue();
           request.setAttribute("list", list);
            
        
             request.getRequestDispatcher("Admin.jsp").forward(request, response);
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
