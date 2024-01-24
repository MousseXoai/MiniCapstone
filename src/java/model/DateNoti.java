/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class DateNoti {
    private int maNoti;
    private int date;

    public DateNoti() {
    }

    public DateNoti(int maNoti, int date) {
        this.maNoti = maNoti;
        this.date = date;
    }

    public int getMaNoti() {
        return maNoti;
    }

    public void setMaNoti(int maNoti) {
        this.maNoti = maNoti;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }
    
}
