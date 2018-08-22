package com.fileNameTrim;

import java.nio.file.Path;
import java.nio.file.Paths;

// input : a header file name( ex - c:/myfile )
// output : void
// result : changed names, under all the files in the folders of the header file
public class FileUtilMain {
	
	public static void main (String args[])
	{
		Path path = Paths.get("c:/");
		FileTreeVisitor fileReader = new FileTreeVisitor();
		
		// get file path from user
		
	}

}
