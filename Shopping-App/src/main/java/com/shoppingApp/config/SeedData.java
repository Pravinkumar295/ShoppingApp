package com.shoppingApp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.shoppingApp.entity.Inventory;
import com.shoppingApp.entity.OrdersList;
import com.shoppingApp.service.InventoryService;
import com.shoppingApp.service.ListService;

@Component
public class SeedData implements CommandLineRunner{

	@Autowired
	InventoryService inventoryService;
	
	@Autowired
	ListService listService;
	
	@Override
	public void run(String... args) throws Exception {
		Inventory inventory = new Inventory();
		inventory.setOrdered(0);
		inventory.setPrice(100);
		inventory.setAvailable(100);
		inventoryService.save(inventory);
		
		OrdersList list =new OrdersList();
		list.setOrderId(100);
		list.setAmount(950);
		list.setDate("25-11-2021");
		list.setCoupon("OFF5");
		listService.save(list);
		
		OrdersList list02 =new OrdersList();
		list02.setOrderId(101);
		list02.setAmount(950);
		list02.setDate("25-11-2021");
		list02.setCoupon("OFF5");
		listService.save(list02);
		
	}
}
