/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Account;
import model.UserGoogleDto;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author Admin
 */
public class DAO extends DBContext {

    PreparedStatement ps = null;
    ResultSet rs = null;
    
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

    public void addGoogleAccount(UserGoogleDto user) {
        
        String sql = "INSERT INTO [dbo].[Account]\n"
                + "           ([user]\n"
                + "           ,[pass]\n"
                + "           ,[email]\n"
                + "           ,[isSell]\n"
                + "           ,[isAdmin]\n"
                + "           ,[isCheck]\n"
                + "           ,[isShip])\n"
                + "     VALUES\n"
                + "           (?,?,?,0,0,0,0)";
        try{
            ps = connection.prepareStatement(sql);
            ps.setString(1, user.getName());
            ps.setString(2, user.getId());
            ps.setString(3, user.getEmail());
            ps.executeUpdate();
        } catch(SQLException e){
            System.out.println("addGoogleAccount: " + e.getMessage());
        }
    }
    public int resetPassword(String nPass,String email) {
        int rowCount=0;
        try {
            String strSQL = "update Account set pass = ? where email=?";
            PreparedStatement st = connection.prepareStatement(strSQL);
            st.setString(1, nPass);
            st.setString(2, email);
            rowCount = st.executeUpdate();
            
        } catch (Exception e) {
            System.out.println("resetPassword:" + e.getMessage());
        }
        return rowCount;
    }

    public void addFacebookAccount(Account a) {
        String sql = "INSERT INTO [dbo].[Account]\n"
                + "           ([user]\n"
                + "           ,[pass]\n"
                + "           ,[email]\n"
                + "           ,[isSell]\n"
                + "           ,[isAdmin]\n"
                + "           ,[isCheck]\n"
                + "           ,[isShip])\n"
                + "     VALUES\n"
                + "           (?,?,?,0,0,0,0)";
        try{
            ps = connection.prepareStatement(sql);
            ps.setString(1, a.getUser());
            ps.setString(2, a.getPass());
            ps.setString(3, a.getEmail());
            ps.executeUpdate();
        } catch(SQLException e){
            System.out.println("addFacebookAccount: " + e.getMessage());
        }
    }

    
}
