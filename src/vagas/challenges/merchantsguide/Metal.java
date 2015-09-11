package vagas.challenges.merchantsguide;

public class Metal {
	
	private int value;
	private int credits;
	
	/**
	 * Constructor for metal
	 * @param unit Intergalactic unit of the input
	 * @param intergalacticValue Intergalactic value of the unit specified
	 * @param credits Number of credits corresponding to unit
	 */
	public Metal(IntergalacticUnit unit, String intergalacticValue, int credits){
		this.value = unit.convertToArabic(intergalacticValue);
		this.credits = credits;
	}
	
	/**
	 * Calculates the credits using the unit specified and the values in that unit
	 * @param unit Intergalactic unit of the input
	 * @param intergalacticValue Intergalactic value of the unit specified
	 * @return The number of credits calculated from the unit
	 */
	public double calculateCredits(IntergalacticUnit unit, String intergalacticValue){
		int intergalactic = unit.convertToArabic(intergalacticValue);
		
		return (int)((intergalactic * credits) /value);
	}
}
