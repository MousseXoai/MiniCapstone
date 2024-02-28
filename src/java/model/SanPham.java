/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class SanPham {
    private int id;
    private String name;
    private String image;
    private double price;
    private int quantity;  
    private String title;
    private String description;
    private int cateID;
    private int branID;
    private String color;
    private String image2;
    private String image3;
    private String image4;
    private int shopID;
    private int sale;
    private int trangthai;
    private int totalRevenue;

    public SanPham() {
    }

    public SanPham(int id, String name, String image, double price, int quantity, String title, String description, int cateID, int branID, String color, String image2, String image3, String image4, int shopID, int sale, int trangthai) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.price = price;
        this.quantity = quantity;
        this.title = title;
        this.description = description;
        this.cateID = cateID;
        this.branID = branID;
        this.color = color;
        this.image2 = image2;
        this.image3 = image3;
        this.image4 = image4;
        this.shopID = shopID;
        this.sale = sale;
        this.trangthai = trangthai;

    }
    public SanPham(int id, String name, String image, double price, int quantity, String title, String description, int cateID, int branID, String color, String image2, String image3, String image4, int shopID, int sale, int trangthai, int totalRevenue) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.price = price;
        this.quantity = quantity;
        this.title = title;
        this.description = description;
        this.cateID = cateID;
        this.branID = branID;
        this.color = color;
        this.image2 = image2;
        this.image3 = image3;
        this.image4 = image4;
        this.shopID = shopID;
        this.sale = sale;
        this.trangthai = trangthai;
        this.totalRevenue = totalRevenue;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public int getCateID() {
        return cateID;
    }

    public void setCateID(int cateID) {
        this.cateID = cateID;
    }

    public int getBranID() {
        return branID;
    }

    public void setBranID(int branID) {
        this.branID = branID;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getImage2() {
        return image2;
    }

    public void setImage2(String image2) {
        this.image2 = image2;
    }

    public String getImage3() {
        return image3;
    }

    public void setImage3(String image3) {
        this.image3 = image3;
    }

    public String getImage4() {
        return image4;
    }

    public void setImage4(String image4) {
        this.image4 = image4;
    }

    public int getShopID() {
        return shopID;
    }

    public void setShopID(int shopID) {
        this.shopID = shopID;
    }

    public int getSale() {
        return sale;
    }

    public void setSale(int sale) {
        this.sale = sale;
    }

    public int getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(int trangthai) {
        this.trangthai = trangthai;
    }
    public int getTotalRevenue() {
        return totalRevenue;
    }

    public void setToalRevenue(int totalQuantity) {
        this.totalRevenue = totalQuantity;
    }
}
