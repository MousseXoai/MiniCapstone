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

/**
 *
 * @author Admin
 */
public class DAO extends DBContext {

    PreparedStatement ps = null;
    ResultSet rs = null;

    public Account check(String u, String p) {
        String sql = "SELECT [uID]\n "
                + "      ,[user]\n "
                + "      ,[pass]\n "
                + "      ,[email]\n "
                + "      ,[isSell]\n "
                + "      ,[isAdmin]\n "
                + "      ,[isCheck]\n "
                + "      ,[isShip]\n "
                + "  FROM [dbo].[Account]"
                + "  WHERE [user] = ? and [pass] = ?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, u);
            ps.setString(2, p);
            rs = ps.executeQuery();
            while (rs.next()) {
                Account a = new Account(rs.getInt(1),
                         rs.getString(2),
                         rs.getString(3),
                         rs.getString(4),
                         rs.getInt(5),
                         rs.getInt(6),
                         rs.getInt(7),
                         rs.getInt(8));
                
                return a;
            }
        } catch (SQLException e) {
            System.out.println("check: " + e.getMessage());
        }
        return null;
    }

    public void addGoogleAccount(UserGoogleDto user) {
        MD5 md = new MD5();
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
            System.out.println(user.getName());
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
            System.out.println("getListQuestion:" + e.getMessage());
        }
        return rowCount;
    }
}
