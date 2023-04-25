/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Admin
 */
public class Product {

    private int id;
    private String name;
    private String image;
    private double price;
    private String description;
    private int quantity;
    private int categoryId;

    public Product(int id, String name, String image, double price, String description, int quantity, int categoryId) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.price = price;
        this.description = description;
        this.quantity = quantity;
        this.categoryId = categoryId;
    }

    public Product(String name, String image, double price, String description, int quantity, int categoryId) {
        this.name = name;
        this.image = image;
        this.price = price;
        this.description = description;
        this.quantity = quantity;
        this.categoryId = categoryId;
    }

    public Product() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

}
