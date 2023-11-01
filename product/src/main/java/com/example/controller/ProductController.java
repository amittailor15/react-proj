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

import com.example.Repository.ProductRepository;
import com.example.model.Product;

@RestController
@RequestMapping("/product1")
public class ProductController {
	
	@Autowired
	ProductRepository productRepository;
	
	@PostMapping("/product")
	public String create(@RequestBody Product product)
	{
		productRepository.save(product);
		return "Product created";
	}
	
	@GetMapping("/product")
	public ResponseEntity<List<Product>> getAllProducts()
	{
		List <Product> pr = new ArrayList<>(); 
		productRepository.findAll().forEach(pr::add); 
		return new ResponseEntity<List<Product>>(pr, HttpStatus.OK);
	}
	
	@GetMapping("/product/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable long id)
	{ 
		Optional<Product> p = productRepository.findById(id);
		if(p.isPresent()) 
		{
			return new ResponseEntity<Product>(p.get(), HttpStatus.FOUND);
		}
		else 
		{
			return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/products/{id}")
	public String deleteProductByEmpId(@PathVariable long id) 
	{ 
		productRepository.deleteById(id); 
		return "Product Deleted Successfully";
	}
	
	@DeleteMapping("/products")
	public String deleteAllProduct()
	{ 
		productRepository.deleteAll(); 
		return "Product deleted Successfully..";
	}
}
