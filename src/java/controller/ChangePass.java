package controller;


import dal.DAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Account;
import org.mindrot.jbcrypt.BCrypt;

@WebServlet(name = "ChangePassServlet", urlPatterns = {"/ChangePassServlet"})
public class ChangePass extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    
  

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        String user = request.getParameter("user");
        String oldPass = request.getParameter("oldPass"); // old
        String newPass = request.getParameter("pass"); // new

        
        
        DAO cp = new DAO();

        Account account = cp.check(user);

        if (account == null || !BCrypt.checkpw(oldPass, account.getPass().trim())) {
            // Sai pass
            String errorMessage = "Mật khẩu cũ không chính xác!";
            request.setAttribute("errorMessage", errorMessage);
            request.getRequestDispatcher("ChangePass.jsp").forward(request, response);
        } else {
            // Đúng pass
            // Mã hóa mật khẩu mới trước khi cập nhật
            String hashedNewPass = BCrypt.hashpw(newPass, BCrypt.gensalt());
            account.setUser(user);
            account.setPass(hashedNewPass);
            
            System.out.println(hashedNewPass);
                   
            System.out.println("Password updated successfully for user: " + user);
               
            // Cập nhật mật khẩu mới vào database
            cp.change(account);
            
            System.out.println(account.getPass());
            

            HttpSession session = request.getSession();
            session.setAttribute("account", account);
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
