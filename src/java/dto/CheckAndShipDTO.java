/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

/**
 *
 * @author dell
 */
public class CheckAndShipDTO {
      private int uID;
    private String name;
    private String avatar;
    private String address;
    private String phonenumber;
    private String email;
   
    private String role;

    public CheckAndShipDTO() {
    }

    public CheckAndShipDTO(int uID, String name, String avatar, String address, String phonenumber, String email, String role) {
        this.uID = uID;
        this.name = name;
        this.avatar = avatar;
        this.address = address;
        this.phonenumber = phonenumber;
        this.email = email;
        this.role = role;
    }

    public int getuID() {
        return uID;
    }

    public void setuID(int uID) {
        this.uID = uID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

   
    
}
