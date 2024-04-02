package com.shoppingApp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.shoppingApp.entity.Inventory;
import com.shoppingApp.entity.Orders;
import com.shoppingApp.entity.OrdersList;
import com.shoppingApp.entity.Payment;
import com.shoppingApp.service.InventoryService;
import com.shoppingApp.service.ListService;
import com.shoppingApp.service.OrderService;
import com.shoppingApp.service.PaymentService;

@RestController
public class EntityController {
	
	@Autowired
	InventoryService inventoryService;
	
	@Autowired
	OrderService orderService;
	
	@Autowired
	PaymentService paymentService;
	
	@Autowired
	ListService listService;
	
	@GetMapping("/inventory")
	public ResponseEntity<List<Inventory>> getAllEntities() {
		 List<Inventory> inventoryList = inventoryService.findAll();
	        HttpStatus status = HttpStatus.OK;
	        return new ResponseEntity<>(inventoryList, status);
    }
	
	 @GetMapping("/fetchCoupon")
	    public Map<String, Integer> getCoupons() {
	        Map<String, Integer> coupons = new HashMap<>();
	        coupons.put("OFF5", 5);
	        coupons.put("OFF10", 10);
	        return coupons;
	    }
	 
	 @PostMapping("/{userId}/order")
	    public Orders getOrderDetails(@PathVariable int userId,
	                                 @RequestParam int qty,
	                                 @RequestParam String coupon) {
	        int amount = qty * 100;
	        int finalAmount = amount;
	        
	        if(qty<1 || qty>100) {
	        	throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid quantity");
	        }
	        if (!isValidCoupon(coupon)) {
	            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid coupon");
	        }
	        if (coupon.equals("OFF5")) {
	            finalAmount = amount - 5 * qty;
	        } else if (coupon.equals("OFF10")) {
	            finalAmount = amount - 10 * qty;
	        } else {
	            System.out.println("Invalid coupon");
	            // You might want to throw an exception or return an error response instead
	        }

	        Orders order01 = new Orders();
	        order01.setOrderId(100);
	        order01.setUserId(userId);
	        order01.setQuantity(qty);
	        order01.setAmount(finalAmount);
	        order01.setCoupon(coupon);

	        return orderService.save(order01);
	    }
	 
	 @PostMapping("/{userId}/{orderId}/pay")
	 public Payment getPaymentDetails(@PathVariable int userId,@PathVariable int orderId,@RequestParam int amount) {
		Payment payment = new Payment();
		if(amount!=950) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Payment Failed as amount is invalid");
		}
		if(orderId>=100) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Payment Failed due to invalid order id");
		}
		payment.setUserId(userId);
		payment.setOrderId(orderId);
		payment.setTransactionId("tran010100001");
		payment.setStatus("successful");
		 
		return paymentService.save(payment);		 
	 }
	 
	 @GetMapping("/{userId}/orders")
	 public ResponseEntity<List<OrdersList>>oList(@PathVariable String userId) {
		 HttpStatus status = HttpStatus.OK;
		 List<OrdersList> ordersList = listService.findAll();
	     return new ResponseEntity<>(ordersList, status);
	 }
	 
	 @GetMapping("/{userId}/orders/{orderId}"
	 		+ "")
	 public ResponseEntity<List<OrdersList>>oLists(@PathVariable String userId ,@PathVariable String orderId) {
		 HttpStatus status = HttpStatus.OK;
		 List<OrdersList> ordersList = listService.findAll();
		 if(!orderId.equals(1)) {
	    	 status = HttpStatus.NOT_FOUND;
	    	 return new ResponseEntity<>(ordersList,status);
	     }
	     return new ResponseEntity<>(ordersList, status);
	     
	 }
	 
	 
	public boolean isValidCoupon(String coupon) {
		if(coupon.equals("OFF5")) {
			return true;
		}
		else if (coupon.equals("OFF10")) {
			return true;
		}
		else {
			return false;
		}
	}
}