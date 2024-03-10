/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class ShopBalance {
    private int shopBalId;
    private int shopID;
    private double amount;
    Date ngayXuat;
    private int loaiid;
    private int maHD;
    private int maShopHD;
    private int maThanhToan;

    public ShopBalance() {
    }

    public ShopBalance(int shopBalId, int shopID, double amount, Date ngayXuat, int loaiid, int maShopHD, int maThanhToan) {
        this.shopBalId = shopBalId;
        this.shopID = shopID;
        this.amount = amount;
        this.ngayXuat = ngayXuat;
        this.loaiid = loaiid;
        this.maShopHD = maShopHD;
        this.maThanhToan = maThanhToan;
    }

    public ShopBalance(int shopBalId, int shopID, double amount, Date ngayXuat, int loaiid, int maHD, int maShopHD, int maThanhToan) {
        this.shopBalId = shopBalId;
        this.shopID = shopID;
        this.amount = amount;
        this.ngayXuat = ngayXuat;
        this.loaiid = loaiid;
        this.maHD = maHD;
        this.maShopHD = maShopHD;
        this.maThanhToan = maThanhToan;
    }
    

    public int getShopBalId() {
        return shopBalId;
    }

    public void setShopBalId(int shopBalId) {
        this.shopBalId = shopBalId;
    }

    public int getShopID() {
        return shopID;
    }

    public void setShopID(int shopID) {
        this.shopID = shopID;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getNgayXuat() {
        return ngayXuat;
    }

    public void setNgayXuat(Date ngayXuat) {
        this.ngayXuat = ngayXuat;
    }

    public int getLoaiid() {
        return loaiid;
    }

    public void setLoaiid(int loaiid) {
        this.loaiid = loaiid;
    }

    public int getMaShopHD() {
        return maShopHD;
    }

    public void setMaShopHD(int maShopHD) {
        this.maShopHD = maShopHD;
    }

    public int getMaThanhToan() {
        return maThanhToan;
    }

    public void setMaThanhToan(int maThanhToan) {
        this.maThanhToan = maThanhToan;
    }

    public int getMaHD() {
        return maHD;
    }

    public void setMaHD(int maHD) {
        this.maHD = maHD;
    }
    
}
