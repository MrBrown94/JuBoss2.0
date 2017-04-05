package juboss;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainApp extends Application {

    private static Stage primaryStage;
    public static Stage stageList;
    private BorderPane rootLayout;
   
  	//private static DbManager db = null;
  	

    @Override
    public void start(Stage primaryStage) {
        MainApp.primaryStage = primaryStage;
        MainApp.primaryStage.setTitle("JuBoss Gestional Software");
        MainApp.primaryStage.setResizable(false);
        
        //creation of listView stage to track theyr addresses
        stageList = new Stage();
        

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
    public static Stage getPrimaryStage() {
        return primaryStage;
    }
    
    //Launch AddEdit
    public static void LaunchAddEdit(){
    	AddEdit.main(null);
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}