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

import com.trasher.spring.model.Organizer;
import com.trasher.spring.service.OrganizerService;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class OrganizerController {

   @Autowired
   private OrganizerService organizerService;

   /*---Add new organizer---*/
   @PostMapping("/organizer")
   public ResponseEntity<?> save(@RequestBody Organizer organizer) {
      long id = organizerService.save(organizer);
      return ResponseEntity.ok().body("New Organizer has been saved with id:" + id);
   }

   /*---Get a organizer by id---*/
   @GetMapping("/organizer/{id}")
   public ResponseEntity<Organizer> get(@PathVariable("id") long id) {
	  Organizer organizer = organizerService.get(id);
      return ResponseEntity.ok().body(organizer);
   }

   /*---get all organizers---*/
   @GetMapping("/organizer")
   public ResponseEntity<List<Organizer>> list() {
      List<Organizer> organizers = organizerService.list();
      return ResponseEntity.ok().body(organizers);
   }
   
   /*---get count of organizers---*/
   @GetMapping("/organizer/count")
   public int countOrg() {
      List<Organizer> organizers = organizerService.list();
      return organizers.size();
   }

   /*---Update a organizer by id---*/
   @PutMapping("/organizer/{id}")
   public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody Organizer organizer) {
	  organizerService.update(id, organizer);
      return ResponseEntity.ok().body("Organizer has been updated successfully.");
   }

   /*---Delete a organizer by id---*/
   @DeleteMapping("/organizer/{id}")
   public ResponseEntity<?> delete(@PathVariable("id") long id) {
	   organizerService.delete(id);
      return ResponseEntity.ok().body("Organizer has been deleted successfully.");
   }
}