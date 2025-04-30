package com.example.Files.Helper;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

public class CreateFoldersViewController implements Initializable {
	
	private CreateFolders createFolders;
	private DirectoryChooser directoryChooser;
	
	@FXML
	private DatePicker datePickerFrom, datePickerTo;
	@FXML
	private TextField pathForFolders;
	
	@FXML
	protected void selectDirectory() {
		pathForFolders.setText(String.valueOf(directoryChooser.showDialog(new Stage())));
	}
	
	@FXML
	protected void createFolders() {
		createFolders.createFolders(datePickerFrom.getValue().getDayOfMonth(), 
				datePickerTo.getValue().getDayOfMonth(), datePickerFrom.getValue(), 
				pathForFolders.getText());
		App.stage.close();
	}
		
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		directoryChooser = new DirectoryChooser();
		createFolders = new CreateFolders();
	}	
}
