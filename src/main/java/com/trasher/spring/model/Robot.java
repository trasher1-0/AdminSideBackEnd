package com.trasher.spring.model;

import java.io.File;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.web.multipart.MultipartFile;

@Entity(name="Robot")
public class Robot {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String details;
	private String image;
	private Long contid;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	public Long getCont_id() {
		return contid;
	}
	public void setCont_id(Long cont_id) {
		this.contid = cont_id;
	}
	
	@Override
	public String toString() {
		return "Robot [id=" + id + ", name=" + name + ", details=" + details + ", image=" + image + "]";
	}
	
	
}
