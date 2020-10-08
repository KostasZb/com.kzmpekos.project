package com.kzmpekos.products;

import javax.persistence.*;

@Entity
public class Product {
    private int productId;
    private String name;
    private int farmerId;
    private int quantity;
    private double pricePerUnit;

    @Id
    @Column(name = "product_id", nullable = false)
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 50)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "farmer_id", nullable = false)
    public int getFarmerId() {
        return farmerId;
    }

    public void setFarmerId(int farmerId) {
        this.farmerId = farmerId;
    }

    @Basic
    @Column(name = "quantity", nullable = false)
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Basic
    @Column(name = "price_per_unit", nullable = false, precision = 0)
    public double getPricePerUnit() {
        return pricePerUnit;
    }

    public void setPricePerUnit(double pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product products = (Product) o;

        if (productId != products.productId) return false;
        if (farmerId != products.farmerId) return false;
        if (quantity != products.quantity) return false;
        if (Double.compare(products.pricePerUnit, pricePerUnit) != 0) return false;
        if (name != null ? !name.equals(products.name) : products.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = productId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + farmerId;
        result = 31 * result + quantity;
        temp = Double.doubleToLongBits(pricePerUnit);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
