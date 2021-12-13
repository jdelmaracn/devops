package com.accenture.ws.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.ws.entity.cafeClerk;
import com.accenture.ws.entity.order;
import com.accenture.ws.repository.OrderRepository;
import com.accenture.ws.service.OrderService;

@RestController
public class OrderAndBillingController {
	
	@Autowired
	private OrderService orderService ;
	cafeClerk clerk;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/getorderlist")
	List<order> getOrderList(){
		return orderService.getOrderList();
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/addorder")
	order addOrder(@RequestBody order orderData) {
		return orderService.addOrderToDB(orderData);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/getorderbyid/{id}")
	Optional<order> addOrder(@PathVariable int id) {
		return Optional.ofNullable(orderService.fetchOrderByID(id).get());
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("/deleteorderbyid/{id}")
	String deleteOrderByID(@PathVariable int id) {
		return orderService.deleteOrderByID(id);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/updateorderbyid/{id}")
	ResponseEntity<order> updateOrderByID(@PathVariable int id, @RequestBody order orderData){

		order o = orderService.fetchOrderByID(id)
				.orElseThrow();
		o.setOrder_id(id);
		o.setOrder_name(orderData.getOrder_name());
		o.setPrice(orderData.getPrice());
		o.setIs_discounted(orderData.isIs_discounted());
		o.setDiscount_percentage(5);
		final order updatedOrder = orderService.addOrderToDB(o);
		return ResponseEntity.ok(updatedOrder);
		
	}
	

	

}
