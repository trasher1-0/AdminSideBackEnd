package com.trasher.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trasher.spring.model.Customer;
import com.trasher.spring.service.CustomerService;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class CustomerController {

   @Autowired
   private CustomerService customerService;

   /*---Add new customer---*/
   @PostMapping("/customer")
   public ResponseEntity<?> save(@RequestBody Customer customer) {
      long invoiceno = customerService.save(customer);
      System.out.println(customer);
      return ResponseEntity.ok().body("New Customer has been saved with invoiceno:" + invoiceno);
   }

   /*---Get a customer by id---*/
   @GetMapping("/customer/{invoiceno}")
   public ResponseEntity<Customer> get(@PathVariable("invoiceno") long invoiceno) {
	  Customer customer = customerService.get(invoiceno);
      return ResponseEntity.ok().body(customer);
   }

   /*---get all customers---*/
   @GetMapping("/customer")
   public ResponseEntity<List<Customer>> list() {
      List<Customer> customers = customerService.list();
      return ResponseEntity.ok().body(customers);
   }
   
   /*---get pending customers count---*/
   @GetMapping("/customer/countPending")
   public int countPen() {
      List<Customer> customers = customerService.pendinglist();
      return customers.size();
   }
   
   /*---get Completed customers count---*/
   @GetMapping("/customer/countSuccess")
   public int countCom() {
      List<Customer> customers = customerService.completelist();
      return customers.size();
   }
   
   /*---get all pending customers---*/
   @GetMapping("/customer/pending")
   public ResponseEntity<List<Customer>> pendinglist() {
      List<Customer> customers = customerService.pendinglist();
      return ResponseEntity.ok().body(customers);
   }
   
   /*---get all pending customers---*/
   @GetMapping("/customer/complete")
   public ResponseEntity<List<Customer>> completelist() {
      List<Customer> customers = customerService.completelist();
      return ResponseEntity.ok().body(customers);
   }

   /*---Update a customer by invoiceno---*/
   @PutMapping("/customer/{invoiceno}")
   public ResponseEntity<?> update(@PathVariable("invoiceno") long invoiceno, @RequestBody Customer customer) {
	  customerService.update(invoiceno, customer);
      return ResponseEntity.ok().body("Customer has been updated successfully.");
   }

   /*---Delete a customer by id---*/
   @DeleteMapping("/customer/{invoiceno}")
   public ResponseEntity<?> delete(@PathVariable("invoiceno") long invoiceno) {
	   customerService.delete(invoiceno);
      return ResponseEntity.ok().body("Customer has been deleted successfully.");
   }
}