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

/**
 *
 * @author admin
 */
public class SaveUpdateProductControl extends HttpServlet {
   
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
            out.println("<title>Servlet SaveUpdateProductControl</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SaveUpdateProductControl at " + request.getContextPath () + "</h1>");
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
        
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        DAO dao = new DAO();
        int pid = Integer.parseInt(request.getParameter("pid"));
        String pname = request.getParameter("pname");
//        String pprice = request.getParameter("pprice");
        Double pprice = Double.parseDouble(request.getParameter("pprice"));
//          float pprice = Float.parseFloat(request.getParameter("pprice"));
        int pquantity = Integer.parseInt(request.getParameter("pquantity"));
        String ptitle = request.getParameter("ptitle");
        String pdescription = request.getParameter("pdescription");
        int pcate = Integer.parseInt(request.getParameter("category"));
        int pbrand = Integer.parseInt(request.getParameter("brand"));
        String pcolor = request.getParameter("pcolor");
        dao.updateProduct(pname, pprice, pquantity, ptitle, pdescription, pcate, pbrand, pcolor, pid);
        System.out.println(pid);
        System.out.println(pname);
        System.out.println(pprice);
        System.out.println(pquantity);
        System.out.println(ptitle);
        System.out.println(pdescription);
        System.out.println(pcate);
        System.out.println(pbrand);
        System.out.println(pcolor);
        request.getRequestDispatcher("QuanLySanPhamControl").forward(request, response);
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
