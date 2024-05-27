/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author MSI
 */
public class User {

    private String userName;
    private String password;
    private String email;
    private String phone;
    private String type;

    public User() {
    }

    public User(String userName, String password, String email, String phone, String type) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.type = type;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "User{" + "userName=" + userName + ", password=" + password + ", email=" + email + ", phone=" + phone + ", type=" + type + '}';
    }

}
