package com.fileNameTrim;

import java.io.File;
import java.util.Scanner;

public class FileTreeVisitor {

	Scanner scanner = new Scanner(System.in);

	void fileTraveler(File file)
	{
		int options = 1; // default, numeric
		
		System.out.println("Option '1' : numeric renaming");
		System.out.println("Option '2' : numeric + parent folder based renaming");
		System.out.println("Choose option : ");
		options = scanner.nextInt();
		
		switch(options) {
		
		case '1' :
			// 1. changing only numbers
		
		
		case '2' : 
			// 2. change based on parent folder name
		
		default : 
			// same as case 1
			
			
		}


	}


}
