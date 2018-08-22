package com.fileNameTrim;

// MUST IMPORT THIS, to validate 'CONTINUE'.
import static java.nio.file.FileVisitResult.*;


// Must Explicitly add an import. Check the static import below.
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
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
		// print information about each type of file.
		System.out.println("file name : " + file_path.getFileName());
		System.out.format("type : " + file_path);
		System.out.println("size : " + attrib.size());
		System.out.println("creation time : " + attrib.creationTime());
		System.out.println("last access time : " + attrib.lastAccessTime());
		System.out.println("last modified time : " + attrib.lastModifiedTime());

		return CONTINUE;
	}

	
	
	// 3) postVisitDirectory
	// invoked after all the entries in a directory are visited.
	// If any errors are encountered, the specific exception is passed to the method.
	@Override
	public FileVisitResult postVisitDirectory (Path dir, IOException exc)
	{
		// print each directory visited
		System.out.format("directory : %s%n", dir);
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
