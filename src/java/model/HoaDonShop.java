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
public class HoaDonShop {
    private int maShopHD;
    private int shopID;
    private double amount;
    Date ngayXuat;
    private int status;

    public HoaDonShop() {
    }

    public HoaDonShop(int maShopHD, int shopID, double amount, Date ngayXuat, int status) {
        this.maShopHD = maShopHD;
        this.shopID = shopID;
        this.amount = amount;
        this.ngayXuat = ngayXuat;
        this.status = status;
    }

    public int getMaShopHD() {
        return maShopHD;
    }

    public void setMaShopHD(int maShopHD) {
        this.maShopHD = maShopHD;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
}
