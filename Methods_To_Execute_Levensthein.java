package main;

import io.DeleteFile;
import io.ExportFile;
import io.ImportFile;

import java.io.IOException;
import java.util.ArrayList;

import relation.GetRelation_Levensthein;

public class Methods_To_Execute_Levensthein {

	/**
	 * 
	 */
	public static void execute_similar_company_levensthein() {
		String start_file = "csv_act_firmen";
		String end_file = "ergebnis_similar_company_levensthein";
		DeleteFile.delete(end_file);
		ArrayList<String> result = GetRelation_Levensthein
				.similar_company(ImportFile
						.importCSVFileToObject_Company(start_file));
		try {
			ExportFile.writeCSVFile_String(end_file, result);
		} catch (IOException e) {
			System.out.println("Fehler! Warum weiﬂ keiner... ");
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 */
	public static void execute_similar_company_same_city_levensthein() {
		String start_file = "csv_act_firmen";
		String end_file = "ergebnis_similar_company_same_city_levensthein";
		DeleteFile.delete(end_file);
		ArrayList<String> result = GetRelation_Levensthein
				.similar_company_same_city(ImportFile
						.importCSVFileToObject_Company(start_file));
		try {
			ExportFile.writeCSVFile_String(end_file, result);
		} catch (IOException e) {
			System.out.println("Fehler! Warum weiﬂ keiner... ");
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 */
	public static void execute_similar_contact_same_city_levensthein() {
		String start_file = "csv_act_kontakte";
		String end_file = "ergebnis_similar_contact_same_city_levensthein";
		DeleteFile.delete(end_file);
		ArrayList<String> result = GetRelation_Levensthein
				.similar_contact_same_city(ImportFile
						.importCSVFileToObject_Kontakt(start_file));
		try {
			ExportFile.writeCSVFile_String(end_file, result);
		} catch (IOException e) {
			System.out.println("Fehler! Warum weiﬂ einer... ");
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 */
	public static void execute_similar_company_same_plz_levensthein() {
		String start_file = "csv_act_firmen";
		String end_file = "ergebnis_similar_company_same_plz_levensthein";
		DeleteFile.delete(end_file);
		ArrayList<String> result = GetRelation_Levensthein
				.similar_company_same_plz(ImportFile
						.importCSVFileToObject_Company(start_file));
		try {
			ExportFile.writeCSVFile_String(end_file, result);
		} catch (IOException e) {
			System.out.println("Fehler! Warum weiﬂ keiner... ");
			e.printStackTrace();
		}
	}
	
	
}
