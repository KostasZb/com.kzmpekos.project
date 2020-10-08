package com.kzmpekos.users;

import javax.persistence.*;

@Entity
public class User {
    @Id
    @Column(name="userId",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    @Basic
    @Column(name = "address_id", nullable = false)
    private int addressId;
    @Basic
    @Column(name = "name", nullable = false, length = 50)
    private String name;
    @Basic
    @Column(name = "email", nullable = false, length = 50)
    private String email;
    @Basic
    @Column(name = "password", nullable = false, length = 50)
    private String password;
    @Basic
    @Column(name = "isFarmer", nullable = false)
    private boolean isFarmer;

    public boolean getIsFarmer() {
        return isFarmer;
    }

    public void setIsFarmer(boolean isFarmer) {
        this.isFarmer = isFarmer;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isFarmer() {
        return isFarmer;
    }

    public void setFarmer(boolean farmer) {
        isFarmer = farmer;
    }
}
