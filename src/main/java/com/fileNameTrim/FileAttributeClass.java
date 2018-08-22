package com.fileNameTrim;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

public class FileAttributeClass {

	public void fileAttributeShower(String fileName)
	{
		
		BasicFileAttributes attrib = null;
		Path file_path = Paths.get(fileName);

		try {
			attrib = Files.readAttributes(file_path, BasicFileAttributes.class);

			System.out.println("file name : " + file_path.getFileName());
			System.out.println("size : " + attrib.size());
			System.out.println("last access time : " + attrib.lastAccessTime());
			System.out.println("last modified time : " + attrib.lastModifiedTime());
			System.out.println("creation time : " + attrib.creationTime());

		} catch(IOException e)
		{
			e.printStackTrace();
		}

	}

}
