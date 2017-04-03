package juboss.view;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class ListViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField search;

    @FXML
    private TableView<?> tableDettaglio;

    @FXML
    private TableView<?> tableIngrosso;

    @FXML
    void initialize() {
        assert search != null : "fx:id=\"search\" was not injected: check your FXML file 'ListView.fxml'.";
        assert tableDettaglio != null : "fx:id=\"tableDettaglio\" was not injected: check your FXML file 'ListView.fxml'.";
        assert tableIngrosso != null : "fx:id=\"tableIngrosso\" was not injected: check your FXML file 'ListView.fxml'.";

    }
}
