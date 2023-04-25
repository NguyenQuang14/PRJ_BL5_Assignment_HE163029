/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class Shipping {

    private int id;
    private String name;
    private String phone;
    private String address;
    private int orderId;

    public Shipping() {
    }

    public Shipping(int id, String name, String phone, String address, int orderId) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.orderId = orderId;
    }

    public Shipping(String name, String phone, String address, int orderId) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.orderId = orderId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        return "Shipping{" + "id=" + id + ", name=" + name + ", phone=" + phone + ", address=" + address + ", orderId=" + orderId + '}';
    }

}
