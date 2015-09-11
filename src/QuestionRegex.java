import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * @author Guilherme M. Figueiroa
 *
 */
public class QuestionRegex {

	private static final String REGEX_PATTERN1 = "(.*)\\s(.*)\\sis\\s(.*)\\sCredits$";
	private static final String REGEX_PATTERN2 = "how\\smuch\\sis\\s(.*)\\s\\?$";
	private static final String REGEX_PATTERN3 = "how\\smany\\sCredits\\sis\\s(.*)\\s(.*)\\s\\?$";
	private static final String REGEX_PATTERN4 = "(.*)\\sis\\s(.*)$";
	private String question;
	private String regex;
	private int type;
	
	/**
	 * Constructor for question regular expressions
	 * 
	 * @param question Question input
	 */
	public QuestionRegex(String question){
		this.question = question;
		if(Pattern.matches(REGEX_PATTERN1, question)){
			this.regex = REGEX_PATTERN1;
			this.type = 0;
		} else if(Pattern.matches(REGEX_PATTERN2, question)){
			this.regex = REGEX_PATTERN2;
			this.type = 1;
		} else if(Pattern.matches(REGEX_PATTERN3, question)){
			this.regex = REGEX_PATTERN3;
			this.type = 2;
		} else if(Pattern.matches(REGEX_PATTERN4, question)){
			this.regex = REGEX_PATTERN4;
			this.type = 3;
		} else {
			this.type = 4;
		}
	}
	
	/**
	 * Returns the type of the question
	 * @return Type of the question
	 */
	public int getType(){
		return this.type;
	}
	
	/**
	 * Compile the question using the regular expression
	 * @return Matcher with groups of substrings found
	 */
	public Matcher compile(){
		if(type == 4) return null;
		
		Matcher m = Pattern.compile(regex).matcher(question);
		m.find();
		
		return m;
	}
}
