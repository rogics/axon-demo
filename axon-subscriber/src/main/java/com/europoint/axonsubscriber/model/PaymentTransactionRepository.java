package com.europoint.axonsubscriber.model;


import com.europoint.axonsubscriber.model.PaymentTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public
interface PaymentTransactionRepository extends JpaRepository<PaymentTransaction, String> {

}
