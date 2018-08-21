package com.fileNameTrim;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
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
	public void fileTraveler(Path header_file_path)
	{
		
		FileVisitor<Path> fileVisitor = new SimpleFileVisitor<Path>()
		{
			
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
		Path rootPath = fileSystem.getPath("c:/");
		
		try {
			Files.walkFileTree(rootPath, fileVisitor);
			
		} catch(IOException ioe) {
			ioe.printStackTrace();
		}
	
	}

}

/*
 To read through, or walk, through a file tree of a system, NIO libraries have provided the Files.walkFileTree() static method. The most basic version of this method takes 2 inputs – a starting Path and a FileVisitor.
The starting Path has to be an instance of java.nio.file.Path interface.
java.nio.file.FileVisitor is also an interface whose most commonly used implementation has been provided by the JDK and is known as SimpleFileVisitor. An implementation of SimpleFileVisitor as an anonymous inner class has been created which overrides two methods – preVisitDirectory() and visitFile(). The anonymous inner class implementation is named – simpleFileVisitor(note the camel casing for object names).
As the NIO API walks the file tree, these two methods are the hooks which let us process events. While preVisitDirectory() method is invoked when a directory is to be visited next, and visitFile() method is invoked when a file is actually visited.
The NIO API uses visitor pattern to walk through the files.
DIRECTORY NAME and DIRECTORY LOCATIONis printed for each directory visited while the FILE NAME is printed for each visited file.
To invoke the Files.walkFileTree() method, first an instance of FileSystem is obtained from FileSystems.getDefault() method. FileSystems is a factory of file systems and the getDefault() method returns a handle to the default file system on which the system is running.
Then from the fileSystem instance we create the a Path instance, named rootPath, with the path "C:\\JavaBrahman\\LEVEL1".
Lastly, we invoke the Files.walkFileTree() method with the rootPath object and the simpleFileVisitor object.
 */
