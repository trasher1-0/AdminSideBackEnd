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
import com.trasher.spring.model.Contributor;
import com.trasher.spring.model.Organizer;
import com.trasher.spring.service.AdminService;
import com.trasher.spring.service.ContributorService;
import com.trasher.spring.service.OrganizerService;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class AuthController {
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private ContributorService contributorService;
	
	@Autowired
	private OrganizerService organizerService;
	
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
	

	@PostMapping("/contributorAuth")
	public boolean checkContributor(@RequestBody Contributor contributor) {
		boolean ch=false;
		List<Contributor> contributors = contributorService.list();
		//System.out.println(contributors);
		for(int i=0;i<contributors.size();i++) {
			if(contributors.get(i).getUsername().equals(contributor.getUsername()) && contributors.get(i).getPassword().equals(contributor.getPassword())) {
				ch= true;
				break;
			}
			
		}
		return ch;
	}
	
	@PostMapping("/organizerAuth")
	public boolean checkOrganizer(@RequestBody Organizer organizer) {
		boolean ch=false;
		List<Organizer> organizers = organizerService.list();
		//System.out.println(organizers);
		for(int i=0;i<organizers.size();i++) {
			if(organizers.get(i).getUsername().equals(organizer.getUsername()) && organizers.get(i).getPassword().equals(organizer.getPassword())) {
				ch= true;
				break;
			}
			
		}
		return ch;
	}
}
