/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;


import dal.DAO;
import model.Account;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.Properties;
import java.util.Random;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
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
        System.out.println(hashedPassword);

        // Tạo JavaBean Account
        Account account = new Account();
        account.setUser(user);
        account.setPass(hashedPassword);
        account.setEmail(email);
        account.setPhonenumber(phonenumber);
        account.setGender(gender);
        account.setAddress(address);

        DAO register = new DAO();
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
                    // Gửi OTP qua email
                    sendOTP(email);
                    // Dang ky thanh cong, chuyen den trang dang nhap
                    register.RegisterCustomer(user, hashedPassword, email, phonenumber, address, gender);                  
                    response.sendRedirect("login.jsp");
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

    //  sending OTP email
    private void sendOTP(String email) {
        int otpvalue = generateOTP();

        // Cấu hình thông tin máy chủ SMTP
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        // Tạo phiên làm việc với máy chủ email
        Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("minhnnhe176468@fpt.edu.vn", "yelyxtmjzielgrwu"); // Thay thế bằng email và mật khẩu của bạn
            }
        });

        // Soạn nội dung email
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(email)); // Điều chỉnh theo địa chỉ email người dùng
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
            message.setSubject("Xác nhận đăng ký");
            message.setText("Mã OTP của bạn là: " + otpvalue);

            // Gửi email
            Transport.send(message);
            System.out.println("Gửi email thành công");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    //  generating random OTP
    private int generateOTP() {
        Random rand = new Random();
        return rand.nextInt(999999);
    }

}
