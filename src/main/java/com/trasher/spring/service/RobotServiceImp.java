package com.trasher.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.trasher.spring.dao.RobotDAO;
import com.trasher.spring.model.Robot;

@Service
@Transactional(readOnly = true)
public class RobotServiceImp implements RobotService{
	   @Autowired
	   private RobotDAO robotDAO;

	   @Transactional
	   @Override
	   public long save(Robot robot) {
	      return robotDAO.save(robot);
	   }

	   @Override
	   public Robot get(long id) {
	      return robotDAO.get(id);
	   }

	   @Override
	   public List<Robot> list() {
	      return robotDAO.list();
	   }

	   @Transactional
	   @Override
	   public void update(long id, Robot robot) {
		   robotDAO.update(id, robot);
	   }
	   
	   @Transactional
	   @Override
	   public void addCont(long id, Robot robot) {
		   robotDAO.addCont(id, robot);
	   }

	   @Transactional
	   @Override
	   public void delete(long id) {
		   robotDAO.delete(id);
	   }
}
