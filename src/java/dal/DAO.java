/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import dto.OrderDTO;
import dto.ShopOrderDTO;
import dto.StatusOrderDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Event;
import jakarta.servlet.http.Part;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Base64;
import java.sql.Date;
import java.util.List;
import model.AccInfo;
import model.Account;
import model.Blog;
import model.Brand;
import model.Cart;
import model.Color;
import model.HoaDon;
import model.InfoLine;
import model.NhanXet;
import model.OrderLine;
import model.PhanLoai;
import model.SanPham;
import model.Shop;
import model.Star;
import model.TrangThai;
import model.WishList;
import model.Account;
import model.AccountBalance;
import model.Contact;
import model.DateNoti;
import model.LoaiAccBal;
import model.LoaiShopBal;
import model.Noti;
import model.NotiCate;
import model.ShippingAddress;
import model.ShopBalance;
import model.SoLuongBan;
import model.ThanhToanVNPAY;
import model.UserGoogleDto;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author Admin
 */
public class DAO extends DBContext {

    PreparedStatement ps;
    ResultSet rs;

    private static java.sql.Date getCurrentDate() {
        java.util.Date today = new java.util.Date();
        return new java.sql.Date(today.getTime());
    }

    public List<SanPham> getWishListSpByAccount(int id) {
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
                + "                           join Account a on wl.accountID= a.uID where a.uID=?";
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
            System.out.println("getWishListSpByAccount" + e.getMessage());
        }
        return list;
    }

    public List<Blog> getBlogByIndex(int indexPage) {
        List<Blog> list = new ArrayList<>();
        String query = "select * from Blog order by [view] desc offset ? rows fetch next 4 rows only";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, (indexPage - 1) * 4);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Blog(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getDate(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getInt(11)
                ));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public int getNumberWlByAcc(int id) {
        int m = 0;
        String strSQL = "SELECT COUNT (productID) as n \n"
                + "FROM WishList  \n"
                + "WHERE accountID=?; ";
        try {
            ps = connection.prepareStatement(strSQL);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                m = rs.getInt(1);
            }
        } catch (SQLException e) {
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

    public List<WishList> getWishListSpByAcc(int id) {
        List<WishList> list = new ArrayList<>();
        String query = "select* from WishList where accountID=?";
        try {

            ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new WishList(rs.getInt(1), rs.getInt(2), rs.getInt(3)));
            }
        } catch (SQLException e) {
            System.out.println("getWishListSpByAcc" + e.getMessage());
        }
        return list;
    }

    public int countAllBlog() {
        String query = "select count(*) from Blog";
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }

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

    public List<Blog> searchBlogByName(String txtSearch) {
        List<Blog> list = new ArrayList<>();
        String query = "select * from Blog where [title] like ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, "%" + txtSearch + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Blog(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getDate(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getInt(11)));
            }
        } catch (Exception e) {
            System.out.println("searchBlogByName" + e.getMessage());
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
            System.out.println("getShopById" + e.getMessage());
        }
        return null;
    }

    public Blog getBlogByID(String id) {

        String query = "select * from Blog where maBlog = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, Integer.parseInt(id));
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Blog(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getDate(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getInt(11));
            }
        } catch (Exception e) {
            System.out.println("getBlogByID" + e.getMessage());
        }
        return null;
    }

    public int getNumberSpByShop(int id) {
        int m = 0;
        String strSQL = "SELECT COUNT ([id]) as n \n"
                + "                 FROM SanPham \n"
                + "                WHERE shopid=?;";
        try {
            ps = connection.prepareStatement(strSQL);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                m = rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println("getNumberSpByShop " + e.getMessage());
        }
        return m;
    }

    public List<SanPham> top6SpMoiNhatByShop(int id) {
        List<SanPham> list = new ArrayList<>();
        String query = "select top(6) * from SanPham c where [shopid] = ? order by id desc ";
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

    public List<SanPham> listSpByShop(int id, int index) {
        List<SanPham> list = new ArrayList<>();
        String query = "select  * from SanPham  where [shopid] = ? order by [id] offset ? rows fetch next 12 rows only ";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            ps.setInt(2, (index - 1) * 12);
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

    public List<SanPham> top6SpBanChayNhat(int shopId) {
        List<SanPham> list = new ArrayList<>();
        String query = "select top(6) * from SanPham s join SoLuongBan slb on s.id = slb.productID where s.shopid=? order by slb.soLuongDaBan desc";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, shopId);
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

    public List<Event> ListEventByShop(int shopID) {
        List<Event> list = new ArrayList<>();
        String query = "select * from Event where shopID = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, shopID);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Event(rs.getInt(4),
                        rs.getInt(1),
                        rs.getString(3),
                        rs.getString(2)));
            }
        } catch (SQLException e) {
            System.out.println("ListEventByShop" + e.getMessage());
        }
        return list;
    }

    public List<Event> getEventByEventID(int eid) {
        List<Event> list = new ArrayList<>();
        String query = "select * from Event where eid = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, eid);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Event(rs.getInt(4),
                        rs.getInt(1),
                        rs.getString(3),
                        rs.getString(2)));
            }
        } catch (SQLException e) {
            System.out.println("getEventByEventID" + e.getMessage());
        }
        return list;
    }

    public List<Blog> getTop3Blog() {
        List<Blog> list = new ArrayList<>();
        String query = "select top 3 * from Blog order by [view] desc";
        try {
            ps = connection.prepareStatement(query);

            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Blog(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getDate(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getInt(11)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<PhanLoai> getAllPhanLoai() {
        List<PhanLoai> list = new ArrayList<>();
        String query = "select * from PhanLoai";
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new PhanLoai(rs.getInt(1),
                        rs.getString(2)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<SanPham> getHotSell(int shopID) {
        List<SanPham> list = new ArrayList<>();
        String query = "SELECT TOP 6 s.id, s.name, s.image, s.price, s.quantity, s.title, s.description, s.cateID, s.branID, s.color, s.image2, s.image3, s.image4, s.shopid, s.sale, s.trangthai, pl.cname AS category_name,  b.bname AS brand_name\n"
                + "FROM SanPham s \n"
                + "INNER JOIN SoLuongBan sl ON s.id = sl.productID \n"
                + "INNER JOIN PhanLoai pl ON s.cateID = pl.cid\n"
                + "INNER JOIN  Brand b ON s.branID = b.bid\n"
                + "ORDER BY sl.soLuongDaBan DESC";
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
                        rs.getInt(16)));
                System.out.println("ID: " + rs.getInt(1));
            }
        } catch (Exception e) {

        }
        return list;
    }

    public List<AccInfo> getLoyalCustomers() {
        List<AccInfo> loyalCustomers = new ArrayList<>();
        String query = "SELECT TOP 10 uID, name, avatar, address, phonenumber, email, TongChiTieu "
                + "FROM AccInfo "
                + "ORDER BY TongChiTieu DESC";
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                loyalCustomers.add(new AccInfo(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getDouble(7)));
                System.out.println("ID: " + rs.getInt(1));

            }
        } catch (Exception e) {

        }
        return loyalCustomers;
    }

    public List<Brand> getAllBrand() {
        List<Brand> list = new ArrayList<>();
        String query = "select * from Brand";
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Brand(rs.getInt(1),
                        rs.getString(2)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<SanPham> getProductByIndex(int indexPage) {
        List<SanPham> list = new ArrayList<>();
        String query = "select * from SanPham order by [id] offset ? rows fetch next 12 rows only";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, (indexPage - 1) * 12);
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

    public int countAllProduct() {
        String query = "select count(*) from SanPham";
        try {
            ps = connection.prepareStatement(query);
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

    public List<SanPham> getProductNew() {
        List<SanPham> list = new ArrayList<>();
        String query = "select top 5 * from   SanPham order by [id] desc ";
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
        } catch (Exception e) {
        }
        return list;
    }

    public List<SanPham> getProductSale() {
        List<SanPham> list = new ArrayList<>();
        String query = "select * from SanPham where sale != 0 ";
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
        } catch (Exception e) {
        }
        return list;
    }

    public List<SanPham> getProductOutOfStock() {
        List<SanPham> list = new ArrayList<>();
        String query = "select * from SanPham where quantity = 0 ";
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
        } catch (Exception e) {
        }
        return list;
    }

    public List<Star> getStarOfProduct() {
        List<Star> list = new ArrayList<>();
        String query = "select productID, AVG(voteStar) as star from NhanXet group by productID";
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Star(rs.getInt(1),
                        rs.getInt(2)
                ));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<SanPham> getProductByCID(String cid) {
        List<SanPham> list = new ArrayList<>();
        String query = "select * from SanPham where cateID=?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, cid);

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

    public List<SanPham> searchByPriceMinToMax(String priceMin, String priceMax) {
        List<SanPham> list = new ArrayList<>();
        String query = "select * from SanPham where [price] >=? and [price]<=?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, priceMin);
            ps.setString(2, priceMax);
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
                        rs.getInt(16)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<SanPham> searchPriceUnder100() {
        List<SanPham> list = new ArrayList<>();
        String query = "select * from SanPham where [price] < 10000000";
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
                        rs.getInt(16)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<SanPham> searchPrice100To200() {
        List<SanPham> list = new ArrayList<>();
        String query = "select * from SanPham where [price] >= 10000000 and [price]<=20000000";
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
                        rs.getInt(16)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    //18
    public List<SanPham> searchPriceAbove200() {
        List<SanPham> list = new ArrayList<>();
        String query = "select * from SanPham where [price] > 20000000";
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
                        rs.getInt(16)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<SanPham> getProductByBID(String bid) {
        List<SanPham> list = new ArrayList<>();
        String query = "select * from SanPham where branID=?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, bid);

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

    public List<Color> getProductColor() {
        List<Color> list = new ArrayList<>();
        String query = "select distinct color from SanPham ";
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Color(
                        rs.getString(1)
                ));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<SanPham> getProductByColor(String color) {
        List<SanPham> list = new ArrayList<>();
        String query = "select * from SanPham where color=?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, color);

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

    public List<SanPham> getProductByName(String txt) {
        List<SanPham> list = new ArrayList<>();
        String query = "select * from SanPham where [name] like '%" + txt + "%' or [title] like '%" + txt + "%' or [description] like '%" + txt + "%' or [color] like '%" + txt + "%' ";
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
                        rs.getInt(16)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public SanPham getProductByID(String id) {
        String query = "select * from SanPham where id = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new SanPham(rs.getInt(1),
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
                        rs.getInt(16));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public int getCateIDByProductID(String id) {
        String query = "select [cateID] from SanPham where [id] =?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, id);
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

    public List<SanPham> getRelatedProduct(int cateIDProductDetail) {
        List<SanPham> list = new ArrayList<>();
        String query = "select top 4 * from SanPham where [cateID] =? order by id desc";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, cateIDProductDetail);
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
                        rs.getInt(16)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<NhanXet> getAllReviewByProductID(String id) {
        List<NhanXet> list = new ArrayList<>();
        String query = "select * from NhanXet where [productID] =?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new NhanXet(rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getDate(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getInt(7)
                ));
            }
        } catch (Exception e) {
        }
        return list;
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

    public double calculateRevenueMonth(int month, int year, int shopID) {
        String query = "select sum(ol.price * ol.quantity) "
                + "from OrderLine ol  join HoaDon hd on hd.maHD = ol.invoiceID "
                + "join SanPham sp on ol.productID = sp.id "
                + "where MONTH(ngayXuat) = ? and YEAR(ngayXuat)=? and sp.shopid =? ";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, month);
            ps.setInt(2, year);
            ps.setInt(3, shopID);
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
        String query = "  select hd.maHD, hd.accountID, hd.tongGia, hd.ngayXuat, hd.trangthaiid, hd.loaiid "
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
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getInt(7)
                ));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Account> getAllAccount() {
        List<Account> list = new ArrayList<>();
        String query = "select * from Account";
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

    public int getSoLuongDaBanById(String id) {
        String query = "select soLuongDaBan from SoLuongBan where [productID] =?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return 0;
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

    public List<AccInfo> getAllAccInfo() {
        List<AccInfo> list = new ArrayList<>();
        String query = "select * from AccInfo";
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new AccInfo(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getDouble(7)));
            }
        } catch (Exception e) {
        }
        return list;
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

    public Cart checkCartExist(int accountID, int productID) {
        String query = "select * from Cart where [accountID] = ? and [productID] = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, accountID);
            ps.setInt(2, productID);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Cart(rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getInt(4)
                );
            }
        } catch (Exception e) {
        }
        return null;
    }

    public void editAmountCart(int accountID, int productID, int i) {
        String query = "update Cart set [amount]=? where [accountID]=? and [productID]=?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, i);
            ps.setInt(2, accountID);
            ps.setInt(3, productID);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void insertCart(int accountID, int productID, int amount) {
        String query = "insert Cart(accountID, productID, amount) values(?,?,?)";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, accountID);
            ps.setInt(2, productID);
            ps.setInt(3, amount);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public WishList checkWishListExist(int accountID, int productID) {
        String query = "select * from WishList where [accountID] = ? and [productID] = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, accountID);
            ps.setInt(2, productID);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new WishList(rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3)
                );
            }
        } catch (Exception e) {
        }
        return null;
    }

    public void insertWishList(int accountID, int productID) {
        String query = "insert WishList(accountID, productID) values(?,?)";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, accountID);
            ps.setInt(2, productID);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public Shop getShopByProductId(int id) {
        String query = "select * from Shop where [shopid] = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, id);

            rs = ps.executeQuery();
            while (rs.next()) {

                return new Shop(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getDate(5),
                        rs.getString(6),
                        rs.getString(7)
                );
            }
        } catch (Exception e) {
        }
        return null;
    }

    public int getShopIdByProductId(String id) {
        String query = "select shopid from SanPham where [id] =?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public List<Cart> getCartByAccountID(int accountID) {
        List<Cart> list = new ArrayList<>();
        String query = "select * from Cart where accountID = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, accountID);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Cart(rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getInt(4)));
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

    public List<WishList> getWishListByAccountID(int accountID) {
        List<WishList> list = new ArrayList<>();
        String query = "select * from WishList where accountID = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, accountID);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new WishList(rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    //get product in cart by account
    public ArrayList<Cart> getProductInCartByAccId(int accountID) {
        ArrayList<Cart> list = new ArrayList<Cart>();
        try {
            String strSQL = "select * from Cart where accountID = ? ";
            ps = connection.prepareStatement(strSQL);
            ps.setInt(1, accountID);
            rs = ps.executeQuery();
            while (rs.next()) {
                int accountid = rs.getInt(1);
                int productid = rs.getInt(2);
                int amount = rs.getInt(3);

                Cart p = new Cart(accountid, productid, amount);
                list.add(p);
            }
        } catch (Exception e) {
            System.out.println("getProductInCartById: " + e.getMessage());
        }
        return list;
    }

    //get a cart by productid
    public Cart getAmountProductIdInCart(int productID, int accountID) {
        try {
            String strSQL = "select * from Cart where productID = ? and accountID= ?";
            ps = connection.prepareStatement(strSQL);
            ps.setInt(1, productID);
            ps.setInt(2, accountID);
            rs = ps.executeQuery();
            while (rs.next()) {
                int accountid = rs.getInt(1);
                int productid = rs.getInt(2);
                int amount = rs.getInt(3);

                Cart p = new Cart(accountid, productid, amount);
                return p;
            }
        } catch (Exception e) {
            System.out.println("getProductInCartById: " + e.getMessage());
        }
        return null;
    }

    //get all product
    public ArrayList<SanPham> getAllProduct() {
        ArrayList<SanPham> list = new ArrayList<SanPham>();
        try {
            String strSQL = "select * from SanPham ";
            ps = connection.prepareStatement(strSQL);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String image = rs.getString(3);
                double price = rs.getDouble(4);
                int quantity = rs.getInt(5);
                String title = rs.getString(6);
                String description = rs.getString(7);
                int cateID = rs.getInt(8);
                int branID = rs.getInt(9);
                String color = rs.getString(10);
                String image2 = rs.getString(11);
                String image3 = rs.getString(12);
                String image4 = rs.getString(13);
                int shopID = rs.getInt(14);
                int sale = rs.getInt(15);
                int trangthai = rs.getInt(16);

                SanPham p = new SanPham(id, name, image, price, quantity, title, description, cateID, branID, color, image2, image3, image4, shopID, sale, trangthai);
                list.add(p);
            }
        } catch (Exception e) {
            System.out.println("getAllProduct: " + e.getMessage());
        }
        return list;
    }

    //get total price in cart by accountID
    public double getTotalPrice(int accountID) {
        double total = 0;
        try {
            String strSQL = "  select SUM(price*amount*(1-sale/100.0)) as total from Cart as c join SanPham as sp on sp.id = c.productID where c.accountID = ? ";
            ps = connection.prepareStatement(strSQL);
            ps.setInt(1, accountID);
            rs = ps.executeQuery();
            while (rs.next()) {
                total = rs.getDouble(1);
            }
        } catch (Exception e) {
            System.out.println("getTotalPrice: " + e.getMessage());
        }
        return total;
    }

    public void removeProductIdInCart(int productID, int accountID) {
        String query = "delete from Cart where productID = ? and accountID = ? ";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, productID);
            ps.setInt(2, accountID);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void updateDecrease(int productID, int accountID) {
        String query = "update Cart set amount = amount - 1 where productID = ? and accountID = ? ";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, productID);
            ps.setInt(2, accountID);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void updateIncrease(int productID, int accountID) {
        String query = "update Cart set amount = amount + 1 where productID = ? and accountID = ? ";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, productID);
            ps.setInt(2, accountID);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public AccInfo getAccInfo(int uID) {
        try {
            String strSQL = "select * from AccInfo where uID = ? ";
            ps = connection.prepareStatement(strSQL);
            ps.setInt(1, uID);
            rs = ps.executeQuery();
            while (rs.next()) {
                int uid = rs.getInt(1);
                String name = rs.getString(2);
                String avatar = rs.getString(3);
                String address = rs.getString(4);
                String phonenumber = rs.getString(5);
                String email = rs.getString(6);
                Double tongchitieu = rs.getDouble(7);
                AccInfo p = new AccInfo(uid, name, avatar, address, phonenumber, email, tongchitieu);
                return p;
            }
        } catch (Exception e) {
            System.out.println("getAccInfo: " + e.getMessage());
        }
        return null;
    }

    public void editAccInfo(String name, String address, String phonenumber, String email, int uID) {
        try {
            String strSQL = "update AccInfo set name = ?, address = ?, phonenumber = ?, email = ? where uID = ? ";
            ps = connection.prepareStatement(strSQL);
            ps.setString(1, name);
            ps.setString(2, address);
            ps.setString(3, phonenumber);
            ps.setString(4, email);
            ps.setInt(5, uID);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("editAccInfo: " + e.getMessage());
        }
    }

    public ArrayList<HoaDon> getAllHoaDon(int accountID) {
        ArrayList<HoaDon> list = new ArrayList<HoaDon>();
        try {
            String strSQL = "select * from HoaDon where accountID = ? ";
            ps = connection.prepareStatement(strSQL);
            ps.setInt(1, accountID);
            rs = ps.executeQuery();
            while (rs.next()) {
                int mahd = rs.getInt(1);
                int accountid = rs.getInt(2);
                double tonggia = rs.getDouble(3);
                Date ngayxuat = rs.getDate(4);
                int trangthai = rs.getInt(5);
                int loai = rs.getInt(6);

                HoaDon p = new HoaDon(rs.getInt(1),
                        rs.getInt(2),
                        rs.getDouble(3),
                        rs.getDate(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getInt(7)
                );
                list.add(p);
            }
        } catch (Exception e) {
            System.out.println("getAllHoaDon: " + e.getMessage());
        }
        return list;
    }

    public ArrayList<OrderLine> getAllOrderLine() {
        ArrayList<OrderLine> list = new ArrayList<OrderLine>();
        try {
            String strSQL = "select * from OrderLine ";
            ps = connection.prepareStatement(strSQL);
            rs = ps.executeQuery();
            while (rs.next()) {
                int invoiceid = rs.getInt(1);
                int productid = rs.getInt(2);
                float price = rs.getFloat(3);
                int quantity = rs.getInt(4);

                OrderLine p = new OrderLine(invoiceid, productid, price, quantity);
                list.add(p);
            }
        } catch (Exception e) {
            System.out.println("getAllOrderLine: " + e.getMessage());
        }
        return list;
    }

    public ArrayList<TrangThai> getAllTrangThai() {
        ArrayList<TrangThai> list = new ArrayList<TrangThai>();
        try {
            String strSQL = "select * from TrangThai ";
            ps = connection.prepareStatement(strSQL);
            rs = ps.executeQuery();
            while (rs.next()) {
                int trangthaiid = rs.getInt(1);
                String trangthai = rs.getString(2);

                TrangThai p = new TrangThai(trangthaiid, trangthai);
                list.add(p);
            }
        } catch (Exception e) {
            System.out.println("getAllTrangThai: " + e.getMessage());
        }
        return list;
    }

    public InfoLine getInfoLine(int invoiceID) {
        try {
            String strSQL = "select * from InfoLine where invoiceID = ? ";
            ps = connection.prepareStatement(strSQL);
            ps.setInt(1, invoiceID);
            rs = ps.executeQuery();
            while (rs.next()) {
                int invoiceid = rs.getInt(1);
                String name = rs.getString(2);
                String email = rs.getString(3);
                String address = rs.getString(4);
                String phonenumber = rs.getString(5);
                String note = rs.getString(6);
                InfoLine p = new InfoLine(invoiceid, name, email, address, phonenumber, note);
                return p;
            }
        } catch (Exception e) {
            System.out.println("getAccInfo: " + e.getMessage());
        }
        return null;
    }

    public HoaDon getHoaDon(int invoiceID) {
        try {
            String strSQL = "select * from HoaDon where maHD = ? ";
            ps = connection.prepareStatement(strSQL);
            ps.setInt(1, invoiceID);
            rs = ps.executeQuery();
            while (rs.next()) {
                int mahd = rs.getInt(1);
                int accountid = rs.getInt(2);
                double tonggia = rs.getDouble(3);
                Date ngayxuat = rs.getDate(4);
                int trangthai = rs.getInt(5);
                int loai = rs.getInt(5);

                HoaDon p = new HoaDon(rs.getInt(1),
                        rs.getInt(2),
                        rs.getDouble(3),
                        rs.getDate(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getInt(7)
                );
                return p;
            }
        } catch (Exception e) {
            System.out.println("getAccInfo: " + e.getMessage());
        }
        return null;
    }

    public TrangThai getTrangThai(int trangthaiid) {
        try {
            String strSQL = "select * from TrangThai where trangthaiid = ? ";
            ps = connection.prepareStatement(strSQL);
            ps.setInt(1, trangthaiid);
            rs = ps.executeQuery();
            while (rs.next()) {
                int trangthaiID = rs.getInt(1);
                String trangthai = rs.getString(2);

                TrangThai p = new TrangThai(trangthaiID, trangthai);
                return p;
            }
        } catch (Exception e) {
            System.out.println("getAccInfo: " + e.getMessage());
        }
        return null;
    }

    public OrderLine getOrderLine(int invoiceID) {
        try {
            String strSQL = "select * from OrderLine where invoiceID = ? ";
            ps = connection.prepareStatement(strSQL);
            ps.setInt(1, invoiceID);
            rs = ps.executeQuery();
            while (rs.next()) {
                int invoiceid = rs.getInt(1);
                int productid = rs.getInt(2);
                float price = rs.getFloat(3);
                int quantity = rs.getInt(4);

                OrderLine p = new OrderLine(invoiceid, productid, price, quantity);
                return p;
            }
        } catch (Exception e) {
            System.out.println("getAccInfo: " + e.getMessage());
        }
        return null;
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
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error");
        }
    }

    public void updateShopProfile(String name, String address, String phoneNumber, String email, int shopID) {
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

    public void deleteEvent(int eid) {
        try {
            String query = "DELETE FROM Event WHERE eid=?";
            ps = connection.prepareStatement(query);
            ps.setInt(1, eid);
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Event deleted successfully!");
            } else {
                System.out.println("Failed to delete event.");
            }
        } catch (Exception e) {
            System.out.println("deleteEvent: " + e.getMessage());
        }
    }

    public List<SanPham> getProductByProductID(int pID) {
        List<SanPham> list = new ArrayList<>();
        String query = " select * from SanPham where id=?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, pID);
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

    public List<Brand> getBrandByShopID(int shopID) {
        List<Brand> list = new ArrayList<>();
        String query = " select distinct b.bid, b.bname from SanPham sp join Brand b on sp.branID = b.bid where shopid=? ";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, shopID);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Brand(rs.getInt(1),
                        rs.getString(2)
                ));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public void updateProduct(String pname, double pprice, int pquantity, String ptitle, String pdescription, int pcateid, int pbrandid, String pcolor, int pid, String image) {
        String query = "UPDATE SanPham SET [name]=?, price=?, quantity=?, title=?, [description]=?, cateID=?, branID=?, color=?, image=? WHERE id=?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, pname);
            ps.setDouble(2, pprice);
            ps.setInt(3, pquantity);
            ps.setString(4, ptitle);
            ps.setString(5, pdescription);
            ps.setInt(6, pcateid);
            ps.setInt(7, pbrandid);
            ps.setString(8, pcolor);
            ps.setString(9, image);
            ps.setInt(10, pid);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void updateEvent(String eventName, int eid) {
        String query = " UPDATE Event set  [eventName] = ?  where [eid] = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(2, eid);

            ps.setString(1, eventName);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
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

    public void addEmailByUid(String email, int id) {
        String strSQL = "insert into AccInfo (uID,email) values(?,?)";
        try {
            ps = connection.prepareStatement(strSQL);
            ps.setInt(1, id);
            ps.setString(2, email);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("addEmailByUid: " + e.getMessage());
        }
    }

    public Account getAccountById(int id) {
        try {
            String strSQL = "select * from Account where uID = ? ";
            ps = connection.prepareStatement(strSQL);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                int uid = rs.getInt(1);
                String user = rs.getString(2);
                String pass = rs.getString(3);
                int isSell = rs.getInt(4);
                int isAdmin = rs.getInt(5);
                int isCheck = rs.getInt(6);
                int isShip = rs.getInt(7);
                Account p = new Account(uid, user, pass, isSell, isAdmin, isCheck, isShip);
                return p;
            }
        } catch (Exception e) {
            System.out.println("getAccountById: " + e.getMessage());
        }
        return null;
    }

    public int getShopIdByAccountId(int accountID) {
        int id = 0;
        String sql = "select shopid from shop where accountid=?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, accountID);
            rs = ps.executeQuery();
            while (rs.next()) {
                id = rs.getInt("shopid");
            }
        } catch (Exception e) {
            System.out.println("getAccountByEmail: " + e.getMessage());
        }
        return id;
    }

    public int countAllLaptop() {
        String query = "select count(*) from SanPham where cateID=1";
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public int countAllDongHo() {
        String query = "select count(*) from SanPham where cateID=2";
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public int countAllBanPhim() {
        String query = "select count(*) from SanPham where cateID=6";
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public int countAllChuot() {
        String query = "select count(*) from SanPham where cateID=7";
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public int countAllTaiNghe() {
        String query = "select count(*) from SanPham where cateID=8";
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public List<SanPham> getTop7NewProduct() {
        List<SanPham> list = new ArrayList<>();
        String query = "select top 7 * from SanPham order by id desc";
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
                        rs.getInt(16)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<SanPham> getBestSellerProduct() {
        List<SanPham> list = new ArrayList<>();
        String query = "select top 3 s.id, s.name, s.image, s.price, s.quantity, s.title, s.description, s.cateID, s.branID,s.color, s.image2, s.image3, s.image4, s.shopid,s.sale,s.trangthai from SanPham s, SoLuongBan so where s.id=so.productID order by so.soLuongDaBan desc";
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
                        rs.getInt(16)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public void RegisterCustomer(String user, String pass) {

        String sql = "INSERT INTO Account([user], pass, isSell, isAdmin, isCheck,isShip)\n"
                + "VALUES (?, ?, 0, 0, 0, 0)";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, pass);

            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }

    }
// get id theo ten

    public int getIDByUsername(Account account) {

        String sql = "select [uID] from Account Where [user] = ?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, account.getUser());

            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;

    }

    public void addbyAccinfo(String email, String address, String phoneNumber, int uID) {

        String sql = "	INSERT INTO AccInfo(email,[address],phonenumber,uID)\n"
                + "                VALUES (?,?,?,?)";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, address);
            ps.setString(3, phoneNumber);
            ps.setInt(4, uID);

            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    //check user ton tai
    public int checkUsername(String user) {
        int exist = 0;
        String sql = "select * from account where [user] = ?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, user);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                exist = 1;
            }
            ps.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return exist;
    }

    // update mk moi
    public void change(Account account) {
        String sql = "update Account set pass = ? Where [user] = ?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, account.getPass());
            ps.setString(2, account.getUser());
            System.out.println(account.getUser());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public Account check(String u) {

        String sql = "SELECT [uID]\n "
                + "      ,[user]\n "
                + "      ,[pass]\n "
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

    public List<SanPham> getProductShopByName(String txt, int shopId) {
        List<SanPham> list = new ArrayList<>();
        String query = "select * from SanPham where [name] like ? and shopid=?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, "%" + txt + "%");
            ps.setInt(2, shopId);
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
                        rs.getInt(16)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<SanPham> getProductShopByCID(String cateID, int shopId) {
        List<SanPham> list = new ArrayList<>();
        String query = "select * from SanPham where cateID=? and shopid=?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, cateID);
            ps.setInt(2, shopId);

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

    public List<SanPham> searchShopByPriceMinToMax(String priceMin, String priceMax, int shopId) {
        List<SanPham> list = new ArrayList<>();
        String query = "select * from SanPham where [price] >=? and [price]<=? and shopid=?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, priceMin);
            ps.setString(2, priceMax);
            ps.setInt(3, shopId);
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
                        rs.getInt(16)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<SanPham> searchShopPriceUnder100(int shopId) {
        List<SanPham> list = new ArrayList<>();
        String query = "select * from SanPham where [price] < 10000000 and shopid=?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, shopId);
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
                        rs.getInt(16)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<SanPham> searchShopPrice100To200(int shopId) {
        List<SanPham> list = new ArrayList<>();
        String query = "select * from SanPham where [price] >= 10000000 and [price]<=20000000 and shopid=?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, shopId);
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
                        rs.getInt(16)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    //18
    public List<SanPham> searchShopPriceAbove200(int shopId) {
        List<SanPham> list = new ArrayList<>();
        String query = "select * from SanPham where [price] > 20000000 and shopid=?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, shopId);
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
                        rs.getInt(16)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<SanPham> getProductShopByBID(String bid, int shopId) {
        List<SanPham> list = new ArrayList<>();
        String query = "select * from SanPham where branID=? and shopid=?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, bid);
            ps.setInt(2, shopId);

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

    public List<SanPham> getProductShopByColor(String color, int shopId) {
        List<SanPham> list = new ArrayList<>();
        String query = "select * from SanPham where color=? and shopid=?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, color);
            ps.setInt(2, shopId);

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

    public int checkEmail(String email) {
        int exist = 0;
        String sql = "select * from accinfo where [email] = ?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, email);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                exist = 1;
            }
            ps.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return exist;
    }

    public String getAvatarByAccId(int accountID) {

        String sql = "select avatar from accinfo where uID = ?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, accountID);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getString(1);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public int countNotiByAccId(int accountID) {
        String sql = "select count(*) from Noti where uID=? and (trangthai=0 or trangthai=2)";
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, accountID);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }

    public int countAds() {
        String sql = "select count(*) from Noti where dateNoti= ? and (noticateid=1 or noticateid=2)";
        try {
            ps = connection.prepareStatement(sql);
            ps.setDate(1, getCurrentDate());

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }

    public ArrayList<Noti> getListAdsToday() {
        ArrayList<Noti> list = new ArrayList<>();
        String query = "select * from Noti where dateNoti=? and (noticateid=1 or noticateid=2)";
        try {
            ps = connection.prepareStatement(query);
            ps.setDate(1, getCurrentDate());
            
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Noti(rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getDate(6),
                        rs.getInt(7),
                        rs.getInt(8),
                        rs.getInt(9)
                ));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public ArrayList<Shop> getAllShop() {
        ArrayList<Shop> list = new ArrayList<>();
        String query = "select * from Shop";
        try {
            ps = connection.prepareStatement(query);

            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Shop(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getDate(5),
                        rs.getString(6),
                        rs.getString(7)
                ));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public ArrayList<NotiCate> getListNotiCate() {
        ArrayList<NotiCate> list = new ArrayList<>();
        String query = "select * from NotiCate";
        try {
            ps = connection.prepareStatement(query);

            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new NotiCate(rs.getInt(1),
                        rs.getString(2)
                ));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public ArrayList<Noti> getListAdsMonth() {
        ArrayList<Noti> list = new ArrayList<>();
        String query = "select * from Noti where (noticateid=1 or noticateid=2) and MONTH(dateNoti)=? order by maNoti desc";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, getCurrentDate().toLocalDate().getMonthValue());

            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Noti(rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getDate(6),
                        rs.getInt(7),
                        rs.getInt(8),
                        rs.getInt(9)
                ));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public ArrayList<DateNoti> getListDateNoti() {
        ArrayList<DateNoti> list = new ArrayList<>();
        String query = "select maNoti, DAY(dateNoti) from Noti where MONTH(dateNoti)=?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, getCurrentDate().toLocalDate().getMonthValue());

            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new DateNoti(rs.getInt(1),
                        getCurrentDate().toLocalDate().getDayOfMonth() - rs.getInt(2)
                ));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public ArrayList<DateNoti> getListDateNoti1() {
        ArrayList<DateNoti> list = new ArrayList<>();
        String query = "select maNoti, DATEDIFF(day, dateNoti, GETDATE()) from Noti ";
        try {
            ps = connection.prepareStatement(query);

            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new DateNoti(rs.getInt(1),
                        rs.getInt(2)
                ));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public ArrayList<Noti> getListNoti(int accountID) {
        ArrayList<Noti> list = new ArrayList<>();
        String query = "select * from Noti where uID=? order by maNoti desc";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, accountID);

            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Noti(rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getDate(6),
                        rs.getInt(7),
                        rs.getInt(8),
                        rs.getInt(9)
                ));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public void ChangeTrangThaiNoti(int maNoti, int newTrangThai) {
        String query = "update Noti set trangthai=? where maNoti=?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, newTrangThai);
            ps.setInt(2, maNoti);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("deleteByMaWl" + e.getMessage());
        }
    }

    public ArrayList<Noti> getListNotiChuaXemByAccId(int accountID) {
        ArrayList<Noti> list = new ArrayList<>();
        String query = "select * from Noti where uID=? and (trangthai=0 or trangthai=2)";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, accountID);

            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Noti(rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getDate(6),
                        rs.getInt(7),
                        rs.getInt(8),
                        rs.getInt(9)
                ));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<TrangThai> getlistTrangThai() {
        ArrayList<TrangThai> list = new ArrayList<>();
        String query = "select * from TrangThai";
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new TrangThai(rs.getInt(1), rs.getString(2)));
            }
        } catch (SQLException e) {
            System.out.println("getlistTrangThai" + e.getMessage());
        }
        return list;
    }

    public List<HoaDon> listHoaDon(int accountID, int trangthai) {
        ArrayList<HoaDon> list = new ArrayList<>();
        String query = "select * from HoaDon where accountID=? and trangthaiid=?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, accountID);
            ps.setInt(2, trangthai);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new HoaDon(rs.getInt(1), rs.getInt(2), rs.getDouble(3), rs.getDate(4), rs.getInt(5), rs.getInt(6), rs.getInt(7)));
            }
        } catch (SQLException e) {
            System.out.println("listHoaDon" + e.getMessage());
        }
        return list;
    }

    public List<OrderDTO> getListOrderDone(int accid, int trangthaiid) {
        ArrayList<OrderDTO> list = new ArrayList<>();
        String query = "select \n"
                + "	h.maHD, h.ngayXuat, sp.image, sp.name, h.tongGia, sp.sale, sp.id as productId ,\n"
                + "	(select count(1) from NhanXet nx where nx.accountID = a.uID and nx.productID =o.productID) as countfb\n"
                + "from OrderLine o\n"
                + "inner join HoaDon h on o.invoiceID = h.maHD\n"
                + "inner join Account a on a.uID = h.accountID\n"
                + "inner join SanPham sp on sp.id = o.productID\n"
                + "where a.uID = ?\n"
                + "and h.trangthaiid = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, accid);
            ps.setInt(2, trangthaiid);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new OrderDTO(rs.getString(1), rs.getDate(2), rs.getString(3), rs.getString(4), rs.getDouble(5), rs.getInt(6), rs.getInt(8), rs.getString(7)));
            }
        } catch (SQLException e) {
            System.out.println("getListOrderLine" + e.getMessage());
        }
        return list;
    }

    public int getQuantityCartByAccountID(int accountID) {
        String sql = "select sum(amount) from Cart where accountID=? group by accountID";
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, accountID);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;

    }

    public String getAvatarByShopId(int shopID) {
        String sql = "select avatar from shop where shopid = ?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, shopID);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getString(1);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public int countNotiByShopId(int shopID) {
        String sql = "select count(*) from Noti where shopID=? and noticateid=3";
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, shopID);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }

    public int countAdsTodayByShopId(int shopID) {
        String sql = "select count(*) from Noti where dateNoti= ? and (noticateid=1 or noticateid=2) and shopID=?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setDate(1, getCurrentDate());
            ps.setInt(2, shopID);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }

    public int countAdsMonthByShopId(int shopID) {
        String sql = "select count(*) from Noti where MONTH(dateNoti)= ? and (noticateid=1 or noticateid=2) and shopID=?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, getCurrentDate().toLocalDate().getMonthValue());
            ps.setInt(2, shopID);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }

    public ArrayList<Noti> getListAdsTodayByShopId(int shopID) {
        ArrayList<Noti> list = new ArrayList<>();
        String query = "select * from Noti where dateNoti=? and (noticateid=1 or noticateid=2) and shopID=?";
        try {
            ps = connection.prepareStatement(query);
            ps.setDate(1, getCurrentDate());
            ps.setInt(2, shopID);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Noti(rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getDate(6),
                        rs.getInt(7),
                        rs.getInt(8),
                        rs.getInt(9)
                ));
            }
        } catch (Exception e) {
            System.out.println("getListAdsTodayByShopId" + e.getMessage());
        }
        return list;
    }

    public ArrayList<Noti> getListAllAdsByShopId(int shopID) {
        ArrayList<Noti> list = new ArrayList<>();
        String query = "select * from Noti where (noticateid=1 or noticateid=2) and shopID=? order by maNoti desc";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, shopID);

            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Noti(rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getDate(6),
                        rs.getInt(7),
                        rs.getInt(8),
                        rs.getInt(9)
                ));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public Noti getNotiById(int notiId) {

        String query = "select * from Noti where maNoti=? ";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, notiId);

            rs = ps.executeQuery();
            while (rs.next()) {
                return new Noti(rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getDate(6),
                        rs.getInt(7),
                        rs.getInt(8),
                        rs.getInt(9)
                );
            }
        } catch (Exception e) {
        }
        return null;
    }

    public void updateNoti(String id, String image, String content) {
        String query = "UPDATE Noti SET [image]=?, contentNoti=? WHERE maNoti=?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, image);
            ps.setString(2, content);
            ps.setString(3, id);

            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }


    public void addNoti(int shopId, Part part, String content, String cate) {
        String query = "insert Noti(shopID, trangthai, image, contentNoti, dateNoti, noticateid)\n" +
"values(?,?,?,?,?,?)";

        try {
            ps = connection.prepareStatement(query);
            InputStream is = part.getInputStream();

            
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

            byte[] buffer = new byte[4096];

            int bytesRead;

            while ((bytesRead = is.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }

            String base64Image = Base64.getEncoder().encodeToString(outputStream.toByteArray());
            String base64 = "data:image/png;base64," + base64Image;
            ps.setInt(1, shopId);
            ps.setInt(2, 0);
            ps.setString(3, base64);
            ps.setString(4, content);
            ps.setDate(5, getCurrentDate());
            ps.setString(6, cate);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    

    public void deleteNotiById(String id) {
        String query = "delete Noti where maNoti=?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, id);

            ps.executeUpdate();
        } catch (Exception e) {
        }

    }

    public void changeImageNoti(Part part, int maNoti) {
        String query = "UPDATE Noti SET image = ? WHERE maNoti = ?";
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
            ps.setInt(2, maNoti);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error");
        }
    }

    public int countNotiTodayByShopId(int shopID) {
        String sql = "select count(*) from Noti where dateNoti= ? and noticateid=3 and shopID=?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setDate(1, getCurrentDate());
            ps.setInt(2, shopID);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }

    public ArrayList<Noti> getListNotiTodayByShopId(int shopID) {
        ArrayList<Noti> list = new ArrayList<>();
        String query = "select * from Noti where dateNoti=? and noticateid=3 and shopID=?";
        try {
            ps = connection.prepareStatement(query);
            ps.setDate(1, getCurrentDate());
            ps.setInt(2, shopID);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Noti(rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getDate(6),
                        rs.getInt(7),
                        rs.getInt(8),
                        rs.getInt(9)
                ));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public ArrayList<Noti> getListAllNotiByShopId(int shopID) {
        ArrayList<Noti> list = new ArrayList<>();
        String query = "select * from Noti where noticateid=3 and shopID=? order by maNoti desc";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, shopID);

            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Noti(rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getDate(6),
                        rs.getInt(7),
                        rs.getInt(8),
                        rs.getInt(9)
                ));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public int countNotiTodayForShop(int shopID) {
        String sql = "select count(*) from Noti where dateNoti= ? and noticateid=4 and shopID=? and (trangthai=0 or trangthai=1)";
        try {
            ps = connection.prepareStatement(sql);
            ps.setDate(1, getCurrentDate());
            ps.setInt(2, shopID);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }

    public ArrayList<Noti> getListNotiTodayForShop(int shopID) {
        ArrayList<Noti> list = new ArrayList<>();
        String query = "select * from Noti where dateNoti=? and noticateid=4 and shopID=?";
        try {
            ps = connection.prepareStatement(query);
            ps.setDate(1, getCurrentDate());
            ps.setInt(2, shopID);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Noti(rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getDate(6),
                        rs.getInt(7),
                        rs.getInt(8),
                        rs.getInt(9)
                ));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public ArrayList<Noti> getListAllNotiForShop(int shopID) {
        ArrayList<Noti> list = new ArrayList<>();
        String query = "select * from Noti where noticateid=4 and shopID=? order by maNoti desc";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, shopID);

            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Noti(rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getDate(6),
                        rs.getInt(7),
                        rs.getInt(8),
                        rs.getInt(9)
                ));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public int getTrangThaiByNotiId(int maNoti) {
        String sql = "select trangthai from Noti where maNoti=?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, maNoti);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }

    public ArrayList<Noti> getListNotiTodayForShopChuaXem(int shopID) {
        ArrayList<Noti> list = new ArrayList<>();
        String query = "select * from Noti where dateNoti=? and noticateid=4 and shopID=? and (trangthai=0 or trangthai=1)";
        try {
            ps = connection.prepareStatement(query);
            ps.setDate(1, getCurrentDate());
            ps.setInt(2, shopID);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Noti(rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getDate(6),
                        rs.getInt(7),
                        rs.getInt(8),
                        rs.getInt(9)
                ));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public ArrayList<Noti> getListAllNotiForShopChuaXem(int shopID) {
        ArrayList<Noti> list = new ArrayList<>();
        String query = "select * from Noti where noticateid=4 and shopID=? and (trangthai=0 or trangthai=1) order by maNoti desc";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, shopID);

            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Noti(rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getDate(6),
                        rs.getInt(7),
                        rs.getInt(8),
                        rs.getInt(9)
                ));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public void addContact(String name, String email, String subject, String content) {
        String query = "insert Contact(name, email, subject, [content], trangthai)\n"
                + "values(?,?,?,?,?)";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, subject);
            ps.setString(4, content);
            ps.setInt(5, 0);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void addContact1(String name, String email, String subject, String content, int accountId) {
        String query = "insert Contact(name, email, subject, [content], uID, trangthai)\n"
                + "values(?,?,?,?,?,?)";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, subject);
            ps.setString(4, content);
            ps.setInt(5, accountId);
            ps.setInt(6, 0);
            ps.executeUpdate();
        } catch (Exception e) {

        }
    }

    public int countContact() {
        String sql = "select count(*) from Contact where trangthai=0";
        try {
            ps = connection.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }

    public ArrayList<Contact> getListContact() {
        ArrayList<Contact> list = new ArrayList<>();
        String query = "select * from Contact where trangthai=0";
        try {
            ps = connection.prepareStatement(query);

            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Contact(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getInt(7)
                ));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public ArrayList<AccInfo> getListAccInfo() {
        ArrayList<AccInfo> list = new ArrayList<>();
        String query = "select * from AccInfo";
        try {
            ps = connection.prepareStatement(query);

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

    public void deleteContactByID(int contactID) {
        String query = "delete Contact where contactID=?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, contactID);

            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public Contact getContactById(int contactID) {

        String query = "select * from Contact where contactID=?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, contactID);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Contact(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getInt(7)
                );
            }
        } catch (Exception e) {
        }
        return null;
    }

    public void changeStatusContact(String id) {
        String sql = "update Contact set trangthai = 1 Where contactID = ?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public List<SanPham> getListAllSanPham() {
        List<SanPham> list = new ArrayList<>();
        String query = "Select * from SanPham ";
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
            System.out.println("getListAllSanPham" + e.getMessage());
        }
        return list;
    }

    public void addProduct(String name, Part image1, double price, int quantity, String title, String description, int cateID, int branID, String color, Part image2, Part image3, Part image4, int shopID, int sale, int trangthai) {
        String query = "insert SanPham(name, image, price, quantity, title, description, cateID, branID, color, image2, image3, image4, shopid, sale, trangthai)\n"
                + "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            ps = connection.prepareStatement(query);
            InputStream is1 = image1.getInputStream();
            InputStream is2 = image2.getInputStream();
            InputStream is3 = image3.getInputStream();
            InputStream is4 = image4.getInputStream();
            // Đọc dữ liệu từ InputStream và chuyển thành chuỗi Base64
            ByteArrayOutputStream outputStream1 = new ByteArrayOutputStream();
            ByteArrayOutputStream outputStream2 = new ByteArrayOutputStream();
            ByteArrayOutputStream outputStream3 = new ByteArrayOutputStream();
            ByteArrayOutputStream outputStream4 = new ByteArrayOutputStream();
            byte[] buffer1 = new byte[4096];
            byte[] buffer2 = new byte[4096];
            byte[] buffer3 = new byte[4096];
            byte[] buffer4 = new byte[4096];
            int bytesRead1;
            int bytesRead2;
            int bytesRead3;
            int bytesRead4;

            while ((bytesRead1 = is1.read(buffer1)) != -1 && (bytesRead2 = is2.read(buffer2)) != -1 && (bytesRead3 = is3.read(buffer3)) != -1 && (bytesRead4 = is4.read(buffer4)) != -1) {
                outputStream1.write(buffer1, 0, bytesRead1);
                outputStream2.write(buffer2, 0, bytesRead2);
                outputStream3.write(buffer3, 0, bytesRead3);
                outputStream4.write(buffer4, 0, bytesRead4);
            }

            String base64Image1 = Base64.getEncoder().encodeToString(outputStream1.toByteArray());
            String base64Image2 = Base64.getEncoder().encodeToString(outputStream2.toByteArray());
            String base64Image3 = Base64.getEncoder().encodeToString(outputStream3.toByteArray());
            String base64Image4 = Base64.getEncoder().encodeToString(outputStream4.toByteArray());
            String base641 = "data:image/png;base64," + base64Image1;
            String base642 = "data:image/png;base64," + base64Image2;
            String base643 = "data:image/png;base64," + base64Image3;
            String base644 = "data:image/png;base64," + base64Image4;
            // Sử dụng setString để lưu trữ chuỗi Base64 vào cột VARCHAR
            ps.setString(1, name);
            ps.setString(2, base641);
            ps.setDouble(3, price);
            ps.setInt(4, quantity);
            ps.setString(5, title);
            ps.setString(6, description);
            ps.setInt(7, cateID);
            ps.setInt(8, branID);
            ps.setString(9, color);
            ps.setString(10, base642);
            ps.setString(11, base643);
            ps.setString(12, base644);
            ps.setInt(13, shopID);
            ps.setInt(14, sale);
            ps.setInt(15, trangthai);
            ps.executeUpdate();
        } catch (Exception e) {

        }
    }

    public List<HoaDon> getOrderByShopID(int shopID) {
        List<HoaDon> list = new ArrayList<>();
        String sql = "select hd.*\n"
                + "from  HoaDon hd\n"
                + "join OrderLine ol on hd.maHD = ol.invoiceID\n"
                + "join SanPham sp on ol.productID = sp.id "
                + " where sp.shopid = ? ";
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, shopID);
            rs = ps.executeQuery();
            while (rs.next()) {
                HoaDon d = new HoaDon();
                d.setMaHD(rs.getInt(1));
                d.setAccountID(rs.getInt(2));
                d.setTongGia(rs.getDouble(3));
                d.setNgayXuat(rs.getDate(4));
                d.setTrangThaiId(rs.getInt(5));
                d.setLoaiid(rs.getInt(6));
                d.setPaymentid(rs.getInt(7));
                list.add(d);
            }
        } catch (SQLException e) {
            System.out.println("getOrderByShopID: " + e.getMessage());
        }
        return list;
    }

    public List<SanPham> searchProductByName(String txt, int shopid) {
        List<SanPham> list = new ArrayList<>();
        String query = "select * from SanPham where [name] like ? and shopid =? ";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, "%" + txt + "%");
            ps.setInt(2, shopid);
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
                        rs.getInt(16)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<StatusOrderDTO> getOrderStatusByShopID(int shopID) {
        List<StatusOrderDTO> list = new ArrayList<>();
        String sql = "select tt.*,hd.maHD \n"
                + "from  HoaDon hd\n"
                + "join OrderLine ol on hd.maHD = ol.invoiceID\n"
                + "join SanPham sp on ol.productID = sp.id\n"
                + "join TrangThai tt on hd.trangthaiid = tt.trangthaiid\n"
                + "where sp.shopid = ? ";
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, shopID);
            rs = ps.executeQuery();
            while (rs.next()) {
                StatusOrderDTO d = new StatusOrderDTO();
                d.setTrangthaiid(rs.getInt(1));
                d.setTrangthai(rs.getString(2));
                d.setMaHD(rs.getInt(3));
                list.add(d);
            }
        } catch (SQLException e) {
            System.out.println("getOrderStatusByShopID: " + e.getMessage());
        }
        return list;
    }

    public List<ShopOrderDTO> getProductOrderByShopID(int shopID) {
        List<ShopOrderDTO> list = new ArrayList<>();
        String sql = "  select sp.[image],sp.[name],hd.maHD\n"
                + "  from  HoaDon hd\n"
                + "  join OrderLine ol on hd.maHD = ol.invoiceID\n"
                + "  join SanPham sp on ol.productID = sp.id\n"
                + "  where sp.shopid = ? ";
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, shopID);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new ShopOrderDTO(rs.getString(1), rs.getString(2), rs.getInt(3))
                );
            }
        } catch (SQLException e) {
            System.out.println("getProductOrderByShopID: " + e.getMessage());
        }
        return list;

    }

    public List<OrderLine> getOrderLineByShopID(int shopID) {
        List<OrderLine> list = new ArrayList<>();
        String sql = "select ol.*\n"
                + "from  HoaDon hd\n"
                + "join OrderLine ol on hd.maHD = ol.invoiceID\n"
                + "join SanPham sp on ol.productID = sp.id\n"
                + "where sp.shopid = ?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, shopID);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new OrderLine(rs.getInt(1),
                        rs.getInt(2),
                        rs.getFloat(3),
                        rs.getInt(4)
                ));
            }
        } catch (SQLException e) {
            System.out.println("getOrderLineByShopID: " + e.getMessage());
        }
        return list;
    }

    public List<SanPham> getProductByIndex2(int indexPage, int shopid) {
        List<SanPham> list = new ArrayList<>();
        String query = "select * from SanPham where shopid=? and trangthai=1 order by [id] offset ? rows fetch next 10 rows only";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, shopid);
            ps.setInt(2, (indexPage - 1) * 10);
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

    public List<AccInfo> getBuyerInfoByOrderWithShopID(int shopID) {
        List<AccInfo> list = new ArrayList<>();
        String sql = "select ai.*\n"
                + "from  HoaDon hd\n"
                + "join OrderLine ol on hd.maHD = ol.invoiceID\n"
                + "join SanPham sp on ol.productID = sp.id\n"
                + "join Account a on hd.accountID = a.[uID]\n"
                + "join AccInfo ai on a.[uID] = ai.[uID]\n"
                + "where sp.shopid = ? ";
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, shopID);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new AccInfo(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getDouble(7)));
            }
        } catch (SQLException e) {
            System.out.println("getOrderLineByShopID: " + e.getMessage());
        }
        return list;
    }

    public List<AccInfo> getAccEmail(int accountID) {
        List<AccInfo> list = new ArrayList<>();
        String query = " select AI.uID, AI.name, AI.avatar, AI.address, AI.phonenumber, AI.email, AI.TongChiTieu from AccInfo AI join Account A on AI.uID = A.uID where AI.uID = ? ";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, accountID);
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

    public List<TrangThai> getStatusCategory() {
        List<TrangThai> list = new ArrayList<>();
        String sql = "SELECT [trangthaiid]\n"
                + "      ,[trangthai]\n"
                + "  FROM [dbo].[TrangThai]";
        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new TrangThai(rs.getInt(1), rs.getString(2)));
            }
        } catch (SQLException e) {
            System.out.println("getStatusCategory: " + e.getMessage());
        }
        return list;
    }

    public void changeOrderStatus(int maHD, int changeStatus) {
        String sql = "Update HoaDon Set trangthaiid = ? where maHD = ? ";
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, changeStatus);
            ps.setInt(2, maHD);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("changeOrderStatus: " + e.getMessage());
        }
    }

    public List<HoaDon> getOrderByShopIDAndStatus(int shopID, int sid) {
        List<HoaDon> list = new ArrayList<>();
        String sql = "select hd.*\n"
                + "from  HoaDon hd\n"
                + "join OrderLine ol on hd.maHD = ol.invoiceID\n"
                + "join SanPham sp on ol.productID = sp.id "
                + " where sp.shopid = ? and hd.trangthaiid = ? ";
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, shopID);
            ps.setInt(2, sid);
            rs = ps.executeQuery();
            while (rs.next()) {
                HoaDon d = new HoaDon();
                d.setMaHD(rs.getInt(1));
                d.setAccountID(rs.getInt(2));
                d.setTongGia(rs.getDouble(3));
                d.setNgayXuat(rs.getDate(4));
                d.setTrangThaiId(rs.getInt(5));
                d.setLoaiid(rs.getInt(6));
                d.setPaymentid(rs.getInt(7));
                list.add(d);
            }
        } catch (SQLException e) {
            System.out.println("getOrderByShopIDAndStatus: " + e.getMessage());
        }
        return list;
    }

    public List<StatusOrderDTO> getOrderStatusByShopIDAndStatus(int shopID, int sid) {
        List<StatusOrderDTO> list = new ArrayList<>();
        String sql = "select tt.*,hd.maHD\n"
                + "from  HoaDon hd\n"
                + "join OrderLine ol on hd.maHD = ol.invoiceID\n"
                + "join SanPham sp on ol.productID = sp.id\n"
                + "join TrangThai tt on hd.trangthaiid = tt.trangthaiid\n"
                + "where sp.shopid = ? and hd.trangthaiid = ?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, shopID);
            ps.setInt(2, sid);
            rs = ps.executeQuery();
            while (rs.next()) {
                StatusOrderDTO d = new StatusOrderDTO();
                d.setTrangthaiid(rs.getInt(1));
                d.setTrangthai(rs.getString(2));
                d.setMaHD(rs.getInt(3));
                list.add(d);
            }
        } catch (SQLException e) {
            System.out.println("getOrderStatusByShopID: " + e.getMessage());
        }
        return list;
    }

    public List<ShopOrderDTO> getProductOrderByShopIDAndStatus(int shopID, int sid) {
        List<ShopOrderDTO> list = new ArrayList<>();
        String sql = "select sp.[image],sp.[name],hd.maHD \n"
                + "from  HoaDon hd\n"
                + "join OrderLine ol on hd.maHD = ol.invoiceID\n"
                + "join SanPham sp on ol.productID = sp.id\n"
                + "where sp.shopid = ? and hd.trangthaiid = ?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, shopID);
            ps.setInt(2, sid);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new ShopOrderDTO(rs.getString(1), rs.getString(2), rs.getInt(3))
                );
            }
        } catch (SQLException e) {
            System.out.println("getProductOrderByShopIDAndStatus: " + e.getMessage());
        }
        return list;

    }

    public List<OrderLine> getOrderLineByShopIDAndStatus(int shopID, int sid) {
        List<OrderLine> list = new ArrayList<>();
        String sql = "select ol.*\n"
                + "from  HoaDon hd\n"
                + "join OrderLine ol on hd.maHD = ol.invoiceID\n"
                + "join SanPham sp on ol.productID = sp.id\n"
                + "where sp.shopid = ? and hd.trangthaiid= ? ";
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, shopID);
            ps.setInt(2, sid);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new OrderLine(rs.getInt(1),
                        rs.getInt(2),
                        rs.getFloat(3),
                        rs.getInt(4)
                ));
            }
        } catch (SQLException e) {
            System.out.println("getOrderLineByShopID: " + e.getMessage());
        }
        return list;
    }

    public List<AccInfo> getBuyerInfoByOrderWithShopIDAndStatus(int shopID, int sid) {
        List<AccInfo> list = new ArrayList<>();
        String sql = "select ai.*\n"
                + "from  HoaDon hd\n"
                + "join OrderLine ol on hd.maHD = ol.invoiceID\n"
                + "join SanPham sp on ol.productID = sp.id\n"
                + "join Account a on hd.accountID = a.[uID]\n"
                + "join AccInfo ai on a.[uID] = ai.[uID]\n"
                + "where sp.shopid = ? and hd.trangthaiid = ?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, shopID);
            ps.setInt(2, sid);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new AccInfo(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getDouble(7)));
            }
        } catch (SQLException e) {
            System.out.println("getOrderLineByShopID: " + e.getMessage());
        }
        return list;
    }

    public List<HoaDon> searchOrderByOrderID(int shopID, String input) {
        List<HoaDon> list = new ArrayList<>();
        int i = Integer.parseInt(input);
        String sql = "select hd.*\n"
                + "from  HoaDon hd\n"
                + "join OrderLine ol on hd.maHD = ol.invoiceID\n"
                + "join SanPham sp on ol.productID = sp.id "
                + " where sp.shopid = ? and hd.maHD = ? ";
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, shopID);
            ps.setInt(2, i);
            rs = ps.executeQuery();
            while (rs.next()) {
                HoaDon d = new HoaDon();
                d.setMaHD(rs.getInt(1));
                d.setAccountID(rs.getInt(2));
                d.setTongGia(rs.getDouble(3));
                d.setNgayXuat(rs.getDate(4));
                d.setTrangThaiId(rs.getInt(5));
                d.setLoaiid(rs.getInt(6));
                d.setPaymentid(rs.getInt(7));
                list.add(d);
            }
        } catch (SQLException e) {
            System.out.println("searchOrderByOrderID: " + e.getMessage());
        }
        return list;
    }

    public List<StatusOrderDTO> getOrderStatusByOrderID(int shopID, String input) {
        List<StatusOrderDTO> list = new ArrayList<>();
        int i = Integer.parseInt(input);
        String sql = "select tt.*,hd.maHD\n"
                + "from  HoaDon hd\n"
                + "join OrderLine ol on hd.maHD = ol.invoiceID\n"
                + "join SanPham sp on ol.productID = sp.id\n"
                + "join TrangThai tt on hd.trangthaiid = tt.trangthaiid\n"
                + "where sp.shopid = ? and hd.maHD = ?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, shopID);
            ps.setInt(2, i);
            rs = ps.executeQuery();
            while (rs.next()) {
                StatusOrderDTO d = new StatusOrderDTO();
                d.setTrangthaiid(rs.getInt(1));
                d.setTrangthai(rs.getString(2));
                d.setMaHD(rs.getInt(3));
                list.add(d);
            }
        } catch (SQLException e) {
            System.out.println("getOrderStatusByOrderID: " + e.getMessage());
        }
        return list;
    }

    public List<ShopOrderDTO> getProductOrderByOrderID(int shopID, String input) {
        List<ShopOrderDTO> list = new ArrayList<>();
        int i = Integer.parseInt(input);
        String sql = "select sp.[image],sp.[name],hd.maHD \n"
                + "from  HoaDon hd\n"
                + "join OrderLine ol on hd.maHD = ol.invoiceID\n"
                + "join SanPham sp on ol.productID = sp.id\n"
                + "where sp.shopid = ? and hd.maHD = ? ";
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, shopID);
            ps.setInt(2, i);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new ShopOrderDTO(rs.getString(1), rs.getString(2), rs.getInt(3))
                );
            }
        } catch (SQLException e) {
            System.out.println("getProductOrderByOrderID: " + e.getMessage());
        }
        return list;

    }

    public List<OrderLine> getOrderLineByOrderID(int shopID, String input) {
        List<OrderLine> list = new ArrayList<>();
        int i = Integer.parseInt(input);
        String sql = "select ol.*\n"
                + "from  HoaDon hd\n"
                + "join OrderLine ol on hd.maHD = ol.invoiceID\n"
                + "join SanPham sp on ol.productID = sp.id\n"
                + "where sp.shopid = ? and hd.maHD = ? ";
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, shopID);
            ps.setInt(2, i);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new OrderLine(rs.getInt(1),
                        rs.getInt(2),
                        rs.getFloat(3),
                        rs.getInt(4)
                ));
            }
        } catch (SQLException e) {
            System.out.println("getOrderLineByOrderID: " + e.getMessage());
        }
        return list;
    }

    public List<AccInfo> getBuyerInfoByOrderWithOrderID(int shopID, String input) {
        List<AccInfo> list = new ArrayList<>();
        int i = Integer.parseInt(input);
        String sql = "select ai.*\n"
                + "from  HoaDon hd\n"
                + "join OrderLine ol on hd.maHD = ol.invoiceID\n"
                + "join SanPham sp on ol.productID = sp.id\n"
                + "join Account a on hd.accountID = a.[uID]\n"
                + "join AccInfo ai on a.[uID] = ai.[uID]\n"
                + "where sp.shopid = ? and hd.maHD = ? ";
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, shopID);
            ps.setInt(2, i);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new AccInfo(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getDouble(7)));
            }
        } catch (SQLException e) {
            System.out.println("getBuyerInfoByOrderWithOrderID: " + e.getMessage());
        }
        return list;
    }

    public List<HoaDon> getOrderByOrderIDAndStatus(int shopID, int sid, String input) {
        List<HoaDon> list = new ArrayList<>();
        int i = Integer.parseInt(input);
        String sql = "select hd.*\n"
                + "from  HoaDon hd\n"
                + "join OrderLine ol on hd.maHD = ol.invoiceID\n"
                + "join SanPham sp on ol.productID = sp.id "
                + " where sp.shopid = ? and hd.trangthaiid = ? and hd.maHD = ? ";
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, shopID);
            ps.setInt(2, sid);
            ps.setInt(3, i);
            rs = ps.executeQuery();
            while (rs.next()) {
                HoaDon d = new HoaDon();
                d.setMaHD(rs.getInt(1));
                d.setAccountID(rs.getInt(2));
                d.setTongGia(rs.getDouble(3));
                d.setNgayXuat(rs.getDate(4));
                d.setTrangThaiId(rs.getInt(5));
                d.setLoaiid(rs.getInt(6));
                d.setPaymentid(rs.getInt(7));
                list.add(d);
            }
        } catch (SQLException e) {
            System.out.println("getOrderByOrderIDAndStatus: " + e.getMessage());
        }
        return list;
    }

    public List<StatusOrderDTO> getOrderStatusByShopIDAndStatus(int shopID, int sid, String input) {
        List<StatusOrderDTO> list = new ArrayList<>();
        int i = Integer.parseInt(input);
        String sql = "select tt.*,hd.maHD\n"
                + "from  HoaDon hd\n"
                + "join OrderLine ol on hd.maHD = ol.invoiceID\n"
                + "join SanPham sp on ol.productID = sp.id\n"
                + "join TrangThai tt on hd.trangthaiid = tt.trangthaiid\n"
                + "where sp.shopid = ? and hd.trangthaiid = ? and hd.maHD = ?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, shopID);
            ps.setInt(2, sid);
            ps.setInt(3, i);
            rs = ps.executeQuery();
            while (rs.next()) {
                StatusOrderDTO d = new StatusOrderDTO();
                d.setTrangthaiid(rs.getInt(1));
                d.setTrangthai(rs.getString(2));
                d.setMaHD(rs.getInt(3));
                list.add(d);
            }
        } catch (SQLException e) {
            System.out.println("getOrderStatusByShopIDAndStatus: " + e.getMessage());
        }
        return list;
    }

    public List<ShopOrderDTO> getProductOrderByOrderIDAndStatus(int shopID, int sid, String input) {
        List<ShopOrderDTO> list = new ArrayList<>();
        int i = Integer.parseInt(input);
        String sql = "select sp.[image],sp.[name],hd.maHD \n"
                + "from  HoaDon hd\n"
                + "join OrderLine ol on hd.maHD = ol.invoiceID\n"
                + "join SanPham sp on ol.productID = sp.id\n"
                + "where sp.shopid = ? and hd.trangthaiid = ? and hd.maHD = ?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, shopID);
            ps.setInt(2, sid);
            ps.setInt(3, i);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new ShopOrderDTO(rs.getString(1), rs.getString(2), rs.getInt(3))
                );
            }
        } catch (SQLException e) {
            System.out.println("getProductOrderByOrderIDAndStatus: " + e.getMessage());
        }
        return list;

    }

    public List<OrderLine> getOrderLineByOrderIDAndStatus(int shopID, int sid, String input) {
        List<OrderLine> list = new ArrayList<>();
        int i = Integer.parseInt(input);
        String sql = "select ol.*\n"
                + "from  HoaDon hd\n"
                + "join OrderLine ol on hd.maHD = ol.invoiceID\n"
                + "join SanPham sp on ol.productID = sp.id\n"
                + "where sp.shopid = ? and hd.trangthaiid= ? and hd.maHD = ?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, shopID);
            ps.setInt(2, sid);
            ps.setInt(3, i);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new OrderLine(rs.getInt(1),
                        rs.getInt(2),
                        rs.getFloat(3),
                        rs.getInt(4)
                ));
            }
        } catch (SQLException e) {
            System.out.println("getOrderLineByOrderIDAndStatus: " + e.getMessage());
        }
        return list;
    }

    public List<AccInfo> getBuyerInfoByOrderWithOrderIDAndStatus(int shopID, int sid, String input) {
        List<AccInfo> list = new ArrayList<>();
        int i = Integer.parseInt(input);
        String sql = "select ai.*\n"
                + "from  HoaDon hd\n"
                + "join OrderLine ol on hd.maHD = ol.invoiceID\n"
                + "join SanPham sp on ol.productID = sp.id\n"
                + "join Account a on hd.accountID = a.[uID]\n"
                + "join AccInfo ai on a.[uID] = ai.[uID]\n"
                + "where sp.shopid = ? and hd.trangthaiid = ? and hd.maHD = ?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, shopID);
            ps.setInt(2, sid);
            ps.setInt(3, i);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new AccInfo(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getDouble(7)));
            }
        } catch (SQLException e) {
            System.out.println("getBuyerInfoByOrderWithOrderIDAndStatus: " + e.getMessage());
        }
        return list;
    }

    public void addNotiChangeStatus(Noti noti) {
        String sql = "INSERT INTO [dbo].[Noti]\n"
                + "           ([shopID]\n"
                + "           ,[uID]\n"
                + "           ,[maHD]\n"
                + "           ,[trangthai]\n"
                + "           ,[image]\n"
                + "           ,[contentNoti]\n"
                + "           ,[dateNoti]\n"
                + "           ,[noticateid])\n"
                + "     VALUES(?,?,?,?,?,?,?,?)";
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, noti.getShopId());
            ps.setInt(2, noti.getuID());
            ps.setInt(3, noti.getMaHD());
            ps.setInt(4, noti.getTrangthai());
            ps.setString(5, noti.getImage());
            ps.setString(6, noti.getContentNoti());
            ps.setDate(7, noti.getDateNoti());
            ps.setInt(8, noti.getNoticateid());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("addNotiChangeStatus: " + e.getMessage());
        }
    }

    public void createShop(String shopName, Part proof1, Part proof2, String address, int uID) {
        String query = "insert ShopHangCho(shopname, proof, proof1, dateThamGia, address, uID) values (?,?,?,?,?,?)";
        try {
            ps = connection.prepareStatement(query);
            InputStream is1 = proof1.getInputStream();
            InputStream is2 = proof2.getInputStream();
            // Đọc dữ liệu từ InputStream và chuyển thành chuỗi Base64
            ByteArrayOutputStream outputStream1 = new ByteArrayOutputStream();
            ByteArrayOutputStream outputStream2 = new ByteArrayOutputStream();
            byte[] buffer1 = new byte[4096];
            byte[] buffer2 = new byte[4096];
            int bytesRead1;
            int bytesRead2;

            while ((bytesRead1 = is1.read(buffer1)) != -1 && (bytesRead2 = is2.read(buffer2)) != -1) {
                outputStream1.write(buffer1, 0, bytesRead1);
                outputStream2.write(buffer2, 0, bytesRead2);
            }

            String base64Image1 = Base64.getEncoder().encodeToString(outputStream1.toByteArray());
            String base64Image2 = Base64.getEncoder().encodeToString(outputStream2.toByteArray());
            String base641 = "data:image/png;base64," + base64Image1;
            String base642 = "data:image/png;base64," + base64Image2;
            ps.setString(1, shopName);
            ps.setString(2, base641);
            ps.setString(3, base642);
            ps.setDate(4, getCurrentDate());
            ps.setString(5, address);
            ps.setInt(6, uID);
            ps.executeUpdate();
        } catch (Exception e) {

        }
    }

    public void addEvent(int shopId, Part image, String eventName) {
        String query = " insert Event([shopID], [image],eventName) values(?,?,?)";
        try {
            ps = connection.prepareStatement(query);
            InputStream is1 = image.getInputStream();

            // Đọc dữ liệu từ InputStream và chuyển thành chuỗi Base64
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = is1.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
            String base64Image = Base64.getEncoder().encodeToString(outputStream.toByteArray());
            String base641 = "data:image/png;base64," + base64Image;

            // Sử dụng setString để lưu trữ chuỗi Base64 vào cột VARCHAR
            ps.setInt(1, shopId);

            ps.setString(2, base641);
            ps.setString(3, eventName);

            ps.executeUpdate();
        } catch (Exception e) {

        }
    }

    public int countNumOfOutProduct(int shopId) {
        String query = "select count(*) from SanPham sp where sp.quantity =0 and sp.shopid = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, shopId);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public List<SanPham> top5SpBanChayNhat(int shopId) {
        List<SanPham> list = new ArrayList<>();
        String query = "WITH ProductQuantity AS (\n"
                + "  SELECT sp.id, SUM(ol.quantity) AS total_quantity\n"
                + "  FROM OrderLine ol \n"
                + "  JOIN SanPham sp ON ol.productID = sp.id\n"
                + "  JOIN HoaDon hd ON ol.invoiceID = hd.maHD\n"
                + "  WHERE sp.shopid = ? \n"
                + "    \n"
                + "  GROUP BY sp.id\n"
                + ")\n"
                + "SELECT TOP(5) sp.*, pq.total_quantity, pq.total_quantity * sp.price AS total_sales\n"
                + "FROM SanPham sp\n"
                + "JOIN ProductQuantity pq ON sp.id = pq.id\n"
                + "ORDER BY pq.total_quantity DESC;";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, shopId);
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
                        rs.getInt(16),
                        rs.getInt(18)
                ));
            }
        } catch (SQLException e) {
            System.out.println("top5SpBanChayNhat" + e.getMessage());
        }
        return list;
    }

    public void insertBillCOD(int accountid, long tongGia, String ngayXuat, int trangThaiId, int loaiid, int paymentid, int maThanhToanTrucTiep) {
        String sql = "insert into HoaDon (accountID, tongGia, ngayXuat, trangthaiid, loaiid, paymentid, maThanhToanTrucTiep) values (?, ?, ? ,?, ?, ?, ?)";
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, accountid);
            ps.setLong(2, tongGia);
            ps.setString(3, ngayXuat);
            ps.setInt(4, trangThaiId);
            ps.setInt(5, loaiid);
            ps.setInt(6, paymentid);
            ps.setInt(7, maThanhToanTrucTiep);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void insertBillVNPAY(int accountid, long tongGia, LocalDateTime ngayXuat, int trangThaiId, int loaiid, int paymentid, int maHoaDonTo) {
        String sql = "insert into HoaDon (accountID, tongGia, ngayXuat, trangthaiid, loaiid, paymentid, maHoaDonTo) values (?, ?, ? ,?, ?, ?, ?)";
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, accountid);
            ps.setLong(2, tongGia);

            Timestamp timestamp = Timestamp.valueOf(ngayXuat);
            ps.setTimestamp(3, timestamp);

            ps.setInt(4, trangThaiId);
            ps.setInt(5, loaiid);
            ps.setInt(6, paymentid);
            ps.setInt(7, maHoaDonTo);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void insertInfoLine(String name, String email, String address, String phonenumber, String note) {
        String sql = "insert into InfoLine ([invoiceID], [name], [email], [address], [phonenumber], [note]) SELECT TOP 1 [maHD], ?, ?, ?, ?, ? FROM [HoaDon] ORDER BY [maHD] DESC";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, address);
            ps.setString(4, phonenumber);
            ps.setString(5, note);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void insertOrderLine(int productID, float price, int quantity) {
        String sql = "INSERT INTO OrderLine ([invoiceID], [productID], [price], [quantity]) SELECT TOP 1 [maHD], ?, ?, ? FROM [HoaDon] ORDER BY [maHD] DESC";
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, productID);
            ps.setFloat(2, price);
            ps.setInt(3, quantity);

            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void insertSoLuongBan(int productID, int soLuongDaBan) {
        String sql = "INSERT INTO SoLuongBan (productID, soLuongDaBan) values (?, ?)";
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, productID);
            ps.setInt(2, soLuongDaBan);

            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void insertThanhToanVNPAY(int vnp_TxnRef, long vnp_Amount, String vnp_BankCode, String vnp_BankTranNo, String vnp_CardType, String vnp_OrderInfo, LocalDateTime vnp_PayDate, int vnp_ResponseCode, String vnp_TmnCode, int vnp_TransactionNo, String vnp_SecureHashType, String vnp_SecureHash) {
        String sql = "insert into [ThanhToanVNPAY] ([vnp_TxnRef], [vnp_Amount], [vnp_BankCode], [vnp_BankTranNo], [vnp_CardType], [vnp_OrderInfo], [vnp_PayDate],[vnp_ResponseCode], [vnp_TmnCode], [vnp_TransactionNo], [vnp_SecureHashType], [vnp_SecureHash]) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, vnp_TxnRef);
            ps.setLong(2, vnp_Amount);
            ps.setString(3, vnp_BankCode);
            ps.setString(4, vnp_BankTranNo);
            ps.setString(5, vnp_CardType);
            ps.setString(6, vnp_OrderInfo);

            Timestamp timestamp = Timestamp.valueOf(vnp_PayDate);
            ps.setTimestamp(7, timestamp);

            ps.setInt(8, vnp_ResponseCode);
            ps.setString(9, vnp_TmnCode);
            ps.setInt(10, vnp_TransactionNo);
            ps.setString(11, vnp_SecureHashType);
            ps.setString(12, vnp_SecureHash);

            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateQuantity(int quantity, int productID) {
        String sql = "update SanPham set quantity = ? where id = ? ";
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, quantity);
            ps.setInt(2, productID);

            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateSoLuongBan(int soLuongDaBan, int productID) {
        String sql = "update SoLuongBan set soLuongDaBan = ? where productID = ? ";
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, soLuongDaBan);
            ps.setInt(2, productID);

            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateTongChiTieu(double tongChiTieu, int uID) {
        String sql = "update [AccInfo] set [TongChiTieu] = ? where [uID] = ? ";
        try {
            ps = connection.prepareStatement(sql);
            ps.setDouble(1, tongChiTieu);
            ps.setInt(2, uID);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public SoLuongBan getSoLuongBanByID(int productID) {
        String sql = "select * from SoLuongBan where productID = ?  ";
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, productID);
            rs = ps.executeQuery();
            while (rs.next()) {
                int productid = rs.getInt(1);
                int soLuongDaBan = rs.getInt(2);

                SoLuongBan p = new SoLuongBan(productid, soLuongDaBan);
                return p;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public ArrayList<HoaDon> getHoaDonByMaHoaDonTo(int maHoaDonTo, int accountID) {
        ArrayList<HoaDon> list = new ArrayList<>();
        String query = " SELECT * FROM HoaDon WHERE maHoaDonTo = ? and accountID = ? ";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, maHoaDonTo);
            ps.setInt(2, accountID);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new HoaDon(rs.getInt(1),
                        rs.getInt(2),
                        rs.getDouble(3),
                        rs.getDate(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getInt(8),
                        rs.getInt(9)
                ));
            }
            System.out.println(list);
        } catch (Exception e) {
        }
        return list;
    }

   public List<SanPham> getOutOfProduct(int shopId) {
        List<SanPham> list = new ArrayList<>();
        String query = "select * from SanPham sp where sp.quantity = 0 and sp.shopid = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, shopId);
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
            System.out.println("getOutOfProduct" + e.getMessage());
        }
        return list;
    }

    public ArrayList<HoaDon> getHoaDonByMaHoaDonCOD(int maThanhToanTrucTiep, int accountID) {
        ArrayList<HoaDon> list = new ArrayList<>();
        String query = "SELECT * FROM HoaDon WHERE maThanhToanTrucTiep = ? and accountID = ? ";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, maThanhToanTrucTiep);
            ps.setInt(2, accountID);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new HoaDon(rs.getInt(1),
                        rs.getInt(2),
                        rs.getDouble(3),
                        rs.getDate(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getInt(8),
                        rs.getInt(9)
                ));
            }
            System.out.println(list);
        } catch (Exception e) {
        }
        return list;
    }

    public ArrayList<ShippingAddress> getShippingAddress(int accountID) {
        ArrayList<ShippingAddress> list = new ArrayList<>();
        String query = "select * from ShippingAddress where accountID = ? ";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, accountID);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new ShippingAddress(rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6)
                ));
            }
            System.out.println(list);
        } catch (Exception e) {

        }
        return list;
    }

    public void deleteOrderWaitting(String invoiceId) {
        String query = "DELETE FROM [dbo].[HoaDon]\n"
                + "      WHERE maHD = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, invoiceId);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("deleteOrderWaitting" + e.getMessage());
        }

    }

    public void deleteOrderLine(String invoiceId) {
        String query = "DELETE FROM [dbo].[OrderLine]\n"
                + "      WHERE invoiceID = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, invoiceId);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("deleteOrderLine" + e.getMessage());
        }
    }

    public void deleteÌnorLine(String invoiceId) {
        String query = "DELETE FROM [dbo].[InfoLine]\n"
                + "      WHERE invoiceID =?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, invoiceId);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("deleteÌnorLine" + e.getMessage());
        }
    }

    public void addFeedBack(int accid, int pID, String message, String image, int rate) {
        String query = "INSERT INTO [dbo].[NhanXet]\n"
                + "           ([accountID]\n"
                + "           ,[productID]\n"
                + "           ,[contentReview]\n"
                + "           ,[dateReview]\n"
                + "           ,[image]\n"
                + "           ,[voteStar])\n"
                + "     VALUES"
                + "           (?,?,?,?,?,?)";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, accid);
            ps.setInt(2, pID);
            ps.setString(3, message);
            ps.setDate(4, getCurrentDate());
            ps.setString(5, image);
            ps.setInt(6, rate);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("addFeedBack" + e.getMessage());
        }
    }

    public List<NhanXet> getListNhanXet(int accountID) {
        List<NhanXet> list = new ArrayList<>();
        String query = "Select * from NhanXet where accountID = ? ";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, accountID);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new NhanXet(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getDate(4), rs.getString(5), rs.getInt(6), rs.getInt(7)));
            }
        } catch (SQLException e) {
            System.out.println("getListNhanXet" + e.getMessage());
        }
        return list;
    }

    public List<OrderLine> getListOrderLine() {
        ArrayList<OrderLine> list = new ArrayList<>();
        String query = "select * from OrderLine";
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new OrderLine(rs.getInt(1), rs.getInt(2), rs.getFloat(3), rs.getInt(4)));
            }
        } catch (SQLException e) {
            System.out.println("getListOrderLine" + e.getMessage());
        }
        return list;
    }

    public List<HoaDon> listHoaDon(int accountID, int trangthaiid, java.sql.Date datea, java.sql.Date dateb) {
        ArrayList<HoaDon> list = new ArrayList<>();
        String query = "SELECT * from HoaDon h where accountID=? and trangthaiid=? and  h.ngayXuat between ? and ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, accountID);
            ps.setInt(2, trangthaiid);
            ps.setDate(3, datea);
            ps.setDate(4, dateb);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new HoaDon(rs.getInt(1), rs.getInt(2), rs.getDouble(3), rs.getDate(4), rs.getInt(5), rs.getInt(6), rs.getInt(7)));
            }
        } catch (SQLException e) {
            System.out.println("listHoaDon" + e.getMessage());
        }
        return list;
    }

    public List<OrderDTO> getListOrderDone(int accountID, int trangthaiid, java.sql.Date datea, java.sql.Date dateb) {
        ArrayList<OrderDTO> list = new ArrayList<>();
        String query = "select\n"
                + "                	h.maHD, h.ngayXuat, sp.image, sp.name, h.tongGia, sp.sale, sp.id as productId ,\n"
                + "                	(select count(1) from NhanXet nx where nx.accountID = a.uID and nx.productID =o.productID) as countfb\n"
                + "              from OrderLine o\n"
                + "                inner join HoaDon h on o.invoiceID = h.maHD\n"
                + "               inner join Account a on a.uID = h.accountID\n"
                + "                inner join SanPham sp on sp.id = o.productID\n"
                + "                where a.uID = ?\n"
                + "               and h.trangthaiid = ? and h.ngayXuat between ? and ? ";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, accountID);
            ps.setInt(2, trangthaiid);
            ps.setDate(3, datea);
            ps.setDate(4, dateb);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new OrderDTO(rs.getString(1), rs.getDate(2), rs.getString(3), rs.getString(4), rs.getDouble(5), rs.getInt(6), rs.getInt(8), rs.getString(7)));
            }
        } catch (SQLException e) {
            System.out.println("getListOrderLine" + e.getMessage());
        }
        return list;
    }
    
    public int countNumOfInvoiceByDay(int shopID, Date date1, Date date2) {
        String query = " select COUNT(hd.maHD) "
                + "from OrderLine ol  join HoaDon hd on hd.maHD = ol.invoiceID "
                + "join SanPham sp on ol.productID = sp.id "
                + "where sp.shopid = ? AND hd.ngayXuat BETWEEN ? AND ? ";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, shopID);
            ps.setDate(2, date1);
            ps.setDate(3, date2);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public int countNumOfCmtByDay(int shopID, Date date1, Date date2) {
        String query = "select count(*) from dbo.SanPham sp join dbo.NhanXet nx on sp.id = nx.productID where sp.shopid = ? "
                + "and nx.dateReview between ? and ? ";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, shopID);
            ps.setDate(2, date1);
            ps.setDate(3, date2);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public double calculateRevenueByDay(int shopID, Date date1, Date date2) {
        String query = "  select sum(sp.price) from HoaDon hd "
                + "join OrderLine ol on hd.maHD = ol.invoiceID "
                + "join SanPham sp on sp.id = ol.productID "
                + "where sp.shopid= ? and hd.ngayXuat between ? and ? ";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, shopID);
            ps.setDate(2, date1);
            ps.setDate(3, date2);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getDouble(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public int countNumOfRefundInvoice(int shopID) {
        String query = " select COUNT(hd.maHD) "
                + "from OrderLine ol  join HoaDon hd on hd.maHD = ol.invoiceID "
                + "join SanPham sp on ol.productID = sp.id "
                + "where sp.shopid = ? and hd.loaiid=2 ";
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

    public int countNumOfRefundInvoiceByDay(int shopID, Date date1, Date date2) {
        String query = " select COUNT(hd.maHD) "
                + "from OrderLine ol  join HoaDon hd on hd.maHD = ol.invoiceID "
                + "join SanPham sp on ol.productID = sp.id "
                + "where sp.shopid = ? and hd.loaiid=2 AND hd.ngayXuat BETWEEN ? AND ? ";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, shopID);
            ps.setDate(2, date1);
            ps.setDate(3, date2);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public List<SanPham> top5SpBanChayNhatByDay(int shopId, Date date1, Date date2) {
        List<SanPham> list = new ArrayList<>();
        String query = "WITH ProductQuantity AS (\n"
                + "  SELECT sp.id, SUM(ol.quantity) AS total_quantity\n"
                + "  FROM OrderLine ol \n"
                + "  JOIN SanPham sp ON ol.productID = sp.id\n"
                + "  JOIN HoaDon hd ON ol.invoiceID = hd.maHD\n"
                + "  WHERE sp.shopid = ? \n"
                + "    AND hd.ngayXuat BETWEEN ? AND ?\n"
                + "  GROUP BY sp.id\n"
                + ")\n"
                + "SELECT TOP(5) sp.*, pq.total_quantity, pq.total_quantity * sp.price AS total_sales\n"
                + "FROM SanPham sp\n"
                + "JOIN ProductQuantity pq ON sp.id = pq.id\n"
                + "ORDER BY pq.total_quantity DESC;";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, shopId);
            ps.setDate(2, date1);
            ps.setDate(3, date2);
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
                        rs.getInt(16),
                        rs.getInt(18)
                ));
            }
        } catch (SQLException e) {
            System.out.println("top5SpBanChayNhatByDay" + e.getMessage());
        }
        return list;
    }

    public HoaDon get1HoaDonto(int maHoaDonTo, int accountID) {
        try {
            String strSQL = "select top 1 * from HoaDon where maHoaDonTo = ? and accountID = ? ";
            ps = connection.prepareStatement(strSQL);
            ps.setInt(1, maHoaDonTo);
            ps.setInt(2, accountID);
            rs = ps.executeQuery();
            while (rs.next()) {
                int mahd = rs.getInt(1);
                int accountid = rs.getInt(2);
                double tonggia = rs.getDouble(3);
                Date ngayxuat = rs.getDate(4);
                int trangthai = rs.getInt(5);
                int loai = rs.getInt(5);

                HoaDon p = new HoaDon(rs.getInt(1),
                        rs.getInt(2),
                        rs.getDouble(3),
                        rs.getDate(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getInt(7)
                );
                return p;
            }
        } catch (Exception e) {
            System.out.println("getAccInfo: " + e.getMessage());
        }
        return null;
    }

    public HoaDon get1HoaDonThanhToanTT(int maThanhToanTrucTiep, int accountID) {
        try {
            String strSQL = "select top 1 * from HoaDon where maThanhToanTrucTiep = ? and accountID = ? ";
            ps = connection.prepareStatement(strSQL);
            ps.setInt(1, maThanhToanTrucTiep);
            ps.setInt(2, accountID);
            rs = ps.executeQuery();
            while (rs.next()) {
                int mahd = rs.getInt(1);
                int accountid = rs.getInt(2);
                double tonggia = rs.getDouble(3);
                Date ngayxuat = rs.getDate(4);
                int trangthai = rs.getInt(5);
                int loai = rs.getInt(5);

                HoaDon p = new HoaDon(rs.getInt(1),
                        rs.getInt(2),
                        rs.getDouble(3),
                        rs.getDate(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getInt(7)
                );
                return p;
            }
        } catch (Exception e) {
            System.out.println("getAccInfo: " + e.getMessage());
        }
        return null;
    }

    public InfoLine getInfoLineBill(int invoiceID) {
        try {
            String strSQL = "select * from InfoLine where invoiceID = ? ";
            ps = connection.prepareStatement(strSQL);
            ps.setInt(1, invoiceID);
            rs = ps.executeQuery();
            while (rs.next()) {
                int invoiceid = rs.getInt(1);
                String name = rs.getString(2);
                String email = rs.getString(3);
                String address = rs.getString(4);
                String phonenumber = rs.getString(5);
                String note = rs.getString(6);
                InfoLine p = new InfoLine(invoiceid, name, email, address, phonenumber, note);
                return p;
            }
        } catch (Exception e) {
            System.out.println("getAccInfo: " + e.getMessage());
        }
        return null;
    }

    public void insertShippingAddress(int accountID, String name, String email, String address, String phonenumber) {
        try {
            String strSQL = "insert into ShippingAddress ([accountID], [name], [email], [address], [phonenumber]) values (?, ?, ?, ?, ?) ";
            ps = connection.prepareStatement(strSQL);
            ps.setInt(1, accountID);
            ps.setString(2, name);
            ps.setString(3, email);
            ps.setString(4, address);
            ps.setString(5, phonenumber);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("insertShippingAddress: " + e.getMessage());
        }
    }

    public void updateShippingAddress(String name, String email, String address, String phonenumber, int shippingID) {
        try {
            String strSQL = "update ShippingAddress set [name] = ? , [email] = ? , [address] = ? , [phonenumber] = ? where shippingID = ? ";
            ps = connection.prepareStatement(strSQL);
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, address);
            ps.setString(4, phonenumber);
            ps.setInt(5, shippingID);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("insertShippingAddress: " + e.getMessage());
        }
    }

    public void deleteShippingAddress(int shippingID) {
        try {
            String strSQL = "  DELETE FROM ShippingAddress WHERE shippingID = ? ";
            ps = connection.prepareStatement(strSQL);
            ps.setInt(1, shippingID);

            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("daleteShippingAddress: " + e.getMessage());
        }
    }

    public ShippingAddress getShippingAddressByShippingId(int shippingID) {
        try {
            String strSQL = "select * from ShippingAddress where shippingID = ? ";
            ps = connection.prepareStatement(strSQL);
            ps.setInt(1, shippingID);
            rs = ps.executeQuery();
            while (rs.next()) {
                int shippingid = rs.getInt(1);
                int accountID = rs.getInt(2);
                String name = rs.getString(3);
                String email = rs.getString(4);
                String address = rs.getString(5);
                String phonenumber = rs.getString(6);
                ShippingAddress p = new ShippingAddress(shippingid, accountID, name, email, address, phonenumber);
                return p;
            }
        } catch (Exception e) {
            System.out.println("getAccInfo: " + e.getMessage());
        }
        return null;
    }

    public Account getAccById(int accountID) {
        try {
            String strSQL = "select * from Account where uID = ? ";
            ps = connection.prepareStatement(strSQL);
            ps.setInt(1, accountID);
            rs = ps.executeQuery();
            while (rs.next()) {
                int uid = rs.getInt(1);
                String user = rs.getString(2);
                String pass = rs.getString(3);
                int isSell = rs.getInt(4);
                int isAdmin = rs.getInt(5);
                int isCheck = rs.getInt(6);
                int isShip = rs.getInt(7);
                double accountBalance= rs.getInt(8);
                Account p = new Account(uid, user, pass, isSell, isAdmin, isCheck, isShip, accountBalance);
                return p;
            }
        } catch (Exception e) {
            System.out.println("getAccountById: " + e.getMessage());
        }
        return null;
    }

    public List<AccountBalance> getAccBalToday() {
        List<AccountBalance> list = new ArrayList<>();
        String query = "select * from AccountBalance where ngayXuat=?";
        try {
            ps = connection.prepareStatement(query);
            ps.setDate(1, getCurrentDate());

            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new AccountBalance(rs.getInt(1),
                        rs.getInt(2),
                        rs.getDouble(3),
                        rs.getDate(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getInt(7)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<AccountBalance> getTopAccBal12() {
        List<AccountBalance> list = new ArrayList<>();
        String query = "select top 4 * from AccountBalance where loaiid=1 or loaiid=2 order by accBalId desc";
        try {
            ps = connection.prepareStatement(query);
            

            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new AccountBalance(rs.getInt(1),
                        rs.getInt(2),
                        rs.getDouble(3),
                        rs.getDate(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getInt(7)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<AccountBalance> getTopAccBal34() {
        List<AccountBalance> list = new ArrayList<>();
        String query = "select top 4 * from AccountBalance where loaiid=3 or loaiid=4 order by accBalId desc";
        try {
            ps = connection.prepareStatement(query);
            

            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new AccountBalance(rs.getInt(1),
                        rs.getInt(2),
                        rs.getDouble(3),
                        rs.getDate(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getInt(7)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<AccountBalance> getTopAccBal() {
        List<AccountBalance> list = new ArrayList<>();
        String query = "select top 4 * from AccountBalance where ngayXuat!=? order by accBalId desc";
        try {
            ps = connection.prepareStatement(query);
            ps.setDate(1, getCurrentDate());

            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new AccountBalance(rs.getInt(1),
                        rs.getInt(2),
                        rs.getDouble(3),
                        rs.getDate(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getInt(7)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<ThanhToanVNPAY> getAllThanhToan() {
        List<ThanhToanVNPAY> list = new ArrayList<>();
        String query = "select * from ThanhToanVNPAY";
        try {
            ps = connection.prepareStatement(query);

            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new ThanhToanVNPAY(rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getDate(7).toLocalDate(),
                rs.getInt(8),
                rs.getString(9),
                rs.getInt(10),
                rs.getString(11),
                rs.getString(12)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<LoaiAccBal> getAllLoaiAccBal() {
        List<LoaiAccBal> list = new ArrayList<>();
        String query = "select * from LoaiAccBal";
        try {
            ps = connection.prepareStatement(query);

            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new LoaiAccBal(rs.getInt(1),
                        rs.getString(2)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public Shop getShopById1(int shopID) {
        String strSQL = "select * from Shop where shopid=?";
        try {
            ps = connection.prepareStatement(strSQL);
            ps.setInt(1, shopID);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Shop(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getDate(5), rs.getString(6), rs.getString(7), rs.getString(8),rs.getDouble(9));
            }
        } catch (SQLException e) {
            System.out.println("getShopById" + e.getMessage());
        }
        return null;
    }

    public List<ShopBalance> getTopShopBal123() {
        List<ShopBalance> list = new ArrayList<>();
        String query = "select top 4 * from ShopBalance where loaiid=1 or loaiid=2 or loaiid=3 order by shopBalId desc";
        try {
            ps = connection.prepareStatement(query);
            

            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new ShopBalance(rs.getInt(1),
                        rs.getInt(2),
                        rs.getDouble(3),
                        rs.getDate(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getInt(7),
                rs.getInt(8)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<ShopBalance> getTopShopBal45() {
        List<ShopBalance> list = new ArrayList<>();
        String query = "select top 4 * from ShopBalance where loaiid=4 or loaiid=5 order by shopBalId desc";
        try {
            ps = connection.prepareStatement(query);
            

            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new ShopBalance(rs.getInt(1),
                        rs.getInt(2),
                        rs.getDouble(3),
                        rs.getDate(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getInt(7),
                rs.getInt(8)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<ShopBalance> getShopBalToday() {
        List<ShopBalance> list = new ArrayList<>();
        String query = "select * from ShopBalance where ngayXuat=?";
        try {
            ps = connection.prepareStatement(query);
            ps.setDate(1, getCurrentDate());

            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new ShopBalance(rs.getInt(1),
                        rs.getInt(2),
                        rs.getDouble(3),
                        rs.getDate(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getInt(7),
                rs.getInt(8)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<ShopBalance> getTopShopBal() {
        List<ShopBalance> list = new ArrayList<>();
        String query = "select top 4 * from ShopBalance where ngayXuat!=? order by shopBalId desc";
        try {
            ps = connection.prepareStatement(query);
            ps.setDate(1, getCurrentDate());

            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new ShopBalance(rs.getInt(1),
                        rs.getInt(2),
                        rs.getDouble(3),
                        rs.getDate(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getInt(7),
                rs.getInt(8)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<LoaiShopBal> getAllLoaiShopBal() {
        List<LoaiShopBal> list = new ArrayList<>();
        String query = "select * from LoaiShopBal";
        try {
            ps = connection.prepareStatement(query);

            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new LoaiShopBal(rs.getInt(1),
                        rs.getString(2)));
            }
        } catch (Exception e) {
        }
        return list;
    }

}
