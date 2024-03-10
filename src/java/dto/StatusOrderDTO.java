/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

/**
 *
 * @author ADMIN
 */
public class StatusOrderDTO {
    int trangthaiid;
    String trangthai;
    int maHD;

    public StatusOrderDTO() {
    }

    public StatusOrderDTO(int trangthaiid, String trangthai, int maHD) {
        this.trangthaiid = trangthaiid;
        this.trangthai = trangthai;
        this.maHD = maHD;
    }

    public int getTrangthaiid() {
        return trangthaiid;
    }

    public void setTrangthaiid(int trangthaiid) {
        this.trangthaiid = trangthaiid;
    }

    public String getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }

    public int getMaHD() {
        return maHD;
    }

    public void setMaHD(int maHD) {
        this.maHD = maHD;
    }
    
}
