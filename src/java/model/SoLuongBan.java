/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class SoLuongBan {
	  private int productID;
	  private int soLuongDaBan;
	public int getProductID() {
		return productID;
	}
	public SoLuongBan(int productID, int soLuongDaBan) {
	
		this.productID = productID;
		this.soLuongDaBan = soLuongDaBan;
	}
	public SoLuongBan() {
		
	}
	@Override
	public String toString() {
		return "SoLuongDaBan [productID=" + productID + ", soLuongDaBan=" + soLuongDaBan + "]";
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	public int getSoLuongDaBan() {
		return soLuongDaBan;
	}
	public void setSoLuongDaBan(int soLuongDaBan) {
		this.soLuongDaBan = soLuongDaBan;
	}
}
