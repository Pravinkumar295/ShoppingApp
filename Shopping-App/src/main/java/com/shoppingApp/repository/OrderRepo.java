package com.shoppingApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shoppingApp.entity.Orders;

public interface OrderRepo extends JpaRepository<Orders, Long>{

}
