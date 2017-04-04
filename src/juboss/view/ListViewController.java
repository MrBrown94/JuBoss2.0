package juboss.view;

import java.awt.List;
import java.awt.Toolkit;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Vector;

import com.sun.javafx.css.CalculatedValue;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
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
import juboss.Wine;

public class ListViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<Wine, String> columnDenominazione1;
    
    @FXML
    private TableColumn<Wine, String> columnDenominazione2;

    @FXML
    private TableColumn<Wine, String>  columnDettaglio;

    @FXML
    private TableView<Wine> tableView;

    @FXML
    private TableColumn<Wine, String>  columnIngrosso;

    @FXML
    void initialize() {
    	assert columnDenominazione1 != null : "fx:id=\"ColumnDenominazione1\" was not injected: check your FXML file 'ListView.fxml'.";
        assert columnDenominazione2 != null : "fx:id=\"ColumnDenominazione2\" was not injected: check your FXML file 'ListView.fxml'.";
        assert columnDettaglio != null : "fx:id=\"ColumnDettaglio\" was not injected: check your FXML file 'ListView.fxml'.";
        assert tableView != null : "fx:id=\"tableView\" was not injected: check your FXML file 'ListView.fxml'.";
        assert columnIngrosso != null : "fx:id=\"columnIngrosso\" was not injected: check your FXML file 'ListView.fxml'.";
        
        
        columnDenominazione1.setCellValueFactory(new PropertyValueFactory<Wine, String>("denominazione"));
        tableView.setItems(getUserList());
        tableView.getColumns().addAll(columnDenominazione1, columnDettaglio);
    }
    
    private ObservableList<Wine> getUserList() {
    	
    	Wine user1 = new Wine("smith", "smith@gmail.com","Susan", "Smith","","","","",1,1,1,true);
    	
    	/*Wine user1 = new Wine("smith", "smith@gmail.com","Susan", "Smith","","","","",1,1,1,true);
    	Wine user2 = new Wine("smith", "smith@gmail.com","Susan", "Smith","","","","",1,1,1,true);
    	Wine user3 = new Wine("smith", "smith@gmail.com","Susan", "Smith","","","","",1,1,1,true);*/
   
        ObservableList<Wine> list = FXCollections.observableArrayList(user1);
        return list;
    }
}
