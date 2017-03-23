package database;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;



public class dbManager {
	
	public dbManager() {
		
		//estrazione path
		File jarDir = new File(ClassLoader.getSystemClassLoader().getResource(".").getPath());
	    String path = jarDir.getAbsolutePath();
	    
	    path = path.replaceAll("bin", "");
	    path = path.replace("\\", "/");
	    
	    
		//String url = "Driver={Microsoft Access Driver (*.mdb, *.accdb)};Dbq=C:/Users/Fabio Di Carlo/git/JuBoss2.0/db.accdb";
		try {
			   
			Connection conn = DriverManager.getConnection("jdbc:ucanaccess://" + path + "db/db.accdb;memory=false");
			System.out.println("connesso");
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Statement s = conn.createStatement();
		//ResultSet rs = s.executeQuery("SELECT [LastName] FROM [Clients]");
		/*while (rs.next()) {
		    System.out.println(rs.getString(1));
		}*/
	    
	}
	
	public static void main(String[] args) {
	    
		dbManager test = new dbManager();
	}
}