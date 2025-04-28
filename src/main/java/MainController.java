import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import com.example.Files.Helper.App;

public class MainController {
	@FXML
	private Button createFoldersButton;
	@FXML
	private Label dateNow;
	
	App app = new App();
	
		
	@FXML
	public void openFoldersMenu(ActionEvent event) {
		app.openWindow("/create_Folders_View.fxml", new Stage());
	}
	
	@FXML
	public void addFilesMenu(ActionEvent event) {
		app.openWindow("/add_Files_View.fxml", new Stage());
	}
	
	@FXML
	public void thoughtsMenu(ActionEvent event) {
		app.openWindow("/thoughts_View.fxml", new Stage());
	}
	
	@FXML
	public void scheduleMenu(ActionEvent event) {
		app.openWindow("/schedule_View.fxml", new Stage());
	}
	
	@FXML
	public void profileMenu(ActionEvent event) {
		app.openWindow("/Profile_View.fxml", new Stage());
	}
}
