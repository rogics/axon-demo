package com.europoint.axonsubscriber.web;

import com.europoint.axonsubscriber.model.PaymentTransaction;
import com.europoint.axonsubscriber.app.PaymentTransactionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/")
public class PaymentTransactionController {

    private PaymentTransactionService paymentTransactionService;


    public PaymentTransactionController(PaymentTransactionService paymentTransactionService) {
        this.paymentTransactionService = paymentTransactionService;
    }



    @GetMapping({ "/GetAllPaymentTransactions" })
    public ResponseEntity<List<PaymentTransaction>> getAllPaymentTransactions() {
        return new ResponseEntity<List<PaymentTransaction>>(paymentTransactionService.findAll(), HttpStatus.OK);
    }
}
