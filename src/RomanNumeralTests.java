import static org.junit.Assert.*;

import org.junit.Test;

/**
 * 
 * @author Guilherme M. Figueiroa
 *
 */
public class RomanNumeralTests {

	@Test
	public void shouldConvertSimpleRoman() {
		assertEquals(RomanNumeral.fromRomanToArabic("I"), 1);
		assertEquals(RomanNumeral.fromRomanToArabic("V"), 5);
		assertEquals(RomanNumeral.fromRomanToArabic("X"), 10);
		assertEquals(RomanNumeral.fromRomanToArabic("L"), 50);
		assertEquals(RomanNumeral.fromRomanToArabic("C"), 100);
		assertEquals(RomanNumeral.fromRomanToArabic("D"), 500);
		assertEquals(RomanNumeral.fromRomanToArabic("M"), 1000);
	}
	
	@Test
	public void shouldConvertTwoAndThreeLetterRoman() {
		assertEquals(RomanNumeral.fromRomanToArabic("II"), 2);
		assertEquals(RomanNumeral.fromRomanToArabic("XX"), 20);
		assertEquals(RomanNumeral.fromRomanToArabic("CC"), 200);
		assertEquals(RomanNumeral.fromRomanToArabic("MM"), 2000);
		assertEquals(RomanNumeral.fromRomanToArabic("III"), 3);
		assertEquals(RomanNumeral.fromRomanToArabic("XXX"), 30);
		assertEquals(RomanNumeral.fromRomanToArabic("CCC"), 300);
		assertEquals(RomanNumeral.fromRomanToArabic("MMM"), 3000);
	}
	
	@Test
	public void shouldSubtractLowerValuesFromRoman(){
		assertEquals(RomanNumeral.fromRomanToArabic("IV"), 4);
		assertEquals(RomanNumeral.fromRomanToArabic("IX"), 9);
		assertEquals(RomanNumeral.fromRomanToArabic("XL"), 40);
		assertEquals(RomanNumeral.fromRomanToArabic("XC"), 90);
		assertEquals(RomanNumeral.fromRomanToArabic("CD"), 400);
		assertEquals(RomanNumeral.fromRomanToArabic("CM"), 900);
	}

	@Test
	public void shouldConvertComplexRomanNumerals(){
		assertEquals(RomanNumeral.fromRomanToArabic("MMCMDCIX"), 3509);
		assertEquals(RomanNumeral.fromRomanToArabic("LXIV"), 64);
		assertEquals(RomanNumeral.fromRomanToArabic("MMMDIX"), 3509);
		assertEquals(RomanNumeral.fromRomanToArabic("CXL"), 140);
		assertEquals(RomanNumeral.fromRomanToArabic("MDCCCXXXVI"), 1836);
		assertEquals(RomanNumeral.fromRomanToArabic("MMDCCCXCVI"), 2896);
		assertEquals(RomanNumeral.fromRomanToArabic("MMMCDLXXXVI"), 3486);
	}
	
	@Test
	public void shouldConvertSimpleArabic(){
		assertEquals(RomanNumeral.fromArabicToRoman(1), "I");
		assertEquals(RomanNumeral.fromArabicToRoman(5), "V");
		assertEquals(RomanNumeral.fromArabicToRoman(10), "X");
		assertEquals(RomanNumeral.fromArabicToRoman(50), "L");
		assertEquals(RomanNumeral.fromArabicToRoman(100), "C");
		assertEquals(RomanNumeral.fromArabicToRoman(500), "D");
		assertEquals(RomanNumeral.fromArabicToRoman(1000), "M");
	}
	
	@Test
	public void shouldConvertComplexRomanToArabic() {
		assertEquals("LXIV", RomanNumeral.fromArabicToRoman(64));
		assertEquals("MMMDIX", RomanNumeral.fromArabicToRoman(3509));
		assertEquals("CXL", RomanNumeral.fromArabicToRoman(140));
		assertEquals("MDCCCXXXVI", RomanNumeral.fromArabicToRoman(1836));
		assertEquals("MMDCCCXCVI", RomanNumeral.fromArabicToRoman(2896));
		assertEquals("MMMCDLXXXVI", RomanNumeral.fromArabicToRoman(3486));
		assertEquals("CMLXV", RomanNumeral.fromArabicToRoman(965));
		assertEquals("CCXXVII", RomanNumeral.fromArabicToRoman(227));
		assertEquals("CCXI", RomanNumeral.fromArabicToRoman(211));
	}
}
