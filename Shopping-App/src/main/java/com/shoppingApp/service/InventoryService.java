package com.shoppingApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoppingApp.entity.Inventory;
import com.shoppingApp.repository.InventoryRepo;

@Service
public class InventoryService {
	
	@Autowired
	InventoryRepo inventoryRepo;
	
	public Inventory save(Inventory inventory) {
		return inventoryRepo.save(inventory);
	}
	
	public List<Inventory> findAll() {
		return inventoryRepo.findAll();
	}
}
