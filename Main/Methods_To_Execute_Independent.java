package main;

import java.io.IOException;
import java.util.ArrayList;

import io.DeleteFile;
import io.ExportFile;
import io.ImportFile;
import relation.GetRelation_Independent;

public class Methods_To_Execute_Independent {

	/**
	 * 
	 */
	public static void execute_empty_company_properties() {
		String start_file = "csv_act_firmen";
		String end_file = "ergebnis_empty_company_properties";
		DeleteFile.delete(end_file);
		ArrayList<String> result = GetRelation_Independent
				.empty_company_properties(ImportFile.importCSVFileToObject_Company(start_file));
		try {
			ExportFile.writeCSVFile_String(end_file, result);
		} catch (IOException e) {
			System.out.println("Fehler! Warum wei� keiner... ");
			e.printStackTrace();
		}
	}

	public static void execute_same_adress_companies() {
		String start_file = "csv_act_firmen";
		String end_file = "ergebnis_same_adress_companies";
		DeleteFile.delete(end_file);
		ArrayList<String> result = GetRelation_Independent.same_adress_companies(
				ImportFile.importCSVFileToObject_Company(start_file));
		try {
			ExportFile.writeCSVFile_String(end_file, result);
		} catch (IOException e) {
			System.out.println("Fehler! Warum weiß keiner... ");
			e.printStackTrace();
		}
	}
}
