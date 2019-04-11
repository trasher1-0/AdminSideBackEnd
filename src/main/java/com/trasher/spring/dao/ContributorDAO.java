package com.trasher.spring.dao;

import java.util.List;

import com.trasher.spring.model.Contributor;

public interface ContributorDAO {
   long save(Contributor contributor);
   Contributor get(long id);
   List<Contributor> list();
   void update(long id, Contributor contributor);
   void delete(long id);
}

