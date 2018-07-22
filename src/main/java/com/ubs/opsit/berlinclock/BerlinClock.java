package com.ubs.opsit.berlinclock;

/**
 * @author UBS
 *
 */
public class BerlinClock {

	private Lamp lamp = new Lamp();

	private static final String STRING_FORMAT = "\r\n";
	private static final int DIV = 5;
	private static final int MIN_INDEX = 1;
	private static final int HOUR_INDEX = 0;
	private static final int SECONDS_INDEX = 2;

	/**
	 * @param time
	 * @return 
	 */
	public String getClockTime(String time) {

		String[] normalTime = time.split(":");
		return getFirstRow(Integer.parseInt(normalTime[SECONDS_INDEX])) + STRING_FORMAT
				+ getSecondRow(Integer.parseInt(normalTime[HOUR_INDEX]) / DIV, Colour.RED) + STRING_FORMAT
				+ getThirdRow(Integer.parseInt(normalTime[HOUR_INDEX]) % DIV, Colour.RED) + STRING_FORMAT
				+ getFourthRow(Integer.parseInt(normalTime[MIN_INDEX]) / DIV, Colour.RED, Colour.YELLOW) + STRING_FORMAT
				+ getFivithRow(Integer.parseInt(normalTime[MIN_INDEX]) % DIV, Colour.YELLOW);
	}

	private String getFirstRow(int number) {

		return lamp.getLamp(number);

	}

	private String getSecondRow(int number, Colour colour) {
		return lamp.getLamp(number, colour);
	}

	private String getThirdRow(int number, Colour colour) {
		return lamp.getLamp(number, colour);
	}

	private String getFourthRow(int number, Colour firstColour, Colour secondColour) {
		return lamp.getLamp(number, firstColour, secondColour);
	}

	private String getFivithRow(int number, Colour colour) {
		return lamp.getLamp(number, colour);
	}

}
