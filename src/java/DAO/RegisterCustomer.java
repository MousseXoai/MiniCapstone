/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;


import dal.DBContext;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 *
 * @author dell
 */
public class RegisterCustomer extends DBContext{
    
    
public void RegisterCustomer(String user, String pass, String email,String phonenumber,String address,String gender) {
    
    String sql = "INSERT INTO Account([user], pass, isSell, isAdmin, isCheck, email,phonenumber,[address],gender)\n" 
            +   "VALUES (?, ?, 0, 0, 0, ?, ?, ?, ?)";
    try {
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, user);
        ps.setString(2, pass);
        ps.setString(3, email);
        ps.setString(4, phonenumber);
        ps.setString(5, address);
        ps.setString(6, gender);
        
        System.out.println(sql);
        ps.executeUpdate();
           

        
        
    } catch (Exception e) {
        System.out.println(e);
    }
    
}

   
       public int checkUsername(String user) {
        int exist = 0;
        String sql = "select * from  Account\n" +
                     "where [user] like ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, "%" + user + "%");
                
            System.out.println(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                exist = 1;
            }
            ps.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return exist;
    }
       

    public static void main(String[] args) {
        // Tạo đối tượng RegisterCustomer
        RegisterCustomer registerCustomer = new RegisterCustomer();

        // Test phương thức RegisterCustomer
        registerCustomer.RegisterCustomer("testUser", "testPass", "testmail","testphone", "testAddress","male");
        System.out.println("Register Successfully");

        // Test phương thức checkUsername
        int usernameCheckResult = registerCustomer.checkUsername("testUser");
        System.out.println("Username Check Result: " + usernameCheckResult);
    }
}

   
 

   


 


