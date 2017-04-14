package juboss.view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import juboss.MainApp;

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
            	if(t1.equals("Italia")) comboRegione.setDisable(false);
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

		    			    	
		    	//filter "." if fieldPrezzo is empty
		    	
		    	if(fieldPrezzo.getText().equals("."))
    				fieldPrezzo.setText("");
		    	
		    //replaces AT RUNTIME each , with . 
		    	
		    	if(newValue.contains(",")) fieldPrezzo.setText(fieldPrezzo.getText().replaceAll(",", "."));
		    	if(fieldPrezzo.getText().equals("") && !checkManuale.isSelected()){
		    		
		    		fieldDettaglio.setText("");
		    		fieldIngrosso.setText("");
		    	}
		    	
		    	
		    	if(newValue.length()>0)	
		    		
		    		//check if new inserted char is in the legal range
		    		
			    	if(legalRange.contains(""+newValue.charAt(newValue.length()-1)))
			    	{
			    		//check if manual mode isn't enabled
			    		
			    		if(!checkManuale.isSelected()){
			    			
			    			percentCalc();
			    		}
			    	}
			    	else
		    			fieldPrezzo.setText(oldValue);
		    }
		});
		
        
      //listener on fieldDettaglio
    	//replaces , with .
    	//check the inserted char if it's contained in legalRange
    	//if checks fail replace the previous content (oldValue)
    
      fieldDettaglio.textProperty().addListener(new ChangeListener<String>() {
	 
	    @Override
	    public void changed(ObservableValue<? extends String> observable,
	            String oldValue, String newValue) {

	    	//int in = newValue.length() - oldValue.length();
	    	
	    	//filter "." if fieldPrezzo is empty
	    	
	    	if(fieldDettaglio.getText().equals("."))
	    		fieldDettaglio.setText("");
	    	
	    //replaces AT RUNTIME each , with . 
	    	
	    	if(newValue.contains(",")) fieldDettaglio.setText(fieldDettaglio.getText().replaceAll(",", "."));
	    	if(fieldDettaglio.getText().equals("") && !checkManuale.isSelected()){
	    		
	    		fieldDettaglio.setText("");
	    		fieldIngrosso.setText("");
	    	}
	    	
	    	
	    	if(newValue.length()>0)	
	    		
	    		//check if new inserted char is in the legal range
	    		
		    	if(legalRange.contains(""+newValue.charAt(newValue.length()-1)))
		    	{
		    		//check if manual mode isn't enabled
		    		
		    		if(!checkManuale.isSelected()){
		    			
		    			percentCalc();
		    		}
		    	}
		    	else
		    		fieldDettaglio.setText(oldValue);
	    }
	});
		
      	//listener on fieldIngrosso
	  	//replaces , with .
	  	//check the inserted char if it's contained in legalRange
	  	//if checks fail replace the previous content (oldValue)
  
      	fieldIngrosso.textProperty().addListener(new ChangeListener<String>() {
	 
	    @Override
	    public void changed(ObservableValue<? extends String> observable,
	            String oldValue, String newValue) {

	    	//int in = newValue.length() - oldValue.length();
	    	
	    	//filter "." if fieldPrezzo is empty
	    	
	    	if(fieldIngrosso.getText().equals("."))
	    		fieldIngrosso.setText("");
	    	
	    //replaces AT RUNTIME each , with . 
	    	
	    	if(newValue.contains(",")) fieldIngrosso.setText(fieldIngrosso.getText().replaceAll(",", "."));
	    	if(fieldDettaglio.getText().equals("") && !checkManuale.isSelected()){
	    		
	    		fieldDettaglio.setText("");
	    		fieldIngrosso.setText("");
	    	}
	    	
	    	
	    	if(newValue.length()>0)	
	    		
	    		//check if new inserted char is in the legal range
	    		
		    	if(legalRange.contains(""+newValue.charAt(newValue.length()-1)))
		    	{
		    		//check if manual mode isn't enabled
		    		
		    		if(!checkManuale.isSelected()){
		    			
		    			percentCalc();
		    		}
		    	}
		    	else
		    		fieldIngrosso.setText(oldValue);
	    }
	});
      
     }
    
    
    //check denominazione and insert
    @FXML
    public void checkAndInsert(){
    	
    	Alert alert = new Alert(AlertType.INFORMATION);
    	alert.setTitle("Errore");
    	alert.setHeaderText(null);
    	alert.setContentText("I campi \"Denominazione e Prezzo/Ingrosso/Dettaglio\" devono essere riempiti!");
    	
    	Alert aggiunto = new Alert(AlertType.INFORMATION);
    	aggiunto.setTitle("Aggiunto.");
    	aggiunto.setHeaderText(null);
    	aggiunto.setContentText("Elemento Aggiunto!");
    	
    	
    	if(fieldDenominazione.getText().equals("") || fieldPrezzo.getText().equals("") || fieldIngrosso.getText().equals("") || fieldDettaglio.getText().equals(""))
    		alert.showAndWait();
    	
    	
    	else
    		//if prezzo dettaglio or ingrosso are empty , replace content with "0"
    		
    		if(fieldPrezzo.getText().equals("")||fieldIngrosso.getText().equals("")||fieldDettaglio.getText().equals(""))
	    		{    			
	    			juboss.Splash.db.insertData(	
	    					fieldDenominazione.getText().toUpperCase(), 
							fieldProduttore.getText().toUpperCase(), 
							fieldTipoVino.getText().toUpperCase(), 
							comboPaese.getSelectionModel().getSelectedItem(), 
							comboRegione.getSelectionModel().getSelectedItem(),
							fieldCapacità.getText().toUpperCase(), 
							textAreaNote.getText(), 
							Double.parseDouble("0"), 
							Double.parseDouble("0"), 
							Double.parseDouble("0"),
							checkManuale.isSelected()
						);
	    			
	    			//update lista dopo inserimento
	    			
    				juboss.Splash.viniOb.clear();
    				
	    			juboss.Splash.update();

    				
    				aggiunto.showAndWait();
    				
    				//clean form    				
    				
    				cleanForm();
	    		
	    		}
		    	
    		//if prezzo dettaglio or ingrosso are NOT empty , puts content on db

	    		else{
	    			
	    			/*
	    			for(int i=0; i<=10000; i++ )
	    			{
	    				juboss.Splash.db.insertData(	
	    												fieldDenominazione.getText().toUpperCase()+" "+i, 
	    												fieldProduttore.getText().toUpperCase(), 
	    												fieldTipoVino.getText().toUpperCase(), 
		    											comboPaese.getSelectionModel().getSelectedItem(), 
		    											comboRegione.getSelectionModel().getSelectedItem(),
		    											fieldCapacità.getText().toUpperCase(), 
		    											textAreaNote.getText(), 
		    											Double.parseDouble(fieldPrezzo.getText()), 
		    											Double.parseDouble(fieldIngrosso.getText()), 
		    											Double.parseDouble(fieldDettaglio.getText()),
		    											checkManuale.isSelected()
		    										);
	    				System.out.println("Aggiunto vino n° "+ i +"/1000");
	    			}
	    			*/
	    			
	    			juboss.Splash.db.insertData(	
							fieldDenominazione.getText().toUpperCase(), 
							fieldProduttore.getText().toUpperCase(), 
							fieldTipoVino.getText().toUpperCase(), 
							comboPaese.getSelectionModel().getSelectedItem(), 
							comboRegione.getSelectionModel().getSelectedItem(),
							fieldCapacità.getText().toUpperCase(), 
							textAreaNote.getText(), 
							Double.parseDouble(fieldPrezzo.getText()), 
							Double.parseDouble(fieldIngrosso.getText()), 
							Double.parseDouble(fieldDettaglio.getText()),
							checkManuale.isSelected()
							);
	    			
	    			//update list after insert
	    			juboss.Splash.viniOb.clear();
	    			
	    			juboss.Splash.update();
	    			
	    			   				
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
					Double d = Double.parseDouble(fieldPrezzo.getText()); 
					Double percent = ((Double.parseDouble(fieldPrezzo.getText()))/100.0 ) * (double)((settings[0]));
					Double d1= Double.parseDouble(fieldPrezzo.getText());
					Double percent1 = ((Double.parseDouble(fieldPrezzo.getText()))/100.0 ) * (double)((settings[1]));
				
					
					//round value to NEXT INTEGER only if is >= 15.0
					if(Double.parseDouble(fieldPrezzo.getText()) <= 15.0){
						
						fieldDettaglio.setText (Double.toString(d+percent));
						fieldIngrosso.setText(Double.toString(d1+percent1));
					}
						else{
							
							fieldDettaglio.setText (Double.toString((Math.ceil(d+percent))));
							fieldIngrosso.setText(Double.toString(Math.ceil(d1+percent1)));
						}
					
					
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
		comboPaese.getSelectionModel().select(0); 
		comboRegione.getSelectionModel().select(0);
		fieldCapacità.clear();
		textAreaNote.clear(); 
		fieldPrezzo.clear(); 
		fieldIngrosso.clear(); 
		fieldDettaglio.clear();
		checkManuale.setSelected(false);
    }
    
    //click on "modifica" button
    @FXML
    void launchListEdit(){
    	
    	//we should run ListView from here
    	try {
           
			MainApp.stageListEdit = new Stage();
			// Load gui.
		    FXMLLoader loader = new FXMLLoader();
		    loader.setLocation(MainApp.class.getResource("view/ListViewEdit.fxml"));
		    AnchorPane listView = (AnchorPane) loader.load();
		   
		    //build scene
		    Scene scene = new Scene(listView);
		    scene.getStylesheets().add("style.css");
		    MainApp.stageListEdit.setScene(scene);
		    MainApp.stageListEdit.centerOnScreen();
		    MainApp.stageListEdit.setResizable(false);
		    
		    //blocks user input on Gui until child stage is closed
		    MainApp.stageListEdit.initModality(Modality.WINDOW_MODAL);
		    MainApp.stageListEdit.initOwner(MainApp.getPrimaryStage());
		    
		    MainApp.stageListEdit.show();
            
            
        } catch (IOException e) {
            e.printStackTrace();
            
        }
    }
    
}