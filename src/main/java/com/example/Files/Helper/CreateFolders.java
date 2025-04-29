package com.example.Files.Helper;

import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javafx.scene.control.DatePicker;
import javafx.stage.DirectoryChooser;


public class CreateFolders {
	File selectedPaths;
	LocalDate startDate;
	LocalDate endDate;
	Label directoryForFolders;
	public void openCreateFoldersMenu(Stage foldersMenuStage) {
		directoryForFolders = new Label("C:\\");
		Button browsDirectory = new Button("Brows");
		Button createFolders = new Button("Create");
		
		
		DatePicker chooseStartOfDayPeriod = new DatePicker();
		DatePicker chooseEndOfDayPeriod = new DatePicker();
		
		
		
		DirectoryChooser directoryChooser = new DirectoryChooser();
		
		
		
		browsDirectory.setOnAction(event -> {
			selectedPaths = directoryChooser.showDialog(foldersMenuStage);
			directoryForFolders.setText(String.valueOf(selectedPaths));
		});
		
		chooseStartOfDayPeriod.setOnAction(event -> {
			startDate = chooseStartOfDayPeriod.getValue();
			
		});
		chooseEndOfDayPeriod.setOnAction(event -> {
			endDate = chooseEndOfDayPeriod.getValue();
		});
		
		createFolders.setOnAction(event -> {
			for(int i = startDate.getDayOfMonth(); i <= endDate.getDayOfMonth(); i++){
					try{
					Files.createDirectory(new File(createFolderDirectoryName(i - 1)).toPath());
				} catch(IOException e) {
					System.out.print(e);
				}
			}
			foldersMenuStage.close();
		});
	}
	
	private String createFolderName(int day) {
		LocalDate liquidDate = startDate.plusDays(day);
		DayOfWeek dayOfWeek = liquidDate.getDayOfWeek();
		return liquidDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")) + "---" + dayOfWeek;
	}
	
	private String createFolderDirectoryName(int day) {
		return selectedPaths + "\\" + createFolderName(day);
	}
}
