package com.shoppingApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoppingApp.entity.Orders;
import com.shoppingApp.repository.OrderRepo;

@Service
public class OrderService {
	@Autowired
	OrderRepo orderRepo;
	
	public Orders save(Orders order) {
		return orderRepo.save(order);
	}
	
	public List<Orders> findAll(){
		return orderRepo.findAll();
	}
}
