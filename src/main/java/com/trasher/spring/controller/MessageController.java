package com.trasher.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trasher.spring.model.Message;
import com.trasher.spring.service.MessageService;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class MessageController {

   @Autowired
   private MessageService messageService;

   /*---Add new message---*/
   @PostMapping("/message")
   public ResponseEntity<?> save(@RequestBody Message message) {
      long id = messageService.save(message);
      return ResponseEntity.ok().body("New Message has been saved with id:" + id);
   }

   /*---Get a message by id---*/
   @GetMapping("/message/{id}")
   public ResponseEntity<Message> get(@PathVariable("id") long id) {
	  Message message = messageService.get(id);
      return ResponseEntity.ok().body(message);
   }

   /*---get all messages---*/
   @GetMapping("/message")
   public ResponseEntity<List<Message>> list() {
      List<Message> messages = messageService.list();
      return ResponseEntity.ok().body(messages);
   }
   
   /*---Delete a message by id---*/
   @DeleteMapping("/message/{id}")
   public ResponseEntity<?> delete(@PathVariable("id") long id) {
	   messageService.delete(id);
      return ResponseEntity.ok().body("Message has been deleted successfully.");
   }
}