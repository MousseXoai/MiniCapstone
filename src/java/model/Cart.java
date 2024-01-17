/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;


import dal.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Admin
 */

public class Cart extends DBContext {
    private int accountID;
    private int productID;
    private int amount;
    private int maCart;

    public Cart() {

        connectDB();
    }

    public Cart(int accountID, int productID, int amount) {
        this.accountID = accountID;
        this.productID = productID;
        this.amount = amount;
        connectDB();
    }
       

    public Cart(int accountID, int productID, int amount, int maCart) {
        this.accountID = accountID;
        this.productID = productID;
        this.amount = amount;
        this.maCart = maCart;
        connectDB();
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

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getMaCart() {
        return maCart;
    }

    public void setMaCart(int maCart) {
        this.maCart = maCart;
    }
    

     Connection cnn;
    PreparedStatement stm;
    ResultSet rs;

    private void connectDB() {
        cnn = connection;
        if (cnn != null) {
            System.out.println("Connect success");
        } else {
            System.out.println("Connect fail");
        }
    }

    
}
