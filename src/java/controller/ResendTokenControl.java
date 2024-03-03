package controller;

import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import jakarta.servlet.ServletException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


public class ResendTokenControl extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String email = (String) session.getAttribute("email");
        System.out.println("Email: " + email);
        if (email != null && !email.isEmpty()) {
            int otp = sendOTP(email);
            
            session.setAttribute("otp", otp);
            session.setAttribute("email", email);
            request.setAttribute("message", "OTP has been resent to your email");
            request.getRequestDispatcher("VerifyEmail.jsp").forward(request, response);
        } else {
            response.sendRedirect("HomePage.jsp"); // Chuyển hướng về trang chủ nếu không có email
        }
    }

    // Phương thức để gửi mã OTP qua email
    private int sendOTP(String email) {
        int otpValue = generateOTP();

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
            message.setText("Mã OTP của bạn là: " + otpValue);

            // Gửi email
            Transport.send(message);
            System.out.println("Gửi email thành công");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

        return otpValue;
    }

    // Phương thức để tạo mã OTP ngẫu nhiên
    private int generateOTP() {
        Random rand = new Random();
        return rand.nextInt(999999);
    }
}
