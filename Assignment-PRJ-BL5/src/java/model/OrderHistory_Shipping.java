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
public class OrderHistory_Shipping {

    private int shippingId;
    private String name;
    private String phone;
    private String address;
    private Date createdDate;
    private Date confirmDate;
    private int orderId;

    public OrderHistory_Shipping() {
    }

    public OrderHistory_Shipping(int shippingId, String name, String phone, String address, Date createdDate, Date confirmDate) {
        this.shippingId = shippingId;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.createdDate = createdDate;
        this.confirmDate = confirmDate;
    }

    public OrderHistory_Shipping(int shippingId, String name, String phone, String address, Date createdDate) {
        this.shippingId = shippingId;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.createdDate = createdDate;
    }

    public OrderHistory_Shipping(int shippingId, String name, String phone, String address, Date createdDate, int orderId) {
        this.shippingId = shippingId;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.createdDate = createdDate;
        this.orderId = orderId;
    }

    public int getShippingId() {
        return shippingId;
    }

    public void setShippingId(int shippingId) {
        this.shippingId = shippingId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getConfirmDate() {
        return confirmDate;
    }

    public void setConfirmDate(Date confirmDate) {
        this.confirmDate = confirmDate;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        return "OrderHistory_Shipping{" + "shippingId=" + shippingId + ", name=" + name + ", phone=" + phone + ", address=" + address + ", createdDate=" + createdDate + ", confirmDate=" + confirmDate + ", orderId=" + orderId + '}';
    }

}
