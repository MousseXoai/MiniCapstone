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
    Date ngayReport;
    private String content;
    private String image;

    public Report() {
    }

    public Report(int reportID, int shopID, int accountID, Date ngayReport, String content, String image) {
        this.reportID = reportID;
        this.shopID = shopID;
        this.accountID = accountID;
        this.ngayReport = ngayReport;
        this.content = content;
        this.image = image;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    
}
