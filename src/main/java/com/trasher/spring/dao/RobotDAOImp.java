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

import com.trasher.spring.model.Robot;

@Repository
public class RobotDAOImp implements RobotDAO {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public long save(Robot robot) {
      sessionFactory.getCurrentSession().save(robot);
      return robot.getId();
   }

   @Override
   public Robot get(long id) {
      return sessionFactory.getCurrentSession().get(Robot.class, id);
   }

   @Override
   public List<Robot> list() {
      List<Robot> list = sessionFactory.getCurrentSession().createQuery("from Robot").list();
      return list;
   }

   @Override
   public void update(long id, Robot robot) {
      Session session = sessionFactory.getCurrentSession();
      Robot robot2 = session.byId(Robot.class).load(id);
      robot2.setName(robot.getName());
      robot2.setDetails(robot.getDetails());
      robot2.setImage(robot.getImage());
      session.flush();
   }

   @Override
   public void delete(long id) {
	   Robot robot = sessionFactory.getCurrentSession().byId(Robot.class).load(id);
      sessionFactory.getCurrentSession().delete(robot);
   }

}