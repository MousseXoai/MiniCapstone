/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import jakarta.servlet.http.Part;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
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
import model.Star;
import model.TrangThai;
import model.WishList;

/**
 *
 * @author Admin
 */
public class DAO extends DBContext{
    PreparedStatement ps = null;
    ResultSet rs = null;

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
        }
        return list;
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
        }
        return null;
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

    public List<SanPham> getProductNew() {
        List<SanPham> list = new ArrayList<>();
        String query = "select top 5 * from SanPham order by [id] desc ";
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
        String query = "select * from SanPham where [name] like ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, "%" + txt + "%");
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
                        rs.getInt(5),
                        rs.getInt(6)
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
    
    //get product in cart by account
    public ArrayList<Cart> getProductInCartByAccId(int accountID){
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
    public Cart getAmountProductIdInCart(int productID){
        try {
            String strSQL = "select * from Cart where productID = ? ";
            ps = connection.prepareStatement(strSQL);
            ps.setInt(1, productID);
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
    public ArrayList<SanPham> getAllProduct(){
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
    public double getTotalPrice(int accountID){
        double total = 0;
        try {
            String strSQL = "select SUM(price*amount) as total from Cart as c join SanPham as sp on sp.id = c.productID where c.accountID = ? ";
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
    
    public void removeProductIdInCart(int productID, int accountID){
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
    
    public AccInfo getAccInfo(int uID){
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
                AccInfo p = new AccInfo(uid, name, avatar, address, phonenumber,email, tongchitieu);
                return p;
            }
        } catch (Exception e) {
            System.out.println("getAccInfo: " + e.getMessage());
        }
        return null;
    }
    
    public void editAccInfo(String name, String address, String phonenumber, String email, int uID){
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
    
    public ArrayList<HoaDon> getAllHoaDon(int accountID){
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
                
                HoaDon p = new HoaDon(mahd, accountid, tonggia, ngayxuat, trangthai);
                list.add(p);
            }
        } catch (Exception e) {
            System.out.println("getAllHoaDon: " + e.getMessage());
        }
        return list;
    }
    
    public ArrayList<OrderLine> getAllOrderLine(){
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
    
    public ArrayList<TrangThai> getAllTrangThai(){
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
    
    public InfoLine getInfoLine(int invoiceID){
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
    
    public HoaDon getHoaDon(int invoiceID){
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
                
                HoaDon p = new HoaDon(mahd, accountid, tonggia, ngayxuat, trangthai);
                return p;
            }
        } catch (Exception e) {
            System.out.println("getAccInfo: " + e.getMessage());
        }
        return null;
    }
    
    public TrangThai getTrangThai(int trangthaiid){
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
    public OrderLine getOrderLine(int invoiceID){
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
    
}
