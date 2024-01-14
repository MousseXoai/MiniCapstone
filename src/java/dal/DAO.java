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
        String sql = "SELECT [uID]\n"
                + "      ,[user]\n"
                + "      ,[pass]\n"
                + "      ,[email]\n"
                + "      ,[isSell]\n"
                + "      ,[isAdmin]\n"
                + "      ,[isCheck]\n"
                + "      ,[isShip]\n"
                + "  FROM [dbo].[Account]"
                + "  WHERE user = ? and pass = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, u);
            st.setString(2, p);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
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
        String sql = "INSERT INTO [dbo].[Account]\n"
                + "           ([user]\n"
                + "           ,[pass]\n"
                + "           ,[email]\n"
                + "           ,[isSell]\n"
                + "           ,[isAdmin]\n"
                + "           ,[isCheck]\n"
                + "           ,[isShip])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,0\n"
                + "           ,0\n"
                + "           ,0\n"
                + "           ,0)";
        try{
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, user.given_name);
            st.setString(2, user.id);
            st.setString(3, user.email);
            ResultSet rs = st.executeQuery();
        } catch(SQLException e){
            System.out.println("addGoogleAccount: " + e.getMessage());
        }
    }

}
