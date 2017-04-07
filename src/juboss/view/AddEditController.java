package juboss.view;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
    private ComboBox<?> comboRegione;

    @FXML
    private TextField fieldProduttore;

    @FXML
    private TextField fieldTipoVino;

    @FXML
    private TextField fieldCapacità;

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
        assert comboRegione != null : "fx:id=\"ComboRegione\" was not injected: check your FXML file 'AddEdit.fxml'.";
        assert fieldProduttore != null : "fx:id=\"fieldProduttore\" was not injected: check your FXML file 'AddEdit.fxml'.";
        assert fieldTipoVino != null : "fx:id=\"fieldTipoVino\" was not injected: check your FXML file 'AddEdit.fxml'.";
        assert fieldCapacità != null : "fx:id=\"fieldCapacità\" was not injected: check your FXML file 'AddEdit.fxml'.";
        assert fieldDenominazione != null : "fx:id=\"fieldDenominazione\" was not injected: check your FXML file 'AddEdit.fxml'.";
        assert comboPaese != null : "fx:id=\"comboPaese\" was not injected: check your FXML file 'AddEdit.fxml'.";
        assert textAreaNote != null : "fx:id=\"textAreaNote\" was not injected: check your FXML file 'AddEdit.fxml'.";
        assert fieldIngrosso != null : "fx:id=\"fieldIngrosso\" was not injected: check your FXML file 'AddEdit.fxml'.";
        assert fieldDettaglio != null : "fx:id=\"fieldDettaglio\" was not injected: check your FXML file 'AddEdit.fxml'.";
        
        
        fieldPrezzo.focusedProperty().addListener(new ChangeListener<Boolean>()
        {
            @Override
            public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldPropertyValue, Boolean newPropertyValue)
            {
                if (newPropertyValue)
                {
                    System.out.println("Textfield on focus");
                }
                else
                {
                    System.out.println("Textfield out focus");
                    fieldPrezzo.setText(fieldPrezzo.getText().replaceAll(",", "."));
                    if(!fieldPrezzo.getText().contains("."))
                    	fieldPrezzo.setText(fieldPrezzo.getText().concat(".00"));
                    
                }
            }
        });

    }
    @FXML
    public void checkAndInsert(){
    	
    	Alert alert = new Alert(AlertType.INFORMATION);
    	alert.setTitle("Errore");
    	alert.setHeaderText(null);
    	alert.setContentText("Il campo \"Denominazione\" deve essere riempito!");
    	
    	Alert aggiunto = new Alert(AlertType.INFORMATION);
    	aggiunto.setTitle("Aggiunto.");
    	aggiunto.setHeaderText(null);
    	aggiunto.setContentText("Elemento Aggiunto!");
    	
    	
    	
    	
    	if(fieldDenominazione.getText().equals(""))
    		alert.showAndWait();
    	
    	else 
    		if(fieldPrezzo.getText().equals("")||fieldIngrosso.getText().equals("")||fieldDettaglio.getText().equals(""))
	    		{
	    			juboss.Splash.db.insertData(	fieldDenominazione.getText().toUpperCase(), 
							fieldProduttore.getText().toUpperCase(), 
							fieldTipoVino.getText().toUpperCase(), 
							""+comboPaese.getSelectionModel().getSelectedIndex(), 
							""+comboRegione.getSelectionModel().getSelectedIndex(),
							fieldCapacità.getText().toUpperCase(), 
							textAreaNote.getText().toUpperCase(), 
							Double.parseDouble("0"), 
							Double.parseDouble("0"), 
							Double.parseDouble("0"),
							checkManuale.isSelected()
						);
	    			
	    			//update lista dopo inserimento
    				juboss.Splash.viniOb = juboss.Splash.db.getAllData();
    				
    				aggiunto.showAndWait();
	    		}
		    	
	    		else{
	    				juboss.Splash.db.insertData(	fieldDenominazione.getText().toUpperCase(), 
	    												fieldProduttore.getText().toUpperCase(), 
	    												fieldTipoVino.getText().toUpperCase(), 
		    											""+comboPaese.getSelectionModel().getSelectedIndex(), 
		    											""+comboRegione.getSelectionModel().getSelectedIndex(),
		    											fieldCapacità.getText().toUpperCase(), 
		    											textAreaNote.getText().toUpperCase(), 
		    											Double.parseDouble(fieldPrezzo.getText()), 
		    											Double.parseDouble(fieldIngrosso.getText()), 
		    											Double.parseDouble(fieldDettaglio.getText()),
		    											checkManuale.isSelected()
		    										);
    				
    			    //update lista dopo inserimento
    				juboss.Splash.viniOb = juboss.Splash.db.getAllData();
    				
    				aggiunto.showAndWait();
    				
    		    	
    				
    			};
    		
    }
    
	
    @FXML
    void manualMode(){}
    
}