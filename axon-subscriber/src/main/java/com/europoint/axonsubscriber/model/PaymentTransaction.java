package com.europoint.axonsubscriber.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Version;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
public
class PaymentTransaction {

    @Id
    private UUID id;

    private BigDecimal amount;


    public PaymentTransaction(UUID id, BigDecimal amount) {
        this.id = id;
        this.amount = amount;
    }

    protected PaymentTransaction() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }


}
