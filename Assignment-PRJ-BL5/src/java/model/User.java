/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class User {

    private int id;
    private String fristName;
    private String lastName;
    private Date birthday;
    private boolean gender;
    private String email;
    private String phone;
    private String address;
    private int accountID;

    public User() {
    }

    public User(int id, String fristName, String lastName, Date birthday, boolean gender, String email, String phone, String address, int accountID) {
        this.id = id;
        this.fristName = fristName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.gender = gender;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.accountID = accountID;
    }

    public User(String fristName, String lastName, String email, String phone, int accountID) {        
        this.fristName = fristName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.accountID = accountID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFristName() {
        return fristName;
    }

    public void setFristName(String fristName) {
        this.fristName = fristName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public boolean isGender() {
        return gender;
    }

    public String getGender() {
        Boolean a = true;
        String trueOut = "true";
        String falseOut = "false";
        if (a.compareTo(gender) == 0) {
            return trueOut;
        }
        return falseOut;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", fristName=" + fristName + ", lastName=" + lastName + ", birthday=" + birthday + ", gender=" + gender + ", email=" + email + ", phone=" + phone + ", address=" + address + ", accountID=" + accountID + '}';
    }

}
