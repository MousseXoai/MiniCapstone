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

        String sql = "  SELECT	a.[uID],\n"
                + "                a.[user],\n"
                + "                a.[pass],\n"
                + "               a.[isSell],\n"
                + "               a.[isAdmin],\n"
                + "               a.[isCheck],\n"
                + "               a.[isShip],\n"
                + "               ac.[email]\n"
                + "               FROM [dbo].[Account] a\n"
                + "               JOIN AccInfo ac on a.[uID] = ac.[uID]\n"
                + "               WHERE [user] = ? ";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, u);

            rs = ps.executeQuery();
            while (rs.next()) {

                Account a = new Account();
                a.setuID(rs.getInt("uID"));
                a.setUser(rs.getString("user"));
                a.setPass(rs.getString("pass"));
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
                + "           ,[isSell]\n"
                + "           ,[isAdmin]\n"
                + "           ,[isCheck]\n"
                + "           ,[isShip])\n"
                + "     VALUES\n"
                + "           (?,?,0,0,0,0)";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, user.getName());
            ps.setString(2, user.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("addGoogleAccount: " + e.getMessage());
        }
    }
    public int getUidByName(Account a) {
        int id = 0;
        String sql = "SELECT  [uID]\n"
                + "FROM [dbo].[Account] \n"
                + "WHERE [user] = ?  ";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, a.getUser());
            rs = ps.executeQuery();
            while (rs.next()) {
                id = rs.getInt("uID");
            }
        } catch (Exception e) {
            System.out.println("getUidByName: " + e.getMessage());
        }
        return id;
    }
    public int getUidByUserName(UserGoogleDto user) {
        int id = 0;
        String sql = "SELECT  [uID]\n"
                + "FROM [dbo].[Account] \n"
                + "WHERE [user] = ?  ";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, user.getName());
            rs = ps.executeQuery();
            while (rs.next()) {
                id = rs.getInt("uID");
            }
        } catch (Exception e) {
            System.out.println("getUidByUserName: " + e.getMessage());
        }
        return id;
    }

    public int resetPassword(String nPass, int uID) {
        int rowCount = 0;
        try {
            String strSQL = "update Account set pass = ? where [uID]=?";
            ps = connection.prepareStatement(strSQL);
            ps.setString(1, nPass);
            ps.setInt(2, uID);
            rowCount = ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("resetPassword:" + e.getMessage());
        }
        return rowCount;
    }

    public int getAccountByEmail(String email) {
        int id = 0;
        String sql = "SELECT  a.[uID]\n"
                + "FROM [dbo].[Account] a\n"
                + "JOIN AccInfo ac on a.[uID] = ac.[uID]\n"
                + "WHERE ac.[email] = ? ";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, email);
            rs = ps.executeQuery();
            while (rs.next()) {
                id = rs.getInt("uID");
            }
        } catch (Exception e) {
            System.out.println("getAccountByEmail: " + e.getMessage());
        }
        return id;
    }

    public void addFacebookAccount(Account a) {
        String sql = "INSERT INTO [dbo].[Account]\n"
                + "           ([user]\n"
                + "           ,[pass]\n"
                + "           ,[isSell]\n"
                + "           ,[isAdmin]\n"
                + "           ,[isCheck]\n"
                + "           ,[isShip])\n"
                + "     VALUES\n"
                + "           (?,?,0,0,0,0)";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, a.getUser());
            ps.setString(2, a.getPass());

            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("addFacebookAccount: " + e.getMessage());
        }
    }

    public void addEmailByUid(String email,int id) {
        String strSQL = "insert into AccInfo (uID,email) values(?,?)";
        try{
        ps = connection.prepareStatement(strSQL);
        ps.setInt(1, id);
        ps.setString(2, email);
        ps.executeUpdate();
        } catch(Exception e) {
            System.out.println("addEmailByUid: " + e.getMessage());
        }
    }

}
