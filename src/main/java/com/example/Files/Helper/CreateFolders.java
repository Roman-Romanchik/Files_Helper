package com.example.Files.Helper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CreateFolders {
	private String createFolderName(int day, LocalDate startPeriod) {
		return startPeriod.plusDays(day).format(
				DateTimeFormatter.ofPattern("dd.MM.yyyy")) + "---" + 
				startPeriod.plusDays(day).getDayOfWeek();
	}
	
	protected String createFolderDirectoryName(int day, LocalDate startPeriod, String path) {
		return path + "\\" + createFolderName(day, startPeriod);
	}
	
	protected void createFolders(int startDay, int endDay, LocalDate startPeriod, String path) {
		for(int i = startDay; i <= endDay; i++){
			try{
				Files.createDirectory(new File(
						createFolderDirectoryName(i - 1, startPeriod, path)).toPath());
			} catch(IOException e) {
				System.out.print(e);
			}
		}
	}
}