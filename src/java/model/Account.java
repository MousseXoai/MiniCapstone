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
    private int isSell;
    private int isAdmin;
    private int isCheck;
    private int isShip;
    private double accountBalance;

    public Account() {
    }

    public Account(int uID, String user, String pass, int isSell, int isAdmin, int isCheck, int isShip, double accountBalance) {
        this.uID = uID;
        this.user = user;
        this.pass = pass;
        this.isSell = isSell;
        this.isAdmin = isAdmin;
        this.isCheck = isCheck;
        this.isShip = isShip;
        this.accountBalance = accountBalance;
    }
    

    public Account(int uID, String user, String pass,int isSell, int isAdmin, int isCheck, int isShip) {
        this.uID = uID;
        this.user = user;
        this.pass = pass;
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
