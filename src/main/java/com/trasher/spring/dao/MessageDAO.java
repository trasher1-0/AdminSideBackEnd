package com.trasher.spring.dao;

import java.util.List;

import com.trasher.spring.model.Message;

public interface MessageDAO {
	long save(Message message);
	Message get(long id);
    List<Message> list();
    void delete(long id);

}
