package juboss.view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;
import juboss.ImpExp;
import juboss.MainApp;

public class GuiController {
	
	
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
    	
    		Stage stage = new Stage();
    		    	
    	//we should run ListView from here
    	try {
           
    		// Load gui.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/AddEdit.fxml"));
            AnchorPane listView = (AnchorPane) loader.load();
           
            //build scene
            Scene scene = new Scene(listView);
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.setResizable(false);
            
            //blocks user input on Gui until child stage is closed
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(MainApp.getPrimaryStage());
            
            stage.show();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    //import db method
    
    @FXML
    void importDb(){
    	
    	ImpExp importDb = new ImpExp();
    	importDb.importa();
    	System.out.println("import");
    	
    }
    
 //import db method
    
    @FXML
    void exportDb(){
    	
    	ImpExp importDb = new ImpExp();
    	importDb.esporta();
    	System.out.println("export");
    	
    }
  
}
