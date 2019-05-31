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

import com.trasher.spring.model.Admin;

@Repository
public class AdminDAOImp implements AdminDAO {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public long save(Admin admin) {
      sessionFactory.getCurrentSession().save(admin);
      return admin.getId();
   }

   @Override
   public Admin get(long id) {
      return sessionFactory.getCurrentSession().get(Admin.class, id);
   }

   @Override
   public List<Admin> list() {
      List<Admin> list = sessionFactory.getCurrentSession().createQuery("from admin").list();
      return list;
   }

   @Override
   public void update(long id, Admin admin) {
      Session session = sessionFactory.getCurrentSession();
      Admin admin2 = session.byId(Admin.class).load(id);
      admin2.setUsername(admin.getUsername());
      admin2.setPassword(admin.getPassword());
      session.flush();
   }

   @Override
   public void delete(long id) {
	   Admin admin = sessionFactory.getCurrentSession().byId(Admin.class).load(id);
      sessionFactory.getCurrentSession().delete(admin);
   }

}