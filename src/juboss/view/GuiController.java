package juboss.view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import juboss.MainApp;

public class GuiController {
	
	

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
    	
    		Stage primaryStage = new Stage();
    	//we should run AddEditMain from here
    	try {
            // Load gui.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/ListView.fxml"));
            AnchorPane listView = (AnchorPane) loader.load();
            //build scene
            Scene scene = new Scene(listView);
            primaryStage.setScene(scene);
            primaryStage.show();	            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
  
}
