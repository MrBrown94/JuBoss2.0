package juboss;

import static java.nio.file.StandardCopyOption.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ImpExp {
	
	//Variabili
	private File file;
	private Path filepath;
	private JFrame frame;
	
	
	/* START - Costruttore ImpExp */
	public ImpExp() {
		
		filepath = Paths.get(juboss.Splash.db.getPath()+"\\db\\db.accdb");
		file = new File(filepath.toString());
	}
	/* END - Costruttore ImpExp */
	
	
	/* START - Metodo importa con chiusura e riapertura DB */
	public void importa() {
		
		juboss.Splash.db.closeDb();
		Path source = openChooser(0);
		
		if(source != null) {
			
			try {
				
				Files.copy(source, filepath, REPLACE_EXISTING);
				juboss.Splash.db = new DbManager();
				
				if(file.exists()) trueOperation(0);
			} catch (IOException e) {
				falseOperation(e.getMessage());
			}
		} else {
			
			juboss.Splash.db = new DbManager();
			falseOperation("");
		}
	}
	/* END - Metodo importa con con chiusura e riapertura DB */
	
	
	/* START - Metodo esporta */
	public void esporta() {
		
		Path source = openChooser(1);
		
		if(source != null) {
			
			try {
				
				Files.copy(filepath, source, REPLACE_EXISTING);
				if(file.exists()) trueOperation(1);
			} catch (IOException e) {
				falseOperation(e.getMessage());
			}
		} else {
			
			falseOperation("");
		}
	}
	/* END - Metodo esporta */
	
	
	/* START - Apertura finestra per la selezione del file da Importare/Esportare */
	private Path openChooser(int i) {
		
		
		//Prendere il look precedente
		LookAndFeel previousLF = UIManager.getLookAndFeel();
		
		
		//Prendere il look del SO per il frame chooser
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			falseOperation(e.getMessage());
		}
		
		
		//Inizializzazione chooser
		JFileChooser chooser = new JFileChooser();
		
	    //Forzare Estensione ACCDB su JFileChooser
	    FileNameExtensionFilter filter = new FileNameExtensionFilter("Access File", "accdb");
	    chooser.setFileFilter(filter);
	    chooser.setSelectedFile(new File("db.accdb"));
	    
	    //Apertura chooser su JFrame
	    JFrame selectedWindows = new JFrame();
	    
	    
	    //i == 0 Operazione di importazione <> i != 0 Operazione di esportazione
	    try {
		    if(i == 0) {
		    	
			    if (chooser.showOpenDialog(selectedWindows) == JFileChooser.APPROVE_OPTION) {
			    	
			    	return chooser.getSelectedFile().toPath();
			    }
		    } else {
		    	
		    	if (chooser.showSaveDialog(selectedWindows) == JFileChooser.APPROVE_OPTION) {
			    	
			    	return chooser.getSelectedFile().toPath();
			    }
		    }			
	    } catch (Exception e) {
	    	falseOperation(e.getMessage());
		} finally {
			
			try {
				UIManager.setLookAndFeel(previousLF);
			} catch (Exception e) {
				falseOperation(e.getMessage());
			}	
		}
	    
	    return null;
	}
	/* END - Apertura finestra per la selezione del file da Importare/Esportare */
	
	
	/* START - Visualizzazione finestra di operazione NON riuscita Importa | Esporta con errore */
	private void falseOperation(String e) {
		
		frame = new JFrame();			 
		JOptionPane.showMessageDialog(frame,"Operazione non eseguita\n"+e,"Warning", JOptionPane.WARNING_MESSAGE);
	}
	/* END - Visualizzazione finestra di operazione NON riuscita Importa | Esporta con errore */
	
	
	/* START - Visualizzazione finestra di operazione riuscita Importa | Esporta */
	private void trueOperation(int i) {
		
		frame = new JFrame();
		int result;
		
		//i == 0 Operazione di importazione <> i != 0 Operazione di esportazione
		if(i == 0){ 
			
			result = JOptionPane.showConfirmDialog(frame,"Importazione eseguita","Info", JOptionPane.CLOSED_OPTION);
		} else {
			
			result = JOptionPane.showConfirmDialog(frame,"Esportazione eseguita","Info", JOptionPane.CLOSED_OPTION);
		}
		
		if(result == JOptionPane.CLOSED_OPTION)	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	/* END - Visualizzazione finestra di operazione NON riuscita Importa | Esporta */
}
