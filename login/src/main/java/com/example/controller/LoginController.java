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

import com.example.Repository.LoginRepository;
import com.example.model.Login;

@RestController
@RequestMapping("/Login1")
public class LoginController {
	
	@Autowired
	LoginRepository LoginRepository;
	
	@PostMapping("/Login")
	public String create(@RequestBody Login Login)
	{
		LoginRepository.save(Login);
		return "Login created";
	}
	
	@GetMapping("/Login")
	public ResponseEntity<List<Login>> getAllLogins()
	{
		List <Login> pr = new ArrayList<>(); 
		LoginRepository.findAll().forEach(pr::add); 
		return new ResponseEntity<List<Login>>(pr, HttpStatus.OK);
	}
	
	@GetMapping("/Login/{id}")
	public ResponseEntity<Login> getLoginById(@PathVariable long id)
	{ 
		Optional<Login> p = LoginRepository.findById(id);
		if(p.isPresent()) 
		{
			return new ResponseEntity<Login>(p.get(), HttpStatus.FOUND);
		}
		else 
		{
			return new ResponseEntity<Login>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/Logins/{id}")
	public String deleteLoginByEmpId(@PathVariable long id) 
	{ 
		LoginRepository.deleteById(id); 
		return "Login Deleted Successfully";
	}
	
	@DeleteMapping("/Logins")
	public String deleteAllLogin()
	{ 
		LoginRepository.deleteAll(); 
		return "Login deleted Successfully..";
	}
}
