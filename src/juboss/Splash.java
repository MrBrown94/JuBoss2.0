package juboss;

import java.awt.*;
import javax.swing.*;

import javafx.collections.ObservableList;
import juboss.model.Wine;

public class Splash extends JWindow {
	
	private static final long serialVersionUID = 1L;
	private int duration;
	
	//ObservableList di  Vini
	public static ObservableList<Wine> viniOb = null;
	public static DbManager db = null;
	
	
	//Costruttore
	public Splash(int d) {
		
		duration = d;
	}

	
	//View Splash JPanel
	public void showSplash() {
		
		//Creazione JPanel
		JPanel content = (JPanel)getContentPane();
		content.setBackground(new Color(0, 0, 0, 255));

		//Center JPanel
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (screen.width-500)/2;
		int y = (screen.height-648)/2;
		setBounds(x,y,500,648);

	    //Apertura GIF
		ImageIcon bg = new ImageIcon(Splash.class.getResource("/splashsmall.gif"));
		JLabel label = new JLabel(bg);
		content.add(label, BorderLayout.CENTER);

		//Display Spldash
		setVisible(true);
		
		//Sleep Splash
	    try { 
	    	db = new DbManager();
	    	
	    	viniOb = db.getAllData();
	    		    	
	    	Thread.sleep(duration);
	    } catch (Exception e) {}
	    
	    dispose();
	}
	
	
	//Start MainApp a timer scaduto
	public void showSplashAndStart(){
			
		showSplash();
		MainApp.main(null);
	}

	
	//Main Splash
	public static void main(String[] args) {
		
		Splash splash = new Splash(1700);
	    splash.showSplashAndStart();
	  }
	
	public static void update(){
		
		 try { 
			 	db = new DbManager();
		    	viniOb.clear();
		    	viniOb = db.getAllData(); 
		    	
		    	Thread.sleep(1700);
		    } catch (Exception e) {}
		 
	}
}