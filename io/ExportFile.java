package io;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;


public class ExportFile {

	/**
	 * Schreibt eine ArrayListe in eine CSV Datei
	 * 
	 * @param name
	 *            Name der Datei
	 * @param list
	 *            Liste die exportiert werden soll
	 * @throws IOException
	 */
	public static void writeCSVFile_String(String name, ArrayList<String> list)
			throws IOException {
		StringBuilder s;
		
		if (list == null) {
			return;
		}

		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(
				new FileOutputStream(
						"C:\\Users\\Morawitzky\\Desktop\\BTI\\Ergebnisse\\"
								+ name + ".csv"), "UTF-8"));

		try {
			for (int i = 0; i < list.size(); ++i) {
				s = new StringBuilder();
				s.append(list.get(i));
				out.newLine();
				out.write(s.toString());
			}
		} finally {
			out.close();
			System.out.println("Die Datei " + name + ".csv wurde exportiert!");
		}
	}
}
