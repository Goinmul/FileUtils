package com.fileNameTrim;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;
import java.nio.file.*;

public class FileTreeWalker {
	
	// import my own custom visitor
	MyFileVisitor myVisitor = new MyFileVisitor();

	public Path walkFileTree(Path start, FileVisitor<? super Path> visitor) throws IOException
	{
		Files.walkFileTree(start, myVisitor); // parameter : starting directory, my custom visitor
		
		// give return value
		return null;
		
	}

	
	
	
}
