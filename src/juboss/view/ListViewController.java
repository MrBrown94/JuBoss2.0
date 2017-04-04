package juboss.view;

import java.awt.Toolkit;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Vector;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import juboss.MainApp;

public class ListViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<Object, String> columnDenominazione1;
    
    @FXML
    private TableColumn<?, ?> columnDenominazione2;

    @FXML
    private TableColumn<?, ?> columnDettaglio;

    @FXML
    private TableView<Object> tableView;

    @FXML
    private TableColumn<?, ?> columnIngrosso;

    @FXML
    void initialize() {
    	assert columnDenominazione1 != null : "fx:id=\"ColumnDenominazione1\" was not injected: check your FXML file 'ListView.fxml'.";
        assert columnDenominazione2 != null : "fx:id=\"ColumnDenominazione2\" was not injected: check your FXML file 'ListView.fxml'.";
        assert columnDettaglio != null : "fx:id=\"ColumnDettaglio\" was not injected: check your FXML file 'ListView.fxml'.";
        assert tableView != null : "fx:id=\"tableView\" was not injected: check your FXML file 'ListView.fxml'.";
        assert columnIngrosso != null : "fx:id=\"columnIngrosso\" was not injected: check your FXML file 'ListView.fxml'.";
        
        //test inizializzazione
        System.out.println("initializing controller");
        
        //caricamento tabella
        System.out.println("creazione tabella");
        
        //inizializzazione colonne
        //columnDenominazione1.setCellValueFactory();
        
        TableColumn<Object,String> columnDenominazione1 = new TableColumn<Object,String>("Denominazione");
        
        columnDenominazione1.setCellValueFactory(new PropertyValueFactory("title"));
        
        Vector < Vector < Object >> vector = MainApp.dataVector;
        ObservableList<Object> vector2 = FXCollections.observableArrayList(vector);
        
        System.out.print(vector);
        
    }
    
    //emette un suono di errore <3
    @FXML
    void sound(){
       	Toolkit.getDefaultToolkit().beep();
    }
}
