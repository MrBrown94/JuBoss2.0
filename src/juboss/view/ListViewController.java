package juboss.view;

import java.awt.Toolkit;
import javafx.collections.ListChangeListener;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
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
	  
	  

    @SuppressWarnings({ "rawtypes", "unchecked" })
	@FXML
    void initialize() {
    	assert columnDenominazione1 != null : "fx:id=\"ColumnDenominazione1\" was not injected: check your FXML file 'ListView.fxml'.";
    	assert columnDenominazione2 != null : "fx:id=\"ColumnDenominazione2\" was not injected: check your FXML file 'ListView.fxml'.";
        assert tableViewDett != null : "fx:id=\"tableViewDett\" was not injected: check your FXML file 'ListView.fxml'.";
        assert tableViewIngro != null : "fx:id=\"tableViewIngro\" was not injected: check your FXML file 'ListView.fxml'.";
        assert columnIngrosso != null : "fx:id=\"columnIngrosso\" was not injected: check your FXML file 'ListView.fxml'.";
        assert columnDettaglio != null : "fx:id=\"columnDettaglio\" was not injected: check your FXML file 'ListView.fxml'.";

        
              
        //caricamento tabella
        System.out.println("creazione tabella");

        /*
      //dati per test  
        List<Wine> vini = new ArrayList<Wine>();
        vini.add(new Wine("123", "Vino De merda", "La troia de mammita", "qwe", "asd", "cazzo", "stronzo", "12 galloni", "stronzoni si nasce", "123€", "190€", "320€"));
        vini.add(new Wine("123", "Vino De merda", "La troia de mammita", "qwe", "asd", "cazzo", "stronzo", "12 galloni", "stronzoni si nasce", "123€", "190€", "320€"));
        vini.add(new Wine("123", "Vino De merda", "La troia de mammita", "qwe", "asd", "cazzo", "stronzo", "12 galloni", "stronzoni si nasce", "123€", "190€", "320€"));
        vini.add(new Wine("123", "Vino De merda", "La troia de mammita", "qwe", "asd", "cazzo", "stronzo", "12 galloni", "stronzoni si nasce", "123€", "190€", "320€"));
        vini.add(new Wine("123", "Vino De merda", "La troia de mammita", "qwe", "asd", "cazzo", "stronzo", "12 galloni", "stronzoni si nasce", "123€", "190€", "320€"));
        vini.add(new Wine("123", "Vino De merda", "La troia de mammita", "qwe", "asd", "cazzo", "stronzo", "12 galloni", "stronzoni si nasce", "123€", "190€", "320€"));
        vini.add(new Wine("123", "Vino De merda", "La troia de mammita", "qwe", "asd", "cazzo", "stronzo", "12 galloni", "stronzoni si nasce", "123€", "190€", "320€"));
        vini.add(new Wine("123", "Vino De merda", "La troia de mammita", "qwe", "asd", "cazzo", "stronzo", "12 galloni", "stronzoni si nasce", "123€", "190€", "320€"));
        vini.add(new Wine("123", "Vino De merda", "La troia de mammita", "qwe", "asd", "cazzo", "stronzo", "12 galloni", "stronzoni si nasce", "123€", "190€", "320€"));
        vini.add(new Wine("123", "Vino De merda", "La troia de mammita", "qwe", "asd", "cazzo", "stronzo", "12 galloni", "stronzoni si nasce", "123€", "190€", "320€"));
        vini.add(new Wine("123", "Vino De merda", "La troia de mammita", "qwe", "asd", "cazzo", "stronzo", "12 galloni", "stronzoni si nasce", "123€", "190€", "320€"));
        vini.add(new Wine("123", "Vino De merda", "La troia de mammita", "qwe", "asd", "cazzo", "stronzo", "12 galloni", "stronzoni si nasce", "123€", "190€", "320€"));
        vini.add(new Wine("123", "Vino De merda", "La troia de mammita", "qwe", "asd", "cazzo", "stronzo", "12 galloni", "stronzoni si nasce", "123€", "190€", "320€"));
        vini.add(new Wine("123", "Vino De merda", "La troia de mammita", "qwe", "asd", "cazzo", "stronzo", "12 galloni", "stronzoni si nasce", "123€", "190€", "320€"));
        vini.add(new Wine("123", "Vino De merda", "La troia de mammita", "qwe", "asd", "cazzo", "stronzo", "12 galloni", "stronzoni si nasce", "123€", "190€", "320€"));
        vini.add(new Wine("123", "Vino De merda", "La troia de mammita", "qwe", "asd", "cazzo", "stronzo", "12 galloni", "stronzoni si nasce", "123€", "190€", "320€"));
        vini.add(new Wine("123", "Vino De merda", "La troia de mammita", "qwe", "asd", "cazzo", "stronzo", "12 galloni", "stronzoni si nasce", "123€", "190€", "320€"));
        vini.add(new Wine("123", "Vino De merda", "La troia de mammita", "qwe", "asd", "cazzo", "stronzo", "12 galloni", "stronzoni si nasce", "123€", "190€", "320€"));
        vini.add(new Wine("123", "Vino De merda", "La troia de mammita", "qwe", "asd", "cazzo", "stronzo", "12 galloni", "stronzoni si nasce", "123€", "190€", "320€"));
        vini.add(new Wine("123", "Vino De merda", "La troia de mammita", "qwe", "asd", "cazzo", "stronzo", "12 galloni", "stronzoni si nasce", "123€", "190€", "320€"));
        vini.add(new Wine("123", "Vino De merda", "La troia de mammita", "qwe", "asd", "cazzo", "stronzo", "12 galloni", "stronzoni si nasce", "123€", "190€", "320€"));
        vini.add(new Wine("123", "Vino De merda", "La troia de mammita", "qwe", "asd", "cazzo", "stronzo", "12 galloni", "stronzoni si nasce", "123€", "190€", "320€"));
        vini.add(new Wine("123", "Vino De merda", "La troia de mammita", "qwe", "asd", "cazzo", "stronzo", "12 galloni", "stronzoni si nasce", "123€", "190€", "320€"));
        
        
        ObservableList<Wine> viniOb = FXCollections.observableList(vini);
         */      
        
        //set content type of column
        
       
        columnDenominazione1.setCellValueFactory(new PropertyValueFactory<Wine, String>("denominazione"));
        columnDenominazione2.setCellValueFactory(new PropertyValueFactory<Wine, String>("denominazione"));

        columnDettaglio.setCellValueFactory(new PropertyValueFactory<Wine, String>("dettaglioEur"));
        columnIngrosso.setCellValueFactory(new PropertyValueFactory<Wine, String>("ingrossoEur"));

        
        tableViewDett.setItems(juboss.Splash.viniOb);
        tableViewIngro.setItems(juboss.Splash.viniOb);
        
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
                    tableViewIngro.getColumns().setAll(columnDenominazione1, columnIngrosso);
                    this.suspended = false;
                }
            }
        });
        
    }
    
    
    
    @FXML
    public void clickItem(MouseEvent event)
    {
        if (event.getClickCount() == 2) //Checking double click
        {
           Wine selected = tableViewDett.getSelectionModel().getSelectedItem();
           System.out.println(selected.getDenominazione());            
            
        }
    }
    
    
    //emette un suono di errore <3
    @FXML
    void sound(){
       	Toolkit.getDefaultToolkit().beep();
    }
    
    //set window in full-screen mode on double click
    @FXML
    void setFullScreen(MouseEvent event)
    {
        	if (event.getClickCount() == 2) //Checking double click
         {  	
        	MainApp.stageList.setFullScreen(true); 
         }
    }
    
  }
