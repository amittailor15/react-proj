package com.example.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.example.model.Order;

@Service
public class OrderService {
	
	@Autowired
	OrderRepository orderRepository;
	public Order addOrder(Order o) {
		System.out.println(o.getProduct()+"   product ");
		return orderRepository.save(o);
		
	}

}
