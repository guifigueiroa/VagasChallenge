package vagas.challenges.merchantsguide;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class IntergalacticUnitAndMetalTests {

	IntergalacticUnit unit;
	Metal silver, gold, iron;
	
	@Before
	public void initialize(){
		unit = new IntergalacticUnit();
		unit.addNumeral("glob", "I");
		unit.addNumeral("prok", "V");
		unit.addNumeral("pish", "X");
		unit.addNumeral("tegj", "L");
	}
	
	@Test
	public void shouldConvertFromIntergalacticToRoman() {
		assertEquals("XLII", unit.convertToRoman("pish tegj glob glob "));
	}

	@Test
	public void shouldConvertFromIntergalacticToArabic() {
		assertEquals(42, unit.convertToArabic("pish tegj glob glob "));
	}
	
	@Test
	public void shouldConvertMetalToCredits(){
		silver = new Metal(unit, "glob glob", 34);
		assertEquals(68, silver.calculateCredits(unit, "glob prok"), 0.001);
		gold = new Metal(unit, "glob prok", 57800);
		assertEquals(57800, gold.calculateCredits(unit, "glob prok"), 0.001);
		iron = new Metal(unit, "pish pish", 3910);
		assertEquals(782, iron.calculateCredits(unit, "glob prok"), 0.001);
	}
}
