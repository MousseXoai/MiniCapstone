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
public class AccountBalance {
    private int accBalId;
    private int accountID;
    private double amout;
    Date ngayXuat;
    private int loaiid;
    private int maHD;
    private int maThanhToan;

    public AccountBalance() {
    }

    public AccountBalance(int accBalId, int accountID, double amout, Date ngayXuat, int loaiid, int maHD, int maThanhToan) {
        this.accBalId = accBalId;
        this.accountID = accountID;
        this.amout = amout;
        this.ngayXuat = ngayXuat;
        this.loaiid = loaiid;
        this.maHD = maHD;
        this.maThanhToan = maThanhToan;
    }

    public int getAccBalId() {
        return accBalId;
    }

    public void setAccBalId(int accBalId) {
        this.accBalId = accBalId;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public double getAmout() {
        return amout;
    }

    public void setAmout(double amout) {
        this.amout = amout;
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

    public int getMaHD() {
        return maHD;
    }

    public void setMaHD(int maHD) {
        this.maHD = maHD;
    }

    public int getMaThanhToan() {
        return maThanhToan;
    }

    public void setMaThanhToan(int maThanhToan) {
        this.maThanhToan = maThanhToan;
    }
    
}
