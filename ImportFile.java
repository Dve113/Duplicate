package io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import model.Firma;
import model.Kontakt;

public class ImportFile {

	/**
	 * 
	 * @param file_name
	 * @return
	 */
	public static ArrayList<Firma> importCSVFileToObject_Company(
			String file_name) {
		String csvFile = "C:\\Users\\Morawitzky\\Desktop\\BTI\\Daten\\"
				+ file_name + ".csv";
		BufferedReader br = null;
		String line = "";
		String csvSplitBy = ";";
		ArrayList<Firma> loaded_file = new ArrayList<Firma>();

		try {
			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) {
				Firma f = new Firma();
				String[] firma = line.split(csvSplitBy);
				if (!(firma.length < 12)) {
					if (firma[0] != null) {
						if (firma[1] != null) {
							if (firma[2] != null) {
								if (firma[3] != null) {
									if (firma[4] != null) {
										if (firma[5] != null) {
											if (firma[6] != null) {
												if (firma[7] != null) {
													if (firma[8] != null) {
														if (firma[9] != null) {
															if (firma[10] != null) {
																if (firma[11] != null) {
																	f.setFirma(firma[0]);
																	f.setTelefon(firma[1]);
																	f.setAdresse1(firma[2]);
																	f.setAdresse2(firma[3]);
																	f.setStadt(firma[4]);
																	f.setBundesland(firma[5]);
																	f.setPLZ(firma[6]);
																	f.setWebseite(firma[7]);
																	f.setBranchen(firma[8]);
																	f.setID(firma[9]);
																	f.setDatensatzverwalter(firma[10]);
																	f.setLand(firma[11]);
																}
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
				loaded_file.add(f);
			}
			System.out.println("Die Datei " + file_name
					+ ".csv wurde importiert!");
			return loaded_file;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	/**
	 * Importiert die csv File aus act zu einem Objekt der Klasse Kontakt
	 * 
	 * @param file_name
	 * @return
	 */
	public static ArrayList<Kontakt> importCSVFileToObject_Kontakt(String file_name) {
		String csvFile = "C:\\Users\\Morawitzky\\Desktop\\BTI\\Daten\\"
				+ file_name + ".csv";
		BufferedReader br = null;
		String line = "";
		String csvSplitBy = ";";
		ArrayList<Kontakt> loaded_file = new ArrayList<Kontakt>();

		try {
			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) {
				Kontakt k = new Kontakt();
				String[] kontakt = line.split(csvSplitBy);
				if (!(kontakt.length < 9)) {
					if (kontakt[0] != null) {
						if (kontakt[1] != null) {
							if (kontakt[2] != null) {
								if (kontakt[3] != null) {
									if (kontakt[4] != null) {
										if (kontakt[5] != null) {
											if (kontakt[6] != null) {
												if (kontakt[7] != null) {
													if (kontakt[8] != null) {
														k.setFirma(kontakt[0]);
														k.setKontakt(kontakt[1]);
														k.setTelefon(kontakt[2]);
														k.setAdresse(kontakt[3]);
														k.setAdresse_2(kontakt[4]);
														k.setStadt(kontakt[5]);
														k.setPLZ(kontakt[6]);
														k.setEMail(kontakt[7]);
														k.setErstellungsdatum(kontakt[8]);
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
				loaded_file.add(k);
			}
			System.out.println("Die Datei " + file_name
					+ ".csv wurde importiert!");
			return loaded_file;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}
}
