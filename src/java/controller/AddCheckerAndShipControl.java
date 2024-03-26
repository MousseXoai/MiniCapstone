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
import model.Account;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author dell
 */
public class AddCheckerAndShipControl extends HttpServlet {

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
       
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("1");
        String user = request.getParameter("username").trim();
        String pass = request.getParameter("pass").trim();
        String email = request.getParameter("email").trim();
        String re_pass = request.getParameter("repass").trim();
        String phonenumber = request.getParameter("phonenumber").trim();
        String address = request.getParameter("address").trim();
        int role = 0;

        String selectedRole = request.getParameter("role");
        System.out.println(user);
        System.out.println(pass);

        String hashedPassword = BCrypt.hashpw(pass, BCrypt.gensalt());
        // Kiểm tra khoảng trắng
        if (user.isEmpty() || pass.isEmpty() || email.isEmpty() || re_pass.isEmpty()
                || phonenumber.isEmpty() || address.isEmpty() || user.contains(" ")
                || pass.contains(" ") || email.contains(" ") || re_pass.contains(" ")
                || phonenumber.contains(" ") || address.contains(" ")) {
            String errorMessage = "Các trường không được chứa khoảng trắng.";
            request.setAttribute("errorMessage", errorMessage);
            request.getRequestDispatcher("Register.jsp").forward(request, response);
            return;
        }
        // Kiểm tra mật khẩu và mật khẩu xác nhận
        if (!pass.equals(re_pass)) {
            String errorMessage = "Mật khẩu và mật khẩu xác nhận không khớp. Vui lòng nhập lại.";
            request.setAttribute("errorMessage", errorMessage);
            request.getRequestDispatcher("AddCheckAndShip.jsp").forward(request, response);
            return;
        }
        if (user.length() > 20) {
            String errorMessage = "Tài khoản không được quá 20 ký tự.";
            request.setAttribute("errorMessage", errorMessage);
            request.getRequestDispatcher("AddCheckAndShip.jsp").forward(request, response);
            return;
        }
        if (pass.length() > 20) {
            String errorMessage = "Mật khẩu không được quá 20 ký tự.";
            request.setAttribute("errorMessage", errorMessage);
            request.getRequestDispatcher("AddCheckAndShip.jsp").forward(request, response);
            return;
        }
        System.out.println("Password: " + pass);
        System.out.println("First character is uppercase: " + Character.isUpperCase(pass.charAt(0)));
        System.out.println("Password matches regex: " + pass.matches("^[A-Za-z0-9!@#$%^&*()-=_+]+$"));
        if (pass.length() <= 8 || !(Character.isUpperCase(pass.charAt(0)) && pass.matches("^[A-Za-z0-9!@#$%^&*()-=_+]+$"))) {
            String errorMessage = "Mật khẩu phải bắt đầu bằng chữ cái in hoa, chứa ít nhất một chữ cái và tối đa 8 ký tự.";
            request.setAttribute("errorMessage", errorMessage);
            request.getRequestDispatcher("AddCheckAndShip.jsp").forward(request, response);
            return;
        }

        if (email.length() > 30) {
            String errorMessage = "Email không được quá 30 ký tự.";
            request.setAttribute("errorMessage", errorMessage);
            request.getRequestDispatcher("AddCheckAndShip.jsp").forward(request, response);
            return;
        }
        // Kiểm tra độ dài của phonenumber 
        if (phonenumber.length() > 10) {
            String errorMessage = "Số điện thoại không được quá 10 ký tự.";
            request.setAttribute("errorMessage", errorMessage);
            request.getRequestDispatcher("AddCheckAndShip.jsp").forward(request, response);
            return;
        }
        // Kiểm tra độ dài của address 
        if (address.length() > 50) {
            String errorMessage = "Địa chỉ không được quá 50 ký tự.";
            request.setAttribute("errorMessage", errorMessage);
            request.getRequestDispatcher("AddCheckAndShip.jsp").forward(request, response);
            return;
        }
        Account account = new Account();
        account.setUser(user);
        account.setPass(hashedPassword);

        DAO register = new DAO();
        if (selectedRole != null) {
            if (selectedRole.equals("isShip")) {
                account.setIsShip(1);
            }
            if (selectedRole.equals("isCheck")) {
                account.setIsCheck(1);
            }
        }
        try {
            int emailCheckResult = register.checkEmail(email);
            int usernameCheckResult = register.checkUsername(user);

            // Kiểm tra tài khoản đã tồn tại hay chưa
            if (usernameCheckResult == 1) {
                String errorMessage = "Tên đăng nhập đã được sử dụng. Vui lòng chọn tên đăng nhập khác.";
                request.setAttribute("errorMessage", errorMessage);
                request.getRequestDispatcher("AddCheckAndShip.jsp").forward(request, response);
            } else if (emailCheckResult == 1) {
                String errorMessage = "Email đã được sử dụng. Vui lòng chọn tên đăng nhập khác.";
                request.setAttribute("errorMessage", errorMessage);
                request.getRequestDispatcher("AddCheckAndShip.jsp").forward(request, response);
            } else {
                // Đăng ký tài khoản
                if (usernameCheckResult == 0) {

                    register.RegisterCheckerAndShipper(account);
                    int uID = register.getIDByUsername(account);

                    register.addbyAccinfo(email, address, phonenumber, uID);

                    request.getRequestDispatcher("CheckAndShip").forward(request, response);

                } else {
                    // Xu ly khi tai khoan dang ky khong thanh cong
                    String errorMessage = "Đã có lỗi xảy ra trong quá trình đăng ký. Vui lòng thử lại sau.";
                    request.setAttribute("errorMessage", errorMessage);
                    request.getRequestDispatcher("AddCheckAndShip.jsp").forward(request, response);
                }

            }
        } catch (Exception e) {
            // Xu ly ngoai le hoac loi co so du lieu
            e.printStackTrace(); // In stack trace ra log
            String errorMessage = "Đã có lỗi xảy ra trong quá trình xử lý. Vui lòng thử lại sau.";
            request.setAttribute("errorMessage", errorMessage);
            request.getRequestDispatcher("AddCheckAndShip.jsp").forward(request, response);
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
