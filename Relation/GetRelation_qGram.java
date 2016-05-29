package relation;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import compare.Compare;
import model.Firma;
import model.Kontakt;

public class GetRelation_qGram {

	/**
	 * Methode vergleicht alle Firmen in der Liste miteinander und gibt eine
	 * Liste mit sehr �hnlichen Firmennamen zur�ck
	 * 
	 * @param data
	 *            Liste mit allen Firmen, eingelesen aus CSV
	 * @return Eine Liste mit den Ergebnissen des Vergleichs
	 */
	public static ArrayList<String> similar_company(ArrayList<Firma> data) {
		ArrayList<String> ergebnis = new ArrayList<String>();
		int y;
		int x = 0;

		GregorianCalendar now = new GregorianCalendar();
		DateFormat df = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.LONG);
		ergebnis.add("Datum:	   " + df.format(now.getTime()));
		ergebnis.add("Wortfilter: 	Gemeinde");
		ergebnis.add("Methode: 		similar_company_qgram");
		ergebnis.add("ergebnisfiller");
		ergebnis.add("");
		
		
		System.out.println("Es wird gearbeitet... ");
		// Header wird entfernt
		data.remove(0);
		while (0 < data.size()) {
			Firma erster = data.get(0);
			if (erster.getFirma() != null) {
				String company1 = Clean_Firma.clean_firma(erster.getFirma().trim());
				// Gemeinden w�rden zu viele Treffer liefern, sind aber generell
				// nicht relevant
				if (company1 != null && !company1.contains("Gemeinde")) {
					for (y = 1; y < data.size() - 1; y++) {
						Firma naechster = data.get(y);
						if (naechster.getFirma() != null) {
							String company2 = Clean_Firma.clean_firma(naechster.getFirma().trim());
							if (company2 != null
									&& !company2.contains("Gemeinde")) {
								// Alle Ergebnisse mit einer Levensthein Distanz
								// von
								// maximal 2 werden in eine Liste gespeichert
								if (Compare.compare_qgram(company1, company2) > 0.90) {
									ergebnis.add(company1 + ", " + company2);
									++x;
								}
							}
						}
					}
				}
			}
			// Der erste Wert in der Liste wird entfernt um einen neuen
			// Vergleichswert zu grabben
			data.remove(0);
		}
		System.out.println("Es wurden " + x + " Ergebnisse gefunden!");
		ergebnis.set(ergebnis.indexOf("ergebnisfiller"), "Ergebnisse: 		" + x);
		if (x > 0) {
			return ergebnis;
		}
		else {
			return null;
		}
	}


	/**
	 * Methode vergleicht alle Firmen in der Liste miteinander, wenn die Namen
	 * relativ �hnlich sind und die Firmen in der gleichen Stadt liegen wird das
	 * Ergebnis in eine Liste geschrieben
	 * 
	 * @param data
	 *            Liste mit allen Firmen, eingelesen aus einer CSV
	 * @return Gibt eine ArrayListe mit je zwei Firmen pro Eintrag zur�ck
	 */
	public static ArrayList<String> similar_company_same_city(
			ArrayList<Firma> data) {
		ArrayList<String> ergebnis = new ArrayList<String>();
		int y;
		int x = 0;
		
		GregorianCalendar now = new GregorianCalendar();
		DateFormat df = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.LONG);
		ergebnis.add("Datum:	   " + df.format(now.getTime()));
		ergebnis.add("Wortfilter: 	Gemeinde");
		ergebnis.add("Methode: 	similar_company_same_city_qgram");
		ergebnis.add("ergebnisfiller");
		ergebnis.add("");

		System.out.println("Es wird gearbeitet...");

		// Header wird entfernt
		data.remove(0);
		// Das erste Element der Liste wird zum Vergleich gegrabbt
		while (0 < data.size()) {
			Firma erster = data.get(0);
			if (erster.getFirma() != null) {
				String company1 = Clean_Firma.clean_firma(erster.getFirma().trim());
				String stadt1 = erster.getStadt().trim();
				// Gemeinden w�rden zu viele Treffer liefern, sind aber generell
				// nicht relevant
				if (company1 != null && !company1.contains("Gemeinde")
						&& stadt1 != null) {
					// Nacheinander werden alle anderen Elemente der Liste mit
					// dem
					// ersten verglichen
					for (y = 1; y < data.size() - 1; y++) {
						Firma naechster = data.get(y);
						if (naechster.getFirma() != null) {
							String company2 = Clean_Firma.clean_firma(naechster.getFirma().trim());
							String stadt2 = naechster.getStadt().trim();
							if (company2 != null
									&& !company2.contains("Gemeinde")
									&& stadt2 != null) {
								// Alle Ergebnisse mit einer Levensthein Distanz
								// von
								// maximal 4 werden in eine Liste gespeichert,
								// wenn sie
								// in der selben Stadt sind
								if (Compare.compare_qgram(company1, company2) > 0.8) {
									if (stadt1.equalsIgnoreCase(stadt2)) {
										ergebnis.add(company1 + ", " + company2);
										++x;
									}
								}
							}
						}
					}
				}
			}

			// Der erste Wert in der Liste wird entfernt um einen neuen
			// Vergleichswert zu grabben
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
	 * Methode liefert alle �hnlichen Firmennamen im identischen PLZ Bereich
	 * 
	 * @param data
	 * @return
	 */
	public static ArrayList<String> similar_company_same_plz(
			ArrayList<Firma> data) {
		ArrayList<String> ergebnis = new ArrayList<String>();
		int x = 0;
		int y;
		
		GregorianCalendar now = new GregorianCalendar();
		DateFormat df = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.LONG);
		ergebnis.add("Datum:	   " + df.format(now.getTime()));
		ergebnis.add("Wortfilter: 	-");
		ergebnis.add("Methode: 		similar_company_same_plz_qgram");
		ergebnis.add("ergebnisfiller");
		ergebnis.add("");
		
		System.out.println("Es wird gearbeitet...");

		// Header wird entfernt
		data.remove(0);

		while (0 < data.size()) {
			Firma erster = data.get(0);
			if (erster.getFirma() != null) {
				String company1 = Clean_Firma.clean_firma(erster.getFirma().trim());
				String plz1 = erster.getPLZ();
				if (company1 != null && plz1 != null) {
					for (y = 1; y < data.size() - 1; y++) {
						Firma naechster = data.get(y);
						if (naechster.getFirma() != null) {
							String company2 = Clean_Firma.clean_firma(naechster.getFirma().trim());
							String plz2 = naechster.getPLZ();
							if (company2 != null && plz2 != null) {
								if (Compare.compare_qgram(company1, company2) > 0.8) {
									if (plz1.equals(plz2)) {
										ergebnis.add(company1 + ", " + company2);
										++x;
									}
								}
							}
						}
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
	 * Diese Methode vergleicht alle Kontakte miteinander, wenn die Kontakte
	 * sehr �hnlich sind und in der gleichen Stadt sind werden sie in eine Liste
	 * geschrieben
	 * 
	 * @param data
	 *            Liste mit allen Kontakten aus CSV importiert
	 * @return Gibt eine Liste mit zwei Kontakten je Eintrag zur�ck
	 */
	public static ArrayList<String> similar_contact_same_city(
			ArrayList<Kontakt> data) {
		ArrayList<String> ergebnis = new ArrayList<String>();
		int y;
		int x = 0;
		
		GregorianCalendar now = new GregorianCalendar();
		DateFormat df = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.LONG);
		ergebnis.add("Datum:	   " + df.format(now.getTime()));
		ergebnis.add("Wortfilter: 	Gemeinde, Stadt");
		ergebnis.add("Methode: 		similar_contact_same_city_qgram");
		ergebnis.add("ergebnisfiller");
		ergebnis.add("");

		System.out.println("Es wird gearbeitet... ");

		// Header wird entfernt
		data.remove(0);
		// Das erste Element der Liste wird zum Vergelich gegrabbt, solange die
		// Liste mindestens ein Element enth�lt
		while (0 < data.size()) {
			Kontakt erster = data.get(0);
			String name1 = erster.getKontakt();
			String stadt1 = erster.getStadt();
			String firma1 = Clean_Firma.clean_firma(erster.getFirma().trim());
			if (firma1 != null && !firma1.contains("Gemeinde")
					&& !firma1.contains("Stadt") && name1 != null
					&& stadt1 != null) {
				// Das erste Element wird mit allen anderen Elementen verglichen
				for (y = 1; y < data.size() - 1; y++) {
					Kontakt naechster = data.get(y);
					String name2 = naechster.getKontakt();
					String stadt2 = naechster.getStadt();
					String firma2 = naechster.getFirma().trim();
					if (firma2 != null && !firma2.contains("Gemeinde")
							&& !firma2.contains("Stadt") && name2 != null
							&& stadt2 != null) {
						// Wenn die Levensthein Distanz kleiner 2 ist und die
						// Stadt identisch ist wird das Ergebnis in eine Liste
						// geschrieben
						if (Compare.compare_qgram(name1, name2) > 0.9) {
							if (stadt1.equalsIgnoreCase(stadt2)) {
								ergebnis.add(name1 + ", " + name2 + " Firmen: "
										+ firma1 + ", " + firma2);
								++x;
							}
						}
					}
				}
			}
			// Das erste Element der Liste wird gel�scht, dadurch gibt es ein
			// neues erstes Element, das zum Vergleich gegrabbt wird
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
	 * Testmethode
	 * 
	 * 
	 * @param data
	 * @return
	 */
	public static ArrayList<String> test_company(ArrayList<Firma> data) {
		ArrayList<String> ergebnis = new ArrayList<String>();
		int y;
		data.remove(0);

		while (0 < data.size()) {
			Firma erster = data.get(0);
			if (erster.getFirma() != null) {
				String company1 = erster.getFirma().trim();
				if (!company1.contains("Gemeinde")) {
					for (y = 1; y < 3; y++) {
						Firma naechster = data.get(y);
						if (naechster.getFirma() != null) {
							String company2 = naechster.getFirma().trim();
							System.out.println(company1 + " , " + company2);
						}

					}
				}
			}

			data.remove(0);
		}
		return ergebnis;
	}


}
