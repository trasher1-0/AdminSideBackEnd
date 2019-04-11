package com.trasher.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.trasher.spring.dao.ContributorDAO;
import com.trasher.spring.model.Contributor;

@Service
@Transactional(readOnly = true)
public class ContributorServiceImp implements ContributorService{
	   @Autowired
	   private ContributorDAO contributorDAO;

	   @Transactional
	   @Override
	   public long save(Contributor contributor) {
	      return contributorDAO.save(contributor);
	   }

	   @Override
	   public Contributor get(long id) {
	      return contributorDAO.get(id);
	   }

	   @Override
	   public List<Contributor> list() {
	      return contributorDAO.list();
	   }

	   @Transactional
	   @Override
	   public void update(long id, Contributor contributor) {
		   contributorDAO.update(id, contributor);
	   }

	   @Transactional
	   @Override
	   public void delete(long id) {
		   contributorDAO.delete(id);
	   }
}
