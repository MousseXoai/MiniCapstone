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
import model.AccInfo;
import model.Account;
import model.HoaDon;
import model.InfoLine;
import model.OrderLine;
import model.SanPham;
import model.TrangThai;

/**
 *
 * @author Tosaka
 */
public class CustomerOrderDetailControl extends HttpServlet {
   
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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CustomerOrderDetailControl</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CustomerOrderDetailControl at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        String invoiceID = request.getParameter("invoiceID");
        DAO dao = new DAO();
        HttpSession session = request.getSession();
        Account a = (Account) session.getAttribute("acc");
        if (a == null) {
            response.sendRedirect("login.jsp");
        } else {

            int accountID = a.getuID();           
            InfoLine il = dao.getInfoLine(Integer.parseInt(invoiceID));
            HoaDon hd = dao.getHoaDon(Integer.parseInt(invoiceID));
            TrangThai tt = dao.getTrangThai(hd.getTrangThaiId());
            OrderLine ol = dao.getOrderLine(Integer.parseInt(invoiceID));
            SanPham sp = dao.getProductByID(String.valueOf(ol.getProductID()));
            AccInfo acc = dao.getAccInfo(hd.getAccountID());

            request.setAttribute("sanpham", sp);
            request.setAttribute("orderline", ol);
            request.setAttribute("trangthai", tt);
            request.setAttribute("hoadon", hd);
            request.setAttribute("infoline", il);
            request.setAttribute("acc", acc);
            request.getRequestDispatcher("OrderDetail.jsp").forward(request, response);
        }
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
