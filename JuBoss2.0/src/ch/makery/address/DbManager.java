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
	public DbManager() {
		
		//Get Path DB
		getPath();
		
		//Connessione al DB
		try {
			connection = DriverManager.getConnection("jdbc:ucanaccess://" + path);
		
			st = connection.createStatement();
			//deleteData(1);
			Vector < Vector < Object >> dataVector = getAllData();
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
		
		int countVini = 0;
		
		try {
			st.execute("SELECT COUNT(*) FROM Vini");
			rs = st.getResultSet();
			
			while (rs.next()) {
				
				countVini = rs.getInt(1);
			}
			
			rs.close();
			
			return countVini;
		} catch (SQLException e) {
			e.printStackTrace();
			
			try {
				rs.close();
				st.close();
				connection.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return 0;
	}
	
	//Get Info Vini
	public Vector < Vector < Object >> getAllData() {
		
		Vector < Vector < Object >> dataVector = new Vector < Vector < Object >>();
		
		try {
			st.execute("SELECT * FROM Vini");
			rs = st.getResultSet();
			
			while (rs.next()){

				Vector < Object > data = new Vector < Object >();
				
	            data.add(rs.getInt(1)); //ID
	            data.add(rs.getString(2)); //Denominazione
	            data.add(rs.getString(3)); //Colore
	            data.add(rs.getString(4)); //Paese
	            data.add(rs.getString(5)); //Regione
	            data.add(rs.getString(5)); //Capacità
	            data.add(rs.getFloat(7)); //Ingrosso
	            data.add(rs.getFloat(8)); //Dettalio
	            data.add(rs.getFloat(9)); //Prezzo
	            data.add(rs.getBoolean(10)); //Disponibile
	            dataVector.add(data);
			}
			
			rs.close();
			return dataVector;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			try {
				rs.close();
				st.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
    }
	
	
	//Inserimento dati in DB con indice n+1
	public void insertData(String denominazione, String colore, String paese, String regione, float ingrosso, float dettaglio, float prezzo, String capacita, boolean disponibile) {
		
		try {
			String query = "INSERT INTO Vini (ID, Denominazione, Colore, Paese, Regione, Capacita, Ingrosso, Dettaglio, Prezzo, Disponibile) VALUES (?,?,?,?,?,?,?,?,?,?)";
			
			pst = connection.prepareStatement(query);
			
			pst.setInt(1, countVini()+1);
			pst.setString(2, denominazione);
			pst.setString(3, colore);
			pst.setString(4, paese);
			pst.setString(5, regione);
			pst.setString(6, capacita);
			pst.setFloat(7, ingrosso);
			pst.setFloat(8, dettaglio);
			pst.setFloat(9, prezzo);
			pst.setBoolean(10, disponibile);
			pst.executeUpdate();
			
			pst.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			
			try {
				pst.close();
				st.close();
				connection.close();
			} catch (SQLException e1) {
				e.printStackTrace();
			}
		}
	}
	
	
	//Modifica row DB tramite indice
	public void editData(int ind, String denominazione, String colore, String paese, String regione, float ingrosso, float dettaglio, float prezzo, String capacita, boolean disponibile) {
		
		try {
			String query = "UPDATE Vini SET Denominazione=?, Colore=?, Paese=?, Regione=?, Capacita=?, Ingrosso=?, Dettaglio=?, Prezzo=?, Disponibile=?  WHERE ID=?";
			
			pst = connection.prepareStatement(query);
			pst.setInt(10, ind); //ID
			
			pst.setString(1, denominazione); //Denominazione
			pst.setString(2, colore); //Colore
			pst.setString(3, paese); //Paese
			pst.setString(4, regione); //Regione
			pst.setString(5, capacita); //Capacità
			pst.setFloat(6, ingrosso); //Ingrosso
			pst.setFloat(7, dettaglio); //Dettaglio
			pst.setFloat(8, prezzo); //Prezzo
			pst.setBoolean(9, disponibile); //Disponibile
			pst.executeUpdate();
			
			pst.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			try {
				pst.close();
				st.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
	//Eliminazione row DB tramite indice
	public void deleteData(int ind) throws SQLException {
				
		int count = countVini();
		
		if(count == ind) {
			
			st.executeUpdate("DELETE FROM Vini WHERE ID=" + ind);
		} else {
			
			st.execute("SELECT * FROM Vini");
			rs = st.getResultSet();
			
			while(rs.next()) {
				int id = rs.getInt(1);
		        String denominazione = rs.getString(2); //Denominazione
		        String colore = rs.getString(3); //Colore
		        String paese = rs.getString(4); //Paese
		        String regione = rs.getString(5); //Regione
		        String capacita = rs.getString(6); //Capacità
		        float ingrosso = rs.getFloat(7); //Ingrosso
		        float dettaglio = rs.getFloat(8); //Dettaglio
		        float prezzo = rs.getFloat(9); //Prezzo
		        boolean disponibile = rs.getBoolean(10); //Disponibile
		        
		        System.out.println(denominazione + colore + paese);
			}
	        
	        //System.out.println(denominazione + colore + paese);
	        rs.close();
	        
			/*editData(ind, denominazione, colore, paese, regione, ingrosso, dettaglio, prezzo, capacita, disponibile);
			st.executeUpdate("DELETE FROM Vini WHERE ID=" + count);*/
		}
	}
	
	public static void main(String[] args) {
	    
		DbManager test = new DbManager();
	}
}