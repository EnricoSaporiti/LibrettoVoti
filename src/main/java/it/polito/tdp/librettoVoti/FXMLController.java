package it.polito.tdp.librettoVoti;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.librettoVoti.model.Libretto;
import it.polito.tdp.librettoVoti.model.Voto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	private Libretto model ; 

    public Libretto getModel() {
		return model;
	}

	public void setModel(Libretto model) {
		this.model = model;
		
   		List<Voto> voti = this.model.getVoti();
		txtVoti.clear();
		txtVoti.appendText("hai superato " + voti.size() + " esami \n");
		for ( Voto v : voti) {
			txtVoti.appendText(v.toString() + "\n");
		}

	}

	public void setLocation(URL location) {
		this.location = location;
	}

	public void setCmbPunti(ComboBox<Integer> cmbPunti) {
		this.cmbPunti = cmbPunti;
	}

	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<Integer> cmbPunti;

    @FXML
    private TextField txtNome;

    @FXML
    private Label txtStatus;

    @FXML
    private TextArea txtVoti;

    /**
     * @param event
     */
    @FXML
    void handleNuovoVoto(ActionEvent event) {
    	
    	String nome = txtNome.getText();
    	Integer punti = cmbPunti.getValue();
    	
    	if(nome.equals("") || punti == null ) {
    		txtStatus.setText("Errore valorizzare sia voti che nome");
    		return;
    	}
    	
    	boolean ok = model.addVoto(new Voto(nome, punti));
    	if(ok) {
    		List<Voto> voti = model.getVoti();
    		txtVoti.clear();
    		txtVoti.appendText("hai superato " + voti.size() + " esami \n");
    		for ( Voto v : voti) {
    			txtVoti.appendText(v.toString() + "\n");
    		}
    		txtNome.clear();
    		cmbPunti.setValue(null);
    		txtStatus.setText("");
    	} else {
    		txtStatus.setText("Errore  esame già presente");
    	}

    	
    }

    @FXML
    void initialize() {
        assert cmbPunti != null : "fx:id=\"cmbPunti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtNome != null : "fx:id=\"txtNome\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtVoti != null : "fx:id=\"txtVoti\" was not injected: check your FXML file 'Scene.fxml'.";

        cmbPunti.getItems().clear();
        for ( int i = 18 ; i <= 30; i++ ) {
        	cmbPunti.getItems().add(i);
        }
        
    }

}
