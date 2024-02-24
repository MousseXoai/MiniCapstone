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
import model.HoaDon;
import model.InfoLine;
import model.OrderLine;
import model.SanPham;

/**
 *
 * @author Tosaka
 */
public class CustomerThankYouControll extends HttpServlet {

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
            out.println("<title>Servlet CustomerThankYouControll</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CustomerThankYouControll at " + request.getContextPath() + "</h1>");
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
                int accountID = a.getuID();
                String maHoaDonTo = (String) session.getAttribute("checkMaHoaDonTo");
                String maThanhToanTrucTiep = (String) session.getAttribute("checkMaThanhToanTrucTiep");
                if (!maHoaDonTo.equals("none")){
                    ArrayList<HoaDon> listHoaDon = dao.getHoaDonByMaHoaDonTo(Integer.parseInt(maHoaDonTo),accountID);                   
                    ArrayList<OrderLine> listOrderLine = dao.getAllOrderLine();
                    ArrayList<SanPham> listSP = dao.getAllProduct();
                    HoaDon hd = dao.get1HoaDonto(Integer.parseInt(maHoaDonTo), accountID);
                    InfoLine infoLine = dao.getInfoLineBill(hd.getMaHD());
                    request.setAttribute("listHoaDon", listHoaDon);  
                    request.setAttribute("listOrderLine", listOrderLine);  
                    request.setAttribute("listsanpham", listSP);
                    request.setAttribute("hd", hd);
                    request.setAttribute("infoLine", infoLine);
                    session.removeAttribute("maHoaDonTo");
                    session.removeAttribute("maThanhToanTrucTiep");                    
                    request.getRequestDispatcher("thankyou.jsp").forward(request, response);
                }
                if(!maThanhToanTrucTiep.equals("none")){
                    ArrayList<HoaDon> listHoaDon = dao.getHoaDonByMaHoaDonCOD(Integer.parseInt(maThanhToanTrucTiep),accountID);
                    ArrayList<OrderLine> listOrderLine = dao.getAllOrderLine();
                    ArrayList<SanPham> listSP = dao.getAllProduct();
                    HoaDon hd = dao.get1HoaDonThanhToanTT(Integer.parseInt(maThanhToanTrucTiep), accountID);
                    InfoLine infoLine = dao.getInfoLineBill(hd.getMaHD());
                    request.setAttribute("listHoaDon", listHoaDon);  
                    request.setAttribute("listOrderLine", listOrderLine);  
                    request.setAttribute("listsanpham", listSP);
                    request.setAttribute("hd", hd);
                    request.setAttribute("infoLine", infoLine);
                    session.removeAttribute("maHoaDonTo");
                    session.removeAttribute("maThanhToanTrucTiep");  
                    request.getRequestDispatcher("thankyou.jsp").forward(request, response);
                }
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
        processRequest(request, response);
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
