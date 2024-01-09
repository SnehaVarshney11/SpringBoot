package com.fileUpload.Helper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {
	//STATIC PATH
	//public final String UPLOAD_DIR = "C:\\Users\\hp\\eclipse-workspace\\FileUpload\\src\\main\\resources\\static\\Image";
	
	//DYNAMIC PATH
	public final String UPLOAD_DIR = new ClassPathResource("/static/Image").getFile().getAbsolutePath();
	
	public FileUploadHelper() throws IOException {
		
	}
	
	public boolean uploadFile(MultipartFile file) {
		
		boolean uploadStatus = false;
		
		try {
			/*
			//Read file
			InputStream is = file.getInputStream();
			byte data[] = new byte[is.available()];
			is.read();
			
			//Write file
			FileOutputStream op = new FileOutputStream(UPLOAD_DIR + "\\" + file.getOriginalFilename());
			op.write(data);
			op.flush();
			op.close();
			*/
			
			Files.copy(file.getInputStream(), Paths.get(UPLOAD_DIR + "\\" + file.getOriginalFilename()) , StandardCopyOption.REPLACE_EXISTING);
			
			uploadStatus = true;
			
		}catch(Exception e) {
			e.printStackTrace();
			uploadStatus =  false;
		}
		
		return uploadStatus;
		
	}
}
