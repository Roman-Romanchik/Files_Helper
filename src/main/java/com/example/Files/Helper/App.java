package com.example.Files.Helper;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Parent;

public class App extends Application {
   
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage stage) {
        stage.setTitle("Files Helper");
		openWindow("/main_View.fxml", stage);
    }
	
	public void openWindow(String resourcePath, Stage stage) {
		Parent root;
		try{
			root = FXMLLoader.load(getClass().getResource(resourcePath));
			Scene scene = new Scene(root);
        
			stage.setScene(scene);
			stage.show();
		} catch (IOException ex) {
			Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
