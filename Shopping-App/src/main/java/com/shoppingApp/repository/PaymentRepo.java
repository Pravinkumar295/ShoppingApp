package com.shoppingApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shoppingApp.entity.Payment;

public interface PaymentRepo extends JpaRepository<Payment, Long>{

}
