package it.blog.tdd.SpringTddExample;

import static org.hamcrest.CoreMatchers.any;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import static org.mockito.Mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringTddExampleApplicationMockito {

	@InjectMocks
	FileUtilHttp fileHttp;

	@Mock
	RestTemplate restTemplate;

	ResponseEntity<String> responseEntity;
	
	@Before
	public void warmUp() {
		MockitoAnnotations.initMocks(this);
		
		responseEntity  = new ResponseEntity<String>("200", HttpStatus.OK);
		
		when(restTemplate.postForEntity(Mockito.<String>any(), Mockito.<HttpEntity<MultiValueMap<String, Object>>>any(), eq(String.class))).thenReturn(responseEntity);				
	}

	@Test
	public void testUploadSingleFile() {
		String result =  fileHttp.uploadSingleFile();
		
		assertEquals(result, "200");
	}
}
