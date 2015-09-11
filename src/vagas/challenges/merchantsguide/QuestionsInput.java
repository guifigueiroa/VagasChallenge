package vagas.challenges.merchantsguide;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QuestionsInput {

	private static final String REGEX_PATTERN1 = "(.*)\\s(.*)\\sis\\s(.*)\\sCredits$";
	private static final String REGEX_PATTERN2 = "how\\smuch\\sis\\s(.*)\\s\\?$";
	private static final String REGEX_PATTERN3 = "how\\smany\\sCredits\\sis\\s(.*)\\s(.*)\\s\\?$";
	private static final String REGEX_PATTERN4 = "(.*)\\sis\\s(.*)$";
	private IntergalacticUnit unit = new IntergalacticUnit();
	private Map<String, Metal> metals = new HashMap<String, Metal>();
	
	public String getAnswer(String input){
		String answer = "";
		
		Matcher m;
		
		if(Pattern.matches(REGEX_PATTERN1, input)){
			m = Pattern.compile(REGEX_PATTERN1).matcher(input);
			if(m.find()){
				String intergalacticUnit = m.group(1);
				String metalName = m.group(2);
				int credits = Integer.parseInt(m.group(3));
				
				Metal metal = new Metal(unit, intergalacticUnit, credits);
				metals.put(metalName, metal);
			}
		} else if(Pattern.matches(REGEX_PATTERN2, input)){
			m = Pattern.compile(REGEX_PATTERN2).matcher(input);
			if(m.find()){
				String intergalacticUnit = m.group(1);
				int value = unit.convertToArabic(intergalacticUnit);
				
				answer = intergalacticUnit + " is " + value;
			}
			
		} else if(Pattern.matches(REGEX_PATTERN3, input)){
			m = Pattern.compile(REGEX_PATTERN3).matcher(input);
			if(m.find()){
				String intergalacticUnit = m.group(1);
				String metalName = m.group(2);
				Metal metal = metals.get(metalName);
				int credits = (int) metal.calculateCredits(unit, intergalacticUnit);
				answer = intergalacticUnit + " " + metalName + " is " + credits + " Credits";
			}
			
		} else if(Pattern.matches(REGEX_PATTERN4, input)){
			m = Pattern.compile(REGEX_PATTERN4).matcher(input);
			if(m.find()){
				unit.addNumeral(m.group(1), m.group(2));
			}
		} else {
			answer = "I have no idea what you are talking about";
		}
		
		return answer;
	}
	
	
	
	public static void main(String args[]) {
		try {
			Scanner in = new Scanner(new FileReader(args[0]));
			QuestionsInput q = new QuestionsInput();
			while(in.hasNextLine()){
				String input = in.nextLine();
				String output = q.getAnswer(input);
				
				if(!output.isEmpty()){
					System.out.println(output);
				}
			}
			
			in.close();
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
		}
	}
}
