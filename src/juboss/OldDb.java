package juboss;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import juboss.model.Wine;

public class OldDb {
	
	private File dbDir = null;
	private String path = "";
	private Statement st = null;
	private Statement st2 = null;
	private Connection connection = null;
	private Connection connection2 = null;
	private ResultSet rs = null;
	private PreparedStatement pst = null;
	
	
	
	//Inizializzazione connessione DB
	public OldDb() {
		
		//Get Path DB
		getPath();
		
		//Connessione al DB
		try {
			
			connection = DriverManager.getConnection("jdbc:ucanaccess://" + path);
			path = path.replace("accdb", "mdb");
			connection2 = DriverManager.getConnection("jdbc:ucanaccess://" + path);
			
			//Creazione Statement
			st = connection.createStatement();
			st2 = connection2.createStatement();
		} catch (SQLException e) {
			errorMessage(e.getMessage());
		}
	}
	
	
	//Get Path del programma
	private void getPath() {
		
		//Estrazione path
		dbDir = new File(ClassLoader.getSystemClassLoader().getResource(".").getPath());
		
		//Decode path e creazione string
	    path = dbDir.getAbsolutePath();
	    
		try {
			
			path = java.net.URLDecoder.decode(path, "UTF-8");
			
			path = path.replaceAll("bin", "");
		    path = path.replace("\\", "/");
		    path += "db/db.accdb;memory=false;COLUMNORDER=DISPLAY";
		} catch (UnsupportedEncodingException e) {
			errorMessage(e.getMessage());
		}
	}
	
	
	//Count elementi nel DB
	public int countVini() {
		
		//Variabile quantità vini totali
		int countVini = 0;
		
		//Query per il count
		try {
			
			st2.execute("SELECT COUNT(*) FROM articoli");
			rs = st2.getResultSet();
			
			while (rs.next()) {
				
				countVini = rs.getInt(1);
			}
			rs=null;
			
			return countVini;
		} catch (SQLException e) {
			errorMessage(e.getMessage());
		}
		
		return 0;
	}
	
	
	//Convert old DB
	public void convertOldDb() {
		
		try {
			String query = "INSERT INTO Vini (ID, Denominazione, Produttore, TipoVino, Paese, Regione, Capacita, Note, Prezzo, Ingrosso, Dettaglio, Manuale) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
			int count = 1;
			int vini = countVini();
			st2.execute("SELECT * FROM articoli");
			rs = st2.getResultSet();
			pst = connection.prepareStatement(query);
			
			while (rs.next()) {
					
				pst.setInt(1, count); //ID
				pst.setString(2, rs.getString(2)); //Denominazione
				pst.setString(3, rs.getString(7)); //Produttore
				pst.setString(4, rs.getString(5)); //TipoVino
				
				String s = rs.getString(8);
				
				if(s == null) s = "";
				if(s.contains("ITALIA")){
					
					pst.setString(5, "ITALIA"); //Paese
					pst.setString(6, s.replace("ITALIA", "").replace("/", "").replace("\\", "")); //Regione
				} else {
						
					pst.setString(5, s); //Paese
					pst.setString(6, ""); //Regione
				}
				

				pst.setString(7, rs.getString(10)); //Capacità
				pst.setString(8, rs.getString(12)); //Note
				pst.setDouble(9, Double.parseDouble(rs.getString(15).replace(",", "."))); //Prezzo
				pst.setDouble(10, 0); //Ingrosso
				pst.setDouble(11, Double.parseDouble(rs.getString(14).replace(",", "."))); //Dettaglio
				pst.setBoolean(12, true); //Manuale True/False
				
				pst.executeUpdate();
				count++;
			}
			count--;
			System.out.println("TOTALE:" + vini + "   INSERITI:" + count); 
			closeDb();
		} catch (SQLException e) {
			errorMessage(e.getMessage());
		}
    }
	
	//Messaggio di errore in MessageDialog e chiamata metodo per chiusura connessione db
	private void errorMessage(String error) {
		
		JOptionPane.showMessageDialog(null,"Connessione al database fallita!\n\n" + error, "Errore database", JOptionPane.ERROR_MESSAGE);
		closeDb();
	}
	
	
	public void test() {
		
		try {
			st2.execute("SELECT * FROM articoli");
			rs = st2.getResultSet();
			
			st.execute("SELECT * FROM Vini");
			ResultSet rs2 = st.getResultSet();
			
			while (rs.next()) {
				rs2.next();
				if (!(Double.parseDouble(rs.getString(14).replace(",", ".")) == rs2.getDouble(11))) {
					System.out.println("false");
					break;
				}
				
				System.out.println(Double.parseDouble(rs.getString(14).replace(",", ".")) + "  " + rs2.getDouble(11));
			}
			System.out.println("END");
			closeDb();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	//Chiusura connessione db
	public void closeDb() {
		
		try {
			st.close();
			connection.close();
			rs.close();
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/*public static void main(String[] args) {
		OldDb test = new OldDb();
		test.convertOldDb();
	}*/
}