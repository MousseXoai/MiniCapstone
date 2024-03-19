/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;


/**
 *
 * @author Acer
 */
public class InvoiceShipping {
    String invoiceID;
    String img;
    String name;
    String address;

    public InvoiceShipping() {
    }

    public InvoiceShipping(String invoiceID, String img, String name, String address) {
        this.invoiceID = invoiceID;
        this.img = img;
        this.name = name;
        this.address = address;
    }

    public String getInvoiceID() {
        return invoiceID;
    }

    public void setInvoiceID(String invoiceID) {
        this.invoiceID = invoiceID;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    
}
