package juboss.view;

import static java.nio.file.StandardCopyOption.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;
import juboss.DbManager;
import juboss.MainApp;
import juboss.Splash;

public class GuiController {
	
	private Path filepath = Paths.get(Splash.db.getPath()+"\\db\\db.accdb");
	
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
    void launchListView() {
    	
    		
    	//set full screen without hiding bottom bar	
    		Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
    		MainApp.stageList.setX(primaryScreenBounds.getMinX());
    		MainApp.stageList.setY(primaryScreenBounds.getMinY());
    		MainApp.stageList.setWidth(primaryScreenBounds.getWidth());
    		MainApp.stageList.setHeight(primaryScreenBounds.getHeight());
    	
    		    	
    	//we should run ListView from here
    	try {
            
    		// Load gui.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/ListView.fxml"));
            AnchorPane listView = (AnchorPane) loader.load();
            
            //build scene
            Scene scene = new Scene(listView);
            MainApp.stageList.setScene(scene);
            MainApp.stageList.setResizable(false);
                   
            MainApp.stageList.show();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    void launchAddEdit() {
    	    		    	
    	//we should run ListView from here
    	try {
           
    		MainApp.stageAddEdit = new Stage();
    		// Load gui.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/AddEdit.fxml"));
            AnchorPane listView = (AnchorPane) loader.load();
           
            //build scene
            Scene scene = new Scene(listView);
            MainApp.stageAddEdit.setScene(scene);
            MainApp.stageAddEdit.centerOnScreen();
            MainApp.stageAddEdit.setResizable(false);
            
            //blocks user input on Gui until child stage is closed
            MainApp.stageAddEdit.initModality(Modality.WINDOW_MODAL);
            MainApp.stageAddEdit.initOwner(MainApp.getPrimaryStage());
            
            MainApp.stageAddEdit.show();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /****************** METODI IMPORTA ******************/
    
    @FXML
    void importDb(){
    	
    	FileChooser fileChooser = new FileChooser();
    	fileChooser.setTitle("Open Resource File");
    	
    	FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Database Access (*.accdb)", "*.accdb");
    	fileChooser.getExtensionFilters().add(extFilter);
    	
    	File file = fileChooser.showOpenDialog(MainApp.primaryStage); 	
    	
    	if (file != null) {
            importa(file.toPath());
        }
    }
    
    
    //Metodo importa con chiusura e riapertura DB
	private void importa(Path source) {
		
		juboss.Splash.db.closeDb();
		
		if(source != null) {
			
			try {
				
				Files.copy(source, filepath, REPLACE_EXISTING);
				juboss.Splash.db = new DbManager();
				
				trueOperation();
			} catch (IOException e) {
				falseOperation(e.getMessage());
			}
		} else {
			
			juboss.Splash.db = new DbManager();
			falseOperation("");
		}
	}
    
	/****************** METODI OPZIONI ******************/
	
	@FXML
	void option(){
		
		//we should run ListView from here
    	try {
           
    		MainApp.stageOption = new Stage();
    		// Load gui.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/Option.fxml"));
            AnchorPane listView = (AnchorPane) loader.load();
           
            //build scene
            Scene scene = new Scene(listView);
            MainApp.stageOption.setScene(scene);
            MainApp.stageOption.centerOnScreen();
            MainApp.stageOption.setResizable(false);
            
            //blocks user input on Gui until child stage is closed
            MainApp.stageOption.initModality(Modality.WINDOW_MODAL);
            MainApp.stageOption.initOwner(MainApp.getPrimaryStage());
            
            MainApp.stageOption.show();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		
	}
	
	
	/****************** METODI ESPORTA ******************/
	
    @FXML
    void exportDb(){
    	
    	FileChooser fileChooser = new FileChooser();
    	fileChooser.setTitle("Open Resource File");
    	
    	FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Database Access (*.accdb)", "*.accdb");
    	fileChooser.getExtensionFilters().add(extFilter);
    	fileChooser.setInitialFileName("db");
    	
    	File file = fileChooser.showSaveDialog(MainApp.primaryStage);
    	
    	if (file != null) {
    		esporta(file.toPath());
        }
    }
    
    
    //Metodo esporta
    private void esporta(Path source) {
		
		if(source != null) {
			
			try {
				
				Files.copy(filepath, source, REPLACE_EXISTING);
				
				trueOperation();
			} catch (IOException e) {
				falseOperation(e.getMessage());
			}
		} else {
			
			falseOperation("");
		}
	}
    
    
    
    /****************** METODI VISUALIZZAZIONE ERRORE/RIUSCITA ******************/
    
    //Visualizzazione finestra di operazione riuscita Importa | Esporta
	private void trueOperation() {
		
		Alert alert = new Alert(AlertType.INFORMATION, "Operazione eseguita!", ButtonType.OK);
		alert.showAndWait();
	}
	
	
	//Visualizzazione finestra di operazione NON riuscita Importa | Esporta con errore
	private void falseOperation(String e) {
		
		Alert alert = new Alert(AlertType.ERROR, "Operazione NON eseguita!\n" + e, ButtonType.OK);
		alert.showAndWait();
	}
}
