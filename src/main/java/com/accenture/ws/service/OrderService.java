package com.accenture.ws.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.ws.entity.order;
import com.accenture.ws.repository.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	OrderRepository orderRepository;
	
	public List<order> getOrderList(){
		return orderRepository.findAll();
	}
	
	public order addOrderToDB(order orderData) {
		return orderRepository.save(orderData);
	}
	
	public Optional<order> fetchOrderByID(int id) {
		return orderRepository.findById(id);
	}
	
	public String deleteOrderByID(int id) {
		String result;
		try {
			orderRepository.deleteById(id);
			result = "Delete Successful";
		}catch(Exception e) {
			result = "Delete Unsuccessful";
		}
		return result;
	}
	
}
