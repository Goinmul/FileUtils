package com.fileNameTrim;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Scanner;

// IMPLEMENT LATER
public class FileVisitorLauncher {


	public void fileTravelerLauncher() throws IOException
	{
		Scanner myScanner = new Scanner(System.in);
		
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
		
		// instantiate basic file attributes
		BasicFileAttributes attrib = Files.readAttributes(path, BasicFileAttributes.class);
		
		// actual methods
		MyFileVisitor traveler = new MyFileVisitor();
		traveler.preVisitDirectory(path, attrib);

		IOException e = new IOException(); // ((!)) is this right syntax?
		traveler.postVisitDirectory(path, e);
		
		
		
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
