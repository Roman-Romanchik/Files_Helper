package com.example.Files.Helper;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class MainController {
	
	App app = new App();
	
	@FXML
	public void openFoldersMenu(ActionEvent event) {
		app.openWindow("/createFoldersView.fxml", App.stage);
	}
	
	@FXML
	public void addFilesMenu(ActionEvent event) {
		app.openWindow("/addFilesView.fxml", App.stage);
	}
	
	@FXML
	public void thoughtsMenu(ActionEvent event) {
		app.openWindow("/thoughtsView.fxml", App.stage);
	}
	
	@FXML
	public void scheduleMenu(ActionEvent event) {
		app.openWindow("/scheduleView.fxml", App.stage);
	}
	
	@FXML
	public void profileMenu(ActionEvent event) {
		app.openWindow("/profileView.fxml", App.stage);
	}
	
	@FXML
	public void dayRecordsMenu(ActionEvent event) {
		app.openWindow("/dayRecordsView.fxml", App.stage);
	}
	
	@FXML
	public void cardDayMenu(ActionEvent event) {
		app.openWindow("/cardDay.fxml", App.stage);
	}
	
	@FXML
	public void MSABGMenu(ActionEvent event) {
		app.openWindow("/msabg.fxml", App.stage);
	}
	
	@FXML
	public void grapghMenu(ActionEvent event) {
		app.openWindow("/graphsView.fxml", App.stage);
	}
	
	@FXML
	public void materialsMenu(ActionEvent event) {
		app.openWindow("/materialsView.fxml", App.stage);
	}
	
	@FXML
	public void libraryMenu(ActionEvent event) {
		app.openWindow("/libraryView.fxml", App.stage);
	}
	
	@FXML
	public void purposesMenu(ActionEvent event) {
		app.openWindow("/purposesView.fxml", App.stage);
	}
	
//	@FXML
//	public void settingsMenu(ActionEvent event) {
//		app.openWindow("/Profile_View.fxml", new Stage());
//	}
}
