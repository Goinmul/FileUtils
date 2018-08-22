package com.fileNameTrim;

import java.io.File;

public class FileMoverOrRenamer {

	// bottom level worker. will be called a lot, changing every file name.
	public void mover_renamer()
	{
		// put existing file name here.
		File file_1 = new File("d:/text1.txt");

		// put new name or a new directory.
		File file_1_moved = new File("d:/text1_moved.txt");

		// actually moving/renaming code
		boolean isMoved  = file_1.renameTo(file_1_moved);
		
		if (isMoved == false)
		{
			System.out.println("file " + file_1 + "is not modified.");
		}
		
		// if you are moving a file to a different directory
		// and you want to delete the original file after moving,
		// use below lines : 
		/*
		if(isMoved == true)
		{
			if(file_1.delete())
				System.out.println("file is moved and original file is deleted.");
			//boolean reminiscence = file.exists(); // for check
		}
		*/

	}


}
