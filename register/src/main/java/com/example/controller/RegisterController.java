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

import com.example.Repository.RegisterRepository;
import com.example.model.Register;

@RestController
@RequestMapping("/register1")
public class RegisterController {
	
	@Autowired
	RegisterRepository registerRepository;
	
	@PostMapping("/register")
	public String create(@RequestBody Register register)
	{
		registerRepository.save(register);
		return "Register created";
	}
	
	@GetMapping("/register")
	public ResponseEntity<List<Register>> getAllRegisters()
	{
		List <Register> pr = new ArrayList<>(); 
		registerRepository.findAll().forEach(pr::add); 
		return new ResponseEntity<List<Register>>(pr, HttpStatus.OK);
	}
	
	@GetMapping("/register/{id}")
	public ResponseEntity<Register> getRegisterById(@PathVariable long id)
	{ 
		Optional<Register> p = registerRepository.findById(id);
		if(p.isPresent()) 
		{
			return new ResponseEntity<Register>(p.get(), HttpStatus.FOUND);
		}
		else 
		{
			return new ResponseEntity<Register>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/registers/{id}")
	public String deleteRegisterByEmpId(@PathVariable long id) 
	{ 
		registerRepository.deleteById(id); 
		return "Register Deleted Successfully";
	}
	
	@DeleteMapping("/registers")
	public String deleteAllRegister()
	{ 
		registerRepository.deleteAll(); 
		return "Register deleted Successfully..";
	}
}
