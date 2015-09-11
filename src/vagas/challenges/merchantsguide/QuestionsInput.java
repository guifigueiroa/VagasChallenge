package vagas.challenges.merchantsguide;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;

public class QuestionsInput {

	
	private IntergalacticUnit unit = new IntergalacticUnit();
	private Map<String, Metal> metals = new HashMap<String, Metal>();
	
	/**
	 * Get answer according to question input
	 * @param input Question Input
	 * @return Answer
	 */
	public String getAnswer(String input){
		QuestionRegex regex = new QuestionRegex(input);
		Matcher m = regex.compile();
		
		switch(regex.getType()){
		case 0:
			addNewMetal(m.group(2), m.group(1), Integer.parseInt(m.group(3)));
			return null;
			
		case 1:
			return intergalacticUnitToArabic(m.group(1));
			
		case 2:
			return metalToCredits(m.group(1), m.group(2));
			
		case 3:
			addIntergalacticNumeral(m.group(1), m.group(2));
			return null;
			
		default:
			return "I have no idea what you are talking about";
		}
	}
	
	/**
	 * Add new intergalactic numeral to the unit
	 * @param intergalacticUnit Intergalactic numeral
	 * @param romanNumeral Equivalent in Roman Numeral
	 */
	private void addIntergalacticNumeral(String intergalacticUnit, String romanNumeral){
		unit.addNumeral(intergalacticUnit, romanNumeral);
	}
	
	/**
	 * Add new metal to list
	 * @param metalName Name of the metal
	 * @param intergalacticUnit Quantity in the intergalactic unit
	 * @param credits Quantity of credits equivalent
	 */
	private void addNewMetal(String metalName, String intergalacticUnit, int credits){
		Metal metal = new Metal(unit, intergalacticUnit, credits);
		metals.put(metalName, metal);
	}
	
	/**
	 * Converts intergalactic unit to arabic
	 * @param intergalacticUnit Intergalactic numeral
	 * @return Arabic number
	 */
	private String intergalacticUnitToArabic(String intergalacticUnit){
		int value = unit.convertToArabic(intergalacticUnit);
		
		return intergalacticUnit + " is " + value;
	}
	
	/**
	 * Converts from metal quantity to credits
	 * @param intergalacticUnit Quantity in the intergalactic unit
	 * @param metalName Metal name
	 * @return Quantity of credits
	 */
	private String metalToCredits(String intergalacticUnit, String metalName){
		Metal metal = metals.get(metalName);
		int credits = (int) metal.calculateCredits(unit, intergalacticUnit);
		
		return intergalacticUnit + " " + metalName + " is " + credits + " Credits";
	}
}
