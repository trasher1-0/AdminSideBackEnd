package com.trasher.spring.dao;

import java.util.List;
import com.trasher.spring.model.Robot;

public interface RobotDAO {
   long save(Robot robot);
   Robot get(long id);
   List<Robot> list();
   void update(long id, Robot robot);
   void delete(long id);
}

