/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.sql.Date;

/**
 *
 * @author dell
 */
public class AdminShopData {
    private int shopID;
    private String shopName;
    private Date dateThamGia;
    private int totalRevenue;
    private int totalSales;

    public AdminShopData() {
    }

    public AdminShopData(int shopID, String shopName, Date dateThamGia, int totalRevenue, int totalSales) {
        this.shopID = shopID;
        this.shopName = shopName;
        this.dateThamGia = dateThamGia;
        this.totalRevenue = totalRevenue;
        this.totalSales = totalSales;
    }

 

    public int getShopID() {
        return shopID;
    }

    public void setShopID(int shopID) {
        this.shopID = shopID;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public Date getDateThamGia() {
        return dateThamGia;
    }

    public void setDateThamGia(Date dateThamGia) {
        this.dateThamGia = dateThamGia;
    }

    public int getTotalRevenue() {
        return totalRevenue;
    }

    public void setTotalRevenue(int totalRevenue) {
        this.totalRevenue = totalRevenue;
    }

    public int getTotalSales() {
        return totalSales;
    }

    public void setTotalSales(int totalSales) {
        this.totalSales = totalSales;
    }

   

  
}
