package com.example.demo.models;

public class NewProduct {
    String name;
    int farmerId;
    int quantity;
    float PricePerUnit;

    public NewProduct() {
    }

    public NewProduct(String name, int farmerId, int quantity, float price_per_unit) {
        this.name = name;
        this.farmerId = farmerId;
        this.quantity = quantity;
        this.PricePerUnit = price_per_unit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFarmerId() {
        return farmerId;
    }

    public void setFarmerId(int farmerId) {
        this.farmerId = farmerId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPricePerUnit() {
        return PricePerUnit;
    }

    public void setPricePerUnit(float price_per_unit) {
        this.PricePerUnit = price_per_unit;
    }
}
