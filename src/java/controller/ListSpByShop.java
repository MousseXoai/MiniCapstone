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
import java.util.List;
import model.Account;
import model.Brand;
import model.Color;
import model.PhanLoai;
import model.SanPham;
import model.Star;

/**
 *
 * @author Acer
 */
public class ListSpByShop extends HttpServlet {
   
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
            out.println("<title>Servlet ListSpByShop</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ListSpByShop at " + request.getContextPath () + "</h1>");
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
        DAO dao = new DAO();
        String id = request.getParameter("id");
        int shopID = Integer.parseInt(id);
        
        List<PhanLoai> listC = dao.getAllPhanLoai();
        List<Brand> listB = dao.getAllBrand();
        String index = request.getParameter("index");
        if (index == null) {
            index = "1";
        }
        int indexPage = Integer.parseInt(index);
        
        List<SanPham> listSpByShop = dao.listSpByShop(shopID, indexPage);
        int allProduct = dao.getNumberSpByShop(shopID);
        
        int endPage = allProduct / 12;
        if (allProduct % 12 != 0) {
            endPage++;
        }

        List<SanPham> listNew = dao.getProductNew();
        List<SanPham> listSale = dao.getProductSale();
        List<SanPham> listOutOfStock = dao.getProductOutOfStock();
        List<Star> listStarOfProduct = dao.getStarOfProduct();
        List<Color> listColor = dao.getProductColor();
        request.setAttribute("shopId", id);
        request.setAttribute("listColor", listColor);
        request.setAttribute("tag", indexPage);
        request.setAttribute("endPage", endPage);
        request.setAttribute("listC", listC);
        request.setAttribute("listB", listB);
        request.setAttribute("listP", listSpByShop);
        request.setAttribute("listN", listNew);
        request.setAttribute("listS", listSale);
        request.setAttribute("listO", listOutOfStock);
        request.setAttribute("star", listStarOfProduct);
        request.getRequestDispatcher("ProductShop.jsp").forward(request, response);

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
