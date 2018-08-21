package com.fileNameTrim;

import java.nio.file.Path;
import java.nio.file.Paths;

public class FileUtilMain {
	
	public static void main (String args[])
	{
		Path path = Paths.get("c:/");
		FileReadingClass fileReader = new FileReadingClass();
		fileReader.fileTraveler(path);
		
		
		
	}

}
