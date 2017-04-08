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
import javafx.scene.layout.AnchorPane;

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
    private AnchorPane root;

    @FXML
    private TextField fieldDettaglio;
    
    //array settings
    int[] settings;   
        
    //this string contains the legal char input
    String legalRange = "1234567890,.";

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
        assert root != null : "fx:id=\"root\" was not injected: check your FXML file 'AddEdit.fxml'.";
       
        
        settings = juboss.Splash.db.getSettings();
        
     
        fieldPrezzo.focusedProperty().addListener(new ChangeListener<Boolean>()
        {
            @Override
            public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldPropertyValue, Boolean newPropertyValue)
            {
                if (!newPropertyValue)
                
                	//concat .00 if the input is integer or not complete
                {      
	                    if(!fieldPrezzo.getText().contains(".") && !fieldPrezzo.getText().equals("") )
		                    	fieldPrezzo.setText(fieldPrezzo.getText().concat(".00"));
	                    
	                    if(!fieldPrezzo.getText().contains(".") && !fieldPrezzo.getText().contains(".00")) {
	                    		fieldPrezzo.setText(fieldPrezzo.getText().concat(".00"));
	                    }
	                    if(fieldPrezzo.getText().lastIndexOf(".") == fieldPrezzo.getText().length()-1){
                    	    	fieldPrezzo.setText(fieldPrezzo.getText().concat("00"));

	                    }
                    
                }
            }
        });
        
            
        
		//listener on fieldPrezzo 
        	//replaces , with .
        	//check the inserted char if it's contained in legalRange
        	//if checks fail replace the previous content (oldValue)
        
        fieldPrezzo.textProperty().addListener(new ChangeListener<String>() {
		 
		    @Override
		    public void changed(ObservableValue<? extends String> observable,
		            String oldValue, String newValue) {

		    	//int in = newValue.length() - oldValue.length();
		    	
		    //replaces AT RUNTIME each , with . 
		    	
		    	if(newValue.contains(",")) fieldPrezzo.setText(fieldPrezzo.getText().replaceAll(",", "."));
		    	
		    	
		    	
		    	if(newValue.length()>0)	
		    		
		    		//check if new inserted char is in the legal range
		    		
			    	if(legalRange.contains(""+newValue.charAt(newValue.length()-1)))
			    	{
			    		//check if manual mode isn't enabled
			    		
			    		if(!checkManuale.isSelected())
			    			percentCalc();
			    	}
			    	else
		    			fieldPrezzo.setText(oldValue);
		    }
		});
		
		
     }
    
    
    //check denominazione and insert
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
    		//if prezzo dettaglio or ingrosso are empty , replace content with "0"
    		
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
    				
    				//clean form    				
    				
    				cleanForm();
	    		
	    		}
		    	
    		//if prezzo dettaglio or ingrosso are NOT empty , puts content on db

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
    				
    			    //update list after insert
    				juboss.Splash.viniOb = juboss.Splash.db.getAllData();
    				
    				aggiunto.showAndWait();
    				
    				//clean form
    				
    				cleanForm();
    				
    			};
    			
    }
    
    //grab focus on click on the bg
	@FXML
	void grabFocus(){
		
		root.requestFocus();
		
		fieldDettaglio.setText(fieldDettaglio.getText().replaceAll(",", "."));
        
        
        if(!fieldDettaglio.getText().contains(".") && !fieldDettaglio.getText().equals("") )
            	fieldDettaglio.setText(fieldDettaglio.getText().concat(".00"));
        
        if(!fieldIngrosso.getText().contains(".") && !fieldIngrosso.getText().equals("") )
        	fieldIngrosso.setText(fieldIngrosso.getText().concat(".00"));
    
	}
    
	//fill dettaglio and ingrosso with values calculated by options
	@FXML
	void percentCalc(){
	
		if(!fieldPrezzo.getText().equals(""))
		{
			fieldDettaglio.setText(Double.toString(Math.ceil(Double.parseDouble(fieldPrezzo.getText()) + Double.parseDouble(fieldPrezzo.getText())/100*settings[0])+1) );
			fieldIngrosso.setText(Double.toString(Math.ceil(Double.parseDouble(fieldPrezzo.getText()) + Double.parseDouble(fieldPrezzo.getText())/100*settings[1])+1) );
		}
		else 
		{
			fieldDettaglio.setText("");
			fieldIngrosso.setText("");
		}
	}
	
    //unlock dettaglio and ingrosso
	@FXML
    void manualMode(){
    	
    	if(checkManuale.isSelected())
	    	{
	    	fieldDettaglio.setDisable(false);
	    	fieldIngrosso.setDisable(false);
	    	fieldDettaglio.clear();
	    	fieldIngrosso.clear();
	    	}
    			else
    			{
    				fieldDettaglio.setDisable(true);
    				fieldIngrosso.setDisable(true);
    				percentCalc();
    			}
    	
    }
    
   //cleans the form
    void cleanForm()
    {
    	fieldDenominazione.clear();
		fieldProduttore.clear(); 
		fieldTipoVino.clear();
		comboPaese.getSelectionModel().select(null); 
		comboRegione.getSelectionModel().select(null);
		fieldCapacità.clear();
		textAreaNote.clear(); 
		fieldPrezzo.clear(); 
		fieldIngrosso.clear(); 
		fieldDettaglio.getText();
		checkManuale.setSelected(false);
    }
    
}