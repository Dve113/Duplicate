package relation;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import compare.Compare;
import model.Firma;

public class GetRelation_Independent {
	
	public static ArrayList<String> same_adress_companies(ArrayList<Firma> data) {
		ArrayList<String> ergebnis = new ArrayList<String>();
		
		int y;
		int x = 0;
		
		GregorianCalendar now = new GregorianCalendar();
		DateFormat df = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.LONG);
		ergebnis.add("Datum:	   " + df.format(now.getTime()));
		ergebnis.add("Wortfilter: 	-");
		ergebnis.add("Methode: 		empty_company_properties");
		ergebnis.add("ergebnisfiller");
		ergebnis.add("");
		
		
		// Header wird entfernt
		data.remove(0);
		
		while (0 < data.size()) {
			Firma firma = data.get(0);
			if (firma.getFirma() != null) {
				String firma_name = firma.getFirma();
				String firma_adresse = firma.getAdresse1().trim();
				String firma_stadt = firma.getStadt();
				String firma_plz = firma.getPLZ();
				for (y = 1; y < data.size()-1; y++) {
					Firma firma2 = data.get(y);
					String firma2_name = firma2.getFirma();
					String firma2_adresse = firma2.getAdresse1();
					String firma2_stadt = firma2.getStadt();
					String firma2_plz = firma2.getPLZ();
					if (firma_adresse.equalsIgnoreCase(firma2_adresse) && firma_plz.equalsIgnoreCase(firma2_plz)) {
						
							ergebnis.add(firma_name + " + " + firma2_name);
							++x;
						
					}
				}
			}
			data.remove(0);
		}
		System.out.println("Es wurden " + x + " Ergebnisse gefunden");
		ergebnis.set(ergebnis.indexOf("ergebnisfiller"), "Ergebnisse: 		" + x);
		if (x > 0) {
			return ergebnis;
		}
		else {
			return null;
		}
	}
	
	
	/**
	 * Diese Methode durchsucht alle Firmen nach kritischen Leeren Feldern, als
	 * kritisch werden Adresse1, Stadt, PLZ und Land angesehen. Firma ohne Namen
	 * kann nicht existieren, daher nicht kritisch
	 * 
	 * @param data
	 *            Liste mit allen Firmen, importiert aus CSV
	 * @return Gibt eine Liste mit Firmennamen zur�ck
	 */
	public static ArrayList<String> empty_company_properties(
			ArrayList<Firma> data) {
		ArrayList<String> ergebnis = new ArrayList<String>();
		int x = 0;

		GregorianCalendar now = new GregorianCalendar();
		DateFormat df = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.LONG);
		ergebnis.add("Datum:	   " + df.format(now.getTime()));
		ergebnis.add("Wortfilter: 	-");
		ergebnis.add("Methode: 		empty_company_properties");
		ergebnis.add("ergebnisfiller");
		ergebnis.add("");
		
		
		// Header wird entfernt
		data.remove(0);

		while (0 < data.size()) {
			Firma firma = data.get(0);
			if (firma.getFirma() != null) {
				String firma_name = Clean_Firma.clean_firma(firma.getFirma()).trim(); 
						//firma.getFirma().trim();
				String adresse = Clean_Adress.clean_adress(firma.getAdresse1())
						.trim();
				String stadt = firma.getStadt().trim();
				String plz = firma.getPLZ().trim();
				// Es kann vorkommen, dass das Land nicht in der exportierten
				// Liste
				// auftaucht, daher dieser try/catch
				try {
					String land = firma.getLand().trim();
					// Wenn eines der Felder leer ist, wird die dazugeh�rige
					// Firma
					// in eine Liste geschrieben
					if (adresse.isEmpty() | stadt.isEmpty() | plz.isEmpty()
							| land.isEmpty()) {
						ergebnis.add(firma_name);
						++x;
					}
				} catch (Exception e) {
					System.out
							.println("Das Feld Land fehlt in der Liste der Firmen, Spalte hinzuf�gen und neu exportieren");
					return null;
				}
			}
			// Erstes Element der Liste wird entfernt, damit eine neues Element
			// zum Pr�fen gegrabbt werden kann
			data.remove(0);
		}
		System.out.println("Es wurden " + x + " Ergebnisse gefunden");
		ergebnis.set(ergebnis.indexOf("ergebnisfiller"), "Ergebnisse: " + x);
		if (x > 0) {
			return ergebnis;
		}
		else {
			return null;
		}
	}

}
