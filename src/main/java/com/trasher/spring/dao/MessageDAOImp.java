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

import com.trasher.spring.model.Message;

@Repository
public class MessageDAOImp implements MessageDAO {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public long save(Message message) {
      sessionFactory.getCurrentSession().save(message);
      return message.getId();
   }

   @Override
   public Message get(long id) {
      return sessionFactory.getCurrentSession().get(Message.class, id);
   }

   @Override
   public List<Message> list() {
      List<Message> list = sessionFactory.getCurrentSession().createQuery("from message").list();
      return list;
   }
   
   @Override
   public List<Message> unreadlist() {
      List<Message> list = sessionFactory.getCurrentSession().createQuery("from message where status='0'").list();
      return list;
   }
   
   @Override
   public List<Message> readlist() {
      List<Message> list = sessionFactory.getCurrentSession().createQuery("from message where status='1'").list();
      return list;
   }

   @Override
   public void delete(long id) {
	   Message message = sessionFactory.getCurrentSession().byId(Message.class).load(id);
      sessionFactory.getCurrentSession().delete(message);
   }

}