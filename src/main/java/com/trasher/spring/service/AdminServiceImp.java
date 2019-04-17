package com.trasher.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.trasher.spring.dao.AdminDAO;
import com.trasher.spring.model.Admin;

@Service
@Transactional(readOnly = true)
public class AdminServiceImp implements AdminService{
	   @Autowired
	   private AdminDAO adminDAO;

	   @Transactional
	   @Override
	   public long save(Admin admin) {
	      return adminDAO.save(admin);
	   }

	   @Override
	   public Admin get(long id) {
	      return adminDAO.get(id);
	   }

	   @Override
	   public List<Admin> list() {
	      return adminDAO.list();
	   }

	   @Transactional
	   @Override
	   public void update(long id, Admin admin) {
		   adminDAO.update(id, admin);
	   }

	   @Transactional
	   @Override
	   public void delete(long id) {
		   adminDAO.delete(id);
	   }
}
