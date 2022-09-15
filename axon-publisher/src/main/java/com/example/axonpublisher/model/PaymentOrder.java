package com.example.axonpublisher.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Version;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
public
class PaymentOrder {

    @Id
    private UUID id;
    private String payer;

    private String recipient;

    private BigDecimal amount;
    @Version
    private Long version;

    public PaymentOrder( String payer, String recipient, BigDecimal amount) {
        this.id = UUID.randomUUID();
        this.payer = payer;
        this.recipient = recipient;
        this.amount = amount;
    }

    protected PaymentOrder() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getPayer() {
        return payer;
    }

    public void setPayer(String paymentInstruction) {
        this.payer = paymentInstruction;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}
