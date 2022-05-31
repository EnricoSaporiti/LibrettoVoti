package it.polito.tdp.librettoVoti.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLInputFactory;

public class Libretto {

	List<Voto> voti = new ArrayList<Voto>();
	
	public boolean addVoto(Voto v) {
		
		if ( !isDuplicato(v) && !isConflitto(v) ) {
			return this.voti.add(v);
		} else {
			return false;
		}
	
	}
	
	
	boolean isDuplicato(Voto v) {
		
		for(Voto x : voti) {
			if(x.equals(v)) {
				return true;
			}
		}
		return false;
		
	}
	
	
	boolean isConflitto(Voto v) {
		
		for(Voto x : voti) {
			if(x.getCorso().equals(v.getCorso())) {
				if(x.getPunteggio() != v.getPunteggio()) {
					return true;
				}
			}
		}
		return false;
	}


	@Override
	public String toString() {

		
		return "Libretto [voti=" + voti + "]";
	}
	
	
	
}
