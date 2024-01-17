/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.SanPham;

/**
 *
 * @author dell
 */
public class ProductDAO extends dal.DBContext {

    PreparedStatement ps;
    ResultSet rs;

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
            System.out.println("getWishListSpByAccount" + e.getMessage());
        }
        return list;
    }
}
