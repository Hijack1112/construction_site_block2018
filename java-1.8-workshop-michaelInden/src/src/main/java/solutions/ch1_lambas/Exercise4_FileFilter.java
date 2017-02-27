package src.main.java.solutions.ch1_lambas;

import java.io.File;
import java.io.FileFilter;

/**
 * Beispielprogramm im Rahmen des Java 8 Hands on Workshops
 * 
 * @author Michael Inden
 *
 * Copyright 2016 by Michael Inden
 */
public class Exercise4_FileFilter {

	public static void main(final String[] args) 
	{
		final FileFilter direcoryFilter = new FileFilter()
		{
			@Override
			public boolean accept(final File pathname) 
			{
				return pathname.isDirectory();
			}	
		};

		final FileFilter pdfFileFilter = new FileFilter()
		{
			@Override
			public boolean accept(final File pathname) 
			{
				return (pathname.isFile() && 
					    pathname.getName().toLowerCase().endsWith(".pdf"));
			}	
		};
		
		// JDK 8
		final FileFilter direcoryFilterJDK8 = File::isDirectory;
		final FileFilter pdfFileFilterJDK8 = pathname -> 
		{
			return (pathname.isFile() && 
					pathname.getName().toLowerCase().endsWith(".pdf"));
		};
	}
}
