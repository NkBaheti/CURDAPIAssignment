package com.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.crm.entity.Customer;
import com.crm.service.CustomerService;

@RestController
public class CustomerController {
	@Autowired
	CustomerService service;
	
	@GetMapping("/allcust")
	public List<Customer> getCustDetails() {
		List<Customer>list= service.getCustDetails();
		return list;
	}
	@PostMapping("/insertcust")
	public String insertCustomer(@RequestBody Customer cust) {	
	String msg= service.insertCustomer (cust);
	return msg;
	}
	@PutMapping("/updatecust")
	public String updateCustomer(@RequestBody Customer cust) {
		String msg = service.updateCustomer (cust);
		return msg;
	}
	@DeleteMapping("/deletecust/{id}")
	public String deleteCustomerById(@PathVariable int id) {
		String msg = service.deleteCustomerById(id);
		return msg;
	}
	@GetMapping("/allcustname")
	public List<String> getCustName() {
		List<String>list= service.getCustName();
		return list;
	}
}
