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
public class Coupon {
    private int shopId;
    private int maLoaiCou;
    private Date dateCoupon;
    private int maCoupon;

    public Coupon() {
    }

    public Coupon(int shopId, int maLoaiCou, Date dateCoupon, int maCoupon) {
        this.shopId = shopId;
        this.maLoaiCou = maLoaiCou;
        this.dateCoupon = dateCoupon;
        this.maCoupon = maCoupon;
    }

    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    public int getMaLoaiCou() {
        return maLoaiCou;
    }

    public void setMaLoaiCou(int maLoaiCou) {
        this.maLoaiCou = maLoaiCou;
    }

    public Date getDateCoupon() {
        return dateCoupon;
    }

    public void setDateCoupon(Date dateCoupon) {
        this.dateCoupon = dateCoupon;
    }

    public int getMaCoupon() {
        return maCoupon;
    }

    public void setMaCoupon(int maCoupon) {
        this.maCoupon = maCoupon;
    }
    
}
