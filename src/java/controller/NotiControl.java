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
import java.util.ArrayList;
import model.Account;
import model.DateNoti;
import model.Noti;
import model.NotiCate;
import model.Shop;

/**
 *
 * @author Admin
 */
public class NotiControl extends HttpServlet {
   
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
        DAO dao= new DAO();
        HttpSession session = request.getSession();
        Account a = (Account) session.getAttribute("acc");
        if (a == null) {
            response.sendRedirect("login.jsp");
        } else {
            int accountID = a.getuID();
            String avatar= dao.getAvatarByAccId(accountID);
            int countNoti= dao.countNotiByAccId(accountID);
            int countAds = dao.countAds();
            ArrayList<Noti> listAdsToday= dao.getListAdsToday();
            ArrayList<Shop> listAllShop= dao.getAllShop();
            ArrayList<NotiCate> listNotiCate= dao.getListNotiCate();
            ArrayList<Noti> listAdsMonth= dao.getListAdsMonth();
            ArrayList<DateNoti> listDateNoti = dao.getListDateNoti();
            request.setAttribute("listDateNoti", listDateNoti);
            request.setAttribute("listAdsMonth", listAdsMonth);
            request.setAttribute("listNotiCate",listNotiCate );
            request.setAttribute("listAdsToday", listAdsToday);
            request.setAttribute("listAllShop", listAllShop);
            request.setAttribute("countAds", countAds);
            request.setAttribute("countNoti", countNoti);
            request.setAttribute("avatar", avatar);
            request.getRequestDispatcher("Notification.jsp").forward(request, response);
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
