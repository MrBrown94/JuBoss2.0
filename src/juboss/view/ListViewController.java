package juboss.view;

import java.awt.Toolkit;
import java.io.IOException;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import juboss.MainApp;
import juboss.model.Wine;

public class ListViewController {
	
	@FXML
	  private TableColumn<Wine, String> columnDenominazione1;

	  @FXML
	  private TableColumn<Wine, String> columnDettaglio;

	  @FXML
	  private TableColumn<Wine, String> columnDenominazione2;

	  @FXML
	  private TableView<Wine> tableViewDett;

	  @FXML
	  private TableColumn<Wine, String> columnIngrosso;

	  @FXML
	  private TableView<Wine> tableViewIngro;
	  
	  @FXML
	  private TextField searchField;
	  
	  public static  Wine selected = null;
	  

    @SuppressWarnings({ "rawtypes", "unchecked" })
	@FXML
    void initialize() {
		    	assert columnDenominazione1 != null : "fx:id=\"ColumnDenominazione1\" was not injected: check your FXML file 'ListView.fxml'.";
		    	assert columnDenominazione2 != null : "fx:id=\"ColumnDenominazione2\" was not injected: check your FXML file 'ListView.fxml'.";
		        assert tableViewDett != null : "fx:id=\"tableViewDett\" was not injected: check your FXML file 'ListView.fxml'.";
		        assert tableViewIngro != null : "fx:id=\"tableViewIngro\" was not injected: check your FXML file 'ListView.fxml'.";
		        assert columnIngrosso != null : "fx:id=\"columnIngrosso\" was not injected: check your FXML file 'ListView.fxml'.";
		        assert columnDettaglio != null : "fx:id=\"columnDettaglio\" was not injected: check your FXML file 'ListView.fxml'.";
		        assert searchField != null : "fx:id=\"searchField\" was not injected: check your FXML file 'ListView.fxml'.";
		
		       
		        //set content type of column
		        columnDenominazione1.setCellValueFactory(new PropertyValueFactory<Wine, String>("denominazione"));
		        columnDenominazione2.setCellValueFactory(new PropertyValueFactory<Wine, String>("denominazione"));
		        
		       
		     
		
		        columnDettaglio.setCellValueFactory(new PropertyValueFactory<Wine, String>("dettaglioEur"));
		        columnIngrosso.setCellValueFactory(new PropertyValueFactory<Wine, String>("ingrossoEur"));
		       
		        //Inizializzazione Sort Denominazione A-Z
		        columnDenominazione1.setSortType(TableColumn.SortType.ASCENDING);
		      
		     //TESTING
		      
		        //adding items to tableView
		        tableViewDett.setItems(null);
		        tableViewDett.refresh();
		        tableViewDett.setItems(juboss.Splash.viniOb);
		        
		       
		        tableViewIngro.setItems(null);
		        tableViewIngro.refresh();
		        tableViewIngro.setItems(juboss.Splash.viniOb);
		     
		      //END TESTING   
		        
		        //lock of column repositioning
		        tableViewDett.getColumns().addListener(new ListChangeListener() {
		            public boolean suspended;
		
		            @Override
		            public void onChanged(Change change) {
		                change.next();
		                if (change.wasReplaced() && !suspended) {
		                    this.suspended = true;
		                    tableViewDett.getColumns().setAll(columnDenominazione1, columnDettaglio);
		                    this.suspended = false;
		                }
		            }
		        });
		        
		        tableViewIngro.getColumns().addListener(new ListChangeListener() {
		            public boolean suspended;
		
		            @Override
		            public void onChanged(Change change) {
		                change.next();
		                if (change.wasReplaced() && !suspended) {
		                    this.suspended = true;
		                    tableViewIngro.getColumns().setAll(columnDenominazione2, columnIngrosso);
		                    this.suspended = false;
		                }
		            }
		        });
		        

		        //focus request on searchfield
		        Platform.runLater(new Runnable() {
		            @Override
		            public void run() {
		            	searchField.requestFocus();
		            }
		        });
		        
		        filterUpdate();
		        
		        //SET Sort Denominazione A-Z
		        tableViewDett.getSortOrder().add(columnDenominazione1);
    }
    
    
    public void filterUpdate(){
    ObservableList<Wine> data =  tableViewDett.getItems();
    searchField.textProperty().addListener((observable, oldValue,  newValue) -> {
                if (oldValue != null && (newValue.length() < oldValue.length())) {
                	tableViewDett.setItems(data);
                }
                String value = newValue.toLowerCase();
                ObservableList<Wine> subentries = FXCollections.observableArrayList();

                long count = tableViewDett.getColumns().stream().count();
                for (int i = 0; i < tableViewDett.getItems().size(); i++) {
                    for (int j = 0; j < count; j++) {
                        String entry = "" + tableViewDett.getColumns().get(j).getCellData(i);
                        if (entry.toLowerCase().contains(value)) {
                            subentries.add(tableViewDett.getItems().get(i));
                            break;
                        }
                    }
                }
                tableViewDett.setItems(subentries);
                tableViewIngro.setItems(subentries);
            });
    }
    @FXML
    public void clickItemDett(MouseEvent event)
    {
        if (event.getClickCount() == 2) //Checking double click
        {
          selected = tableViewDett.getSelectionModel().getSelectedItem();
           
           try {
               
       		// Load gui.
               FXMLLoader loader = new FXMLLoader();
               loader.setLocation(MainApp.class.getResource("view/InfoPopup.fxml"));
               AnchorPane infoPopup = (AnchorPane) loader.load();
               
               	           
	           MainApp.stageInfoPop.centerOnScreen();
                   
	           //build scene
               Scene scene = new Scene(infoPopup);
               scene.getStylesheets().add("style.css");
               MainApp.stageInfoPop.setScene(scene);
               MainApp.stageInfoPop.setResizable(false);
               
               MainApp.stageInfoPop.show();
               
               
               
           } catch (IOException e) {
               e.printStackTrace();
           }  
        }
    }
    
    @FXML
    public void clickItemIngro(MouseEvent event)
    {
        if (event.getClickCount() == 2) //Checking double click
        {
          selected = tableViewIngro.getSelectionModel().getSelectedItem();
           
           try {
               
       		// Load gui.
               FXMLLoader loader = new FXMLLoader();
               loader.setLocation(MainApp.class.getResource("view/InfoPopup.fxml"));
               AnchorPane infoPopup = (AnchorPane) loader.load();
               
               	           
	           MainApp.stageInfoPop.centerOnScreen();
                   
	           //build scene
               Scene scene = new Scene(infoPopup);
               scene.getStylesheets().add("style.css");
               MainApp.stageInfoPop.setScene(scene);
               MainApp.stageInfoPop.setResizable(false);
               
               MainApp.stageInfoPop.show();
               
               
               
           } catch (IOException e) {
               e.printStackTrace();
           }
        }
    }
    
    //emette un suono di errore <3
    @FXML
    void sound(){
       	Toolkit.getDefaultToolkit().beep();
    }
    
    //set window in full-screen mode
    @FXML
    void setFullScreen(MouseEvent event)
    {
        	if (MainApp.stageList.isFullScreen()) MainApp.stageList.setFullScreen(false); 
        		else MainApp.stageList.setFullScreen(true); 
    }
    
  }
