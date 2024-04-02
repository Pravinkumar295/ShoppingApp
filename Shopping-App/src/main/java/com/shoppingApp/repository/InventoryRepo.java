package com.shoppingApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shoppingApp.entity.Inventory;

public interface InventoryRepo extends JpaRepository<Inventory, Long>{

}
