package com.trasher.spring.dao;

import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.trasher.spring.model.Customer;

@Repository
public class CustomerDAOImp implements CustomerDAO {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public long save(Customer customer) {
      sessionFactory.getCurrentSession().save(customer);
      return customer.getInvoiceno();
   }

   @Override
   public Customer get(long invoiceno) {
      return sessionFactory.getCurrentSession().get(Customer.class, invoiceno);
   }

   @Override
   public List<Customer> list() {
      List<Customer> list = sessionFactory.getCurrentSession().createQuery("from customer").list();
      return list;
   }
   
   @Override
   public List<Customer> pendinglist() {
      List<Customer> list = sessionFactory.getCurrentSession().createQuery("from customer where status=0").list();
      return list;
   }
   
   @Override
   public List<Customer> completelist() {
      List<Customer> list = sessionFactory.getCurrentSession().createQuery("from customer where status=1").list();
      return list;
   }

   @Override
   public void update(long invoiceno, Customer customer) {
      Session session = sessionFactory.getCurrentSession();
      Customer customer2 = session.byId(Customer.class).load(invoiceno);
      customer2.setUsername(customer.getUsername());
      customer2.setFullname(customer.getFullname());
      customer2.setAddress(customer.getAddress());
      customer2.setCity(customer.getCity());
      customer2.setMobile(customer.getMobile());
      customer2.setEmail(customer.getEmail());
      customer2.setPassword(customer.getPassword());
      customer2.setDate(customer.getDate());
      customer2.setTimeperiod(customer.getTimeperiod());
      customer2.setStatus(customer.getStatus());
      session.flush();
   }

   @Override
   public void delete(long invoiceno) {
	   Customer customer = sessionFactory.getCurrentSession().byId(Customer.class).load(invoiceno);
      sessionFactory.getCurrentSession().delete(customer);
   }

}