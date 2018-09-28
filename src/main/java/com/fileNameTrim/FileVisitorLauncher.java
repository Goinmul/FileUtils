package com.fileNameTrim;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class FileVisitorLauncher {

	// launcher without CLI implementation (just for myself)
	public void fileTravelerLauncher(String args[]) throws IOException
	{
		Scanner myScanner = new Scanner(System.in);
		FileTreeWalker myWalker = new FileTreeWalker();

		// test case
		// get file path from user
		System.out.print("type header file directory check : ");
		String header_directory = myScanner.nextLine();

		// directory valid check
		File directory_valid_check = new File(header_directory);
		if(directory_valid_check.isDirectory() == false)
		{
			System.out.println(header_directory + " is not a valid directory.");
			System.exit(1);
		}

		Path path = Paths.get(header_directory);

		//0) organized in my other class
		MyFileVisitor traveler = new MyFileVisitor();
		myWalker.walkFileTree(path, traveler);
		
	}
	
	
	// launcher for distribution (CLI option added)
	public void fileTravelerLauncherCLI(String args[]) throws IOException, ParseException
	{
		// 1. Creating options.
		// create Options object
		Options options = new Options();
		
		// add options
		options.addOption(Option.builder("n").longOpt("numeric")
				.desc("numeric serialization for image files (000~999)")
				.build());
		
		options.addOption(Option.builder("a").longOpt("add string")
				.desc("add string at the end of file name")
				.hasArg().argName("input string")
				.build());

		options.addOption(Option.builder("h").longOpt("help")
				.desc("print help message")
				.build());
		
		options.addOption(Option.builder("p").longOpt("print list")
				.desc("print all the file list under the directory")
				.build());
		
		// create parser (DefaultParser is recommended)
		CommandLineParser parser = new DefaultParser();
		CommandLine cmd = parser.parse(options, args);


		// 2. Set actions for each option respectively.
		if (cmd.hasOption("p"))
		{
			// print
			
		}
		
		else if (cmd.hasOption("n"))
		{
			// numeric serialization for image files (000~999)
			
		}
		
		else if (cmd.hasOption("a"))
		{
			// add string at the end of file name
			
		}

		else if (cmd.hasOption("h"))
		{
			// HelpFormatter shows the help message. (optional)
			HelpFormatter formatter = new HelpFormatter();
			formatter.printHelp("file util options", options);
		}
		
		else
		{
			System.out.println("no options input from user - exit program.");
			System.exit(1);
		}



		Scanner myScanner = new Scanner(System.in);
		FileTreeWalker myWalker = new FileTreeWalker();

		// test case
		// get file path from user
		System.out.print("type header file directory check : ");
		String header_directory = myScanner.nextLine();

		// directory valid check
		File directory_valid_check = new File(header_directory);
		if(directory_valid_check.isDirectory() == false)
		{
			System.out.println(header_directory + " is not a valid directory.");
			System.exit(1);
		}

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
