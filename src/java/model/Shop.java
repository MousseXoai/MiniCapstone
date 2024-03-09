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
    private int accountid;
    private Date dateThamGia;
    private String address;
    private String proof;
    private String proof1;
    private double shopBalance;


    public Shop() {
    }

    public Shop(int shopId, String shopName, String avatar, int accountid, Date dateThamGia, String address, String proof) {
        this.shopId = shopId;
        this.shopName = shopName;
        this.avatar = avatar;
        this.accountid = accountid;
        this.dateThamGia = dateThamGia;
        this.address = address;
        this.proof = proof;
    }

    public Shop(int shopId, String shopName, String avatar, int accountid, Date dateThamGia, String address, String proof, String proof1, double shopBalance) {
        this.shopId = shopId;
        this.shopName = shopName;
        this.avatar = avatar;
        this.accountid = accountid;
        this.dateThamGia = dateThamGia;
        this.address = address;
        this.proof = proof;
        this.proof1 = proof1;
        this.shopBalance = shopBalance;
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

    public int getAccountid() {
        return accountid;
    }

    public void setAccountid(int accountid) {
        this.accountid = accountid;
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

    public String getProof() {
        return proof;
    }

    public void setProof(String proof) {
        this.proof = proof;
    }

    public String getProof1() {
        return proof1;
    }

    public void setProof1(String proof1) {
        this.proof1 = proof1;
    }

    public double getShopBalance() {
        return shopBalance;
    }

    public void setShopBalance(double shopBalance) {
        this.shopBalance = shopBalance;
    }
    
}
