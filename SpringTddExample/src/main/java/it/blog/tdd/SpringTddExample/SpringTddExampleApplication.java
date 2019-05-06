package it.blog.tdd.SpringTddExample;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.core.io.Resource;

@SpringBootApplication
public class SpringTddExampleApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringTddExampleApplication.class, args);
	}
	
	@Override
    public void run(String... args) {
		
    }
	
}
