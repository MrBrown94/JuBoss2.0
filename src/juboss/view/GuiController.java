package juboss.view;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import juboss.AddEdit;
import juboss.List;
import juboss.MainApp;

public class GuiController {
	
	private MainApp mainapp;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button ShowListBtn;

    @FXML
    private Button AddEditBtn;

    @FXML
    void initialize() {
        assert ShowListBtn != null : "fx:id=\"ShowListBtn\" was not injected: check your FXML file 'Gui.fxml'.";
        assert AddEditBtn != null : "fx:id=\"AddEditBtn\" was not injected: check your FXML file 'Gui.fxml'.";

    }
    
    @FXML
    void launchAddEdit() {
    	//we should run AddEditMain from here
    	MainApp.LaunchAddEdit();
    }
    
    /**
     * Is called by the main application to give a reference back to itself
     * 
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainapp = mainApp;
    }

}
