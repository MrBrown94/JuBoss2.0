package juboss.view;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AddEditController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField fieldPrezzo;

    @FXML
    private CheckBox checkManuale;

    @FXML
    private ComboBox<?> ComboRegione;

    @FXML
    private TextField fieldProduttore;

    @FXML
    private TextField fieldCapacit�;

    @FXML
    private TextField fieldDenominazione;

    @FXML
    private ComboBox<?> comboPaese;

    @FXML
    private TextArea textAreaNote;

    @FXML
    private TextField fieldIngrosso;

    @FXML
    private TextField fieldDettaglio;

    @FXML
    void initialize() {
        assert fieldPrezzo != null : "fx:id=\"fieldPrezzo\" was not injected: check your FXML file 'AddEdit.fxml'.";
        assert checkManuale != null : "fx:id=\"checkManuale\" was not injected: check your FXML file 'AddEdit.fxml'.";
        assert ComboRegione != null : "fx:id=\"ComboRegione\" was not injected: check your FXML file 'AddEdit.fxml'.";
        assert fieldProduttore != null : "fx:id=\"fieldProduttore\" was not injected: check your FXML file 'AddEdit.fxml'.";
        assert fieldCapacit� != null : "fx:id=\"fieldCapacit�\" was not injected: check your FXML file 'AddEdit.fxml'.";
        assert fieldDenominazione != null : "fx:id=\"fieldDenominazione\" was not injected: check your FXML file 'AddEdit.fxml'.";
        assert comboPaese != null : "fx:id=\"comboPaese\" was not injected: check your FXML file 'AddEdit.fxml'.";
        assert textAreaNote != null : "fx:id=\"textAreaNote\" was not injected: check your FXML file 'AddEdit.fxml'.";
        assert fieldIngrosso != null : "fx:id=\"fieldIngrosso\" was not injected: check your FXML file 'AddEdit.fxml'.";
        assert fieldDettaglio != null : "fx:id=\"fieldDettaglio\" was not injected: check your FXML file 'AddEdit.fxml'.";
        
        
      }
    
    @FXML
    public void checkFullFillment(){
    	
    	Alert alert = new Alert(AlertType.INFORMATION);
    	alert.setTitle("Errore");
    	alert.setHeaderText(null);
    	alert.setContentText("Il campo \"Denominazione\" deve essere riempito!");

    	if(fieldDenominazione.getText().equals(""))
    		alert.showAndWait();
    	else{};
    	
    }
}