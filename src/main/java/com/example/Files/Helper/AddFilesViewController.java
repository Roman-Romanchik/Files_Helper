package com.example.Files.Helper;


import java.io.IOException;
import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.input.DragEvent;
import javafx.scene.input.TransferMode;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

public class AddFilesViewController implements Initializable {
	
	@FXML
	private Label directoryLabel, viewAddedFiles;
	@FXML
	private Parent root;
	
	private List listOfFiles;
	private DirectoryChooser directoryChooser;
	private String str;
	@FXML
	protected void selectDirectory() {
		directoryLabel.setText(String.valueOf(directoryChooser.showDialog(new Stage())));
	}
	
	@FXML
	protected void compareFilesToFolder() {
		if(listOfFiles == null) {
			App.stage.close();
		} else {
			Iterator<File> iterator = listOfFiles.iterator();
			while(iterator.hasNext()) {
				try {
					Path theFile = iterator.next().toPath();
					Path target = Paths.get(directoryLabel.getText());
					theFile = Files.move(theFile, target.resolve(theFile.getFileName()), REPLACE_EXISTING);
				} catch(IOException e) {
					System.out.print(e);
				}
			}
			App.stage.close();
		}
	}
	
	
	
	@FXML
	private void onDragDetected(DragEvent event){
		
		root.startDragAndDrop(TransferMode.MOVE);
		event.consume();
	};
	
	@FXML
	private void onDragOver(DragEvent event) {
		event.acceptTransferModes(TransferMode.MOVE);
		event.consume();
	}
	
	@FXML
	private void onDragEntered(DragEvent event) {
		root.setStyle("-fx-background-color: #00ff00");
		event.consume();
	};
	@FXML
	private void onDragExited(DragEvent event) {
		root.setStyle("-fx-background-color: #ffffff");
		event.consume();
	};
	
	@FXML
	private void onDragDropped(DragEvent event) {
		root.setStyle("-fx-background-color: #ffffff");
		listOfFiles = event.getDragboard().getFiles();
		Iterator<File> iterator = listOfFiles.iterator();
		while(iterator.hasNext()) {
				str += (iterator.next().toPath().getFileName()) + "\n";
			}
			viewAddedFiles.setText(str);
		event.consume();
	}
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		directoryChooser = new DirectoryChooser();
		listOfFiles = new LinkedList<File>();
		str = "";
	}	
	
}
