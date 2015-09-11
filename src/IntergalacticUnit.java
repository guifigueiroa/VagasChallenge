import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author Guilherme M. Figueiroa
 *
 */
public class IntergalacticUnit {

	private Map<String, String> numerals = 
			new HashMap<String, String>();
	
	/**
	 * Add new numeral to the intergalactic unit
	 * 
	 * @param numeral Numeral (eg. glob, prok)
	 * @param roman Romal numeral (eg. XX, MXXIV)
	 */
	public void addNumeral(String numeral, String roman){
		numerals.put(numeral, roman);
	}
	
	/**
	 * Converts the intergalactic unit to Roman
	 * @param intergalactic Intergalactic Unit
	 * @return Roman numeral
	 */
	public String convertToRoman(String intergalactic){
		for(String numeral : numerals.keySet()){
			intergalactic = intergalactic.replace(numeral, numerals.get(numeral));
		}
		
		return intergalactic.replace(" ", "");
	}
	
	/**
	 * Converts the intergalactic unit to Arabic
	 * @param intergalactic Intergalactic Unit
	 * @return Arabic numeral
	 */
	public int convertToArabic(String intergalactic){
		return RomanNumeral.fromRomanToArabic(convertToRoman(intergalactic));
	}
}
