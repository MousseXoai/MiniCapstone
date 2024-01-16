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
import model.SanPham;
import model.Shop;
import model.WishList;

/**
 *
 * @author Admin
 */
public class DAO extends DBContext {

    PreparedStatement ps;
    ResultSet rs;

    public List<SanPham> getWishListSpByAccount() {
        List<SanPham> list = new ArrayList<>();
        String query = "Select [id]\n"
                + "      ,[name]\n"
                + "      ,[image]\n"
                + "      ,[price]\n"
                + "      ,[quantity]\n"
                + "      ,[title]\n"
                + "      ,[description]\n"
                + "      ,[cateID]\n"
                + "      ,[branID]\n"
                + "      ,[color]\n"
                + "      ,[image2]\n"
                + "      ,[image3]\n"
                + "      ,[image4]\n"
                + "      ,[shopid]\n"
                + "      ,[sale]\n"
                + "      ,[trangthai] from\n"
                + "                               SanPham sp join WishList wl on sp.id = wl.productID\n"
                + "                           join Account a on wl.accountID= a.uID where a.uID=2";
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new SanPham(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getInt(8),
                        rs.getInt(9),
                        rs.getString(10),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13),
                        rs.getInt(14),
                        rs.getInt(15),
                        rs.getInt(16)
                ));
            }
        } catch (SQLException e) {
            System.out.println("getWishListSpByAccount" + e.getMessage());
        }
        return list;
    }

    public int getNumberWlByAcc() {
        int m = 0;
        String strSQL = "SELECT COUNT (productID) as n \n"
                + "FROM WishList  \n"
                + "WHERE accountID=2; ";
        try {
            ps = connection.prepareStatement(strSQL);
            rs = ps.executeQuery();
            if (rs.next()) {
                m = rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println("getNumberWl " + e.getMessage());
        }
        return m;
    }

    public void deleteByMaWl(String id) {
        String query = "DELETE FROM [dbo].[WishList]\n"
                + "      WHERE maWishList=?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("deleteByMaWl" + e.getMessage());
        }
    }

    public List<WishList> getWishListSpByAcc() {
        List<WishList> list = new ArrayList<>();
        String query = "select* from WishList where accountID=2";
        try {

            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new WishList(rs.getInt(1), rs.getInt(2), rs.getInt(3)));
            }
        } catch (SQLException e) {
            System.out.println("getWishListSpByAcc" + e.getMessage());
        }
        return list;
    }

    public Shop getShopById(int id) {
        String strSQL = "select * from Shop where shopid=?";
        try {
            ps = connection.prepareStatement(strSQL);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Shop(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getDate(5), rs.getString(6), rs.getString(7));
            }
        } catch (SQLException e) {
            System.out.println("getShopById " + e.getMessage());
        }
        return null;
    }

    public int getNumberSpByShop() {
        int m = 0;
        String strSQL = "SELECT COUNT ([id]) as n \n"
                + "                 FROM SanPham \n"
                + "                WHERE shopid=2;";
        try {
            ps = connection.prepareStatement(strSQL);
            rs = ps.executeQuery();
            if (rs.next()) {
                m = rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println("getNumberSpByShop " + e.getMessage());
        }
        return m;
    }

    public List<SanPham> top3SpMoiNhatByShop(int id) {
        List<SanPham> list = new ArrayList<>();
        String query = "select top(3) * from SanPham c where [shopid] = ? order by id desc ";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new SanPham(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getInt(8),
                        rs.getInt(9),
                        rs.getString(10),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13),
                        rs.getInt(14),
                        rs.getInt(15),
                        rs.getInt(16)
                ));
            }
        } catch (SQLException e) {
            System.out.println("top3SpMoiNhatByShop" + e.getMessage());
        }
        return list;
    }

    public List<SanPham> listSpByShop(int id) {
        List<SanPham> list = new ArrayList<>();
        String query = "select  * from SanPham  where [shopid] = ? ";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new SanPham(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getInt(8),
                        rs.getInt(9),
                        rs.getString(10),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13),
                        rs.getInt(14),
                        rs.getInt(15),
                        rs.getInt(16)
                ));
            }
        } catch (SQLException e) {
            System.out.println("listSpByShop" + e.getMessage());
        }
        return list;
    }

    public List<SanPham> top6SpBanChayNhat() {
        List<SanPham> list = new ArrayList<>();
        String query = "select top(6) * from SanPham s join SoLuongBan slb on s.id = slb.productID  order by slb.soLuongDaBan desc";
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new SanPham(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getInt(8),
                        rs.getInt(9),
                        rs.getString(10),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13),
                        rs.getInt(14),
                        rs.getInt(15),
                        rs.getInt(16)
                ));
            }
        } catch (SQLException e) {
            System.out.println("top6SpBanChayNhat" + e.getMessage());
        }
        return list;
    }
}
