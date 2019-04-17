package com.trasher.spring.service;

import java.util.List;
import com.trasher.spring.model.Admin;

public interface AdminService {
   long save(Admin admin);
   Admin get(long id);
   List<Admin> list();
   void update(long id, Admin admin);
   void delete(long id);
}
