package com.trasher.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.trasher.spring.dao.OrganizerDAO;
import com.trasher.spring.model.Organizer;

@Service
@Transactional(readOnly = true)
public class OrganizerServiceImp implements OrganizerService{
	   @Autowired
	   private OrganizerDAO organizerDAO;

	   @Transactional
	   @Override
	   public long save(Organizer organizer) {
	      return organizerDAO.save(organizer);
	   }

	   @Override
	   public Organizer get(long id) {
	      return organizerDAO.get(id);
	   }

	   @Override
	   public List<Organizer> list() {
	      return organizerDAO.list();
	   }

	   @Transactional
	   @Override
	   public void update(long id, Organizer organizer) {
		   organizerDAO.update(id, organizer);
	   }

	   @Transactional
	   @Override
	   public void delete(long id) {
		   organizerDAO.delete(id);
	   }
}
