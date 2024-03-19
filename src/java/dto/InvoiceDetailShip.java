/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

/**
 *
 * @author Acer
 */
public class InvoiceDetailShip {

    String invoiceID;
    String status;
    String img;
    String name;
    String color;
    int quantity;
    double tonggia;
    String note;
    String cusName;
    String address;
    String email;
    String phonenumber;

    public InvoiceDetailShip() {
    }

    public InvoiceDetailShip(String invoiceID, String status, String img, String name, String color, int quantity, double tonggia, String note, String cusName, String address, String email, String phonenumber) {
        this.invoiceID = invoiceID;
        this.status = status;
        this.img = img;
        this.name = name;
        this.color = color;
        this.quantity = quantity;
        this.tonggia = tonggia;
        this.note = note;
        this.cusName = cusName;
        this.address = address;
        this.email = email;
        this.phonenumber = phonenumber;
    }

    public String getInvoiceID() {
        return invoiceID;
    }

    public void setInvoiceID(String invoiceID) {
        this.invoiceID = invoiceID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTonggia() {
        return tonggia;
    }

    public void setTonggia(double tonggia) {
        this.tonggia = tonggia;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }
    

}
