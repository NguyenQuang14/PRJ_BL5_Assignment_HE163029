/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class OrderInfo {

    private int orderId;
    private String FirstName;
    private String LastName;
    private String phone;
    private String email;
    private double totalPrice;
    private String createdDate;

    public OrderInfo() {
    }

    public OrderInfo(int orderId, String FirstName, String LastName, String phone, String email, double totalPrice, String createdDate) {
        this.orderId = orderId;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.phone = phone;
        this.email = email;
        this.totalPrice = totalPrice;
        this.createdDate = createdDate;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public String getName() {
        return FirstName+" "+LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "OrderInfo{" + "orderId=" + orderId + ", FirstName=" + FirstName + ", LastName=" + LastName + ", phone=" + phone + ", email=" + email + ", totalPrice=" + totalPrice + ", createdDate=" + createdDate + '}';
    }

}
