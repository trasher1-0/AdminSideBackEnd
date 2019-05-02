package com.trasher.spring.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {
	public String storeFile(MultipartFile file) throws IOException;
}
