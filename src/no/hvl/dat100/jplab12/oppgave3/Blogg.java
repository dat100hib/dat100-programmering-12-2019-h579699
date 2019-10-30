package no.hvl.dat100.jplab12.oppgave3;

import no.hvl.dat100.jplab12.common.TODO;
import no.hvl.dat100.jplab12.oppgave1.*;
import no.hvl.dat100.jplab12.oppgave2.*;

public class Blogg {

	// TODO: objektvariable 
	private Innlegg [] innleggtabell;
	private int nesteLedige;

	public Blogg() {
		this.innleggtabell = new Innlegg [20];
		this.nesteLedige = 0;
	}

	public Blogg(int lengde) {
		this.innleggtabell = new Innlegg [lengde];
		this.nesteLedige = 0;
	}

	public int getAntall() {
		return nesteLedige;
	}
	
	public void setAntall(int antall) {
		this.nesteLedige = antall;
	}
	
	public Innlegg[] getSamling() {
		return this.innleggtabell;

	}
	
	public int finnInnlegg(Innlegg innlegg) {
		int pos = -1;
		int i = 0;
		while(i < nesteLedige) {
			if(innlegg.erLik(innleggtabell[i])){
				return i; 
			}
			i++;
		}
		return pos;
	}

	public boolean finnes(Innlegg innlegg) {
		return finnInnlegg(innlegg) >= 0;
	}

	public boolean ledigPlass() {
		return nesteLedige < innleggtabell.length;

	}
	
	public boolean leggTil(Innlegg innlegg) {
		
		if (!finnes(innlegg) && ledigPlass()) {
			innleggtabell[nesteLedige] = innlegg;
			nesteLedige++;
			return true;
		}
		return false;
	}
	
	public String toString() {
		String str = nesteLedige + "\n";		
		for (int i = 0; i < nesteLedige; i++) {
			Innlegg innlegg = innleggtabell[i];
			
			if (innlegg instanceof Bilde) {
				Bilde bilde = (Bilde) innlegg;
				str += bilde.toString();
			} else {
				Tekst tekst = (Tekst) innlegg;
				str += tekst.toString();
			}
		}
			
		return str;
	}

	// valgfrie oppgaver nedenfor
	
	public void utvid() {
		
	    Innlegg[] ny = new Innlegg[2 * innleggtabell.length];
	    for (int i = 0; i < nesteLedige; i++) {
	        ny[i] = innleggtabell[i];
	    }
	    
	    innleggtabell = ny;
	}
	
	public boolean leggTilUtvid(Innlegg innlegg) {

		if (!finnes(innlegg)) {
			if(nesteLedige == innleggtabell.length) {
				utvid();
			}
			innleggtabell[nesteLedige] = innlegg;
			nesteLedige++;
			return true;
		} else {
			return false;
		}
		
	}
	
	public boolean slett(Innlegg innlegg) {
		int pos = finnInnlegg(innlegg);
        if (pos >= 0) {
            nesteLedige--;
            innleggtabell[pos] = innleggtabell[nesteLedige];
            innleggtabell[nesteLedige] = null;
            return true;
        } else {
            return false;
        }
	}
	
	public int[] search(String keyword) {
		int forekomster = 0;
		int [] soekeTab = new int [nesteLedige];
		
		for(int i = 0; i < nesteLedige; i++) {
			String tekst = "";
			if (innleggtabell[i] instanceof Bilde) {
				Bilde bilde = (Bilde) innleggtabell[i];
				tekst = bilde.getTekst();
			} else {
				Tekst txt = (Tekst) innleggtabell[i];
				tekst = txt.getTekst();
			}
			
			if(tekst.indexOf(keyword) >= 0) {
				soekeTab[forekomster] = innleggtabell[i].getId();
				forekomster++;
			}
		}
		
		return soekeTab;

	}
}