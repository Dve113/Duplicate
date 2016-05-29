package main;

import io.DeleteFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Execute {

	public static void start() {
		System.out.println("Was wollen Sie tun und welchen Algorithmus wollen Sie nutzen?");
		System.out.println("Bitte beachten Sie, dass die Methoden QGram, Chapman und MongeElkan sehr rechenintensiv sind und daher viel Zeit benötigen!");
		System.out.println("------------------------");
		System.out.println("(1)	Sehr ähnliche Firmennamen finden");
		System.out.println("(1.1)  -  QGram");
		System.out.println("(1.2)  -  Levensthein");
		System.out.println("(1.3)  -  Chapman");
		System.out.println("(1.4)  -  JaroWinkler");
		System.out.println("(1.5)  -  MongeElkan");
		System.out.println("");
		System.out.println("(2)	Ähnliche Firmennamen in der selben Stadt finden");
		System.out.println("(2.1)  -  QGram");
		System.out.println("(2.2)  -  Levensthein");
		System.out.println("(2.3)  -  Chapman");
		System.out.println("(2.4)  -  JaroWinkler");
		System.out.println("(2.5)  -  MongeElkan");
		System.out.println("");
		System.out.println("(3)	Sehr ähnliche Kontakte in der gleichen Stadt finden");
		System.out.println("(3.1)  -  QGram");
		System.out.println("(3.2)  -  Levensthein");
		System.out.println("(3.3)  -  Chapman");
		System.out.println("(3.4)  -  JaroWinkler");
		System.out.println("(3.5)  -  MongeElkan");
		System.out.println("");
		System.out.println("(4)	Ähnliche Firmennamen im gleichen PLZ-Bereich finden");
		System.out.println("(4.1)  -  QGram");
		System.out.println("(4.2)  -  Levensthein");
		System.out.println("(4.3)  -  Chapman");
		System.out.println("(4.4)  -  JaroWinkler");
		System.out.println("(4.5)  -  MongeElkan");
		System.out.println("");
		System.out.println("(5)  -  Leere Adressfelder in Firmen finden");
		System.out.println("(6)  -  Ergebnis-Verzeichnis leeren");
		System.out.println("(7)  -  Gleiche Adressen bei Firmen finden");
		System.out.println("(8)  -  Nichts");
		System.out.println("------------------------");
		System.out.println("Geben sie die gewünschte Zahl ein: ");

		InputStreamReader streamReader = new InputStreamReader(System.in);
		BufferedReader bufferedReader = new BufferedReader(streamReader);
		String desired_method = "null";

		try {
			desired_method = bufferedReader.readLine();
		} catch (IOException e) {
			System.out
					.println("Es gab einen Fehler bei der Eingabe bitte nur die Zahl eingeben!");
			System.out.println("Der Vorgang wird neu gestartet!");
			Execute.start();
		}
		switch (desired_method) {
		case "1.1":
			Methods_To_Execute_qGram.execute_similar_company_qgram();
			break;
		case "1.2":
			Methods_To_Execute_Levensthein.execute_similar_company_levensthein();
			break;
		case "1.3":
			Methods_To_Execute_Chapman.execute_similar_company_chapman();
			break;
		case "1.4":
			Methods_To_Execute_JaroWinkler.execute_similar_company_jarowinkler();
			break;
		case "1.5":
			Methods_To_Execute_MongeElkan.execute_similar_company_mongeelkan();
			break;
		case "2.1":
			Methods_To_Execute_qGram.execute_similar_company_same_city_qgram();
			break;
		case "2.2":
			Methods_To_Execute_Levensthein.execute_similar_company_same_city_levensthein();
			break;
		case "2.3":
			Methods_To_Execute_Chapman.execute_similar_company_same_city_chapman();
			break;
		case "2.4":
			Methods_To_Execute_JaroWinkler.execute_similar_company_same_city_jarowinkler();
			break;
		case "2.5":
			Methods_To_Execute_MongeElkan.execute_similar_company_same_city_mongeelkan();
			break;
		case "3.1":
			Methods_To_Execute_qGram.execute_similar_contact_same_city_qgram();
			break;
		case "3.2":
			Methods_To_Execute_Levensthein.execute_similar_contact_same_city_levensthein();
			break;
		case "3.3":
			Methods_To_Execute_Chapman.execute_similar_contact_same_city_chapman();
			break;
		case "3.4":
			Methods_To_Execute_JaroWinkler.execute_similar_contact_same_city_jarowinler();
			break;
		case "3.5":
			Methods_To_Execute_MongeElkan.execute_similar_contact_same_city_mongeelkan();
			break;
		case "4.1":
			Methods_To_Execute_qGram.execute_similar_company_same_plz_qgram();
			break;
		case "4.2":
			Methods_To_Execute_Levensthein.execute_similar_company_same_plz_levensthein();
			break;
		case "4.3":
			Methods_To_Execute_Chapman.execute_similar_company_same_plz_chapman();
			break;
		case "4.4":
			Methods_To_Execute_JaroWinkler.execute_similar_company_same_plz_jarowinkler();
			break;
		case "4.5":
			Methods_To_Execute_MongeElkan.execute_similar_company_same_plz_mongeelkan();
			break;
		case "5":
			Methods_To_Execute_Independent.execute_empty_company_properties();
			break;
		case "6":
			DeleteFile.deleteDir();
			break;
		case "7":
			Methods_To_Execute_Independent.execute_same_adress_companies();
			break;
		case "8":
			System.out.println("Das Programm wird beendet");
			break;
		default:
			System.out.println("Die Eingabe liegt nicht zwischen 1 und 10");
		}
	}

}
