package com.trasher.spring.service;

import java.util.List;

import com.trasher.spring.model.Message;

public interface MessageService {
	long save(Message message);
	   Message get(long id);
	   List<Message> list();
	   void delete(long id);
}
