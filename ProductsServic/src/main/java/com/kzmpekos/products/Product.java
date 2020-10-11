package com.kzmpekos.products;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class Product {
    @Id
    @Column(name = "product_id", nullable = false)
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment",strategy = "increment")
    private int productId;
    @Basic
    @Column(name = "name", nullable = false, length = 50)
    private String name;
    @Basic
    @Column(name = "farmer_id", nullable = false)
    private int farmerId;
    @Basic
    @Column(name = "quantity", nullable = false)
    private int quantity;
    @Basic
    @Column(name = "price_per_unit", nullable = false, precision = 0)
    private float pricePerUnit;

    public Product() {
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
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
        return pricePerUnit;
    }

    public void setPricePerUnit(float pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }
}
