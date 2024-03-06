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
import java.util.List;
import model.Account;
import model.Brand;
import model.PhanLoai;
import model.SanPham;

/**
 *
 * @author admin
 */
@WebServlet(name = "AddProductControl", urlPatterns = {"/addproduct"})
@MultipartConfig(maxFileSize = 16177216)//1.5mb
public class AddProductControl extends HttpServlet {
   
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
        if (a == null || a.getIsSell()!=1) {
            response.sendRedirect("login.jsp");
        } else {

            int accountID = a.getuID();
            int shopID = dao.getShopIdByAccountId(accountID);
            List<SanPham> getProduct = dao.getAllProductByShopID(shopID);
            request.setAttribute("getProduct", getProduct);
            List<PhanLoai> getCategory = dao.getCategoryByShopID(shopID);
            request.setAttribute("getCategory", getCategory);
            List<Brand> getBrand = dao.getBrandByShopID(shopID);
            request.setAttribute("getBrand", getBrand);
            request.getRequestDispatcher("AddProduct.jsp").forward(request, response);
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
        int shopID = dao.getShopIdByAccountId(accountID);
        String pname = request.getParameter("prd_name");
        Part image1 = request.getPart("prd_image1");
        double pprice = Double.parseDouble(request.getParameter("prd_price"));
        int pquantity = Integer.parseInt(request.getParameter("prd_quantity"));
        String ptitle = request.getParameter("prd_title");
        String pdescription = request.getParameter("prd_details");
        int pcateid = Integer.parseInt(request.getParameter("cat_id"));
        int pbrandid = Integer.parseInt(request.getParameter("bid"));
        String pcolor = request.getParameter("prd_color");
        Part image2 = request.getPart("prd_image2");
        Part image3 = request.getPart("prd_image3");
        Part image4 = request.getPart("prd_image4");
        dao.addProduct(pname, image1, pprice, pquantity, ptitle, pdescription, pcateid, pbrandid, pcolor, image2, image3, image4, shopID, 0, 0);
        response.sendRedirect("QuanLySanPhamControl");
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
