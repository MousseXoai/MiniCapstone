/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class NotiCate {
    private int noticateid;
    private String noticate;

    public NotiCate() {
    }

    public NotiCate(int noticateid, String noticate) {
        this.noticateid = noticateid;
        this.noticate = noticate;
    }

    public int getNoticateid() {
        return noticateid;
    }

    public void setNoticateid(int noticateid) {
        this.noticateid = noticateid;
    }

    public String getNoticate() {
        return noticate;
    }

    public void setNoticate(String noticate) {
        this.noticate = noticate;
    }
    
}
