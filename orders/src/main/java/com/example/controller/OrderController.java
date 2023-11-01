package com.example.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Repository.OrderRepository;
import com.example.Repository.OrderService;
import com.example.model.Order;

@RestController
@RequestMapping("/order1")
public class OrderController {
	
 	@Autowired
	OrderService orderService;
 	
 	@Autowired
	OrderRepository orderRepository;
	
	@PostMapping("/order")
	public String create(@RequestBody Order order)
	{
		orderRepository.save(order);
		//orderService.addOrder(order);
		return "Order created";
	}
	
	@GetMapping("/order")
	public ResponseEntity<List<Order>> getAllOrders()
	{
		List <Order> pr = new ArrayList<>(); 
		orderRepository.findAll().forEach(pr::add); 
		return new ResponseEntity<List<Order>>(pr, HttpStatus.OK);
	}
	
	@GetMapping("/order/{id}")
	public ResponseEntity<Order> getOrderById(@PathVariable long id)
	{ 
		Optional<Order> p = orderRepository.findById(id);
		if(p.isPresent()) 
		{
			return new ResponseEntity<Order>(p.get(), HttpStatus.FOUND);
		}
		else 
		{
			return new ResponseEntity<Order>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/orders/{id}")
	public String deleteOrderByEmpId(@PathVariable long id) 
	{ 
		orderRepository.deleteById(id); 
		return "Order Deleted Successfully";
	}
	
	@DeleteMapping("/orders")
	public String deleteAllOrder()
	{ 
		orderRepository.deleteAll(); 
		return "Order deleted Successfully..";
	}
}
