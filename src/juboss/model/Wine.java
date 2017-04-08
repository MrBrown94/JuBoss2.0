package juboss.model;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.TableView;

public class Wine {
	
	private SimpleStringProperty id;
	private SimpleStringProperty denominazione;
	private SimpleStringProperty produttore;
	private SimpleStringProperty tipoVino;
	private SimpleStringProperty paese;
	private SimpleStringProperty regione;
	private SimpleStringProperty capacità;
	private SimpleStringProperty note;
	private SimpleStringProperty prezzo;
	private SimpleStringProperty prezzoEur;
	private SimpleStringProperty ingrosso;
	private SimpleStringProperty ingrossoEur;
	private SimpleStringProperty dettaglio;
	private SimpleStringProperty dettaglioEur;
	private SimpleBooleanProperty manuale;
	
	
	public Wine(String id, String denominazione, String produttore, String tipoVino, String paese, String regione, String capacità, String note, String prezzo, String ingrosso, String dettaglio,Boolean manuale){
		
		this.id = new SimpleStringProperty(id);
		this.denominazione = new SimpleStringProperty(denominazione);
		this.produttore = new SimpleStringProperty(produttore);
		this.tipoVino = new SimpleStringProperty(tipoVino);
		this.paese = new SimpleStringProperty(paese);
		this.regione = new SimpleStringProperty(regione);
		this.capacità = new SimpleStringProperty(capacità);
		this.note = new SimpleStringProperty(note);
		this.prezzo = new SimpleStringProperty(prezzo);
		this.prezzoEur = new SimpleStringProperty(prezzo+" €");
		this.ingrosso = new SimpleStringProperty(ingrosso);
		this.ingrossoEur = new SimpleStringProperty(ingrosso+" €");
		this.dettaglio = new SimpleStringProperty(dettaglio);
		this.dettaglioEur = new SimpleStringProperty(dettaglio+" €");
		this.manuale = new SimpleBooleanProperty(manuale);
	}
	
	
	public String getId(){return id.get();}
	
	public String getDenominazione(){return denominazione.get();}
	
	public String getProduttore(){return produttore.get();}
	
	public String getTipoVino(){return tipoVino.get();}
	
	public String getPaese(){return paese.get();}
	
	public String getRegione(){return regione.get();}
	
	public String getCapacità(){return capacità.get();}
	
	public String getNote(){return note.get();}
	
	public String getPrezzo(){return prezzo.get();}
	
	public String getPrezzoEur(){return prezzoEur.get();}
	
	public String getIngrosso(){return ingrosso.get();}
	
	public String getIngrossoEur(){return ingrossoEur.get();}
	
	public String getDettaglio(){return dettaglio.get();}
	
	public String getDettaglioEur(){return dettaglioEur.get();}
	
	public boolean getManuale(){return manuale.get();}
}


