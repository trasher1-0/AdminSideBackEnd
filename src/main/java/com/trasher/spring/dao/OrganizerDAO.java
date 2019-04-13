package com.trasher.spring.dao;

import java.util.List;

import com.trasher.spring.model.Organizer;


public interface OrganizerDAO {
	long save(Organizer organizer);
	Organizer get(long id);
    List<Organizer> list();
    void update(long id, Organizer organizer);
    void delete(long id);
}
