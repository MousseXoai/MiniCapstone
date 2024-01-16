/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class TrangThai {
    private int trangThaiId;
    private String trangThai;

    public TrangThai() {
    }

    public TrangThai(int trangThaiId, String trangThai) {
        this.trangThaiId = trangThaiId;
        this.trangThai = trangThai;
    }

    public int getTrangThaiId() {
        return trangThaiId;
    }

    public void setTrangThaiId(int trangThaiId) {
        this.trangThaiId = trangThaiId;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
    
}
