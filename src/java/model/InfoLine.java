/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class InfoLine {
    private int invoiceID;
    private String name;
    private String email;
    private String address;
    private String phonenumber;
    private String note;

    public InfoLine() {
    }

    public InfoLine(int invoiceID, String name, String email, String address, String phonenumber, String note) {
        this.invoiceID = invoiceID;
        this.name = name;
        this.email = email;
        this.address = address;
        this.phonenumber = phonenumber;
        this.note = note;
    }

    public int getInvoiceID() {
        return invoiceID;
    }

    public void setInvoiceID(int invoiceID) {
        this.invoiceID = invoiceID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }
    
    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
    @Override
    public String toString() {
        return "InfoLine{" + "invoiceID=" + invoiceID + ", name=" + name + ", email=" + email + ", address=" + address + ", phonenumber=" + phonenumber + ", note=" + note + '}';
    }

}
