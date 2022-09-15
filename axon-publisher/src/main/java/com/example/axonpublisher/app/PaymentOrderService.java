package com.example.axonpublisher.app;

import com.europoint.publisherapi.events.PaymentOrderCreatedEvent;
import com.example.axonpublisher.model.PaymentOrder;
import com.example.axonpublisher.model.PaymentOrderRepository;
import org.axonframework.eventhandling.EventBus;
import org.axonframework.eventhandling.GenericDomainEventMessage;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentOrderService {
    final private PaymentOrderRepository paymentOrderRepository;
    final private EventBus eventBus;

    public PaymentOrderService(PaymentOrderRepository paymentOrderRepository, EventBus eventBus) {
        this.paymentOrderRepository = paymentOrderRepository;
        this.eventBus = eventBus;
    }

    @Transactional
    public PaymentOrder create(PaymentOrder paymentOrder) {
        PaymentOrder entity;

        try {
            entity = paymentOrderRepository.save(paymentOrder);
            eventBus.publish(new GenericDomainEventMessage<PaymentOrderCreatedEvent>(
                            "PaymentOrderAggregate",
                            entity.getId().toString(),
                            entity.getVersion(),
                            new PaymentOrderCreatedEvent(
                                    entity.getId(),
                                    entity.getPayer(),
                                    entity.getRecipient(),
                                    entity.getAmount()
                            )
                    )
            );
        } catch (Exception e) {
            throw new CreatePaymentOrderException();
        }
        return entity;
    }

    public List<PaymentOrder> findAll() {
        return paymentOrderRepository.findAll();
    }

    public Optional<PaymentOrder> findById(String paymentOrderId) {
        return paymentOrderRepository.findById(paymentOrderId);
    }

}
