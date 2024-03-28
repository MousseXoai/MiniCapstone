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
import jakarta.websocket.SendResult;
import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Account;
import model.ShopHangCho;

/**
 *
 * @author dell
 */
public class ShopWaiting extends HttpServlet {

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
            out.println("<title>Servlet ShopWaiting</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ShopWaiting at " + request.getContextPath() + "</h1>");
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
        try ( PrintWriter out = response.getWriter()) {

            DAO dao = new DAO();
            HttpSession session = request.getSession();
            Account a = (Account) session.getAttribute("acc");
            if (a == null) {
                response.sendRedirect("login.jsp");
            } else {
                List<ShopHangCho> listshc = dao.getAllShopHangCho();
                request.setAttribute("listshc", listshc);
                request.getRequestDispatcher("ShopWaitting.jsp").forward(request, response);
            }
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
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            String id = request.getParameter("id");
            String uid = request.getParameter("uid");
            String Name = request.getParameter("Name");
            
            String date = request.getParameter("date");
            
            String address = request.getParameter("address");
            String proof = request.getParameter("proof");
            String proof1 = request.getParameter("proof1");
            
            String approve = request.getParameter("approve");

            System.out.println(id);
            System.out.println(uid);
            System.out.println(Name);
            System.out.println(date);
            System.out.println(address);
            System.out.println(proof);
            System.out.println(proof1);
            System.out.println(approve);

            DAO dao = new DAO();
            HttpSession session = request.getSession();
            Account a = (Account) session.getAttribute("acc");
            if (a == null) {
                response.sendRedirect("login.jsp");
            } else {
                if(approve.equals("approve")){  
                    dao.AddShopHangChoToShop(Name,Integer.parseInt(uid),date,address,proof, proof1);
                    dao.UpdateAccountIsSell(Integer.parseInt(uid));
                    
                    dao.deleteShopHangCho(Integer.parseInt(id));
                    
                    response.sendRedirect("ShopWaiting");
                }
                else if(approve.equals("reject")){
                    dao.deleteShopHangCho(Integer.parseInt(id));
                    response.sendRedirect("ShopWaiting");
                }
            }
        } catch (Exception e) {
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
