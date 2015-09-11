package vagas.challenges.merchantsguide;

import static org.junit.Assert.*;

import org.junit.Test;

public class QuestionsInputTests {

	@Test
	public void testOutputs() {
		QuestionsInput q = new QuestionsInput();
		
		assertEquals(q.getAnswer("glob is I"), "");
		assertEquals(q.getAnswer("prok is V"), "");
		assertEquals(q.getAnswer("pish is X"), "");
		assertEquals(q.getAnswer("tegj is L"), "");
		assertEquals(q.getAnswer("glob glob Silver is 34 Credits"), "");
		assertEquals(q.getAnswer("glob prok Gold is 57800 Credits"), "");
		assertEquals(q.getAnswer("pish pish Iron is 3910 Credits"), "");
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
