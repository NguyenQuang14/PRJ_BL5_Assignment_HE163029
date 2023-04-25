/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;

/**
 *
 * @author Admin
 */
public class Order {

    private int id;
    private int accountId;
    private double totalPrice;
    private String note;
    private Date createdDate;

    public Order() {
    }

    public Order(int id, int accountId, double totalPrice, String note, Date createdDate) {
        this.id = id;
        this.accountId = accountId;
        this.totalPrice = totalPrice;
        this.note = note;
        this.createdDate = createdDate;
    }

    public Order(int accountId, double totalPrice, String note) {
        this.accountId = accountId;
        this.totalPrice = totalPrice;
        this.note = note;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }



    @Override
    public String toString() {
        return "Order{" + "id=" + id + ", accountId=" + accountId + ", totalPrice=" + totalPrice + ", note=" + note + ", createdDate=" + createdDate + '}';
    }

}
