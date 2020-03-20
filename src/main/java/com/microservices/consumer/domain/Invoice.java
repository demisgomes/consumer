package com.microservices.consumer.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class Invoice {
    @Id
    @GeneratedValue
    private Long id;
    private String provider;
    private String purchaseDate;
    private BigDecimal purchaseAmount;

    public Invoice() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public Invoice(Long id, String provider, String purchaseDate, BigDecimal purchaseAmount) {
        this.id = id;
        this.provider = provider;
        this.purchaseDate = purchaseDate;
        this.purchaseAmount = purchaseAmount;
    }

    public BigDecimal getPurchaseAmount() {
        return purchaseAmount;
    }

    public void setPurchaseAmount(BigDecimal purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }
}
