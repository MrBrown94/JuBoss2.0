package ch.makery.address;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class DbManager {
	
	private File dbDir = null;
	private String path = "";
	private Statement st = null;
	private Connection connection = null;
	private ResultSet rs = null;
	private PreparedStatement pst = null;
	
	//Inizializzazione connessione DB
	public DbManager() throws SQLException {
		
		//Get Path DB
		try {
			getPath();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		//Connessione al DB
		connection = DriverManager.getConnection("jdbc:ucanaccess://" + path);
	
		//Creazione Statement
		st = connection.createStatement();
		
		//TEST PROGRAMMA
		deleteData(1);
	}
	
	
	//Get Path del programma
	public void getPath() throws UnsupportedEncodingException {
		
		//Estrazione path
		dbDir = new File(ClassLoader.getSystemClassLoader().getResource(".").getPath());
		
		//Decode path e creazione string
	    path = dbDir.getAbsolutePath();
		path = java.net.URLDecoder.decode(path, "UTF-8");
		
	    path = path.replaceAll("bin", "");
	    path = path.replace("\\", "/");
	    path += "db/db.accdb;memory=false;COLUMNORDER=DISPLAY";
	}
	
	
	//Count elementi nel DB
	public int countVini() throws SQLException {
		
		//Variabile quantità vini totali
		int countVini = 0;
		
		//Query per il count
		st.execute("SELECT COUNT(*) FROM Vini");
		rs = st.getResultSet();
		
		while (rs.next()) {
			
			countVini = rs.getInt(1);
		}
		
		rs.close();
		
		return countVini;
	}
	
	
	//Get Info Vini
	public Vector < Vector < Object >> getAllData() throws SQLException {
		
		//Vector di elementi info Vini
		Vector < Vector < Object >> dataVector = new Vector < Vector < Object >>();

		st.execute("SELECT * FROM Vini");
		rs = st.getResultSet();
		
		while (rs.next()){

			Vector < Object > data = new Vector < Object >();
			
            data.add(rs.getInt(1)); //ID
            data.add(rs.getString(2)); //Denominazione
            data.add(rs.getString(3)); //Produttore
            data.add(rs.getString(4)); //TipoVino
            data.add(rs.getString(5)); //Paese
            data.add(rs.getString(5)); //Regione
            data.add(rs.getString(7)); //Capacità
            data.add(rs.getString(8)); //Note
            data.add(rs.getFloat(9)); //Prezzo
            data.add(rs.getFloat(10)); //Ingrosso
            data.add(rs.getFloat(11)); //Dettaglio
            data.add(rs.getBoolean(12)); //Manuale True/False
            dataVector.add(data);
		}
		
		return dataVector;
    }
	
	
	//Inserimento dati in DB con indice n+1
	public void insertData(String denominazione, String produttore, String tipovino, String paese, String regione, String capacita, String note, float prezzo, float ingrosso, float dettaglio, boolean manuale) throws SQLException {
		
		//Query per l'inserimento dei dati nel DB
		String query = "INSERT INTO Vini (ID, Denominazione, Produttore, TipoVino, Paese, Regione, Capacita, Note, Prezzo, Ingrosso, Dettaglio, Manuale) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
		
		pst = connection.prepareStatement(query);
		
		pst.setInt(1, countVini()+1); //ID
		pst.setString(2, denominazione); //Denominazione
		pst.setString(3, produttore); //Produttore
		pst.setString(4, tipovino); //TipoVino
		pst.setString(5, paese); //Paese
		pst.setString(6, regione); //Regione
		pst.setString(7, capacita); //Capacità
		pst.setString(8, note); //Note
		pst.setFloat(9, prezzo); //Prezzo
		pst.setFloat(10, ingrosso); //Ingrosso
		pst.setFloat(11, dettaglio); //Dettaglio
		pst.setBoolean(12, manuale); //Manuale True/False
		pst.executeUpdate();
	}
	
	
	//Modifica row DB tramite indice
	public void editData(int ind, String denominazione, String produttore, String tipovino, String paese, String regione, String capacita, String note, float prezzo, float ingrosso, float dettaglio, boolean manuale) throws SQLException {
		
		//Query per l'update dei dati nel DB
		String query = "UPDATE Vini SET Denominazione=?, Produttore=?, TipoVino=?, Paese=?, Regione=?, Capacita=?, Note=?, Prezzo=?, Ingrosso=?, Dettaglio=?, Manuale=?  WHERE ID=?";
		
		pst = connection.prepareStatement(query);
		pst.setInt(12, ind); //ID
		
		pst.setString(1, denominazione); //Denominazione
		pst.setString(2, produttore); //Produttore
		pst.setString(3, tipovino); //TipoVino
		pst.setString(4, paese); //Paese
		pst.setString(5, regione); //Regione
		pst.setString(6, capacita); //Capacità
		pst.setString(7, note); //Note
		pst.setFloat(8, prezzo); //Prezzo
		pst.setFloat(9, ingrosso); //Ingrosso
		pst.setFloat(10, dettaglio); //Dettaglio
		pst.setBoolean(11, manuale); //Manuale True/False
		pst.executeUpdate();
	}
	
	
	//Eliminazione row DB tramite indice
	public void deleteData(int ind) throws SQLException {
				
		int count = countVini();
		
		if(count == ind) {
			
			st.executeUpdate("DELETE FROM Vini WHERE ID=" + ind);
		} else {
			
			st.execute("SELECT * FROM Vini");
			rs = st.getResultSet();
			
            rs.getInt(1); //ID
            rs.getString(2); //Denominazione
            rs.getString(3); //Produttore
            rs.getString(4); //TipoVino
            rs.getString(5); //Paese
            rs.getString(5); //Regione
            rs.getString(7); //Capacità
            rs.getString(8); //Note
            rs.getFloat(9); //Prezzo
            rs.getFloat(10); //Ingrosso
            rs.getFloat(11); //Dettaglio
            rs.getBoolean(12); //Manuale True/False
	        
			/*editData(ind, denominazione, colore, paese, regione, ingrosso, dettaglio, prezzo, capacita, disponibile);
			st.executeUpdate("DELETE FROM Vini WHERE ID=" + count);*/
		}
	}
	
	public static void main(String[] args) {
	    
		try {
			DbManager test = new DbManager();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}