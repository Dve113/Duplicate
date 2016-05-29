package compare;

import uk.ac.shef.wit.simmetrics.similaritymetrics.AbstractStringMetric;
import uk.ac.shef.wit.simmetrics.similaritymetrics.ChapmanMatchingSoundex;
import uk.ac.shef.wit.simmetrics.similaritymetrics.JaroWinkler;
import uk.ac.shef.wit.simmetrics.similaritymetrics.MongeElkan;
import uk.ac.shef.wit.simmetrics.similaritymetrics.QGramsDistance;

public class Compare {

	private static AbstractStringMetric metric_qgram;
	private static AbstractStringMetric metric_chapman;
	private static AbstractStringMetric metric_jarowinkler;
	private static AbstractStringMetric metric_mongeelkan;

	/**
	 * Vergleicht zwei gegebene Strings mit dem Levensthein Algorithmus
	 * 
	 * @param str1
	 * @param str2
	 * @return gibt die Levensthein-Distanz zwischen den beiden Strings an
	 */
	public static boolean compare_levensthein(String str1, String str2,
			int distance) {

		Levensthein metric_levensthein = new Levensthein();

		int result_levensthein = metric_levensthein.LevenshteinDistance(str1,
				str2);

		if (result_levensthein < distance) {
			return true;
		}
		return false;
	}

	/**
	 * Vergleicht zwei gegebene Strings mit der QGram-Methdoe
	 * 
	 * @param str1
	 * @param str2
	 * @return einen prozentuell normalisierten Wert zwischen 0 und 1, der die
	 *         Übereinstimmung angibt
	 */
	public static float compare_qgram(String str1, String str2) {

		metric_qgram = new QGramsDistance();

		final float result = metric_qgram.getSimilarity(str1, str2);

		return result;
	}

	/**
	 * Vergleicht zwei gegebene Strings mit Chapman Methode
	 * 
	 * @param str1
	 * @param str2
	 * @return einen prozentuell normalisierten Wert zwischen 0 und 1, der die
	 *         Übereinstimmung angibt
	 */
	public static float compare_chapman(String str1, String str2) {

		metric_chapman = new ChapmanMatchingSoundex();

		final float result = metric_chapman.getSimilarity(str1, str2);

		return result;
	}

	/**
	 * Vergleicht zwei gegebene Strings mit JaroWinkler
	 * @param str1
	 * @param str2
	 * @return
	 */
	public static float compare_jarowinkler(String str1, String str2) {

		metric_jarowinkler = new JaroWinkler();
		
		final float result = metric_jarowinkler.getSimilarity(str1, str2);
		
		return result;
		
	}
	
	/**
	 * Vergleicht zwei gegebene Strings mit MongeElkan
	 * @param str1
	 * @param str2
	 * @return
	 */
	public static float compare_mongeelkan(String str1, String str2) {
		
		metric_mongeelkan = new MongeElkan();
		
		final float result = metric_mongeelkan.getSimilarity(str1, str2);
		
		return result;
	}
}
