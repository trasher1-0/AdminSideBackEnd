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

import com.trasher.spring.model.Contributor;
import com.trasher.spring.service.ContributorService;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class ContributorController {

   @Autowired
   private ContributorService contributorService;

   /*---Add new contributor---*/
   @PostMapping("/contributor")
   public ResponseEntity<?> save(@RequestBody Contributor contributor) {
      long id = contributorService.save(contributor);
      return ResponseEntity.ok().body("New Contributor has been saved with id:" + id);
   }

   /*---Get a contributor by id---*/
   @GetMapping("/contributor/{id}")
   public ResponseEntity<Contributor> get(@PathVariable("id") long id) {
	  Contributor contributor = contributorService.get(id);
      return ResponseEntity.ok().body(contributor);
   }

   /*---get all contributors---*/
   @GetMapping("/contributor")
   public ResponseEntity<List<Contributor>> list() {
      List<Contributor> contributors = contributorService.list();
      return ResponseEntity.ok().body(contributors);
   }
   
   /*---get count of contributors---*/
   @GetMapping("/contributor/count")
   public int countCon() {
      List<Contributor> contributors = contributorService.list();
      return contributors.size();
   }

   /*---Update a contributor by id---*/
   @PutMapping("/contributor/{id}")
   public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody Contributor contributor) {
	  contributorService.update(id, contributor);
      return ResponseEntity.ok().body("Contributor has been updated successfully.");
   }

   /*---Delete a contributor by id---*/
   @DeleteMapping("/contributor/{id}")
   public ResponseEntity<?> delete(@PathVariable("id") long id) {
	   contributorService.delete(id);
      return ResponseEntity.ok().body("Contributor has been deleted successfully.");
   }
}