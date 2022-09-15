package com.europoint.axonsubscriber.eventhandlers;

import com.europoint.axonsubscriber.app.PaymentTransactionService;
import com.europoint.axonsubscriber.model.PaymentTransaction;
import com.europoint.publisherapi.events.PaymentOrderCreatedEvent;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@ProcessingGroup("PaymentOrderSaga")
public class PaymentOrderSaga {
    private final Logger logger = LoggerFactory.getLogger(PaymentOrderSaga.class);

    private PaymentTransactionService paymentTransactionService;

    public PaymentOrderSaga(PaymentTransactionService paymentTransactionService) {
        this.paymentTransactionService = paymentTransactionService;
    }

    @EventHandler
    void on(PaymentOrderCreatedEvent event) {
        logger.info("PaymentOrderSaga - EventHandler for PaymentOrderCreatedEvent started: "+event.toString());
        paymentTransactionService.create(new PaymentTransaction(event.getId(),event.getAmount()));
    }

}
