/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;

/**
 *
 * @author Admin
 */
public class Shop {
    private int shopId;
    private String shopName;
    private String avatar;
    private Date dateThamGia;
    private String address;

    public Shop() {
    }

    public Shop(int shopId, String shopName, String avatar, Date dateThamGia, String address) {
        this.shopId = shopId;
        this.shopName = shopName;
        this.avatar = avatar;
        this.dateThamGia = dateThamGia;
        this.address = address;
    }

    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Date getDateThamGia() {
        return dateThamGia;
    }

    public void setDateThamGia(Date dateThamGia) {
        this.dateThamGia = dateThamGia;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    
    
}
