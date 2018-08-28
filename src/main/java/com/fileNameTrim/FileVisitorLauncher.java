package com.fileNameTrim;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class FileVisitorLauncher {

	public void fileTravelerLauncher() throws IOException
	{
		Scanner myScanner = new Scanner(System.in);
		FileTreeWalker myWalker = new FileTreeWalker();
		/*
		int options = 1; // default, numeric
		
		System.out.println("Option '1' : numeric renaming");
		System.out.println("Option '2' : numeric + parent folder based renaming");
		System.out.println("Choose option : ");
		options = myScanner.nextInt();
		*/
		
		// test case
		// get file path from user
		System.out.print("Enter the header file to check : ");
		String header_directory = myScanner.nextLine();
		Path path = Paths.get(header_directory);
		
		
		
		//0) organized in my other class
		MyFileVisitor traveler = new MyFileVisitor();
		myWalker.walkFileTree(path, traveler);
		
		//1) simple one
		//MyFileVisitor traveler = new MyFileVisitor();
		//Files.walkFileTree(path, traveler);
		
		//2) options included : levels to visit, and
		// set of 'FileVisitOption' enums
		/*
		import static java.nio.file.FileVisitResult.*;

		Path startingDir = ...;

		EnumSet<FileVisitOption> opts = EnumSet.of(FOLLOW_LINKS);

		Finder finder = new Finder(pattern);
		Files.walkFileTree(startingDir, opts, Integer.MAX_VALUE, finder);
		
		*/
		
		
		
		
		/*
		switch(options) {
		
		case '1' :
			// 1. changing only numbers
		
		case '2' : 
			// 2. change based on parent folder name
		
		default : 
			// same as case 1
			
		}
		*/
	}

}
