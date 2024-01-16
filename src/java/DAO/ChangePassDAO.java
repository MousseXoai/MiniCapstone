/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import dal.DBContext;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Account;

/**
 *
 * @author dell
 */
public class ChangePassDAO extends DBContext {

    public Account check(String user, String pass) {
        String sql = "SELECT * FROM Account WHERE [user] = ? AND pass = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Account(user, pass);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public void change(Account account) {
        String sql = "update Account set pass = ? Where [user] = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, account.getUser());
            ps.setString(2, account.getPass());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

}
