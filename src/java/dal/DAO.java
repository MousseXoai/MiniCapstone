/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Account;
import model.PhanLoai;
import model.SanPham;

/**
 *
 * @author dell
 */
public class DAO extends DBContext{
     PreparedStatement ps = null;
    ResultSet rs = null;
    //dky tai khoan 
    public void RegisterCustomer(String user, String pass, String email,String phonenumber,String address,String gender) {
  
    String sql = "INSERT INTO Account([user], pass, isSell, isAdmin, isCheck, email,phonenumber,[address],gender)\n" 
            +   "VALUES (?, ?, 0, 0, 0, ?, ?, ?, ?)";
    try {
        ps = connection.prepareStatement(sql);
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

   //check user ton tai
       public int checkUsername(String user) {
        int exist = 0;
        String sql = "select * from  Account\n" +
                     "where [user] like ?";
        try {
            ps = connection.prepareStatement(sql);
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
       
    //check Account ton tai   
        public Account check(String user, String pass) {
        String sql = "SELECT * FROM Account WHERE [user] = ? AND pass = ?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, pass);
             rs = ps.executeQuery();
            if (rs.next()) {
                return new Account(user, pass);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
        
    // update mk moi
    public void change(Account account) {
        String sql = "update Account set pass = ? Where [user] = ?";
        try {
             ps = connection.prepareStatement(sql);
            ps.setString(1, account.getUser());
            ps.setString(2, account.getPass());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    //list cate
     public List<PhanLoai> getAllCate() {
        List<PhanLoai> listCate  = new ArrayList<>();
        String query = "SELECT * FROM PhanLoai";
        try{
            System.out.println("No co vao day");
            System.out.println(connection.prepareStatement(query));
            ps = connection.prepareStatement(query);
            System.out.println("ket noi thanh cong");
             rs = ps.executeQuery();
            System.out.println(rs);
            while(rs.next()){
                listCate.add(new PhanLoai(rs.getInt(1), rs.getString(2)));
            }
            ps.close();
            rs.close();
        }catch(Exception e){
            System.out.println(e);
        }
        return listCate;
    }
     
     // list product
      public List<SanPham> TopProductNew() {
        List<SanPham> list = new ArrayList<>();
        String query = "SELECT TOP 8 [id], [name], [image], [price] FROM SanPham ORDER BY id DESC ";
        try {
            ps = connection.prepareStatement(query);
          
            rs = ps.executeQuery();
            while (rs.next()) {
                SanPham p = new SanPham();
                rs.getInt(1);
                rs.getString(2);
                rs.getString(3);
                rs.getDouble(4);
            list.add(p);
         
            }
        } catch (SQLException e) {
            System.out.println("TopProductNew" + e.getMessage());
        }
        return list;
    }
      
       public Account check(String u) {
        
        String sql = "SELECT [uID]\n "
                + "      ,[user]\n "
                + "      ,[pass]\n "
                + "      ,[email]\n "
                + "      ,[isSell]\n "
                + "      ,[isAdmin]\n "
                + "      ,[isCheck]\n "
                + "      ,[isShip]\n "
                + "  FROM [dbo].[Account]"
                + "  WHERE [user] = ? ";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, u);
                     
            rs = ps.executeQuery();
            while (rs.next()) {
                
                Account a = new Account();
                a.setuID(rs.getInt("uID"));
                a.setUser(rs.getString("user"));
                a.setPass(rs.getString("pass"));
                a.setEmail(rs.getString("email"));
                a.setIsSell(rs.getInt("isSell"));
                a.setIsAdmin(rs.getInt("isAdmin"));
                a.setIsCheck(rs.getInt("isCheck"));
                a.setIsShip(rs.getInt("isShip"));
                return a;
            }
        } catch (SQLException e) {
            System.out.println("check: " + e.getMessage());
        }
        return null;
}
}
