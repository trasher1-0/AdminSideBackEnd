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
	
	//validate Contributor
	@PostMapping("/contributorAuth")
	public Contributor checkContributor(@RequestBody Contributor contributor) throws NullPointerException{
		Contributor cont=new Contributor();
		System.out.println(contributor.getUsername());
		boolean ch=false;
		List<Contributor> contributors = contributorService.list();
		//System.out.println(contributors);
		for(int i=0;i<contributors.size();i++) {
			if(contributors.get(i).getUsername().equals(contributor.getUsername()) && contributors.get(i).getPassword().equals(contributor.getPassword())) {
				cont=contributors.get(i);
				break;
			}
			
		}
		System.out.println(cont.getUsername());
		return cont;
	}
	
	//Forget Contributor Password
	@PostMapping("/forget/cont")
	public Contributor getPassCont(@RequestBody Contributor contributor) throws NullPointerException{
		Contributor cont=new Contributor();
		System.out.println(contributor.getUsername());
		List<Contributor> contributors = contributorService.list();
		//System.out.println(contributors);
		for(int i=0;i<contributors.size();i++) {
			if(contributors.get(i).getEmail().equals(contributor.getEmail())) {
				cont=contributors.get(i);
				break;
			}
			
		}
		return cont;
	}
	
	//validate Organizer
	@PostMapping("/organizerAuth")
	public Organizer checkOrganizer(@RequestBody Organizer organizer) {
		boolean ch=false;
		Organizer org = new Organizer();
		List<Organizer> organizers = organizerService.list();
		//System.out.println(organizers);
		for(int i=0;i<organizers.size();i++) {
			if(organizers.get(i).getUsername().equals(organizer.getUsername()) && organizers.get(i).getPassword().equals(organizer.getPassword())) {
				org = organizers.get(i);
				break;
			}
			
		}
		return org;
	}
	
	//validate Organizer
	@PostMapping("/forget/org")
	public Organizer forgetOrg(@RequestBody Organizer organizer) {
		Organizer org = new Organizer();
		List<Organizer> organizers = organizerService.list();
		for(int i=0;i<organizers.size();i++) {
			if(organizers.get(i).getEmail().equals(organizer.getEmail())) {
				org = organizers.get(i);
				break;
			}
			
		}
		return org;
	}
}
