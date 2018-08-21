package com.fileNameTrim;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class FileReadingClass {
	
	// @param : file name
	public void fileRead(String file_name) throws FileNotFoundException
	{
		//BufferedReader br = new BufferedReader(new FileReader(new File(file_name)));
	
		Path file_path = Paths.get(file_name);
		File file = file_path.toFile();
		
		file_path.getFileName();
		file.renameTo(file);
		
		
		BasicFileAttributes attrib = null;
		
	}
	
	
	// #1) print all files' name under a header file
	public void printFileListFromFolder(String header_file)
	{
		// print all the below files in the header file.
		File file = new File(header_file);
		File[] files = file.listFiles();
		for (File f : files)
		{
			System.out.println(f.getName());
		}
		
	}
	
	// #2) travel to the deepest bottom file, of a header directory

	// source) https://www.javabrahman.com/quick-tips/java-recursively-list-files-subdirectories-directory-examples/
	// quite hard to understand...
	public void fileTraveler(String header_file_path)
	{
		FileVisitor<Path> fileVisitor = new SimpleFileVisitor<Path>() {
			
			@Override
			public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrib)
			{
				System.out.println("Directory name : " + dir.getFileName());
				System.out.println("Location : " + dir.toFile().getPath());
			
				return FileVisitResult.CONTINUE;
			}
			
			@Override
			public FileVisitResult visitFile(Path visitedFile, BasicFileAttributes fileAttributes)
			{
				System.out.println("File name : " + visitedFile.getFileName());
				return FileVisitResult.CONTINUE;
			}
		
		}; // Oh!
		
		FileSystem fileSystem = FileSystems.getDefault();
		
	}

}
