package com.example.Files.Helper;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class AddFilesToFolder {
	
	GridPane root = new GridPane();
	Scene scene = new Scene(root, 300, 600);
	Stage addFilesStage = new Stage();
	Label miniLabel = new Label ("---");
	String filesNames = "";
	
	public void openAddFilesMenu() {
		scene.setOnDragDetected(event -> {
			scene.startDragAndDrop(TransferMode.ANY);
			event.consume();
		});
		
		scene.setOnDragOver(event -> {
			event.acceptTransferModes(TransferMode.MOVE);
			event.consume();
		});
		
		scene.setOnDragEntered(event -> {
			scene.setFill(Color.GREEN);
			event.consume();
		});
		
		scene.setOnDragExited(event -> {
			scene.setFill(Color.WHITE);
			event.consume();
		});
		
		scene.setOnDragDropped(event -> {
			
			Dragboard db = event.getDragboard();
			List<File> files = db.getFiles();
			Iterator<File> iterator = files.iterator();
			while(iterator.hasNext()) {
				filesNames += iterator.next().getName() + "\n";
			}
			miniLabel.setText(filesNames);
			event.consume();
		});
		
		root.add(miniLabel, 0,0);
		addFilesStage.setScene(scene);
		addFilesStage.show();
	}
	
	
	
	
}
