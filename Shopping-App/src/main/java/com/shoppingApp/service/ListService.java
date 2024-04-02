package com.shoppingApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoppingApp.entity.OrdersList;
import com.shoppingApp.repository.ListRepo;

@Service
public class ListService {
	@Autowired
	ListRepo listRepo;
	
	public OrdersList save (OrdersList list) {
		return listRepo.save(list);
	}
	
	public List<OrdersList> findAll(){
		return listRepo.findAll();
	}
}
