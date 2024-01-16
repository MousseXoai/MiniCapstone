/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import DAO.RegisterCustomer;
import model.Account;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author dell
 */
public class RegisterCustomerController extends HttpServlet {
   


    private static final long serialVersionUID = 1L;

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
            out.println("<title>Servlet RegisterCustomerController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RegisterCustomerController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Lay du lieu tu form dang ky
        String user = request.getParameter("user");
        String pass = request.getParameter("pass");
        String email = request.getParameter("email");
        String re_pass = request.getParameter("repass");
        String phonenumber = request.getParameter("phonenumber");
        String address = request.getParameter("address");
        String gender = request.getParameter("gender");
        
        

        // Kiểm tra mật khẩu và mật khẩu xác nhận
        if (!pass.equals(re_pass)) {
            // Xu ly khi mật khẩu và mật khẩu xác nhận không khớp
            String errorMessage = "Mật khẩu và mật khẩu xác nhận không khớp. Vui lòng nhập lại.";
            request.setAttribute("errorMessage", errorMessage);
            request.getRequestDispatcher("Register.jsp").forward(request, response);
            return; // Kết thúc phương thức để ngăn chặn tiếp tục đăng ký
        }

        // Kiểm tra độ dài của phonenumber 
        if (phonenumber.length() > 10) {
            String errorMessage = "Số điện thoại không được quá 10 ký tự.";
            request.setAttribute("errorMessage", errorMessage);
            request.getRequestDispatcher("Register.jsp").forward(request, response);
            return; // Kết thúc phương thức để ngăn chặn tiếp tục đăng ký
        }
        // Kiểm tra độ dài của address 
        if (address.length() > 50) {
            String errorMessage = "Địa chỉ không được quá 50 ký tự.";
            request.setAttribute("errorMessage", errorMessage);
            request.getRequestDispatcher("Register.jsp").forward(request, response);
            return; // Kết thúc phương thức để ngăn chặn tiếp tục đăng ký
        }

        // Hash mật khẩu
        String hashedPassword = BCrypt.hashpw(pass, BCrypt.gensalt());



        // Tạo JavaBean Account
        Account account = new Account();
        account.setUser(user);
        account.setPass(hashedPassword);
        account.setEmail(email);
        account.setPhonenumber(phonenumber);
        account.setGender(gender);
        account.setAddress(address);

        RegisterCustomer register = new RegisterCustomer();

        try {
            int usernameCheckResult = register.checkUsername(user);

            // Kiểm tra tài khoản đã tồn tại hay chưa
            if (usernameCheckResult == 1) {
                String errorMessage = "Tên đăng nhập đã được sử dụng. Vui lòng chọn tên đăng nhập khác.";
                request.setAttribute("errorMessage", errorMessage);
                request.getRequestDispatcher("Register.jsp").forward(request, response);
            } else {
                // Đăng ký tài khoản
                if (usernameCheckResult == 0) {
                    // Dang ky thanh cong, chuyen den trang dang nhap
                    register.RegisterCustomer(user, pass, email, phonenumber, address, gender);
                    response.sendRedirect("HomePage.jsp");
                } else {
                    // Xu ly khi tai khoan dang ky khong thanh cong
                    String errorMessage = "Đã có lỗi xảy ra trong quá trình đăng ký. Vui lòng thử lại sau.";
                    request.setAttribute("errorMessage", errorMessage);
                    request.getRequestDispatcher("Register.jsp").forward(request, response);
                }
            }
        } catch (Exception e) {
            // Xu ly ngoai le hoac loi co so du lieu
            e.printStackTrace(); // In stack trace ra log
            String errorMessage = "Đã có lỗi xảy ra trong quá trình xử lý. Vui lòng thử lại sau.";
            request.setAttribute("errorMessage", errorMessage);
                request.getRequestDispatcher("Register.jsp").forward(request, response);
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
