package model;


public class Firma {

	String Firma;
	String Telefon;
	String Adresse1;
	String Adresse2;
	String Stadt;
	String Bundesland;
	String PLZ;
	String Webseite;
	String Branchen;
	String ID;
	String Datensatzverwalter;
	String Land;
	
	/**
	 * @return the firma
	 */
	public String getFirma() {
		return Firma;
	}

	/**
	 * @param firma
	 *            the firma to set
	 */
	public void setFirma(String firma) {
		Firma = firma;
	}

	/**
	 * @return the telefon
	 */
	public String getTelefon() {
		return Telefon;
	}

	/**
	 * @param telefon
	 *            the telefon to set
	 */
	public void setTelefon(String telefon) {
		Telefon = telefon;
	}
	
	/**
	 * @return the adresse
	 */
	public String getAdresse1() {
		return Adresse1;
	}

	/**
	 * @param adresse
	 *            the adresse to set
	 */
	public void setAdresse1(String adresse) {
		Adresse1 = adresse;
	}

	/**
	 * @return the adresse_2
	 */
	public String getAdresse2() {
		return Adresse2;
	}

	/**
	 * @param adresse_2
	 *            the adresse_2 to set
	 */
	public void setAdresse2(String adresse2) {
		Adresse2 = adresse2;
	}
	
	/**
	 * @return the stadt
	 */
	public String getStadt() {
		return Stadt;
	}

	/**
	 * @param stadt
	 *            the stadt to set
	 */
	public void setStadt(String stadt) {
		Stadt = stadt;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getBundesland() {
		return Bundesland;
	}
	
	/**
	 * 
	 * @param bundesland
	 */
	public void setBundesland(String bundesland) {
		Bundesland = bundesland;
	}
	
	/**
	 * @return the pLZ
	 */
	public String getPLZ() {
		return PLZ;
	}

	/**
	 * @param pLZ
	 *            the pLZ to set
	 */
	public void setPLZ(String pLZ) {
		PLZ = pLZ;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getWebseite() {
		return Webseite;
	}
	
	/**
	 * 
	 * @param webseite
	 */
	public void setWebseite(String webseite) {
		Webseite = webseite;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getBranchen() {
		return Branchen;
	}
	
	/**
	 * 
	 * @param branchen
	 */
	public void setBranchen(String branchen) {
		Branchen = branchen;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getID() {
		return ID;
	}
	
	/**
	 * 
	 * @param id
	 */
	public void setID(String id) {
		ID = id;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getDatensatzverwalter() {
		return Datensatzverwalter;
	}
	
	/**
	 * 
	 * @param datensatzverwalter
	 */
	public void setDatensatzverwalter(String datensatzverwalter) {
		Datensatzverwalter = datensatzverwalter;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getLand() {
		return Land;
	}
	
	/**
	 * 
	 * @param land
	 */
	public void setLand(String land) {
		Land = land;
	}
	
	public String toString() {
		return Adresse1 + ", " + Adresse2 + ", " + Stadt + ", " + Bundesland + ", " + PLZ + ", " + Webseite + ", " + Branchen + ", " + ID + ", " + Datensatzverwalter + ", " + Land;
	}
}
