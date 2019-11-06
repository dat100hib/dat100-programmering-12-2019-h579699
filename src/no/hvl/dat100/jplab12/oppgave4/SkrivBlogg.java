package no.hvl.dat100.jplab12.oppgave4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import static javax.swing.JOptionPane.*;

import no.hvl.dat100.jplab12.oppgave3.*;
import no.hvl.dat100.jplab12.common.TODO;

public class SkrivBlogg {

	private static String MAPPE = System.getProperty("user.dir") + "/src/no/hvl/dat100/jplab12/tests/";

	public static boolean skriv(Blogg samling, String filnavn) {
		boolean korrekt;
		PrintWriter writer = null;

		try {
			writer = new PrintWriter(MAPPE + filnavn); //Åpner skriver
			writer.println(samling.toString());

		} catch (FileNotFoundException e) {
			showMessageDialog(null, "Feilmelding: Finner ikke filen!");
		} finally {
			if (writer != null) {
				writer.close();
				korrekt = true;
			} else {
			korrekt = false;
			}
		}
		return korrekt;
	}
}
