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
public class Report {
    private int reportID;
    private int shopID;
    private int accountID;
    private int reasonID;
    private int status;   
    Date ngayReport;
    private String description;
    private String image1;
    private String appeal;
    private String image2;

    public Report() {
    }

    public Report(int reportID, int shopID, int accountID, int reasonID, int status, Date ngayReport, String description, String image1, String appeal, String image2) {
        this.reportID = reportID;
        this.shopID = shopID;
        this.accountID = accountID;
        this.reasonID = reasonID;
        this.status = status;
        this.ngayReport = ngayReport;
        this.description = description;
        this.image1 = image1;
        this.appeal = appeal;
        this.image2 = image2;
    }

    

    public int getReportID() {
        return reportID;
    }

    public void setReportID(int reportID) {
        this.reportID = reportID;
    }

    public int getShopID() {
        return shopID;
    }

    public void setShopID(int shopID) {
        this.shopID = shopID;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public Date getNgayReport() {
        return ngayReport;
    }

    public void setNgayReport(Date ngayReport) {
        this.ngayReport = ngayReport;
    }

    public int getReasonID() {
        return reasonID;
    }

    public void setReasonID(int reasonID) {
        this.reasonID = reasonID;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage1() {
        return image1;
    }

    public void setImage1(String image1) {
        this.image1 = image1;
    }

    public String getAppeal() {
        return appeal;
    }

    public void setAppeal(String appeal) {
        this.appeal = appeal;
    }

    public String getImage2() {
        return image2;
    }

    public void setImage2(String image2) {
        this.image2 = image2;
    }

    
    
}
