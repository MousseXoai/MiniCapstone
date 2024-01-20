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
import model.SanPham;
import model.Star;

/**
 *
 * @author Admin
 */
public class HomeControl extends HttpServlet {
   
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
        int countLaptop = dao.countAllLaptop();
        int countDongHo = dao.countAllDongHo();
        int countBanPhim = dao.countAllBanPhim();
        int countChuot = dao.countAllChuot();
        int countTaiNghe = dao.countAllTaiNghe();
        List<SanPham> listNew = dao.getProductNew();
        List<SanPham> listSale = dao.getProductSale();
        List<SanPham> listOutOfStock = dao.getProductOutOfStock();
        List<Star> listStarOfProduct= dao.getStarOfProduct();
        List<SanPham> list = dao.getTop7NewProduct();
        List<SanPham> listBestSeller = dao.getBestSellerProduct();
        
        request.setAttribute("laptop", countLaptop);
        request.setAttribute("dongho", countDongHo);
        request.setAttribute("banphim", countBanPhim);
        request.setAttribute("chuot", countChuot);
        request.setAttribute("tainghe", countTaiNghe);
        request.setAttribute("listP", list);
        request.setAttribute("listN", listNew);
        request.setAttribute("listS", listSale);
        request.setAttribute("listO", listOutOfStock);
        request.setAttribute("star", listStarOfProduct);
        request.setAttribute("listBest", listBestSeller);
        request.getRequestDispatcher("HomePage.jsp").forward(request, response);
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
