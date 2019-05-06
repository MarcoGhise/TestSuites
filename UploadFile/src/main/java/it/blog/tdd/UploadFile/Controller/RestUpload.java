package it.blog.tdd.UploadFile.Controller;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class RestUpload {

	@Value("${uploaddir}")
	private String uploadDir;
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	@ResponseBody
	public int uploadingPost(@RequestParam("file") MultipartFile multipartFile) throws IOException {

		String uploadingDir = System.getProperty("user.dir") + uploadDir;
				
		String fileName = uploadingDir + multipartFile.getOriginalFilename();
		
		File file = new File(fileName);
		multipartFile.transferTo(file);

		return 200;
	}
	
}
