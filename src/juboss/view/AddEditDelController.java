package juboss.view;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import juboss.MainApp;

public class AddEditDelController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField fieldPrezzo;

    @FXML
    private CheckBox checkManuale;

    @FXML
    private ComboBox<String> comboRegione;

    @FXML
    private TextField fieldProduttore;

    @FXML
    private TextField fieldTipoVino;

    @FXML
    private TextField fieldCapacità;

    @FXML
    private TextField fieldDenominazione;

    @FXML
    private ComboBox<String> comboPaese;

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
        
        MainApp.stageListEdit.close();
        
        comboPaese.getItems().addAll(
            	"",
        		"Italia",
    			"Germania",
    			"Francia",
    			"Spagna",
    			"Grecia",
    			"Afghanistan",
    			"Albania",
    			"Algeria",
    			"Samoa americane",
    			"Andorra",
    			"Angola",
    			"Anguilla",
    			"Antartide",
    			"Antigua e Barbuda",
    			"Argentina",
    			"Armenia",
    			"Aruba",
    			"Australia",
    			"Austria",
    			"Azerbaijan",
    			"Bahamas",
    			"Bahrain",
    			"Bangladesh",
    			"Barbados",
    			"Belarus",
    			"Belgio",
    			"Belize",
    			"Benin",
    			"Bermuda",
    			"Bhutan",
    			"Bolivia",
    			"Bosnia-Erzegovina",
    			"Botswana",
    			"Bouvet Island",
    			"Brasile",
    			"Territorio britannico dell'Oceano Indiano",
    			"Brunei Darussalam",
    			"Bulgaria",
    			"Burkina Faso",
    			"Burundi",
    			"Cambogia",
    			"Cameroun",
    			"Canada",
    			"Capo Verde",
    			"Isole Cayman",
    			"Repubblica Centrafricana",
    			"Chad",
    			"Chile",
    			"Cina",
    			"Isola di Natale",
    			"Cocos (Keeling)",
    			"Colombia",
    			"Comore",
    			"Congo",
    			"Congo, Repubblica Democratica del",
    			"Isole Cook",
    			"Costa Rica",
    			"Costa d'Avorio",
    			"Croazia",
    			"Cuba",
    			"Cipro",
    			"Repubblica Ceca",
    			"Danimarca",
    			"Djibouti",
    			"Dominica",
    			"Repubblica Dominicana",
    			"Ecuador",
    			"Egitto",
    			"El Salvador",
    			"Guinea Equatoriale",
    			"L'Eritrea",
    			"Estonia",
    			"Etiopia",
    			"Isole Falkland (Malvinas)",
    			"Isole Faroe",
    			"Fiji",
    			"Finlandia",
    			"Guiana francese",
    			"Polinesia francese",
    			"Territori francesi meridionali",
    			"Gabon",
    			"Gambia",
    			"Georgia",
    			"Ghana",
    			"Gibilterra",
    			"Groenlandia",
    			"Granada",
    			"Guadeloupe",
    			"Guam",
    			"Guatemala",
    			"Guinea",
    			"Guinea-Bissau",
    			"Guyana",
    			"Haiti",
    			"Isola Heard e McDonald Isole",
    			"Santa Sede (Cittá del Vaticano)",
    			"Honduras",
    			"Hong Kong",
    			"Ungheria",
    			"Islanda",
    			"India",
    			"Indonesia",
    			"Iran",
    			"Iraq",
    			"Irlanda",
    			"Israele",
    			"Giamaica",
    			"Giappone",
    			"Giordania",
    			"Kazakhstan",
    			"Kenya",
    			"Kiribati",
    			"Corea del Sud popolare democratica",
    			"Corea del Sud",
    			"Kuwait",
    			"Kyrgyzstan",
    			"Repubblica democratica popolare del Laos",
    			"Lettonia",
    			"Libano",
    			"Lesoto",
    			"Liberia",
    			"Jamahiriya araba libica",
    			"Liechtenstein",
    			"Lituania",
    			"Luxembourg",
    			"Macao",
    			"Macedonia, ex Repubblica jugoslava di",
    			"Madagascar",
    			"Malawi",
    			"Malaysia",
    			"Maldive",
    			"Mali",
    			"Malta",
    			"Isole Marshall",
    			"Martinique",
    			"Mauritania",
    			"Mauritius",
    			"Mayotte",
    			"Messico",
    			"Micronesia, Stati federati di",
    			"Moldavia",
    			"Monaco",
    			"Mongolia",
    			"Montserrat",
    			"Marocco",
    			"Mozambico",
    			"Myanmar",
    			"Namibia",
    			"Nauru",
    			"Nepal",
    			"Olanda",
    			"Antille Olandesi",
    			"Nuova Caledonia",
    			"Nuova Zelanda",
    			"Nicaragua",
    			"Niger",
    			"Nigeria",
    			"Niue",
    			"Norfolk Island",
    			"Isole Marianne settentrionali",
    			"Norvegia",
    			"Oman",
    			"Pakistan",
    			"Palau",
    			"Territori Palestinesi Occupati",
    			"Panama",
    			"Papua Nuova Guinea",
    			"Paraguay",
    			"Perú",
    			"Filippine",
    			"Pitcairn",
    			"Polonia",
    			"Portogallo",
    			"Porto Rico",
    			"Qatar",
    			"Riunione",
    			"Romania",
    			"Federazione Russa",
    			"Ruanda",
    			"Sant'Elena",
    			"Saint Christopher e Nevis",
    			"Santa Lucia",
    			"Saint Pierre e Miquelon",
    			"Saint Vincent e Grenadine",
    			"Samoa",
    			"San Marino",
    			"Sao Tome e Principe",
    			"Arabia Saudita",
    			"Senegal",
    			"Serbia e Montenegro",
    			"Seychelles",
    			"Sierra Leone",
    			"Singapore",
    			"Slovacchia",
    			"La Slovenia",
    			"Isole Salomone",
    			"Somalia",
    			"Sud Africa",
    			"Georgia del Sud e isole Sandwich del Sud",
    			"Sri Lanka",
    			"Sudan",
    			"Suriname",
    			"Svalbard e Jan Mayen",
    			"Swaziland",
    			"Svezia",
    			"Svizzera",
    			"Repubblica Araba Siriana",
    			"Taiwan, Provincia della Cina",
    			"Tajikistan",
    			"Tanzania, United Republic of",
    			"Tailandia",
    			"Timor Est",
    			"Andare",
    			"Tokelau",
    			"Tonga",
    			"Trinidad e Tobago",
    			"Tunisia",
    			"Tacchino",
    			"Turkmenistan",
    			"Turks e Caicos",
    			"Tuvalu",
    			"Uganda",
    			"Ucraina",
    			"Emirati Arabi Uniti",
    			"Regno Unito",
    			"Stati Uniti",
    			"Stati Uniti Isole Minori",
    			"Uruguay",
    			"Uzbekistan",
    			"Vanuatu",
    			"Venezuela",
    			"Vietnam",
    			"Isole Vergini, britannico",
    			"Virgin Islands, Stati Uniti",
    			"Wallis e Futuna",
    			"Sahara occidentale",
    			"Yemen",
    			"Zambia",
    			"Zimbabwe"
         		);
 
 
            comboRegione.getItems().addAll("","Abruzzo","Basilicata","Calabria","Campania","Emilia-Romagna","Friuli-Venezia Giulia","Lazio","Liguria","Lombardia","Marche","Molise",
    				"Piemonte","Puglia","Sardegna","Sicilia","Toscana","Trentino-Alto Adige","Umbria","Valle d'Aosta","Veneto");
            
            
            comboRegione.setDisable(true);
            
            
            //lock regione
            
            comboPaese.valueProperty().addListener(new ChangeListener<String>() {
                @Override public void changed(ObservableValue<? extends String> ov, String t, String t1) {
                	if(t1.equals("ITALIA") || t1.equals("Italia")) comboRegione.setDisable(false);
                		else comboRegione.setDisable(true);
                  }    
              });
        
            fieldPrezzo.focusedProperty().addListener(new ChangeListener<Boolean>()
            {
                @Override
                public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldPropertyValue, Boolean newPropertyValue)
                {
                    if (!newPropertyValue)
                    
                    	//concat .00 if the input is integer or not complete
                    {      
                    		if(fieldPrezzo.getText().equals("")) fieldPrezzo.setText("");
                    		
                    			else if(!fieldPrezzo.getText().contains(".") && !fieldPrezzo.getText().equals("") )
    		                    	fieldPrezzo.setText(fieldPrezzo.getText().concat(".00"));
    	                    
                    			else if(!fieldPrezzo.getText().contains(".") && !fieldPrezzo.getText().contains(".00")) 
    	                    		fieldPrezzo.setText(fieldPrezzo.getText().concat(".00"));
    	                    
                    			else if(fieldPrezzo.getText().lastIndexOf(".") == fieldPrezzo.getText().length()-1){
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
		
        //fill fields with information of item picked in list
        if(ListViewEditController.selected != null){
						        	
						        fieldDenominazione.setText(ListViewEditController.selected.getDenominazione());
								fieldProduttore.setText(ListViewEditController.selected.getProduttore());
								fieldTipoVino.setText(ListViewEditController.selected.getTipoVino());
								comboPaese.setValue(ListViewEditController.selected.getPaese()); 
								comboRegione.setValue(ListViewEditController.selected.getRegione());
								fieldCapacità.setText(ListViewEditController.selected.getCapacità());
								textAreaNote.setText(ListViewEditController.selected.getNote());
								fieldPrezzo.setText(ListViewEditController.selected.getPrezzo());
								fieldIngrosso.setText(ListViewEditController.selected.getIngrosso());
								fieldDettaglio.setText(ListViewEditController.selected.getDettaglio());
								checkManuale.setSelected(ListViewEditController.selected.getManuale());
								
        					}
        
             }
    
    
    //check denominazione and insert
    @FXML
    public void checkAndEdit(){
    	
    	Alert alert = new Alert(AlertType.INFORMATION);
    	alert.setTitle("Errore");
    	alert.setHeaderText(null);
    	alert.setContentText("Il campo \"Denominazione\" deve essere riempito!");
    	
    	Alert modificato = new Alert(AlertType.INFORMATION);
    	modificato.setTitle("Modificato.");
    	modificato.setHeaderText(null);
    	modificato.setContentText("Elemento Modificato!");
    	
    	
    	
    	
    	if(fieldDenominazione.getText().equals(""))
    		alert.showAndWait();
    	
    	
    	else
    		//if prezzo dettaglio or ingrosso are empty , replace content with "0"
    		
    		if(fieldPrezzo.getText().equals("")||fieldIngrosso.getText().equals("")||fieldDettaglio.getText().equals(""))
	    		{
	    			juboss.Splash.db.editData(	
	    											Integer.parseInt(ListViewEditController.selected.getId()),
							    					fieldDenominazione.getText().toUpperCase(), 
													fieldProduttore.getText().toUpperCase(), 
													fieldTipoVino.getText().toUpperCase(), 
	    											comboPaese.getSelectionModel().getSelectedItem(), 
	    											comboRegione.getSelectionModel().getSelectedItem(), 
													fieldCapacità.getText().toUpperCase(), 
													""+textAreaNote.getText().toUpperCase(), 
													Double.parseDouble("0"), 
													Double.parseDouble("0"), 
													Double.parseDouble("0"),
													checkManuale.isSelected()
						);
	    			
	    			//update lista dopo inserimento
    				juboss.Splash.viniOb = juboss.Splash.db.getAllData();
    				
    				modificato.showAndWait();
    				
    				//clean form    				
    				
    				cleanForm();
	    		
	    		}
		    	
    		//if prezzo dettaglio or ingrosso are NOT empty , puts content on db

	    		else{
	    				juboss.Splash.db.editData(	
	    												Integer.parseInt(ListViewEditController.selected.getId()),
	    												fieldDenominazione.getText().toUpperCase(), 
	    												fieldProduttore.getText().toUpperCase(), 
	    												fieldTipoVino.getText().toUpperCase(), 
		    											comboPaese.getSelectionModel().getSelectedItem(), 
		    											comboRegione.getSelectionModel().getSelectedItem(),
		    											fieldCapacità.getText().toUpperCase(), 
		    											""+textAreaNote.getText().toUpperCase(), 
		    											Double.parseDouble(fieldPrezzo.getText()), 
		    											Double.parseDouble(fieldIngrosso.getText()), 
		    											Double.parseDouble(fieldDettaglio.getText()),
		    											checkManuale.isSelected()
		    										);
    				
    			    //update list after insert
	    			juboss.Splash.viniOb.removeAll(juboss.Splash.viniOb);
    				juboss.Splash.viniOb = juboss.Splash.db.getAllData();
    				
    		    	Optional<ButtonType> result = modificato.showAndWait();

    				if (result.get() == ButtonType.OK){
    		    		
    		    		    		    		
    		    		juboss.Splash.viniOb.clear();
    					juboss.Splash.viniOb = juboss.Splash.db.getAllData();
    		        	
    		    		
    		        
    		        	//AGGIUNGERE METODO refresh DA CONTROLLER
    		        	
    		        	MainApp.stageAddEditDel.close();
    		        	
    		        	      	
    		        	MainApp.stageListEdit.close();
    		        	launchListEdit();
    				}
    		        	
    		    	else {
    		    			alert.close();
    		    		 }
    				
    			};
    }
    
    @FXML
    void deleteItem(){
    	
    	Alert alert = new Alert(AlertType.CONFIRMATION);
    	alert.setTitle("Elimina Elemento?");
    	alert.setHeaderText(null);
    	alert.setContentText("Vuoi davvero Eliminare\n \""+ ListViewEditController.selected.getDenominazione() + "\" ?" );
        	
    	alert.setResizable(true);
    	
    	alert.getDialogPane().setPrefSize(500, 150);
        	
    	Optional<ButtonType> result = alert.showAndWait();
    	
    	if (result.get() == ButtonType.OK){
    		
    		juboss.Splash.db.deleteData( Integer.parseInt(ListViewEditController.selected.getId()) );
    		
    		juboss.Splash.viniOb.clear();
			juboss.Splash.viniOb = juboss.Splash.db.getAllData();
        	
    		
        
        	//AGGIUNGERE METODO refresh DA CONTROLLER
        	
        	MainApp.stageAddEditDel.close();
        	
        	      	
        	MainApp.stageListEdit.close();
        	launchListEdit();
        }
    	
    	else {
    			alert.close();
    		 }
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
		fieldDettaglio.clear();
		checkManuale.setSelected(false);
    }
    
    //click  on "modifica" button
    @FXML
    void launchListEdit(){
    	MainApp.stageListEdit.close();
    	//we should run ListView from here
    	try {
           
    		//MainApp.stageList = new Stage();
    		// Load gui.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/ListViewEdit.fxml"));
            AnchorPane listView = (AnchorPane) loader.load();
           
            //build scene
            Scene scene = new Scene(listView);
            scene.getStylesheets().add("style.css");
            MainApp.stageList.setScene(scene);
            MainApp.stageList.centerOnScreen();
            MainApp.stageList.setResizable(false);
            
           
            
            MainApp.stageList.show();
            
        } catch (IOException e) {
            e.printStackTrace();
            
        }
    	 
           
    }
    
}