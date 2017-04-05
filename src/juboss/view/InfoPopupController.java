package juboss.view;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class InfoPopupController {


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField fieldProduttore;

    @FXML
    private TextField fieldTipo;

    @FXML
    private TextField fieldPaese;

    @FXML
    private TextField fieldCapacità;

    @FXML
    private TextArea fieldNote;

    @FXML
    private TextArea fieldDenominazione;

    @FXML
    private TextField fieldColore;

    @FXML
    void initialize() {
        assert fieldProduttore != null : "fx:id=\"fieldProduttore\" was not injected: check your FXML file 'InfoPopup.fxml'.";
        assert fieldTipo != null : "fx:id=\"fieldTipo\" was not injected: check your FXML file 'InfoPopup.fxml'.";
        assert fieldPaese != null : "fx:id=\"fieldPaese\" was not injected: check your FXML file 'InfoPopup.fxml'.";
        assert fieldCapacità != null : "fx:id=\"fieldCapacità\" was not injected: check your FXML file 'InfoPopup.fxml'.";
        assert fieldNote != null : "fx:id=\"fieldNote\" was not injected: check your FXML file 'InfoPopup.fxml'.";
        assert fieldDenominazione != null : "fx:id=\"fieldDenominazione\" was not injected: check your FXML file 'InfoPopup.fxml'.";
        assert fieldColore != null : "fx:id=\"fieldColore\" was not injected: check your FXML file 'InfoPopup.fxml'.";
        
        
        fieldDenominazione.setText(ListViewController.selected.getDenominazione());
        fieldProduttore.setText(ListViewController.selected.getProduttore());
        fieldCapacità.setText(ListViewController.selected.getCapacità());
        fieldTipo.setText(ListViewController.selected.getTipoVino());
        fieldNote.setText(ListViewController.selected.getNote());
        fieldPaese.setText(ListViewController.selected.getPaese());
    
    }
    
    
}
