package com.example.Files.Helper;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Font;
import javafx.util.Duration;

public class App extends Application {
   
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage stage) {
        stage.setTitle("Files Helper");
        
		Tooltip tooltipForButtonsCreateFolders = new Tooltip("create folders");
		tooltipForButtonsCreateFolders.setShowDelay(Duration.ZERO);
		
		Tooltip tooltipForButtonAddFiles = new Tooltip("Add files");
		tooltipForButtonAddFiles.setShowDelay(Duration.ZERO);
		
        Label labelChooseAction = new Label("Choose your action");
		labelChooseAction.setFont(Font.font(20));
		GridPane.setHalignment(labelChooseAction, HPos.CENTER);
		GridPane.setValignment(labelChooseAction, VPos.CENTER);
		
        Button buttonCreateFolders = new Button("Create folders");
		buttonCreateFolders.setFont(Font.font(15));
		GridPane.setHalignment(buttonCreateFolders, HPos.RIGHT);
		GridPane.setValignment(buttonCreateFolders, VPos.CENTER);
		buttonCreateFolders.setMaxWidth(120);
		buttonCreateFolders.setMaxHeight(35);
		buttonCreateFolders.setTooltip(tooltipForButtonsCreateFolders);
		
        Button buttonAddFiles = new Button("Add files");
		buttonAddFiles.setFont(Font.font(15));
		GridPane.setHalignment(buttonAddFiles, HPos.LEFT);
		GridPane.setValignment(buttonAddFiles, VPos.CENTER);
		buttonAddFiles.setMaxWidth(120);
		buttonAddFiles.setMaxHeight(35);
		buttonAddFiles.setTooltip(tooltipForButtonAddFiles);
        
        
        
        GridPane root = new GridPane();
		
		
		ColumnConstraints firstColumn = new ColumnConstraints(200, 200, Double.MAX_VALUE);
		ColumnConstraints secondColumn = new ColumnConstraints(200, 200, Double.MAX_VALUE);
		ColumnConstraints thirdColumn = new ColumnConstraints(200, 200, Double.MAX_VALUE);
		
		RowConstraints firstRow = new RowConstraints(50);
		RowConstraints secondRow = new RowConstraints(50);
		
		firstColumn.setHgrow(Priority.ALWAYS);
		secondColumn.setHgrow(Priority.ALWAYS);
		thirdColumn.setHgrow(Priority.ALWAYS);
		
		root.getColumnConstraints().add(firstColumn);
		root.getColumnConstraints().add(secondColumn);
		root.getColumnConstraints().add(thirdColumn);
		
		root.getRowConstraints().add(firstRow);
		root.getRowConstraints().add(secondRow);
		
        root.add(labelChooseAction, 1, 0);
        root.add(buttonCreateFolders, 0, 1);
        root.add(buttonAddFiles, 2, 1);
        
        buttonCreateFolders.setOnAction(event ->{
			CreateFolders createFolders = new CreateFolders();
			createFolders.openCreateFoldersMenu();
		});
        buttonAddFiles.setOnAction(event -> {
			AddFilesToFolder addFilesToFolder = new AddFilesToFolder();
			addFilesToFolder.openAddFilesMenu();
		});
		
        Scene scene = new Scene(root, 600, 400);
        
        stage.setScene(scene);
        stage.show();
    }
}
