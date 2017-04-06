package juboss;

import static java.nio.file.StandardCopyOption.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


public class ImpExp {
	
	//Variabili
	private File file, bk;
	private Path filepath;
	
	
	/* START - Costruttore XML BackUp */
	public ImpExp() {
		
		//file = new File(juboss.Splash.db.+ "lista.xml");
		filepath = file.toPath();
	}
	/* END - Costruttore XML BackUp */
	
	
	/* START - Metodo Importa con return successo */
	public boolean importa(Path source) {
		
		/* Variabile error: true = Nessun Errore
		 *                 false = Errore */
		boolean error = true;
		
		try {
			Files.copy(source, filepath, REPLACE_EXISTING);
		} catch (IOException e) {
			e.printStackTrace();
			error = false;
		}
		
		return file.exists() && error;
	}
	/* END - Metodo Importa con return successo */
	
	
	/* START - Metodo Esporta con return successo */
	public boolean esporta(Path source) {
		
		/* Variabile error: true = Nessun Errore
		 *                 false = Errore */
		boolean error = true;
		
		try {
			Files.copy(filepath, source, REPLACE_EXISTING);
		} catch (IOException e) {
			e.printStackTrace();
			error = false;
		}
		
		return file.exists() && error;
	}
	/* END - Metodo Esporta con return successo */
	
	
	/* START - Metodo per il backup alla chiusura */
	public void autoBackup() {
		
		bk = new File(Splash.decodePath + "BKlista.xml");
		
		try {
			Files.copy(filepath, bk.toPath(), REPLACE_EXISTING);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/* END - Metodo per il backup alla chiusura */
}
