package com.crm.dao;

import java.util.List;
import java.util.ArrayList;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.crm.entity.Customer;

@Repository
public class CustomerDao {

	@Autowired
	SessionFactory sf;

	public List<Customer> getCustDetails() {
		Session session= sf.openSession();
		Criteria criteria= session.createCriteria(Customer.class);
		return criteria.list();
	}

	public String insertCustomer(Customer cust) {
		Session session= sf.openSession();
		Transaction transaction= session.beginTransaction();
		session.save(cust);
		transaction.commit();
		session.close();
		return "Customer inserted sucessfully.....!!!";
	}

	public String updateCustomer(Customer cust) {
		Session session= sf.openSession();
		Transaction transaction= session.beginTransaction();
		session.update(cust);
		transaction.commit();
		session.close();
		return "Customer updated sucessfully.....!!!";
	}

	public String deleteCustomerById(int id) {
		Session session= sf.openSession();
		Transaction transaction= session.beginTransaction();
		Customer customer= session.load(Customer.class, id);
		session.delete(customer);
		transaction.commit();
		session.close();
		return "Customer deleted sucessfully.....!!!";
	}

	public List<String> getCustName() {
		Session session= sf.openSession();
		Criteria criteria= session.createCriteria(Customer.class);
		List<Customer>aaa =criteria.list();
		List<String>list= new ArrayList<>();
		for (Customer customer : aaa) {
			list.add(customer.getFname());
		}
		return list;
	}

}
