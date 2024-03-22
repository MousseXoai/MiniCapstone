/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Tosaka
 */
public class Reason {
    int reasonID;
    String reasonName;
    int reason_option;

    public Reason() {
    }

    public Reason(int reasonID, String reasonName, int reason_option) {
        this.reasonID = reasonID;
        this.reasonName = reasonName;
        this.reason_option = reason_option;
    }

    public int getReasonID() {
        return reasonID;
    }

    public void setReasonID(int reasonID) {
        this.reasonID = reasonID;
    }

    public String getReasonName() {
        return reasonName;
    }

    public void setReasonName(String reasonName) {
        this.reasonName = reasonName;
    }

    public int getReason_option() {
        return reason_option;
    }

    public void setReason_option(int reason_option) {
        this.reason_option = reason_option;
    }
    
    
}
