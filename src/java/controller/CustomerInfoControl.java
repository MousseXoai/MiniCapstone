/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
<<<<<<< HEAD
=======

>>>>>>> a80a1c7044ea43e7e03095598d85b43400a78274
package controller;

import dal.DAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.AccInfo;

/**
 *
 * @author Tosaka
 */
public class CustomerInfoControl extends HttpServlet {
<<<<<<< HEAD

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
=======
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
>>>>>>> a80a1c7044ea43e7e03095598d85b43400a78274
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
<<<<<<< HEAD
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
=======
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
>>>>>>> a80a1c7044ea43e7e03095598d85b43400a78274
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
<<<<<<< HEAD
            out.println("<title>Servlet CustomerInfoControl</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CustomerInfoControl at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
=======
            out.println("<title>Servlet CustomerInfoControl</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CustomerInfoControl at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
>>>>>>> a80a1c7044ea43e7e03095598d85b43400a78274
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
<<<<<<< HEAD
            throws ServletException, IOException {
=======
    throws ServletException, IOException {
>>>>>>> a80a1c7044ea43e7e03095598d85b43400a78274
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            DAO dao = new DAO();
            AccInfo acc = dao.getAccInfo(2);
            request.setAttribute("acc", acc);
            request.getRequestDispatcher("UserProfile.jsp").forward(request, response);

        }
<<<<<<< HEAD
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
=======
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
>>>>>>> a80a1c7044ea43e7e03095598d85b43400a78274
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
<<<<<<< HEAD
            throws ServletException, IOException {
=======
    throws ServletException, IOException {
>>>>>>> a80a1c7044ea43e7e03095598d85b43400a78274
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            String fullname = request.getParameter("fullname").replaceAll("\\s+", " ").trim();
            String address = request.getParameter("address").replaceAll("\\s+", " ").trim();
            String phonenum = request.getParameter("phonenum").replaceAll("\\s", "").trim();
            String email = request.getParameter("email").replaceAll("\\s", "").trim();

            String err = "";

            DAO dao = new DAO();

            if (fullname.isEmpty() || address.isEmpty() || phonenum.isEmpty() || email.isEmpty()) {
                err = getServletContext().getInitParameter("messErrorEditProfileCustomer");
            } else if (!fullname.matches("[\\p{L}\\s]+")) {
                err = getServletContext().getInitParameter("messErrorInvalidName");
            } else if (phonenum.length() > 10 || !phonenum.matches("\\d+")) {
                err = getServletContext().getInitParameter("messErrorPhoneNum");
            } else if (!email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")) {
                err = getServletContext().getInitParameter("messErrorInvalidEmail");
            } else if (fullname.length() > 50 || email.length() > 50) {
                err = getServletContext().getInitParameter("messErrorNameAndEmail");
            }

            if (!err.isEmpty()) {
                AccInfo acc = dao.getAccInfo(2);
                request.setAttribute("acc", acc);
                request.setAttribute("err", err);
                request.getRequestDispatcher("UserProfile.jsp").forward(request, response);
            } else {            
                dao.editAccInfo(fullname, address, phonenum, email, 2);
                response.sendRedirect("customerinfo");
            }
        }
    }

<<<<<<< HEAD
    /**
     * Returns a short description of the servlet.
     *
=======
    /** 
     * Returns a short description of the servlet.
>>>>>>> a80a1c7044ea43e7e03095598d85b43400a78274
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
