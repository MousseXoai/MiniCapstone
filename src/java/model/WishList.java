/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class WishList {
    private int accountID;
    private int productID;
    private int maWishList;

    public WishList() {
    }

    public WishList(int accountID, int productID, int maWishList) {
        this.accountID = accountID;
        this.productID = productID;
        this.maWishList = maWishList;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getMaWishList() {
        return maWishList;
    }

    public void setMaWishList(int maWishList) {
        this.maWishList = maWishList;
    }
    
}
