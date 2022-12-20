package com.europoint.axonsubscriber.eventhandlers;

import com.europoint.publisherapi.events.PaymentOrderCreatedEvent;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.SequenceNumber;
import org.axonframework.modelling.saga.SagaEventHandler;
import org.axonframework.modelling.saga.StartSaga;
import org.axonframework.spring.stereotype.Saga;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@ProcessingGroup("PaymentOrderIdempotentSaga")
@Saga
public class PaymentOrderIdempotentSaga {

    private final Logger logger = LoggerFactory.getLogger(PaymentOrderIdempotentSaga.class);

    private Long paymentOrderCreatedEventLatestSequenceNumber = -1L;

    @StartSaga
    @SagaEventHandler(associationProperty = "Id")
    public void on(PaymentOrderCreatedEvent event, @SequenceNumber Long sequenceNumber) {
        logger.info("PaymentOrderIdempotentSaga - EventHandler for PaymentOrderCreatedEvent started: "+event.toString()+" seq:"+sequenceNumber.toString());
        if (paymentOrderCreatedEventLatestSequenceNumber > sequenceNumber) {
            
            //Do something
            paymentOrderCreatedEventLatestSequenceNumber=sequenceNumber;
        }
        else {
            logger.warn("Duplicate event received!");
        }
    }
}
