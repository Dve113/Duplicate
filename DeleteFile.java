package io;

import java.io.File;

public class DeleteFile {

	/**
	 * 
	 * @param file
	 */
	public static void delete(String file_name) {

		File file = new File(
				"C:\\Users\\Morawitzky\\Desktop\\BTI\\"
						+ file_name + ".csv");

		if (file.exists()) {
			file.delete();
			System.out.println("Die Datei " + file.getName()
					+ " war schon vorhanden und wurde gel�scht!");
		}
	}

	/**
	 * 
	 * @param dir
	 */
	public static void deleteDir() {

		File dir = new File(
				"C:\\Users\\Morawitzky\\Desktop\\BTI\\Ergebnisse\\");

		File[] files = dir.listFiles();
		if (files != null) {
			for (int i = 0; i < files.length; i++) {
				files[i].delete(); // Datei l�schen
			}
		}
		System.out.println("Alle Dateien wurden gel�scht!");
	}

}
