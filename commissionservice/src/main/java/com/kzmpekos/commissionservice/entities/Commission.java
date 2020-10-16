package com.kzmpekos.commissionservice.entities;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Commission {
    @Id
    @Column(name="orderId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;
    @Basic
    @Column(name = "userId")
    private int userId;
    @Basic
    @Column(name = "farmerId")
    private int farmerId;
    @Basic
    @Column(name = "timestamp")
    private Timestamp timestamp;
    @Basic
    @Column(name = "totalCost")
    private float totalCost;

    public Commission() {
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        userId = userId;
    }

    public int getFarmerId() {
        return farmerId;
    }

    public void setFarmerId(int farmerId) {
        this.farmerId = farmerId;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public float getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(float totalCost) {
        totalCost = totalCost;
    }



}

