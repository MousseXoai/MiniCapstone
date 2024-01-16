/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class LoaiCou {
    private String contentCoupon;
    private int maLoaiCou;

    public LoaiCou() {
    }

    public LoaiCou(String contentCoupon, int maLoaiCou) {
        this.contentCoupon = contentCoupon;
        this.maLoaiCou = maLoaiCou;
    }

    public String getContentCoupon() {
        return contentCoupon;
    }

    public void setContentCoupon(String contentCoupon) {
        this.contentCoupon = contentCoupon;
    }

    public int getMaLoaiCou() {
        return maLoaiCou;
    }

    public void setMaLoaiCou(int maLoaiCou) {
        this.maLoaiCou = maLoaiCou;
    }
    
}
