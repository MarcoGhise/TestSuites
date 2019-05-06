package it.blog.tdd.SpringTddExample;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringTddExampleApplicationFT {

	String source = "C:\\progetti\\Java8\\SpringTddExample\\mvnw.cmd";
	String destination = "C:\\progetti\\Java8\\SpringTddExample\\backup_mvnw.cmd";

	@Autowired
	FileUtil file;

	@Before
	public void warmUp() throws IOException {
		try {
			Files.delete(Paths.get(destination));
		} catch (NoSuchFileException e) {
			// Doesn't matter..
		}
	}

	@Test
	public void testCopyAndReadFile() throws IOException {

		file.copyFile(source, destination);

		String fileContent = file.readFile(destination);

		assertTrue(fileContent != null);

	}

}
