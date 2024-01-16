/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import jakarta.servlet.http.Part;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import model.AccInfo;
import model.Account;
import model.HoaDon;
import model.PhanLoai;
import model.SanPham;
import model.TrangThai;

/**
 *
 * @author Admin
 */
public class DAO extends DBContext {

    PreparedStatement ps = null;
    ResultSet rs = null;

    public int countProductSaledByShopID(int shopID) {
        String query = "select count(*) from dbo.SoLuongBan slb join dbo.SanPham sp on slb.productID = sp.id where sp.shopid = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, shopID);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public int countItemInShop(int shopID) {
        String query = "select count(sp.id) from dbo.SanPham sp where sp.shopid =?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, shopID);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }
    public int totalProductInShop(int shopID) {
        String query = "select SUM(sp.quantity) from dbo.SanPham sp where sp.shopid =?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, shopID);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public double calculateRevenue(int shopID) {
        String query = "select SUM(sp.price*slb.soLuongDaBan) from dbo.SoLuongBan slb join dbo.SanPham sp on slb.productID = sp.id where sp.shopid = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, shopID);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getDouble(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public int countNumOfCmt(int shopID) {
        String query = "select count(*) from dbo.SanPham sp join dbo.NhanXet nx on sp.id = nx.productID where sp.shopid = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, shopID);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public double calculateRevenueDay(int day, int shopID) {
        String query = "select sum(ol.price * ol.quantity) "
                + "from OrderLine ol  join HoaDon hd on hd.maHD = ol.invoiceID "
                + "join SanPham sp on ol.productID = sp.id "
                + "where DATEPART(dw, [ngayXuat]) = ? and sp.shopid =? ";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, day);
            ps.setInt(2, shopID);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getDouble(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }
    public double calculateRevenueMonth(int month, int shopID) {
        String query = "select sum(ol.price * ol.quantity) "
                + "from OrderLine ol  join HoaDon hd on hd.maHD = ol.invoiceID "
                + "join SanPham sp on ol.productID = sp.id "
                + "where MONTH(ngayXuat) = ? and sp.shopid =? ";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, month);
            ps.setInt(2, shopID);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getDouble(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }
    public List<HoaDon> getAllInvoiceByShopID(int shopid) {
        List<HoaDon> list = new ArrayList<>();
        String query = "  select hd.maHD, hd.accountID, hd.tongGia, hd.ngayXuat, hd.trangthaiid "
                + "from OrderLine ol  join HoaDon hd on hd.maHD = ol.invoiceID "
                + "join SanPham sp on ol.productID = sp.id "
                + "where shopid = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, shopid);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new HoaDon(rs.getInt(1),
                        rs.getInt(2),
                        rs.getDouble(3),
                        rs.getDate(4),
                        rs.getInt(5)
                       ));
            }
        } catch (Exception e) {
        }
        return list;
    }
    public List<Account> getAllAccount() {
        List<Account> list = new ArrayList<>();
        String query = "select * from Account ";
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Account(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getInt(7)));
            }
        } catch (Exception e) {
        }
        return list;
    }
    public List<TrangThai> getAllInvoiceStatus() {
        List<TrangThai> list = new ArrayList<>();
        String query = " select * from TrangThai";
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new TrangThai(rs.getInt(1),
                        rs.getString(2)
                        ));
            }
        } catch (Exception e) {
        }
        return list;
    }
    public int countNumOfInvoice(int shopID) {
        String query = " select COUNT(hd.maHD) "
                + "from OrderLine ol  join HoaDon hd on hd.maHD = ol.invoiceID "
                + "join SanPham sp on ol.productID = sp.id "
                + "where sp.shopid = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, shopID);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }
    public List<AccInfo> getShopInfo(int shopID) {
        List<AccInfo> list = new ArrayList<>();
        String query = " select ai.uID, ai.name, ai.avatar, ai.address, ai.phonenumber, ai.email, ai.TongChiTieu "
                + "from AccInfo ai join Account a on ai.uID = a.uID "
                + "where a.isSell = 1 and ai.uID = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, shopID);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new AccInfo(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getDouble(7)
                        ));
            }
        } catch (Exception e) {
        }
        return list;
    }
    public List<SanPham> getAllProductByShopID(int shopID) {
        List<SanPham> list = new ArrayList<>();
        String query = "  select * from SanPham where shopid = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, shopID);
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
        } catch (Exception e) {
        }
        return list;
    }
    public void updateShopProfile(String name, String address, String phoneNumber, String email, int shopID){
        String query = "update AccInfo set name=?, address=?, phonenumber=?, email=? where uID=? ";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, address);
            ps.setString(3, phoneNumber);
            ps.setString(4, email);
            ps.setInt(5, shopID);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    public void changeAvatarShop(Part part, int shopID) {
    String query = "UPDATE AccInfo SET avatar = ? WHERE uID = ?";
    try {
        ps = connection.prepareStatement(query);
        InputStream is = part.getInputStream();
        
        // Đọc dữ liệu từ InputStream và chuyển thành chuỗi Base64
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        
        byte[] buffer = new byte[4096];
        
        int bytesRead;
        
        while ((bytesRead = is.read(buffer)) != -1) {
            
            outputStream.write(buffer, 0, bytesRead);
        }
        String base64Image = Base64.getEncoder().encodeToString(outputStream.toByteArray());
        String base64 = "data:image/png;base64," + base64Image;
        // Sử dụng setString để lưu trữ chuỗi Base64 vào cột VARCHAR
        ps.setString(1, base64);
        System.out.println("0");
        ps.setInt(2, shopID);
        System.out.println("0");
        ps.executeUpdate();
        System.out.println("0");
    } catch (Exception e) {
        System.out.println("Error");
    }
}
    public List<PhanLoai> getCategoryByShopID(int shopID) {
        List<PhanLoai> list = new ArrayList<>();
        String query = "SELECT DISTINCT p.cid, p.cname FROM SanPham sp JOIN PhanLoai p ON sp.cateID = p.cid WHERE shopid = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, shopID);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new PhanLoai(rs.getInt(1),
                        rs.getString(2)
                        
                ));
            }
        } catch (Exception e) {
        }
        return list;
    }
    public void deleteProduct(int id) {
    try {
        String query = "DELETE FROM SanPham WHERE id=?";
        ps = connection.prepareStatement(query);
        ps.setInt(1, id);
        int rowsAffected = ps.executeUpdate();
        if (rowsAffected > 0) {
            System.out.println("Product deleted successfully!");
        } else {
            System.out.println("Failed to delete product.");
        }
    } catch (Exception e) {
        System.out.println("deleteProduct:" + e.getMessage());
    }
}
}
