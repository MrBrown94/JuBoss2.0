package juboss;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class Search extends Thread {
	
	private TableRowSorter<TableModel> rowSorter = null; 
    private JTextField tf = null;
    private String text;
    
    
    //Costruttore classe Search
    public Search(JTable tb, JTextField tf) {
    	
    	this.tf = tf;
    	
    	rowSorter = new TableRowSorter<>(tb.getModel());
    	tb.setRowSorter(rowSorter);
    	
    	Thread.currentThread().setName("Search");
    }
    
    
    //Creazione nuovo Thread con override dei metodi per la ricerca
    public void run() {
    
    	tf.getDocument().addDocumentListener(new DocumentListener(){
    		
    		//Aggiornamento table con ricerca su JTextField
            @Override
            public void insertUpdate(DocumentEvent e) {
            	
                text = tf.getText();
                	
                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }
            
            //Aggiornamento table con display all se JTextField è lunghezza 0
            @Override
            public void removeUpdate(DocumentEvent e) {
            	
            	text = tf.getText();
		
	            if (text.trim().length() == 0) {
	                rowSorter.setRowFilter(null);
	            } else {
	                rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
	            }
            }
            
            //Errore se comando non supportato
            @Override
            public void changedUpdate(DocumentEvent e) {
                throw new UnsupportedOperationException("Non supportato.");
            }
        });
    }
}
