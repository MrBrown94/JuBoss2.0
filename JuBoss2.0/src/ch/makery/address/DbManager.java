package ch.makery.address;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbManager {
	
	File dbDir = null;
	String path = "";
	Statement st = null;
	Connection connection = null;
	ResultSet rs = null;
	
	//Inizializzazione connessione DB
	public DbManager() {
		
		//Get Path DB
		getPath();
		
		//Connessione al DB
		try {
			connection = DriverManager.getConnection("jdbc:ucanaccess://" + path);
		
			st = connection.createStatement();
			getAllData();
			
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
	
	
	//Get Info Vini
	public void getAllData() {
		
		try {
			st.execute("SELECT * FROM Vini");
			rs = st.getResultSet();
			
			while ( rs.next() ){
				System.out.println(rs.getInt("ID"));
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
	
	public static void main(String[] args) {
	    
		DbManager test = new DbManager();
	}
}