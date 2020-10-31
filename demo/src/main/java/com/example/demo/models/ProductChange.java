package com.example.demo.models;

public class ProductChange {
    private int quantity;
    private float pricePerUnit;
    private int productId;

    public ProductChange() {
    }


    public ProductChange(int quantity, float pricePerUnit, int productId) {
        this.quantity = quantity;
        this.pricePerUnit = pricePerUnit;
        this.productId = productId;
    }


    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPricePerUnit() {
        return pricePerUnit;
    }

    public void setPricePerUnit(float pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }
}
