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
public class Noti {
    private int shopId;
    private String contentNoti;
    private Date dateNoti;
    private int maNoti;

    public Noti() {
    }

    public Noti(int shopId, String contentNoti, Date dateNoti, int maNoti) {
        this.shopId = shopId;
        this.contentNoti = contentNoti;
        this.dateNoti = dateNoti;
        this.maNoti = maNoti;
    }

    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    public String getContentNoti() {
        return contentNoti;
    }

    public void setContentNoti(String contentNoti) {
        this.contentNoti = contentNoti;
    }

    public Date getDateNoti() {
        return dateNoti;
    }

    public void setDateNoti(Date dateNoti) {
        this.dateNoti = dateNoti;
    }

    public int getMaNoti() {
        return maNoti;
    }

    public void setMaNoti(int maNoti) {
        this.maNoti = maNoti;
    }
    
}
