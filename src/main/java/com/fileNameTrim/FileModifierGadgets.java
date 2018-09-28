package com.fileNameTrim;

import java.io.File;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/*
 * <Method explanation>
 * bottom level workers. will be called the most, affecting the program performance the most.
 * !)Path valid check already done in FileVisitorLauncher class
 * 
 * 1) optional_renamer : add a string, at the end of a file name
 * 2) sequential_file_organizer : serially renames image files(jpg, jpeg, png, gif, ...)
 * 
 * 
 * 
 * @author HW
 */
public class FileModifierGadgets {

	public void optional_renamer(Path path)
	{
		// pass parameter, converting Path type to String type to modify
		String file_name_string = path.toString();
		File file_1 = new File(file_name_string);
		System.out.println(file_name_string);
		
		// regular expression logic 
		// splitting actual file name and ".type" 
		// Example) "file1.txt" -> "file1" + ".txt"
		
		// regex for a file name (like file1.txt)
		Pattern file_name_pattern = Pattern.compile("(.+)(\\..+)");
		Matcher myMatcher = file_name_pattern.matcher(file_name_string);
		
		String added_part = "";
		// gets into if statement, when the file name explicitly shows its type.
		// example) data_file.txt
		
		if (myMatcher.find()) 
		{
			String actual_file_name = null;
			String file_type = null;
			
			// if the file name was "book.txt", group(1) is "book"
			actual_file_name = myMatcher.group(1);
			// and group(2) is ".txt"
			file_type = myMatcher.group(2);

			// ex) book_ADDED.txt
			String new_name = actual_file_name + added_part + file_type; 
			File file_1_moved = new File(new_name);
			
			// actually moving/renaming code
			boolean isMoved  = file_1.renameTo(file_1_moved);
			
			if (isMoved == true)
			{
				System.out.println("file [" + file_1_moved +"] is created.\r");
			}
			if (isMoved == false)
			{
				System.out.println("file [" + file_1 + "] is not modified.\r");
			}
			
		}
		
		// gets into else if statement, when the file doesn't have extension(intentionally deleted, ...)
		// example) data_file (full name should have been data_file.txt)
		else
		{
			String new_name = file_name_string + added_part;
			File file_1_moved = new File(new_name);
			
			// actually moving/renaming code
			boolean isMoved  = file_1.renameTo(file_1_moved);
			
			if (isMoved == true)
			{
				System.out.println("file [" + file_1_moved +"] is created.\r");
			}
			if (isMoved == false)
			{
				System.out.println("file [" + file_1 + "] is not modified.\r");
			}
			
		}
	}
	
		
		public void sequential_file_organizer(Path path)
		{

			// pass parameter, converting Path type to String type to modify
			String file_name_string = path.toString();
			File file_1 = new File(file_name_string);
			System.out.println(file_name_string);
			
			// regular expression logic 
			// splitting actual file name and ".type" 
			// Example) "file1.txt" -> "file1" + ".txt"
			
			// regex for a file name (like file1.txt)
			Pattern file_name_pattern = Pattern.compile("(.+)(\\..+)");
			Matcher myMatcher = file_name_pattern.matcher(file_name_string);
			
			// ((!)) set this String for your customized usage.
			String added_part = "x0x0x0x0x";
			
			// gets into if statement, when the file name explicitly shows its type.
			// example) data_file.txt
			if (myMatcher.find()) 
			{
				String actual_file_name = null;
				String file_type = null;
				
				// if the file name was "book.txt", group(1) is "book"
				actual_file_name = myMatcher.group(1);
				// and group(2) is ".txt"
				file_type = myMatcher.group(2);

				String new_name = actual_file_name + added_part + file_type; 
				File file_1_moved = new File(new_name);
				
				// actually moving/renaming code
				boolean isMoved  = file_1.renameTo(file_1_moved);
				
				if (isMoved == true)
				{
					System.out.println("file [" + file_1_moved +"] is created.\r");
				}
				if (isMoved == false)
				{
					System.out.println("file [" + file_1 + "] is not modified.\r");
				}
				
			}
			
			// gets into else if statement, when the file name implicitly contains its type.
			// example) data_file (full name would be data_file.txt)
			else
			{
				String new_name = file_name_string + added_part;
				File file_1_moved = new File(new_name);
				
				// actually moving/renaming code
				boolean isMoved  = file_1.renameTo(file_1_moved);
				
				if (isMoved == true)
				{
					System.out.println("file [" + file_1_moved +"] is created.\r");
				}
				if (isMoved == false)
				{
					System.out.println("file [" + file_1 + "] is not modified.\r");
				}
				
			}
		
	}
		public void file_name_printer(Path path)
		{
			String file_name_string = path.toString();
			System.out.println(file_name_string);
		}
		
		
	// if you are moving a file to a different directory
			// and you want to delete the original file after moving,
			// use below lines : 

			/*
			File file_1 = new File(file_name_string);
			File file_1_moved = new File(new_name);

			// actually moving/renaming code
			boolean isMoved  = file_1.renameTo(file_1_moved);

			if(isMoved == true)
			{
				if(file_1.delete())
					System.out.println("file is moved and original file is deleted.");
				//boolean reminiscence = file.exists(); // for check
			}
			 */
		//
	

}
