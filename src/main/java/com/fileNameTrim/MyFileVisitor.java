package com.fileNameTrim;

// MUST IMPORT THIS, to validate 'CONTINUE'.
import static java.nio.file.FileVisitResult.CONTINUE;
import static java.nio.file.FileVisitResult.SKIP_SUBTREE;
import static java.nio.file.FileVisitResult.TERMINATE;

// Must Explicitly add an import. Check the static import below.
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Scanner;

	class MyFileVisitor extends SimpleFileVisitor<Path>{

		FileModifierGadgets myTool = new FileModifierGadgets(); // where all options are

		// 1) preVisitDirectory
		// Any directory "SCCS" is skipped.
		@Override
		public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrib)
		{
			if (dir.getFileName().toString().equals("SCCS"))
			{
				System.out.println("@skipped directory : " + dir);
				return SKIP_SUBTREE;
			}
			//System.out.format("(pre visit) directory : %s%n", dir);

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

			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			myTool.file_name_printer(file_path);
			//myTool.optional_renamer(file_path);
			//myTool.mover_renamer(file_path);

			return CONTINUE;

		}



		// 3) postVisitDirectory
		// invoked after all the entries in a directory are visited.
		// If any errors are encountered, the specific exception is passed to the method.
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
		/*
	 // Circular Link handling example snippet
	 @Override
	public FileVisitResult
    visitFileFailed(Path file,
        IOException exc) {
    		if (exc instanceof FileSystemLoopException) {
        System.err.println("cycle detected: " + file);
    } else {
        System.err.format("Unable to copy:" + " %s: %s%n", file, exc);
    }
    return CONTINUE;
}
		 */
	}
