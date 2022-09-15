package com.europoint.axonsubscriber.app;


import com.europoint.axonsubscriber.model.PaymentTransaction;
import com.europoint.axonsubscriber.model.PaymentTransactionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class PaymentTransactionService {
    final private PaymentTransactionRepository paymentTransactionRepository;

    public PaymentTransactionService(PaymentTransactionRepository paymentTransactionRepository) {
        this.paymentTransactionRepository = paymentTransactionRepository;
    }

    @Transactional
    public PaymentTransaction create(PaymentTransaction paymentTransaction) {
        paymentTransactionRepository.save(paymentTransaction);
        return paymentTransaction;
    }

    public List<PaymentTransaction> findAll() {
        return paymentTransactionRepository.findAll();
    }
}
