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
    private int uID;
    private int trangthai;
    private String image;
    private String contentNoti;
    private Date dateNoti;
    private int noticateid;
    private int maNoti;

    public Noti() {
    }

    public Noti(int shopId, int uID, int trangthai, String image, String contentNoti, Date dateNoti, int noticateid, int maNoti) {
        this.shopId = shopId;
        this.uID = uID;
        this.trangthai = trangthai;
        this.image = image;
        this.contentNoti = contentNoti;
        this.dateNoti = dateNoti;
        this.noticateid = noticateid;
        this.maNoti = maNoti;
    }

    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    public int getuID() {
        return uID;
    }

    public void setuID(int uID) {
        this.uID = uID;
    }

    public int getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(int trangthai) {
        this.trangthai = trangthai;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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

    public int getNoticateid() {
        return noticateid;
    }

    public void setNoticateid(int noticateid) {
        this.noticateid = noticateid;
    }

    public int getMaNoti() {
        return maNoti;
    }

    public void setMaNoti(int maNoti) {
        this.maNoti = maNoti;
    }

    
    
}
