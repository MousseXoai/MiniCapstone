/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class Account {

    private int uID;
    private String user;
    private String pass;
    private String email;
    private String phonenumber;
    private String address;
    private String gender;
    private String code;
    private int isSell;
    private int isAdmin;
    private int isCheck;
    private int isShip;

    public Account() {
    }

    public Account(int uID, String user, String pass, String email, String phonenumber, String address, String gender, String code, int isSell, int isAdmin, int isCheck, int isShip) {
        this.uID = uID;
        this.user = user;
        this.pass = pass;
        this.email = email;
        this.phonenumber = phonenumber;
        this.address = address;
        this.gender = gender;
        this.code = code;
        this.isSell = isSell;
        this.isAdmin = isAdmin;
        this.isCheck = isCheck;
        this.isShip = isShip;
    }
    
     public Account(String user, String pass) {
        
        this.user = user;
        this.pass = pass;

    }

    public int getuID() {
        return uID;
    }

    public void setuID(int uID) {
        this.uID = uID;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        if ("male".equalsIgnoreCase(gender) || "female".equalsIgnoreCase(gender)) {
            this.gender = gender;
        } else {
            throw new IllegalArgumentException("Giới tính chỉ có thể là 'male' hoặc 'female'");
        }
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getIsSell() {
        return isSell;
    }

    public void setIsSell(int isSell) {
        this.isSell = isSell;
    }

    public int getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(int isAdmin) {
        this.isAdmin = isAdmin;
    }

    public int getIsCheck() {
        return isCheck;
    }

    public void setIsCheck(int isCheck) {
        this.isCheck = isCheck;
    }

    public int getIsShip() {
        return isShip;
    }

    public void setIsShip(int isShip) {
        this.isShip = isShip;
    }

}
