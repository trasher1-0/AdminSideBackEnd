package com.trasher.spring.service;

import java.util.List;
import com.trasher.spring.model.Contributor;

public interface ContributorService {
   long save(Contributor contributor);
   Contributor get(long id);
   Contributor getPassword(String email);
   List<Contributor> list();
   void update(long id, Contributor contributor);
   void delete(long id);
}
