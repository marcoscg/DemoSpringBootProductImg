package com.mardeveloper.app.util;

import java.io.*;
import java.nio.file.*;
 
import org.springframework.web.multipart.MultipartFile;

public class FileUploadUtil {

	public static void saveFile(String uploadDir, String fileName, MultipartFile multipartFile) {
		
		Path uploadPath = Paths.get(uploadDir);

		try {
			
			if (!Files.exists(uploadPath)) {			
				Files.createDirectories(uploadPath);
			}			
			
			InputStream inputStream = multipartFile.getInputStream();			
			
			Path filePath = uploadPath.resolve(fileName);
			
			Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
			
		} catch (IOException ioe) {
			throw new RuntimeException("Could not save image file: " + fileName, ioe);
		}
	}

}
