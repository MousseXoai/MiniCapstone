package DAO;

import java.util.Properties;
import java.util.Random;
import javax.mail.*;
import javax.mail.internet.*;
import model.Account;

public class SendEmail {
    public String getRandom() {
        Random random = new Random();
        int number = random.nextInt(999999);
        return String.format("%06d", number);
    }

    public boolean sendEmail(Account account) {
        boolean test = false;
        
        String toEmail = account.getEmail();
        String fromEmail = System.getenv("EMAIL_USERNAME"); 
        String pass = System.getenv("EMAIL_PASSWORD"); 
        

        // Thiết lập thông tin máy chủ email (SMTP)
        String host = "smtp.gmail.com"; // Đổi nếu bạn sử dụng máy chủ email khác
        String port = "587";

        // Thiết lập các thuộc tính
        Properties properties = new Properties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true"); 

        // Tạo session
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, pass);
            }
        });

        try {
            // Tạo đối tượng MimeMessage
            Message message = new MimeMessage(session);

            // Thiết lập thông tin người gửi, người nhận, chủ đề và nội dung email
            message.setFrom(new InternetAddress(fromEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            message.setSubject("Subject of the email");
            message.setText("Your confirmation code is: " + getRandom());

            // Gửi email
            Transport.send(message);

            System.out.println("Email sent successfully!");
            test = true;

        } catch (MessagingException e) {
            e.printStackTrace();
        }

        return test;
    }
}
