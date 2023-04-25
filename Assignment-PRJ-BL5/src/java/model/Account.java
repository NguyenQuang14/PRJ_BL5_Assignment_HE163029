/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class Account {

    public static final int ADMIN = 1;
    public static final int USER = 0;
    private int id;
    private String name;
    private String password;
    private int role;

    public Account() {
    }

    public Account(int id, String name, String password, int role) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.role = role;
    }

    public Account(String username, String password, int role) {
        this.name = name;
        this.password = password;
        this.role = role;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Account{" + "id=" + id + ", name=" + name + ", password=" + password + ", role=" + role + '}';
    }

}
