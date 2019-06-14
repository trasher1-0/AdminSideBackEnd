package com.trasher.spring.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import com.trasher.spring.model.Robot;
import com.trasher.spring.service.FileService;
import com.trasher.spring.service.RobotService;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class RobotController {
	
   @Autowired
   private RobotService robotService;
   
   /*---Add new robot---*/
   @PostMapping("/robot")
   public ResponseEntity<?> save(@RequestBody Robot robot) throws IOException{ 
      long id = robotService.save(robot);
      return ResponseEntity.ok().body("New Robot has been saved with id:" + id);
   }

   /*---Get a robot by id---*/
   @GetMapping("/robot/{id}")
   public ResponseEntity<Robot> get(@PathVariable("id") long id) {
	  Robot robot = robotService.get(id);
      return ResponseEntity.ok().body(robot);
   }
   
   /*---Get a robot by contributor Id---*/
   @GetMapping("/robot/cont/{id}")
   public Robot getContRob(@PathVariable("id") long id) throws NullPointerException {
	   List<Robot> robots = robotService.list();
	   Robot robot=null;
	   for(int i=0;i<robots.size();i++) {
		   if(robots.get(i).getCont_id()==id) {
			   robot=robots.get(i);
			   break;
		   }
	   }
	   return robot;
   }

   /*---get all robots---*/
   @GetMapping("/robot")
   public ResponseEntity<List<Robot>> list() {
      List<Robot> robots = robotService.list();
      return ResponseEntity.ok().body(robots);
   }
   
   /*---get Count of robots---*/
   @GetMapping("/robot/count")
   public int countrob() {
      List<Robot> robots = robotService.list();
      return robots.size();
   }

   /*---Update a robot by id---*/
   @PutMapping("/robot/{id}")
   public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody Robot robot) {
	  robotService.update(id, robot);
      return ResponseEntity.ok().body("Robot has been updated successfully.");
   }
   
   /*---Add Contributor to Robot---*/
   @PutMapping("/robot/cont/add/{id}")
   public ResponseEntity<?> addCont(@PathVariable("id") long id, @RequestBody Robot robot) {
	  robotService.addCont(id, robot);
	  //System.out.println(robot.getCont_id());
      return ResponseEntity.ok().body("Contributor added to robot.");
   }

   /*---Delete a robot by id---*/
   @DeleteMapping("/robot/{id}")
   public ResponseEntity<?> delete(@PathVariable("id") long id) {
	   robotService.delete(id);
      return ResponseEntity.ok().body("Robot has been deleted successfully.");
   }
}