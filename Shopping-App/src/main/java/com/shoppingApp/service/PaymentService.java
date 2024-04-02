package com.shoppingApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoppingApp.entity.Payment;
import com.shoppingApp.repository.PaymentRepo;

@Service
public class PaymentService {

	@Autowired
	PaymentRepo paymentRepo;
	
	public Payment save(Payment payment) {
		return paymentRepo.save(payment);
	}
}
