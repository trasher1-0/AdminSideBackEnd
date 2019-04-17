package com.trasher.spring.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.trasher.spring.model.Admin;
import com.trasher.spring.service.AdminService;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class AdminController {

   @Autowired
   private AdminService adminService;

   /*---Add new admin---*/
   @PostMapping("/admin")
   public ResponseEntity<?> save(@RequestBody Admin admin) {
      long id = adminService.save(admin);
      return ResponseEntity.ok().body("New Admin has been saved with id:" + id);
   }

   /*---Get a admin by id---*/
   @GetMapping("/admin/{id}")
   public ResponseEntity<Admin> get(@PathVariable("id") long id) {
	  Admin admin = adminService.get(id);
      return ResponseEntity.ok().body(admin);
   }

   /*---get all admins---*/
   @GetMapping("/admin")
   public ResponseEntity<List<Admin>> list() {
      List<Admin> admins = adminService.list();
      return ResponseEntity.ok().body(admins);
   }

   /*---Update a admin by id---*/
   @PutMapping("/admin/{id}")
   public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody Admin admin) {
	  adminService.update(id, admin);
      return ResponseEntity.ok().body("Admin has been updated successfully.");
   }

   /*---Delete a admin by id---*/
   @DeleteMapping("/admin/{id}")
   public ResponseEntity<?> delete(@PathVariable("id") long id) {
	   adminService.delete(id);
      return ResponseEntity.ok().body("Admin has been deleted successfully.");
   }
}