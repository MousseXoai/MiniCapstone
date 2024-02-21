/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dal.DAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import model.AccInfo;
import model.Account;

/**
 *
 * @author admin
 */
@WebServlet(name = "CreateShopControl", urlPatterns = {"/createShop"})
@MultipartConfig(maxFileSize = 16177216)//1.5mb
public class CreateShopControl extends HttpServlet {
   
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
        if (a == null || a.getIsSell()==1) {
            response.sendRedirect("login.jsp");
        } else {

            int accountID = a.getuID();
            List<AccInfo> email = dao.getAccEmail(accountID);
            request.setAttribute("email", email);
        request.getRequestDispatcher("CreateShop.jsp").forward(request, response);
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
        HttpSession session = request.getSession();
        Account a = (Account) session.getAttribute("acc");
        int accountID = a.getuID();
        DAO dao = new DAO();
//        LocalDate curDate = java.time.LocalDate.now();
//        String date = curDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
//        java.sql.Date sqlDate = java.sql.Date.valueOf(curDate);
        String shopName = request.getParameter("name");
        Part proof1 = request.getPart("proof1");
        Part proof2 = request.getPart("proof2");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        dao.createShop(shopName, proof1, proof2, address, accountID);
        
        request.getRequestDispatcher("HomePage.jsp").forward(request, response);
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
