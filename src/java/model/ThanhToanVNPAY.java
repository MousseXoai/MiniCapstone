/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;

/**
 *
 * @author Tosaka
 */
public class ThanhToanVNPAY {
    int vnp_TxnRef;
    int vnp_Amount;
    String vnp_BankCode;
    String vnp_BankTranNo;
    String vnp_CardType;
    String vnp_OrderInfo;
    LocalDate vnp_PayDate;
    int vnp_ResponseCode;
    String vnp_TmnCode;
    int vnp_TransactionNo;
    String vnp_SecureHashType;
    String vnp_SecureHash;

    public ThanhToanVNPAY() {
    }

    public ThanhToanVNPAY(int vnp_TxnRef, int vnp_Amount, String vnp_BankCode, String vnp_BankTranNo, String vnp_CardType, String vnp_OrderInfo, LocalDate vnp_PayDate, int vnp_ResponseCode, String vnp_TmnCode, int vnp_TransactionNo, String vnp_SecureHashType, String vnp_SecureHash) {
        this.vnp_TxnRef = vnp_TxnRef;
        this.vnp_Amount = vnp_Amount;
        this.vnp_BankCode = vnp_BankCode;
        this.vnp_BankTranNo = vnp_BankTranNo;
        this.vnp_CardType = vnp_CardType;
        this.vnp_OrderInfo = vnp_OrderInfo;
        this.vnp_PayDate = vnp_PayDate;
        this.vnp_ResponseCode = vnp_ResponseCode;
        this.vnp_TmnCode = vnp_TmnCode;
        this.vnp_TransactionNo = vnp_TransactionNo;
        this.vnp_SecureHashType = vnp_SecureHashType;
        this.vnp_SecureHash = vnp_SecureHash;
    }

    public int getVnp_TxnRef() {
        return vnp_TxnRef;
    }

    public void setVnp_TxnRef(int vnp_TxnRef) {
        this.vnp_TxnRef = vnp_TxnRef;
    }

    public int getVnp_Amount() {
        return vnp_Amount;
    }

    public void setVnp_Amount(int vnp_Amount) {
        this.vnp_Amount = vnp_Amount;
    }

    public String getVnp_BankCode() {
        return vnp_BankCode;
    }

    public void setVnp_BankCode(String vnp_BankCode) {
        this.vnp_BankCode = vnp_BankCode;
    }

    public String getVnp_BankTranNo() {
        return vnp_BankTranNo;
    }

    public void setVnp_BankTranNo(String vnp_BankTranNo) {
        this.vnp_BankTranNo = vnp_BankTranNo;
    }

    public String getVnp_CardType() {
        return vnp_CardType;
    }

    public void setVnp_CardType(String vnp_CardType) {
        this.vnp_CardType = vnp_CardType;
    }

    public String getVnp_OrderInfo() {
        return vnp_OrderInfo;
    }

    public void setVnp_OrderInfo(String vnp_OrderInfo) {
        this.vnp_OrderInfo = vnp_OrderInfo;
    }

    public LocalDate getVnp_PayDate() {
        return vnp_PayDate;
    }

    public void setVnp_PayDate(LocalDate vnp_PayDate) {
        this.vnp_PayDate = vnp_PayDate;
    }

    public int getVnp_ResponseCode() {
        return vnp_ResponseCode;
    }

    public void setVnp_ResponseCode(int vnp_ResponseCode) {
        this.vnp_ResponseCode = vnp_ResponseCode;
    }

    public String getVnp_TmnCode() {
        return vnp_TmnCode;
    }

    public void setVnp_TmnCode(String vnp_TmnCode) {
        this.vnp_TmnCode = vnp_TmnCode;
    }

    public int getVnp_TransactionNo() {
        return vnp_TransactionNo;
    }

    public void setVnp_TransactionNo(int vnp_TransactionNo) {
        this.vnp_TransactionNo = vnp_TransactionNo;
    }

    public String getVnp_SecureHashType() {
        return vnp_SecureHashType;
    }

    public void setVnp_SecureHashType(String vnp_SecureHashType) {
        this.vnp_SecureHashType = vnp_SecureHashType;
    }

    public String getVnp_SecureHash() {
        return vnp_SecureHash;
    }

    public void setVnp_SecureHash(String vnp_SecureHash) {
        this.vnp_SecureHash = vnp_SecureHash;
    }
  
    
}
