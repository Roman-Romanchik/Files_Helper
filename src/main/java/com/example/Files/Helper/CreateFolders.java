package com.example.Files.Helper;

import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.RowConstraints;
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
	public void openCreateFoldersMenu() {
		directoryForFolders = new Label("C:\\");
		Button browsDirectory = new Button("Brows");
		Button createFolders = new Button("Create");
		
		
		DatePicker chooseStartOfDayPeriod = new DatePicker();
		DatePicker chooseEndOfDayPeriod = new DatePicker();
		
		
		
		DirectoryChooser directoryChooser = new DirectoryChooser();
		
		Stage foldersMenuStage = new Stage();
		
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
		
		
		GridPane root = new GridPane();
		
		ColumnConstraints firstColumn = new ColumnConstraints(200, 200, Double.MAX_VALUE);
		ColumnConstraints secondColumn = new ColumnConstraints(200, 200, Double.MAX_VALUE);
		
		RowConstraints firstRow = new RowConstraints(50);
		RowConstraints secondRow = new RowConstraints(50);
		RowConstraints thirdRow = new RowConstraints(50);
		
		root.getColumnConstraints().add(firstColumn);
		root.getColumnConstraints().add(secondColumn);
		
		root.getRowConstraints().add(firstRow);
		root.getRowConstraints().add(secondRow);
		root.getRowConstraints().add(thirdRow);
		
		root.add(directoryForFolders, 0, 0);
		root.add(browsDirectory, 1, 0);
		root.add(chooseStartOfDayPeriod, 0, 2);
		root.add(chooseEndOfDayPeriod, 1, 2);
		root.add(createFolders, 3, 3);
		
		Scene scene = new Scene(root);
		
		
		
		foldersMenuStage.setScene(scene);
		
		foldersMenuStage.show();
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
