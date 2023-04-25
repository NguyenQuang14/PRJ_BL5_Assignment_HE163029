/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class OrderHistory_Product {
    private int orderId;
    private String name;
    private String image;
    private double price;
    private int quantity;

    public OrderHistory_Product() {
    }

    public OrderHistory_Product(int orderId, String name, String image, double price, int quantity) {
        this.orderId = orderId;
        this.name = name;
        this.image = image;
        this.price = price;
        this.quantity = quantity;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "OrderHistory_Product{" + "orderId=" + orderId + ", name=" + name + ", image=" + image + ", price=" + price + ", quantity=" + quantity + '}';
    }
    
    
}
