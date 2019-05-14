package com.trasher.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.trasher.spring.dao.MessageDAO;
import com.trasher.spring.model.Message;

@Service
@Transactional(readOnly = true)
public class MessageServiceImp implements MessageService{
	   @Autowired
	   private MessageDAO messageDAO;

	   @Transactional
	   @Override
	   public long save(Message message) {
	      return messageDAO.save(message);
	   }

	   @Override
	   public Message get(long id) {
	      return messageDAO.get(id);
	   }

	   @Override
	   public List<Message> list() {
	      return messageDAO.list();
	   }

	   @Transactional
	   @Override
	   public void delete(long id) {
		   messageDAO.delete(id);
	   }
}
