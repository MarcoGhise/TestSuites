package it.blog.tdd.SpringTddExample;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringTddExampleApplicationTests {

	@Autowired
	FileUtil file;
	
	@Test
	public void testFileName() {

		assertTrue(file.isValidFileName("test.txt"));
		
		assertFalse(file.isValidFileName("12 3.txt"));
		
		assertFalse(file.isValidFileName("notvalid?.file"));
		
		assertFalse(file.isValidFileName(null));
	}

}
