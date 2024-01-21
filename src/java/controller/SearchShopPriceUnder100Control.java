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
import java.util.List;
import model.Brand;
import model.Color;
import model.PhanLoai;
import model.SanPham;
import model.Star;

/**
 *
 * @author Admin
 */
public class SearchShopPriceUnder100Control extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String id= request.getParameter("id");
        int shopId= Integer.parseInt(id);
        DAO dao = new DAO();
         List<PhanLoai> listC = dao.getAllPhanLoai();
        List<Brand> listB = dao.getAllBrand();
        List<SanPham> list = dao.searchShopPriceUnder100(shopId);
         List<SanPham> listNew = dao.getProductNew();
        List<SanPham> listSale = dao.getProductSale();
        List<SanPham> listOutOfStock = dao.getProductOutOfStock();
        List<Star> listStarOfProduct= dao.getStarOfProduct();
        List<Color> listColor =dao.getProductColor();
        request.setAttribute("shopId", id);
        request.setAttribute("listColor", listColor);
        request.setAttribute("listC", listC);
        request.setAttribute("listB", listB);
        request.setAttribute("listP", list);
        request.setAttribute("listN", listNew);
        request.setAttribute("listS", listSale);
        request.setAttribute("listO", listOutOfStock);
        request.setAttribute("star", listStarOfProduct);
        request.getRequestDispatcher("ProductShop.jsp").forward(request, response);
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
