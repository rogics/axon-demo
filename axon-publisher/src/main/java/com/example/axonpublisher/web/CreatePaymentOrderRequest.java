package com.example.axonpublisher.web;

import java.math.BigDecimal;

public class CreatePaymentOrderRequest {
    private String payer;
    private String recipient;
    private BigDecimal amount;

    public CreatePaymentOrderRequest(String payer, String recipient, BigDecimal amount) {
        this.payer = payer;
        this.recipient = recipient;
        this.amount = amount;
    }

    public String getPayer() {
        return payer;
    }

    public void setPayer(String payer) {
        this.payer = payer;
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
}
