package com.trasher.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.trasher.spring.dao.CustomerDAO;
import com.trasher.spring.model.Customer;

@Service
@Transactional(readOnly = true)
public class CustomerServiceImp implements CustomerService{
	   @Autowired
	   private CustomerDAO customerDAO;

	   @Transactional
	   @Override
	   public long save(Customer customer) {
	      return customerDAO.save(customer);
	   }

	   @Override
	   public Customer get(long id) {
	      return customerDAO.get(id);
	   }

	   @Override
	   public List<Customer> list() {
	      return customerDAO.list();
	   }
	   
	   @Override
	   public List<Customer> pendinglist() {
	      return customerDAO.pendinglist();
	   }
	   
	   @Override
	   public List<Customer> completelist() {
	      return customerDAO.completelist();
	   }

	   @Transactional
	   @Override
	   public void update(long id, Customer customer) {
		   customerDAO.update(id, customer);
	   }

	   @Transactional
	   @Override
	   public void delete(long id) {
		   customerDAO.delete(id);
	   }
}
