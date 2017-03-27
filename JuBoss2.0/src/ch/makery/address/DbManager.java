package ch.makery.address;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
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
	private int countVini = 0;
	
	//Inizializzazione connessione DB
	public DbManager() {
		
		//Get Path DB
		getPath();
		
		//Connessione al DB
		try {
			connection = DriverManager.getConnection("jdbc:ucanaccess://" + path);
		
			st = connection.createStatement();
			insertData("a", "b", "c", "d", "15", "20", "15", "1,5", "FALSE");
			
		} catch (SQLException e) {
			e.printStackTrace();
			
			try {
				connection.close();
				st.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	
	//Get Path del programma
	public void getPath() {
		
		//Estrazione path
		dbDir = new File(ClassLoader.getSystemClassLoader().getResource(".").getPath());
		
		//Decode path e creazione string
	    path = dbDir.getAbsolutePath();
	    try {
			path = java.net.URLDecoder.decode(path, "UTF-8");
			
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
	    
	    path = path.replaceAll("bin", "");
	    path = path.replace("\\", "/");
	    path += "db/db.accdb;memory=false";
	}
	
	
	//Count elementi nel DB
	public int countVini() {
		
		try {
			st.execute("SELECT COUNT(*) FROM Vini");
			rs = st.getResultSet();
			
			while (rs.next()) {
				
				countVini = rs.getInt(1);
			}
			
			return countVini;
		} catch (SQLException e) {
			e.printStackTrace();
			
			try {
				st.close();
				connection.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return 0;
	}
	
	//Get Info Vini
	public void getAllData() {
		
		Vector < Vector < Object >> dataVector = new Vector < Vector < Object >>();
		
		try {
			st.execute("SELECT * FROM Vini");
			rs = st.getResultSet();
			
			while (rs.next()){

				Vector < Object > data = new Vector < Object >();getClass();
				
	            data.add(rs.getInt(1)); //ID
	            data.add(rs.getString(2)); //Denominazione
	            data.add(rs.getString(3)); //Colore
	            data.add(rs.getString(4)); //Paese
	            data.add(rs.getString(5)); //Regione
	            data.add(rs.getString(6)); //Ingrosso
	            data.add(rs.getString(7)); //Dettaglio
	            data.add(rs.getString(8)); //Prezzo
	            data.add(rs.getString(9)); //Capacità
	            data.add(rs.getString(10)); //Disponibile
	            dataVector.add (data);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			try {
				st.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
    }
	
	
	//Inserimento dati in DB con indice n+1
	public void insertData(String denominazione, String colore, String paese, String regione, String ingrosso, String dettaglio, String prezzo, String capacita, String disponibile) {
		
		try {
			st.executeUpdate("INSERT INTO Vini VALUES('" + countVini()+1 + "','" + denominazione + "','" + colore + "','" + paese + "','" + regione + "','" + ingrosso 
					+ "','" + dettaglio + "','" + prezzo + "','" + capacita + "','"  + disponibile + "')");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			try {
				st.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
	    
		DbManager test = new DbManager();
	}
}