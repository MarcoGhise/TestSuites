package it.blog.tdd.SpringTddExample;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;

import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Component;

@Component
public class FileUtil {

	final static String regExFileName = "^\\w*\\.\\w{3}$";

	public boolean isValidFileName(String fileName) {
		if (fileName != null)
			return fileName.matches(regExFileName);
		else
			return false;

	}

	public void copyFile(String source, String destination) throws IOException {
		Path sourcePath = Paths.get(source);
		Path destinationPath = Paths.get(destination);
		Files.copy(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);
	}

	public String readFile(String source) throws IOException {
		Path sourcePath = Paths.get(source);

		List<String> contents = Files.readAllLines(sourcePath);
		Optional<String> result = contents.stream().reduce((x, y) -> x + " " + y);
		
		if (result.isPresent())
			return result.get();
		else 
			return null;
	}
}
