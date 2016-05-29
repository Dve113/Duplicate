package relation;

public class Clean_Adress {
	
	public static String clean_adress(String adress) {	
		adress = adress.replaceAll("\\d", "");
		adress = adress.replaceAll("ß", "ss");
		adress = adress.replaceAll("ä", "ae");
		adress = adress.replaceAll("ö", "oe");
		adress = adress.replaceAll("ü", "ue");
		return adress;
	}
}
