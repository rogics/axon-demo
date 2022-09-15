package com.europoint.publisherapi.events;

import java.math.BigDecimal;
import java.util.UUID;

public class PaymentOrderCreatedEvent {
    private UUID id;

    private String payer;

    private String recipient;

    private BigDecimal amount;


    public PaymentOrderCreatedEvent(UUID id, String payer, String recipient, BigDecimal amount) {
        this.id = id;
        this.payer = payer;
        this.recipient = recipient;
        this.amount = amount;
    }

    public UUID getId() {
        return id;
    }

    public String getPayer() {
        return payer;
    }

    public String getRecipient() {
        return recipient;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "PaymentOrderCreatedEvent{" +
                "id=" + id +
                ", payer='" + payer + '\'' +
                ", recipient='" + recipient + '\'' +
                ", amount=" + amount +
                '}';
    }
}
