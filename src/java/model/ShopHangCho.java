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
public class ShopHangCho {
    private int id;
    private String shopName;
    private String user;
    private String pass;
    private String email;
    private String proof;
    private String proof1;
    private Date dateThamGia;
    private String address;

    public ShopHangCho() {
    }

    public ShopHangCho(int id, String shopName, String user, String pass, String email, String proof, String proof1, Date dateThamGia, String address) {
        this.id = id;
        this.shopName = shopName;
        this.user = user;
        this.pass = pass;
        this.email = email;
        this.proof = proof;
        this.proof1 = proof1;
        this.dateThamGia = dateThamGia;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
