package com.fileNameTrim;

import static java.nio.file.FileVisitResult.CONTINUE;
import static java.nio.file.FileVisitResult.SKIP_SUBTREE;
import static java.nio.file.FileVisitResult.TERMINATE;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class FileVisitorsGroup {
	
	// *Options
	// 
	class OptionalRenamer extends SimpleFileVisitor<Path>{

		FileModifierGadgets myTool = new FileModifierGadgets(); // where all options are
		
		// 1) preVisitDirectory
		@Override
		public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrib)
		{
			if (dir.getFileName().toString().equals("SCCS"))
			{
				System.out.println("@skipped directory : " + dir);
				return SKIP_SUBTREE;
			}
			return CONTINUE;
		}


		// 2) visitFile
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

			myTool.optional_renamer(file_path);
			return CONTINUE;

		}

		// 3) postVisitDirectory
		@Override
		public FileVisitResult postVisitDirectory (Path dir, IOException exc)
		{
			// print each directory visited
			//System.out.format("(post visit) directory : %s%n", dir);
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

	
	
	
	

}
