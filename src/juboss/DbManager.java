package juboss;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import juboss.model.Wine;

public class DbManager {
	
	private File dbDir = null;
	private String path = "";
	private Statement st = null;
	private Connection connection = null;
	private ResultSet rs = null;
	private PreparedStatement pst = null;
	private List<Wine> data = new ArrayList<Wine>();
	
	
	//Inizializzazione connessione DB
	public DbManager() {
		
		//Get Path DB
		getPath();
		
		//Connessione al DB
		try {
			
			//connection = DriverManager.getConnection("jdbc:ucanaccess://" + path);
			try {
				Class.forName("org.sqlite.JDBC");
			} catch (ClassNotFoundException e) {
				errorMessage(e.getMessage());
			} 
			connection = DriverManager.getConnection("jdbc:sqlite://" + path);
			
			//Creazione Statement
			st = connection.createStatement();
		} catch (SQLException e) {
			errorMessage(e.getMessage());
		}
	}
	
	
	//Get Path del programma
	public String getPath() {
		
		//Estrazione path
		dbDir = new File(ClassLoader.getSystemClassLoader().getResource(".").getPath());
		
		//Decode path e creazione string
	    path = dbDir.getAbsolutePath();
	    
		try {
			
			path = java.net.URLDecoder.decode(path, "UTF-8");
			
			path = path.replaceAll("bin", "");
		    path = path.replace("\\", "/");
		    
		    String rePath = path;
		    
		    //path += "/db/db.accdb;memory=false;COLUMNORDER=DISPLAY;singleconnection=true";
		    path += "db/database.db";
		    		    
		    return rePath;
		} catch (UnsupportedEncodingException e) {
			errorMessage(e.getMessage());
		}
		
		return null;
	}
	
	
	//Count elementi nel DB
	public int countVini() {
		
		//Variabile quantità vini totali
		int countVini = 0;
		
		//Query per il count
		try {
			
			st.execute("SELECT COUNT(*) FROM Vini");
			rs = st.getResultSet();
			
			while (rs.next()) {
				
				countVini = rs.getInt(1);
			}
			
			return countVini;
		} catch (SQLException e) {
			errorMessage(e.getMessage());
		}
		
		return 0;
	}
	
	
	//Get Info Vini
	public ObservableList<Wine> getAllData() {
		
		
		System.out.println("Accesso Db");
		
		try {
			
			st.execute("SELECT * FROM Vini");
			rs = st.getResultSet();
			
			while (rs.next()) {

	            data.add(new Wine(String.valueOf(rs.getInt(1)), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), String.valueOf(rs.getDouble(9)), String.valueOf(rs.getDouble(10)), String.valueOf(rs.getDouble(11)), rs.getBoolean(12)));
			}
			ObservableList<Wine> viniOb = FXCollections.observableList(data);
			
			return viniOb;
			
		} catch (SQLException e) {
			errorMessage(e.getMessage());
		}
		
		return null;
    }
	
	
	//Inserimento dati in DB con indice n+1
	public void insertData(String denominazione, String produttore, String tipovino, String paese, String regione, String capacita, String note, double prezzo, double ingrosso, double dettaglio, boolean manuale) {

		//Query per l'inserimento dei dati nel DB
		String query = "INSERT INTO Vini (ID, Denominazione, Produttore, TipoVino, Paese, Regione, Capacita, Note, Prezzo, Ingrosso, Dettaglio, Manuale) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
		
		try {
			
			pst = connection.prepareStatement(query);
			
			pst.setInt(1, countVini()+1); //ID
			pst.setString(2, denominazione); //Denominazione
			pst.setString(3, produttore); //Produttore
			pst.setString(4, tipovino); //TipoVino
			pst.setString(5, paese); //Paese
			pst.setString(6, regione); //Regione
			pst.setString(7, capacita); //Capacità
			pst.setString(8, note); //Note
			pst.setDouble(9, prezzo); //Prezzo
			pst.setDouble(10, ingrosso); //Ingrosso
			pst.setDouble(11, dettaglio); //Dettaglio
			pst.setBoolean(12, manuale); //Manuale True/False
			pst.executeUpdate();
		} catch (SQLException e) {
			errorMessage(e.getMessage());
		}
	}
	
	
	//Modifica row DB tramite indice
	public void editData(int ind, String denominazione, String produttore, String tipovino, String paese, String regione, String capacita, String note, double prezzo, double ingrosso, double dettaglio, boolean manuale) {
		
		//Query per l'update dei dati nel DB
		String query = "UPDATE Vini SET Denominazione=?, Produttore=?, TipoVino=?, Paese=?, Regione=?, Capacita=?, Note=?, Prezzo=?, Ingrosso=?, Dettaglio=?, Manuale=?  WHERE ID=?";
		
		try {
			
			pst = connection.prepareStatement(query);
			
			pst.setInt(12, ind); //ID
			
			pst.setString(1, denominazione); //Denominazione
			pst.setString(2, produttore); //Produttore
			pst.setString(3, tipovino); //TipoVino
			pst.setString(4, paese); //Paese
			pst.setString(5, regione); //Regione
			pst.setString(6, capacita); //Capacità
			pst.setString(7, note); //Note
			pst.setDouble(8, prezzo); //Prezzo
			pst.setDouble(9, ingrosso); //Ingrosso
			pst.setDouble(10, dettaglio); //Dettaglio
			pst.setBoolean(11, manuale); //Manuale True/False
			pst.executeUpdate();
		} catch (SQLException e) {
			errorMessage(e.getMessage());
		}
	}
	
	
	//Eliminazione row DB tramite indice
	public void deleteData(int ind) {
				
		int count = countVini();
		
		try{
			
			if(count == ind) {
				
				st.executeUpdate("DELETE FROM Vini WHERE ID=" + ind);
			} else {
				
				st.execute("SELECT * FROM Vini WHERE ID=" + count);
				rs = st.getResultSet();
				
				rs.next();	
	            rs.getInt(1); //ID
	            String denominazione = rs.getString(2); //Denominazione
	            String produttore = rs.getString(3); //Produttore
	            String tipovino = rs.getString(4); //TipoVino
	            String paese = rs.getString(5); //Paese
	            String regione = rs.getString(6); //Regione
	            String capacita = rs.getString(7); //Capacità
	            String note = rs.getString(8); //Note
	            double prezzo = rs.getDouble(9); //Prezzo
	            double ingrosso = rs.getDouble(10); //Ingrosso
	            double dettaglio = rs.getDouble(11); //Dettaglio
	            boolean manuale = rs.getBoolean(12); //Manuale True/False
		        
				editData(ind, denominazione, produttore, tipovino, paese, regione, capacita, note, prezzo, ingrosso, dettaglio, manuale);
				st.executeUpdate("DELETE FROM Vini WHERE ID=" + count);
			}
		} catch (SQLException e) {
			errorMessage(e.getMessage());
		}
	}
	
	
	//Get settings % Ingrosso/Dettaglio
	public int[] getSettings() {
		
		int[] setting = new int[2];
		
		try {
			
			st.execute("SELECT * FROM Settings");
			rs = st.getResultSet();
			
			rs.next();
			setting[0] = rs.getInt(1);
			setting[1] = rs.getInt(2);
			
			return setting;
		} catch (SQLException e) {
			errorMessage(e.getMessage());
		}
		
		return null;
	}
	
	
	//Set settings % Ingrosso/Dettaglio
	public void setSettings(int ingrosso, int dettaglio) {
		
		String query = "UPDATE Settings SET Ingrosso=?, Dettaglio=?";
		
		try {
			
			pst = connection.prepareStatement(query);
			
			pst.setInt(1, ingrosso); //Ingrosso
			pst.setInt(2, dettaglio); //Dettaglio
			pst.executeUpdate();
		} catch (SQLException e) {
			errorMessage(e.getMessage());
		}
	}
	
	
	//Messaggio di errore in MessageDialog e chiamata metodo per chiusura connessione db
	private void errorMessage(String error) {
		
		JOptionPane.showMessageDialog(null,"Connessione al database fallita!\n\n" + error, "Errore database", JOptionPane.ERROR_MESSAGE);
		closeDb();
	}
	
	
	//Chiusura connessione db
	public void closeDb() {
				
		try {
			
			if(st != null) st.close();
			if(connection != null) connection.close();
			if(rs != null) rs.close();
			if(pst != null) pst.close();
			System.gc();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}