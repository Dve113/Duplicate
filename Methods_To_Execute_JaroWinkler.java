package main;

import io.DeleteFile;
import io.ExportFile;
import io.ImportFile;

import java.io.IOException;
import java.util.ArrayList;

import relation.GetRelation_JaroWinkler;

public class Methods_To_Execute_JaroWinkler {

	/**
	 * 
	 */
	public static void execute_similar_company_jarowinkler() {
		String start_file = "csv_act_firmen";
		String end_file = "ergebnis_similar_company_jarowinkler";
		DeleteFile.delete(end_file);
		ArrayList<String> result = GetRelation_JaroWinkler
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
	public static void execute_similar_company_same_city_jarowinkler() {
		String start_file = "csv_act_firmen";
		String end_file = "ergebnis_similar_company_same_city_jarowinkler";
		DeleteFile.delete(end_file);
		ArrayList<String> result = GetRelation_JaroWinkler
				.similar_company_same_city(ImportFile
						.importCSVFileToObject_Company(start_file));
		try {
			ExportFile.writeCSVFile_String(end_file, result);
		} catch (IOException e) {
			System.out.println("Fehler!");
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 */
	public static void execute_similar_contact_same_city_jarowinler() {
		String start_file = "csv_act_kontakte";
		String end_file = "ergebnis_similar_contact_same_city_jarowinkler";
		DeleteFile.delete(end_file);
		ArrayList<String> result = GetRelation_JaroWinkler
				.similar_contact_same_city(ImportFile
						.importCSVFileToObject_Kontakt(start_file));
		try {
			ExportFile.writeCSVFile_String(end_file, result);
		} catch (IOException e) {
			System.out.println("Fehler!");
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 */
	public static void execute_similar_company_same_plz_jarowinkler() {
		String start_file = "csv_act_firmen";
		String end_file = "ergebnis_similar_company_same_plz_jarowinkler";
		DeleteFile.delete(end_file);
		ArrayList<String> result = GetRelation_JaroWinkler
				.similar_company_same_plz(ImportFile
						.importCSVFileToObject_Company(start_file));
		try {
			ExportFile.writeCSVFile_String(end_file, result);
		} catch (IOException e) {
			System.out.println("Fehler!");
			e.printStackTrace();
		}
	}
	
}
