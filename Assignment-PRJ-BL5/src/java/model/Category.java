/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

//import lombok.Builder;
//import lombok.Getter;
//import lombok.Setter;
//import lombok.ToString;
//
///**
// *
// * @author Admin
// */
//@Builder
//@Getter
//@Setter
//@ToString
public class Category {

    private int id;
    private String name;
    private int quantity;

    public Category() {
    }

    public Category(int id, String name, int quantity) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Category{" + "id=" + id + ", name=" + name + ", quantity=" + quantity + '}';
    }

   
}
