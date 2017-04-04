package juboss;

import java.io.IOException;
import java.util.Vector;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainApp extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;
    
    //Vector di elementi info Vini
  	public static Vector < Vector < Object >> dataVector = new Vector < Vector < Object >>();
  	private static DbManager db = null;
  	

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("JuBoss Gestional Software");
        this.primaryStage.setResizable(false);
        

        initRootLayout();

        showGui();
    }

    /**
     * Initializes the root layout.
     */
    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Shows the person overview inside the root layout.
     */
    public void showGui() {
        try {
            // Load gui.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/Gui.fxml"));
            AnchorPane gui = (AnchorPane) loader.load();

            // Set person overview into the center of root layout.
            rootLayout.setCenter(gui);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns the main stage.
     * @return
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }
    
    
    //Caricamento dati dal db
    public static void preLoad(DbManager database, Vector < Vector < Object >> vector) {
    	
    	db = database;
    	dataVector = vector;
    }
    
    
    //Return dati DB
    public static DbManager returnDb() {
    	
    	return db;
    }
    
    
    //Return dati Vector
    public static Vector < Vector < Object >> returnVector() {
    	
    	dataVector = db.getAllData();
    	return dataVector;
    }

    //Launch AddEdit
    public static void LaunchAddEdit(){
    	AddEdit.main(null);
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}