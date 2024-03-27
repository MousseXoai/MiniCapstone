/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Tosaka
 */
public class RefundReason {
    int refundReason;
    int maHD;
    int reasonID;
    String note;

    public RefundReason() {
    }

    public RefundReason(int refundReason, int maHD, int reasonID, String note) {
        this.refundReason = refundReason;
        this.maHD = maHD;
        this.reasonID = reasonID;
        this.note = note;
    }

    public int getRefundReason() {
        return refundReason;
    }

    public void setRefundReason(int refundReason) {
        this.refundReason = refundReason;
    }

    public int getMaHD() {
        return maHD;
    }

    public void setMaHD(int maHD) {
        this.maHD = maHD;
    }

    public int getReasonID() {
        return reasonID;
    }

    public void setReasonID(int reasonID) {
        this.reasonID = reasonID;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
    
}
