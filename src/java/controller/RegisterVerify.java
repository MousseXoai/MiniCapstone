package controller;

import dal.DAO;
import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Account;
import org.mindrot.jbcrypt.BCrypt;

/**
 * Servlet implementation class ValidateOtp
 */
public class RegisterVerify extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        String user = ((String) session.getAttribute("user")).trim();
        String pass = ((String) session.getAttribute("pass")).trim();
        String email = ((String) session.getAttribute("email")).trim();
        String phonenumber = ((String) session.getAttribute("phonenumber")).trim();
        String address = ((String) session.getAttribute("address")).trim();

        // Hash mật khẩu
        String hashedPassword = BCrypt.hashpw(pass, BCrypt.gensalt());
        System.out.println(hashedPassword);

        // Tạo JavaBean Account
        Account account = new Account();
        account.setUser(user);
        account.setPass(hashedPassword);

        DAO register = new DAO();

        int value;
        try {
            value = Integer.parseInt(request.getParameter("otp"));
        } catch (NumberFormatException e) {
             String errorMessage = "Invalid OTP format.";
                request.setAttribute("errorMessage", errorMessage);
                request.getRequestDispatcher("VerifyEmail.jsp").forward(request, response);
            return;
        }

        int otp = (int) session.getAttribute("otp");

        RequestDispatcher dispatcher = null;
        if (value == otp) {
            request.setAttribute("email", request.getParameter("email"));

            register.RegisterCustomer(user, hashedPassword);
            int uID = register.getIDByUsername(account);
            System.out.println(uID);
            register.addbyAccinfo(email, address, phonenumber, uID);

            request.setAttribute("status", "success");
            dispatcher = request.getRequestDispatcher("login.jsp");
            dispatcher.forward(request, response);

        } else {
            request.setAttribute("message", "wrong otp");
            dispatcher = request.getRequestDispatcher("VerifyEmail.jsp");
            dispatcher.forward(request, response);

        }

    }

}
