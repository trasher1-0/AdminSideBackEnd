package com.trasher.spring.service;

import java.util.List;
import com.trasher.spring.model.Customer;

public interface CustomerService {
   long save(Customer customer);
   Customer get(long id);
   List<Customer> list();
   void update(long id, Customer customer);
   void delete(long id);
}