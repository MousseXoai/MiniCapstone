/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class Fee {
    private int shopID;
    private String contentInvoice;
    private double price;
    private int invoiceID;

    public Fee() {
    }

    public Fee(int shopID, String contentInvoice, double price, int invoiceID) {
        this.shopID = shopID;
        this.contentInvoice = contentInvoice;
        this.price = price;
        this.invoiceID = invoiceID;
    }

    public int getShopID() {
        return shopID;
    }

    public void setShopID(int shopID) {
        this.shopID = shopID;
    }

    public String getContentInvoice() {
        return contentInvoice;
    }

    public void setContentInvoice(String contentInvoice) {
        this.contentInvoice = contentInvoice;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getInvoiceID() {
        return invoiceID;
    }

    public void setInvoiceID(int invoiceID) {
        this.invoiceID = invoiceID;
    }
    
}
