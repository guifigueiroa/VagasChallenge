import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 
 * @author Guilherme M. Figueiroa
 *
 */
public class RomanNumeral {

	/**
	 * Roman to Arabic auxiliary Map
	 */
	private static Map<Character, Integer>
			romanToArabic = new HashMap<Character, Integer>(){{
			 put('I', 1);
		     put('V', 5);
		     put('X', 10);
		     put('L', 50);
		     put('C', 100);
		     put('D', 500);
		     put('M', 1000);
	}};
	
	/**
	 * Arabic to Roman auxiliary Map
	 */
	private static LinkedHashMap<Integer, String>
		arabicToRoman = new LinkedHashMap<Integer, String>(){{
			put(1000, "M");
			put(900, "CM");
			put(500, "D");
			put(400, "CD");
			put(100, "C");
			put(90, "XC");
			put(50, "L");
			put(40, "XL");
			put(10, "X");
			put(9, "IX");
			put(5, "V");
			put(4, "IV");
			put(1, "I");
	}};
	
	/**
	 * Converts from Roman numeral to Arabic
	 * @param roman Roman numeral
	 * @return Corresponding Arabic value
	 */
	public static int fromRomanToArabic(String roman){
		int arabic = 0;
		
		int previousNumber = 0;
		
		for(int i = roman.length() - 1; i >= 0; i--){
			int number = romanToArabic.get(roman.charAt(i));
			
			if(number < previousNumber)
				number = number * (-1);
			
			arabic += number;
			
			previousNumber = number;
		}
		
		return arabic;
	}
	
	/**
	 * Converts from Arabic numeral to Roman
	 * @param arabic Arabic numeral
	 * @return Corresponding Roman value
	 */
	public static String fromArabicToRoman(int arabic){
		String roman = "";
		
		for(int key : arabicToRoman.keySet()){
			while(arabic >= key){
				roman += arabicToRoman.get(key);
				arabic -= key;
			}
		}
		
		return roman;
	}
}
