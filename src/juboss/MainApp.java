package juboss;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainApp extends Application {

    public static Stage primaryStage;
    public static Stage stageAddEdit;
    public static Stage stageOption;
    public static Stage stageList;
    public static Stage stageImport;
    public static Stage stageExport;
    public static Stage stageInfoPop;
    private BorderPane rootLayout;

    @Override
    public void start(Stage primaryStage) {
        MainApp.primaryStage = primaryStage;
        MainApp.primaryStage.setTitle("JuBoss Gestional Software");
        MainApp.primaryStage.setResizable(false);
        
     //creation stages to track theyr addresses
       
        stageList = new Stage(); //listView
        	//blocks user input on Gui until child stage is closed
        	MainApp.stageList.initModality(Modality.WINDOW_MODAL);
        	MainApp.stageList.initOwner(MainApp.getPrimaryStage());
        
        stageInfoPop = new Stage(); //infoPopup
		    //blocks user input on Gui until child stage is closed
		    MainApp.stageInfoPop.initModality(Modality.WINDOW_MODAL);
		    MainApp.stageInfoPop.initOwner(stageList);
		    MainApp.stageInfoPop.setAlwaysOnTop(true);
		
		           
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
    
   
    public static void main(String[] args) {
        launch(args);
    }
}