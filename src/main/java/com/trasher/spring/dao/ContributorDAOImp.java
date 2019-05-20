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

import com.trasher.spring.model.Contributor;

@Repository
public class ContributorDAOImp implements ContributorDAO {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public long save(Contributor contributor) {
      sessionFactory.getCurrentSession().save(contributor);
      return contributor.getId();
   }

   @Override
   public Contributor get(long id) {
      return sessionFactory.getCurrentSession().get(Contributor.class, id);
   }
   
   @Override
   public Contributor getPassword(String email) {
      return sessionFactory.getCurrentSession().get(Contributor.class, email);
   }

   @Override
   public List<Contributor> list() {
      List<Contributor> list = sessionFactory.getCurrentSession().createQuery("from Contributor").list();
      return list;
   }

   @Override
   public void update(long id, Contributor contributor) {
      Session session = sessionFactory.getCurrentSession();
      Contributor contributor2 = session.byId(Contributor.class).load(id);
      contributor2.setUsername(contributor.getUsername());
      contributor2.setFullname(contributor.getFullname());
      contributor2.setAddress(contributor.getAddress());
      contributor2.setCity(contributor.getCity());
      contributor2.setMobile(contributor.getMobile());
      contributor2.setEmail(contributor.getEmail());
      contributor2.setPassword(contributor.getPassword());
      session.flush();
   }

   @Override
   public void delete(long id) {
	   Contributor contributor = sessionFactory.getCurrentSession().byId(Contributor.class).load(id);
      sessionFactory.getCurrentSession().delete(contributor);
   }

}