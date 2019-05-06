package it.blog.tdd.SpringTddExample;

import java.io.IOException; 
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Component
public class FileUtilHttp {

	@Value("${serverurl}")
	private String serverUrl;

	@Autowired
	RestTemplate restTemplate;
	
	@Bean
    public RestTemplate restTemplate() {
     return new RestTemplate();
	} 

	public String uploadSingleFile() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.MULTIPART_FORM_DATA);

		MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
		body.add("file", getTestFile());
		
		HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);
		ResponseEntity<String> response = restTemplate.postForEntity(serverUrl, requestEntity, String.class);
		
		System.out.println("Response code: " + response.getBody());

		return response.getBody();
	}

	private Resource getTestFile() {
		Path testFile;
		try {
			testFile = Files.createTempFile("test-file", ".txt");

			System.out.println("Creating and Uploading Test File: " + testFile);
			Files.write(testFile, "Hello World !!, This is a test file.".getBytes());
			return new FileSystemResource(testFile.toFile());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
