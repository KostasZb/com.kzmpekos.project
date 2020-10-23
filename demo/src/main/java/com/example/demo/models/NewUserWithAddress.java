package com.example.demo.models;

public class NewUserWithAddress {
    private String email;
    private String password;
    private String name;
    private String city;
    private String postcode;
    private String address;
    private boolean farmer;

    public NewUserWithAddress(String email, String password, String name, String city, String postcode, String address, boolean farmer) {

        this.email = email;
        this.password = password;
        this.name = name;
        this.city = city;
        this.postcode = postcode;
        this.address = address;
        this.farmer = farmer;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isFarmer() {
        return farmer;
    }

    public void setFarmer(boolean farmer) {
        this.farmer = farmer;
    }
}
