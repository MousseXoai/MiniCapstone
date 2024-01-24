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
public class HoaDon {
	private int maHD;
	private int accountID;
	private double tongGia;
	Date ngayXuat;
        private int trangThaiId;
        private int loaiid;
        private int paymentid;

    public HoaDon() {
    }

    public HoaDon(int maHD, int accountID, double tongGia, Date ngayXuat, int trangThaiId, int loaiid, int paymentid) {
        this.maHD = maHD;
        this.accountID = accountID;
        this.tongGia = tongGia;
        this.ngayXuat = ngayXuat;
        this.trangThaiId = trangThaiId;
        this.loaiid = loaiid;
        this.paymentid = paymentid;
    }

    public int getMaHD() {
        return maHD;
    }

    public void setMaHD(int maHD) {
        this.maHD = maHD;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public double getTongGia() {
        return tongGia;
    }

    public void setTongGia(double tongGia) {
        this.tongGia = tongGia;
    }

    public Date getNgayXuat() {
        return ngayXuat;
    }

    public void setNgayXuat(Date ngayXuat) {
        this.ngayXuat = ngayXuat;
    }

    public int getTrangThaiId() {
        return trangThaiId;
    }

    public void setTrangThaiId(int trangThaiId) {
        this.trangThaiId = trangThaiId;
    }

    public int getLoaiid() {
        return loaiid;
    }

    public void setLoaiid(int loaiid) {
        this.loaiid = loaiid;
    }

    public int getPaymentid() {
        return paymentid;
    }

    public void setPaymentid(int paymentid) {
        this.paymentid = paymentid;
    }

    
        
    

   
	
}