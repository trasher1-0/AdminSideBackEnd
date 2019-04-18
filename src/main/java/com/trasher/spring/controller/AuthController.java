package com.trasher.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trasher.spring.model.Admin;
import com.trasher.spring.service.AdminService;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class AuthController {
	@Autowired
	private AdminService adminService;
	
	@PostMapping("/adminAuth")
	public boolean check(@RequestBody Admin admin) {
		boolean ch=false;
		List<Admin> admins = adminService.list();
		//System.out.println(admins);
		for(int i=0;i<admins.size();i++) {
			if(admins.get(i).getUsername().equals(admin.getUsername()) && admins.get(i).getPassword().equals(admin.getPassword())) {
				ch= true;
				break;
			}
			
		}
		return ch;
	   }
}
