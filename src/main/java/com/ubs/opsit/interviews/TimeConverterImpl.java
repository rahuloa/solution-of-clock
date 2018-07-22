package com.ubs.opsit.interviews;

import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ubs.opsit.berlinclock.BerlinClock;

public class TimeConverterImpl implements TimeConverter {

	private Logger logger = LoggerFactory.getLogger(TimeConverter.class);

	private BerlinClock berlinClock = new BerlinClock();

	@Override
	public String convertTime(String aTime) {
		logger.debug("Started - Convert Time : {}", aTime);
		isValid(aTime);
		String result = berlinClock.getClockTime(aTime);
		logger.debug("Completed - Convert Time : {}", result);
		return result;
	}

	/**
	 * Validate time in hh:mm:ss format.
	 * 
	 * @param time
	 * @throws IllegalArgumentException
	 */
	public void isValid(String time) throws IllegalArgumentException {
		Pattern PATTERN = Pattern.compile("([01]?[0-9]|2[0-4]):[0-5][0-9]:[0-5][0-9]");
		if (!(!StringUtils.isBlank(time) && PATTERN.matcher(time).matches())) {
			logger.error("Invalid Time format ::" + time);
			throw new IllegalArgumentException("Invalid time format:Correct format: hh:mm:ss.");
		}
	}

}
