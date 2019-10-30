package no.hvl.dat100.jplab12.oppgave5;

import static javax.swing.JOptionPane.showMessageDialog;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import no.hvl.dat100.jplab12.common.TODO;
import no.hvl.dat100.jplab12.oppgave1.*;
import no.hvl.dat100.jplab12.oppgave2.*;
import no.hvl.dat100.jplab12.oppgave3.*;

import javax.swing.JOptionPane;

public class LesBlogg {

	private static String MAPPE = System.getProperty("user.dir") + "/src/no/hvl/dat100/jplab12/tests/";

	private static String TEKST = "TEKST";
	private static String BILDE = "BILDE";

	public static Blogg les(String filnavn) {
		Blogg blogg = null;
		Scanner leser = null;
		
		try {
			File innfil = new File(MAPPE + filnavn);
	        leser = new Scanner(innfil);
	        
			int antInnlegg = Integer.parseInt(leser.nextLine());
	        
	        blogg = new Blogg(antInnlegg);
	        blogg.setAntall(antInnlegg);
	        
	        int pos = 0;
	        while(leser.hasNextLine()) {
	        	String linje = leser.nextLine();

	        	if (linje.equals(TEKST)) {
	        		
        			int id = Integer.parseInt(leser.nextLine());
        			String bruker = leser.nextLine();
        			String dato = leser.nextLine();
        			int likes = Integer.parseInt(leser.nextLine());
        			String tekst = leser.nextLine();
        			Tekst txtEl = new Tekst(id, bruker, dato, likes, tekst); 
        			blogg.getSamling()[pos] = txtEl;
        			pos++;
        			
	        	} else if (linje.equals(BILDE)) {

	        		int id = Integer.parseInt(leser.nextLine());
        			String bruker = leser.nextLine();
        			String dato = leser.nextLine();
        			int likes = Integer.parseInt(leser.nextLine());
        			String tekst = leser.nextLine();
        			String url = leser.nextLine();
        			Tekst bildeEl = new Bilde(id, bruker, dato, likes, tekst, url); 
        			blogg.getSamling()[pos] = bildeEl;	
        			pos++;
	        	}
	        }
		} catch (FileNotFoundException e) {
			showMessageDialog(null, "Feilmelding: Finner ikke filen!");
		} finally {
			if(blogg != null) {
				leser.close();
			}
		}
        	
        return blogg;

	}
}
