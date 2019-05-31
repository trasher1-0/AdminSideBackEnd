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

import com.trasher.spring.model.Organizer;

@Repository
public class OrganizerDAOImp implements OrganizerDAO {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public long save(Organizer organizer) {
      sessionFactory.getCurrentSession().save(organizer);
      return organizer.getId();
   }

   @Override
   public Organizer get(long id) {
      return sessionFactory.getCurrentSession().get(Organizer.class, id);
   }

   @Override
   public List<Organizer> list() {
      List<Organizer> list = sessionFactory.getCurrentSession().createQuery("from organizer").list();
      return list;
   }

   @Override
   public void update(long id, Organizer organizer) {
      Session session = sessionFactory.getCurrentSession();
      Organizer organizer2 = session.byId(Organizer.class).load(id);
      organizer2.setUsername(organizer.getUsername());
      organizer2.setFullname(organizer.getFullname());
      organizer2.setAddress(organizer.getAddress());
      organizer2.setCity(organizer.getCity());
      organizer2.setMobile(organizer.getMobile());
      organizer2.setEmail(organizer.getEmail());
      organizer2.setPassword(organizer.getPassword());
      session.flush();
   }

   @Override
   public void delete(long id) {
	   Organizer organizer = sessionFactory.getCurrentSession().byId(Organizer.class).load(id);
      sessionFactory.getCurrentSession().delete(organizer);
   }

}