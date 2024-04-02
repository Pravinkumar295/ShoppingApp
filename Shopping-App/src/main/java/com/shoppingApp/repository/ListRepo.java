package com.shoppingApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shoppingApp.entity.OrdersList;

public interface ListRepo extends JpaRepository<OrdersList, Long>{

}
