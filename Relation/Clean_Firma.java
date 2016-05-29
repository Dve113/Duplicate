package relation;

public class Clean_Firma {
	
	public static String clean_firma(String firma) {
		firma = firma.replaceAll("ß", "ss");
		firma = firma.replaceAll("ä", "ae");
		firma = firma.replaceAll("ö", "oe");
		firma = firma.replaceAll("ü", "ue");
		
		return firma;
	}

}
