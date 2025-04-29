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
	
	@FXML
	public void dayRecordsMenu(ActionEvent event) {
		app.openWindow("/dayRecordsView.fxml", new Stage());
	}
	
	@FXML
	public void cardDayMenu(ActionEvent event) {
		app.openWindow("/cardDay.fxml", new Stage());
	}
	
	@FXML
	public void MSABGMenu(ActionEvent event) {
		app.openWindow("/MSABG.fxml", new Stage());
	}
	
	@FXML
	public void grapghMenu(ActionEvent event) {
		app.openWindow("/graphsView.fxml", new Stage());
	}
	
	@FXML
	public void materialsMenu(ActionEvent event) {
		app.openWindow("/materialsView.fxml", new Stage());
	}
	
	@FXML
	public void libraryMenu(ActionEvent event) {
		app.openWindow("/libraryView.fxml", new Stage());
	}
	
	@FXML
	public void purposesMenu(ActionEvent event) {
		app.openWindow("/purposesView.fxml", new Stage());
	}
	
//	@FXML
//	public void settingsMenu(ActionEvent event) {
//		app.openWindow("/Profile_View.fxml", new Stage());
//	}
}
