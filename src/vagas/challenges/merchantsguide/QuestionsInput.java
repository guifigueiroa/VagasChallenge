package vagas.challenges.merchantsguide;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;

public class QuestionsInput {

	
	private IntergalacticUnit unit = new IntergalacticUnit();
	private Map<String, Metal> metals = new HashMap<String, Metal>();
	
	public String getAnswer(String input){
		String answer = "";
		
		QuestionRegex regex = new QuestionRegex(input);
		Matcher m = regex.compile();
		
		String intergalacticUnit;
		String metalName;
		Metal metal;
		int credits;
		
		switch(regex.getType()){
		case 0:
			intergalacticUnit = m.group(1);
			metalName = m.group(2);
			credits = Integer.parseInt(m.group(3));
			
			metal = new Metal(unit, intergalacticUnit, credits);
			metals.put(metalName, metal);
			break;
			
		case 1:
			intergalacticUnit = m.group(1);
			int value = unit.convertToArabic(intergalacticUnit);
			
			answer = intergalacticUnit + " is " + value;
			break;
			
		case 2:
			intergalacticUnit = m.group(1);
			metalName = m.group(2);
			metal = metals.get(metalName);
			credits = (int) metal.calculateCredits(unit, intergalacticUnit);
			
			answer = intergalacticUnit + " " + metalName + " is " + credits + " Credits";
			break;
			
		case 3:
			unit.addNumeral(m.group(1), m.group(2));
			break;
			
		case 4:
			answer = "I have no idea what you are talking about";
			break;
		}
		
		return answer;
	}
}
