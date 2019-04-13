package com.trasher.spring.service;

import java.util.List;
import com.trasher.spring.model.Organizer;

public interface OrganizerService {
   long save(Organizer organizer);
   Organizer get(long id);
   List<Organizer> list();
   void update(long id, Organizer organizer);
   void delete(long id);
}
