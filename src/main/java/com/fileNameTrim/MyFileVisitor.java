package com.fileNameTrim;

// MUST IMPORT THIS, to validate 'CONTINUE'.
import static java.nio.file.FileVisitResult.*;

import java.io.File;
// Must Explicitly add an import. Check the static import below.
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class MyFileVisitor extends SimpleFileVisitor<Path>{

	
	// 1) preVisitDirectory
	// Any directory "SCCS" is skipped.
	@Override
	public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrib)
	{
		if (dir.getFileName().toString().equals("SCCS"))
		{
			return SKIP_SUBTREE;
		}
		return CONTINUE;
	}
	

	
	// 2) visitFile
	// invoked on the file being visited.
	// you should put your logic for each file in here.
	@Override
	public FileVisitResult visitFile(Path file_path, BasicFileAttributes attrib)
	{
		// if the program reaches at a specific file, terminates program
		Path sensitive_directory = Paths.get("c:/programfiles");
		if (file_path.getFileName().equals(sensitive_directory))
		{
			System.out.println("Dangerous directory reached : " + file_path);
			return TERMINATE;
		}
		
		// print information about each type of file.
		System.out.println("file name : " + file_path.getFileName());
		System.out.format("type : " + file_path);
		System.out.println("size : " + attrib.size());
		System.out.println("creation time : " + attrib.creationTime());
		System.out.println("last access time : " + attrib.lastAccessTime());
		System.out.println("last modified time : " + attrib.lastModifiedTime());

		// renaming file.
		File original = file_path.toFile();

		// ((!)) would the file name be shown like "01.txt" or just "01"? MUST EXPERIMENT show it is shown like.
		// I think previous one is shown.
		
		// logic for changing 1, 01, 001 to 0001.
		// consider : 02-1
		// consider : 1.2
		// consider : random_word_02
		// consider : 19301402701307 - > no answer, so just ignore
		
		// logic : 
		// 1) at the very beginning, parse the type of file. (ex) "01.txt" -> "01", ".txt"
		// 2) delete everything except the considered parsing chars.
		// then the remaining string should be like this :
		
		// 02-1 -> 02-1
		// 1.2 -> 1.2
		// random_word_02 -> __02
		
		// 3) now depending on what parser the line has, (count all types of parser, and choose the most found one. If same, weight one that comes later. 
		// parse the remaining numbers to a temporary array.
		
		String unprocessed = original.getName(); // it would be like sample_file.txt
		String new_name = null;
		
		
		
		
		
		File renamed = new File(new_name);

		// actually moving/renaming code
		boolean isMoved  = original.renameTo(renamed); // in Unix or Linux, you might need this code due to access authority.
		if (isMoved == false)
		{
			System.out.print("At " + file_path + " ");
			System.out.println("file : " + original + " is not modified.");
		}
		
		return CONTINUE;
		
	}

	
	
	// 3) postVisitDirectory
	// invoked after all the entries in a directory are visited.
	// If any errors are encountered, the specific exception is passed to the method.
	@Override
	public FileVisitResult postVisitDirectory (Path dir, IOException exc)
	{
		// print each directory visited
		System.out.format("(post visit) directory : %s%n", dir);
		return CONTINUE;
	}


	
	// 4) visitFileFailed
	@Override
	public FileVisitResult visitFileFailed(Path file_path, IOException exc)
	{
		System.err.println(exc);
		return CONTINUE;
	}



}
