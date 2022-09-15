package com.example.axonpublisher.web;

import com.example.axonpublisher.model.PaymentOrder;
import com.example.axonpublisher.app.PaymentOrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/api/")
public class PaymentOrderController {

    private PaymentOrderService paymentOrderService;


    public PaymentOrderController(PaymentOrderService paymentOrderService) {
        this.paymentOrderService = paymentOrderService;
    }

    @PostMapping({ "/CreatePaymentOrder" })
    public ResponseEntity<UUID> createPaymentOrder(@RequestBody CreatePaymentOrderRequest req) {
        var newPO = new PaymentOrder(req.getPayer(),req.getRecipient(),req.getAmount());
        paymentOrderService.create(newPO);
        return new ResponseEntity<UUID>(newPO.getId(), HttpStatus.OK);
    }


    @GetMapping({ "/GetAllPaymentOrders" })
    public ResponseEntity<List<PaymentOrder>> getAllPaymentOrders() {
        return new ResponseEntity<List<PaymentOrder>>(paymentOrderService.findAll(), HttpStatus.OK);
    }
}
