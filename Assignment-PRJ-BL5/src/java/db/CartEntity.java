/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

/**
 *
 * @author Dell
 */
public class CartEntity {

    private int accountID;
    private int productID;
    private int amount;

    @Override
    public String toString() {
        return "CartEntity{" + "accountID=" + accountID + ", productID=" + productID + ", amount=" + amount + '}';
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public CartEntity(int accountID, int productID, int amount) {
        this.accountID = accountID;
        this.productID = productID;
        this.amount = amount;
    }

    public CartEntity() {
    }
}
