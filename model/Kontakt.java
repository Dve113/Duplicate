package model;

public class Kontakt {

	String Firma;
	String Kontakt;
	String Telefon;
	String Adresse;
	String Adresse_2;
	String Stadt;
	String PLZ;
	String EMail;
	String Erstellungsdatum;

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
	 * @return the kontakt
	 */
	public String getKontakt() {
		return Kontakt;
	}

	/**
	 * @param kontakt
	 *            the kontakt to set
	 */
	public void setKontakt(String kontakt) {
		Kontakt = kontakt;
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
	public String getAdresse() {
		return Adresse;
	}

	/**
	 * @param adresse
	 *            the adresse to set
	 */
	public void setAdresse(String adresse) {
		Adresse = adresse;
	}

	/**
	 * @return the adresse_2
	 */
	public String getAdresse_2() {
		return Adresse_2;
	}

	/**
	 * @param adresse_2
	 *            the adresse_2 to set
	 */
	public void setAdresse_2(String adresse_2) {
		Adresse_2 = adresse_2;
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
	 * @return the eMail
	 */
	public String getEMail() {
		return EMail;
	}

	/**
	 * @param eMail
	 *            the eMail to set
	 */
	public void setEMail(String eMail) {
		EMail = eMail;
	}

	/**
	 * @return the erstellungsdatum
	 */
	public String getErstellungsdatum() {
		return Erstellungsdatum;
	}

	/**
	 * @param erstellungsdatum
	 *            the erstellungsdatum to set
	 */
	public void setErstellungsdatum(String erstellungsdatum) {
		Erstellungsdatum = erstellungsdatum;
	}

	public String toString() {
		return Firma + ", " + Kontakt + ", " + Telefon + ", " + Adresse + ", "
				+ Adresse_2 + ", " + Stadt + ", " + PLZ + ", " + EMail + ", " + Erstellungsdatum;
	}

}
