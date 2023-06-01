package com.crm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crm.dao.CustomerDao;
import com.crm.entity.Customer;

@Service
public class CustomerService {

	@Autowired
	CustomerDao dao;
	
	public List<Customer> getCustDetails() {
		 List<Customer> list = dao.getCustDetails();
		return list;
	}

	public String insertCustomer(Customer cust) {
		String msg= dao.insertCustomer(cust);
		return msg;
	}

	public String updateCustomer(Customer cust) {
		String msg= dao.updateCustomer(cust);
		return msg;
	}

	public String deleteCustomerById(int id) {
		String msg= dao.deleteCustomerById(id);
		return msg;
	}

	public List<String> getCustName() {
		 List<String> list = dao.getCustName();
			return list;

	}


}
