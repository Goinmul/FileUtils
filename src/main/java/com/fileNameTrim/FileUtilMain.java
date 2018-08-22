package com.fileNameTrim;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

// input : a header file name( ex - c:/myfile )
// output : void
// result : changed names, under all the files in the folders of the header file
public class FileUtilMain {
	
	
	public static void main (String args[])
	{
		Scanner myScanner = new Scanner(System.in);
		String header_directory = myScanner.nextLine();
		
		Path path = Paths.get(header_directory);
		
		FileVisitorLauncher fileReader = new FileVisitorLauncher();
		
		// get file path from user
		
	}

}
