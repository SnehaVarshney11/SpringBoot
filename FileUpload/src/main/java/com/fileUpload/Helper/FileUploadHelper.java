package com.fileUpload.Helper;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {
public final String UPLOAD_DIR = "C:\\Users\\hp\\eclipse-workspace\\FileUpload\\src\\main\\resources\\static\\Image";
	
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
