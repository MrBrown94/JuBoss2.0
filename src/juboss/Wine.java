package juboss;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Wine {
	
	private String denominazione;
	private String produttore;
	private String colore;
	private String tipovino;
	private String paese;
	private String regione;
	private String capacita;
	private String note;
	private float prezzo;
	private float ingrosso;
	private float dettaglio;
	private boolean manuale;
	
	
	public Wine(String denominazione, String produttore, String colore, String tipovino, String paese, String regione, String capacita, String note, float prezzo, float ingrosso, float dettaglio, boolean manuale) {
	
		this.denominazione = denominazione;
		this.produttore = produttore;
		this.colore = colore;
		this.tipovino = tipovino;
		this.paese = paese;
		this.regione = regione;
		this.capacita = capacita;
		this.note = note;
		this.prezzo = prezzo;
		this.ingrosso = ingrosso;
		this.dettaglio = dettaglio;
		this.manuale = manuale;
	}
	
	
	private StringProperty firstName;
    public void setFirstName(String value) { firstNameProperty().set(value); }
    public String getFirstName() { return firstNameProperty().get(); }
    public StringProperty firstNameProperty() { 
        if (firstName == null) firstName = new SimpleStringProperty(this, "firstName");
        return firstName; 
    }
	
	
	
	public String getDenominazione() {return denominazione;}
	public void setDenominazione(String s) {this.denominazione = s;}
	
	
	public String getProduttore() {return produttore;}
	public void setProduttore(String s) {this.produttore = s;}
	
	
	public String getColore() {return colore;}
	public void setColore(String s) {this.colore = s;}
	
	
	public String getTipoVino() {return tipovino;}
	public void setTipoVino(String s) {this.tipovino = s;}
	
	
	public String getPaese() {return paese;}
	public void setPaese(String s) {this.paese = s;}
	
	
	public String getRegione() {return regione;}
	public void setRegione(String s) {this.regione = s;}
	
	
	public String getCapacita() {return capacita;}
	public void setCapacita(String s) {this.capacita = s;}
	
	
	public String getNote() {return note;}
	public void setNote(String s) {this.note = s;}
	
	
	public float getPrezzo() {return prezzo;}
	public void setPrezzo(float f) {this.prezzo = f;}
	
	
	public float getIngrosso() {return ingrosso;}
	public void setIngrosso(float f) {this.ingrosso = f;}
	
	
	public float getDettaglio() {return dettaglio;}
	public void setDettaglio(float f) {this.dettaglio = f;}
	
	
	public boolean getManuale() {return manuale;}
	public void setManuale(boolean b) {this.manuale = b;}
}