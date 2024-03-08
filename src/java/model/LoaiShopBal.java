/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class LoaiShopBal {
    private int loaiid;
    private String loai;

    public LoaiShopBal() {
    }

    public LoaiShopBal(int loaiid, String loai) {
        this.loaiid = loaiid;
        this.loai = loai;
    }

    public int getLoaiid() {
        return loaiid;
    }

    public void setLoaiid(int loaiid) {
        this.loaiid = loaiid;
    }

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }
    
}
