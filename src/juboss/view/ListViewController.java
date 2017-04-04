package juboss.view;

import java.awt.Toolkit;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Vector;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import juboss.MainApp;

public class ListViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<?, ?> ColumnDenom;

    @FXML
    private TableColumn<?, ?> ColumnDenominazione;

    @FXML
    private TableColumn<?, ?> ColumnDettaglio;

    @FXML
    private TableView<?> tableView;

    @FXML
    private TableColumn<?, ?> columnIngrosso;

    @FXML
    void initialize() {
    	
        assert ColumnDenom != null : "fx:id=\"ColumnDenom\" was not injected: check your FXML file 'ListView.fxml'.";
        assert ColumnDenominazione != null : "fx:id=\"ColumnDenominazione\" was not injected: check your FXML file 'ListView.fxml'.";
        assert ColumnDettaglio != null : "fx:id=\"ColumnDettaglio\" was not injected: check your FXML file 'ListView.fxml'.";
        assert tableView != null : "fx:id=\"tableView\" was not injected: check your FXML file 'ListView.fxml'.";
        assert columnIngrosso != null : "fx:id=\"columnIngrosso\" was not injected: check your FXML file 'ListView.fxml'.";
        
        //test inizializzazione
        System.out.println("initializing controller");
        
        //caricamento tabella
        System.out.println("creazione tabella");
        
        Vector < Vector < Object >> vector = MainApp.returnVector();
        ObservableList<Object> vector2 = FXCollections.observableArrayList(vector);
        
        System.out.print(vector.get(1).get(1));

        
    }
    
    //emette un suono di errore <3
    @FXML
    void sound(){
       	Toolkit.getDefaultToolkit().beep();
    }
}
