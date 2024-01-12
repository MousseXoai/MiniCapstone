/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Account;

/**
 *
 * @author Admin
 */
public class DAO extends DBContext{
    PreparedStatement ps = null;
    ResultSet rs = null;

    public Account check(String u, String p) {
        String sql = "SELECT [Id]\n"
                + "      ,[Name]\n"
                + "      ,[Address]\n"
                + "      ,[Phone]\n"
                + "      ,[Username]\n"
                + "      ,[Password]\n"
                + "      ,[role]\n"
                + "  FROM [dbo].[Users]"
                + "  WHERE Username = ? and Password = ?";
//        try {
////            PreparedStatement st = connection.prepareStatement(sql);
////            st.setString(1, u);
////            st.setString(2, p);
////            ResultSet rs = st.executeQuery();
////            if (rs.next()) {
////                Account a = new Account(rs.getInt(1)
////                                    ,rs.getString(2)
////                                    , rs.getString(3) 
////                                    ,rs.getString(4)
////                                    ,rs.getString(5)
////                                    ,rs.getString(6)
////                                    ,rs.getString(7));
////                return a;
////            }
//        } catch (SQLException e) {
//            
//        }
        return null;
    }
    
}
