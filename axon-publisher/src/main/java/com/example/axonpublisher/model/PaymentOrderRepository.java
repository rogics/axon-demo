package com.example.axonpublisher.model;


import com.example.axonpublisher.model.PaymentOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public
interface PaymentOrderRepository extends JpaRepository<PaymentOrder, String> {

}
