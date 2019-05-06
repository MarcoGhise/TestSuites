package it.blog.tdd.SpringTddExample;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringTddExampleApplicationIT {

	@Autowired
	FileUtilHttp file;
	
	@Test
	public void testFileName() {
		
		assertEquals(file.uploadSingleFile(), "200" );
		
	}

}
