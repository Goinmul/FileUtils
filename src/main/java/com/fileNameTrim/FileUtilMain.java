package com.fileNameTrim;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import org.apache.commons.cli.ParseException;

import java.nio.file.attribute.BasicFileAttributes;
// input : a header file name( ex - c:/myfile )
// output : void
// result : changed names, under all the files in the folders of the header file
public class FileUtilMain {
	
	public static void main (String args[]) throws IOException, ParseException
	{
		FileVisitorLauncher fileReader = new FileVisitorLauncher();
		fileReader.fileTravelerLauncher(args); // with CLI options
		
	}

}
