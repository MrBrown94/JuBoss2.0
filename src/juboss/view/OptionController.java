package juboss.view;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import juboss.MainApp;
import javafx.scene.control.Alert.AlertType;

public class OptionController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField fieldIngrosso;

    @FXML
    private TextField fieldDettaglio;

    @FXML
    void initialize() {
        assert fieldIngrosso != null : "fx:id=\"fieldIngrosso\" was not injected: check your FXML file 'Option.fxml'.";
        assert fieldDettaglio != null : "fx:id=\"fieldDettaglio\" was not injected: check your FXML file 'Option.fxml'.";

        int[] settings = juboss.Splash.db.getSettings();
        
        fieldIngrosso.setText(Integer.toString(settings[0]));
        fieldDettaglio.setText(Integer.toString(settings[1]));
        
    }
    
    @FXML
    void editOption(){
    	
    	juboss.Splash.db.setSettings(
    								Integer.parseInt(fieldIngrosso.getText()), 
    								Integer.parseInt(fieldDettaglio.getText())
    								);
    	
    	Alert alert = new Alert(AlertType.INFORMATION);
    	alert.setTitle("Opzioni Modificate");
    	alert.setHeaderText(null);
    	alert.setContentText("Opzioni Modificate!");
    	
    	alert.showAndWait();
    	MainApp.stageOption.close();
    }
    
    @FXML
    void close(){
    	
    	MainApp.stageOption.close();
    }
}
