/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author admin
 */
public class Follow {
    private int followId;
    private int shopId;
    private int accountID;
    Date dateFollow;

    public Follow() {
    }

    public Follow(int followId, int shopId, int accountID, Date dateFollow) {
        this.followId = followId;
        this.shopId = shopId;
        this.accountID = accountID;
        this.dateFollow = dateFollow;
    }

    public int getFollowId() {
        return followId;
    }

    public void setFollowId(int followId) {
        this.followId = followId;
    }

    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public Date getDateFollow() {
        return dateFollow;
    }

    public void setDateFollow(Date dateFollow) {
        this.dateFollow = dateFollow;
    }
    
}
