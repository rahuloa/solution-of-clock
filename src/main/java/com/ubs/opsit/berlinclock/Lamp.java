package com.ubs.opsit.berlinclock;

public class Lamp {

	private static final String ONE_LAMP = "O";
	private static final String FOUR_LAMP = "OOOO";
	private static final String ELEVEN_LAMP = "OOOOOOOOOOO";

	/**
	 * Get four lamp based on number
	 * 
	 * @param number
	 * @return String four lamp string
	 */
	public String getLamp(int number, Colour colour) {
		StringBuffer lamps = new StringBuffer(FOUR_LAMP);

		for (int i = 0; i < number; i++) {
			lamps.replace(i, i + 1, colour.getColour());

		}
		return lamps.toString();
	}

	/**
	 * Get eleven lamp based on number
	 * 
	 * @param number
	 * @param firstColour
	 * @param secondColour
	 * @return
	 */
	public String getLamp(int number, Colour firstColour, Colour secondColour) {

		StringBuffer lamps = new StringBuffer(ELEVEN_LAMP);

		for (int i = 0; i < number; i++) {
			if (0 == (i + 1) % 3) {
				lamps.replace(i, i + 1, firstColour.getColour());
			} else {
				lamps.replace(i, i + 1, secondColour.getColour());
			}
		}
		return lamps.toString();
	}

	/**
	 * Get one lamp based on number
	 * 
	 * @param number
	 * @return String one lamp string
	 */
	public String getLamp(int number) {
		if (0 == number % 2) {
			return Colour.YELLOW.getColour();
		}

		return ONE_LAMP;
	}

}
