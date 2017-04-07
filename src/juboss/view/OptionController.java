package juboss.view;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

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
}
