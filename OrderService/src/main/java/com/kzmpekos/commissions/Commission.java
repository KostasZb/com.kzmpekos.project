package com.kzmpekos.commissions;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Commission {
    @Id
    @Column(name="orderId",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;
    @Basic
    @Column(name = "UserId", nullable = false)
    private int UserId;
    @Basic
    @Column(name = "farmerId", nullable = false)
    private int farmerId;
    @Basic
    @Column(name = "timestamp", nullable = false)
    private Timestamp timestamp;
    @Basic
    @Column(name = "TotalCost", nullable = false)
    private float TotalCost;

    public Commission() {
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
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
        return TotalCost;
    }

    public void setTotalCost(float totalCost) {
        TotalCost = totalCost;
    }



}

