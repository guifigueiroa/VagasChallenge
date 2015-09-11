import static org.junit.Assert.*;

import org.junit.Test;

/**
 * 
 * @author Guilherme M. Figueiroa
 *
 */
public class QuestionsInputTests {

	@Test
	public void testOutputs() {
		QuestionsInput q = new QuestionsInput();
		
		assertNull(q.getAnswer("glob is I"));
		assertNull(q.getAnswer("prok is V"));
		assertNull(q.getAnswer("pish is X"));
		assertNull(q.getAnswer("tegj is L"));
		assertNull(q.getAnswer("glob glob Silver is 34 Credits"));
		assertNull(q.getAnswer("glob prok Gold is 57800 Credits"));
		assertNull(q.getAnswer("pish pish Iron is 3910 Credits"));
		assertEquals(q.getAnswer("how much is pish tegj glob glob ?"), 
				"pish tegj glob glob is 42");
		assertEquals(q.getAnswer("how many Credits is glob prok Silver ?"), 
				"glob prok Silver is 68 Credits");
		assertEquals(q.getAnswer("how many Credits is glob prok Gold ?"), 
				"glob prok Gold is 57800 Credits");
		assertEquals(q.getAnswer("how many Credits is glob prok Iron ?"), 
				"glob prok Iron is 782 Credits");
		assertEquals(q.getAnswer("how much wood could a woodchuck chuck "
				+ "if a woodchuck could chuck wood ?"), 
				"I have no idea what you are talking about");
	}

}
