package com.ubs.opsit.berlinclock;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.ubs.opsit.interviews.BerlinClockTestTimeConstant;

public class LampTest {
	
	private Lamp lamp = new Lamp();

	@Test
	public void lampWithValidDataShouldReturnOneLamp() {
		assertEquals(BerlinClockTestTimeConstant.ONE_LAMP_INT_0, lamp.getLamp(0));
		assertEquals(BerlinClockTestTimeConstant.ONE_LAMP_INT_1, lamp.getLamp(1));
	}

	@Test
	public void lampWithValidDataShouldReturnFourLamp() {
		assertEquals(BerlinClockTestTimeConstant.FOUR_LAMP_RED_INT_1, lamp.getLamp(1, Colour.RED));
		assertEquals(BerlinClockTestTimeConstant.FOUR_LAMP_RED_INT_2, lamp.getLamp(2, Colour.RED));
		assertEquals(BerlinClockTestTimeConstant.FOUR_LAMP_RED_INT_3, lamp.getLamp(3, Colour.RED));
		assertEquals(BerlinClockTestTimeConstant.FOUR_LAMP_RED_INT_4, lamp.getLamp(4, Colour.RED));
		assertEquals(BerlinClockTestTimeConstant.FOUR_LAMP_YELLOW_INT_1, lamp.getLamp(1, Colour.YELLOW));
		assertEquals(BerlinClockTestTimeConstant.FOUR_LAMP_YELLOW_INT_2, lamp.getLamp(2, Colour.YELLOW));
		assertEquals(BerlinClockTestTimeConstant.FOUR_LAMP_YELLOW_INT_3, lamp.getLamp(3, Colour.YELLOW));
		assertEquals(BerlinClockTestTimeConstant.FOUR_LAMP_YELLOW_INT_4, lamp.getLamp(4, Colour.YELLOW));
	}

	@Test
	public void lampWithValidDataShouldReturnElevenLamp() {
		assertEquals(BerlinClockTestTimeConstant.ELEVEN_LAMP_RED_YELLOW_INT_11,
				lamp.getLamp(11, Colour.RED, Colour.YELLOW));
		assertEquals(BerlinClockTestTimeConstant.ELEVEN_LAMP_RED_YELLOW_INT_3,
				lamp.getLamp(3, Colour.RED, Colour.YELLOW));
		assertEquals(BerlinClockTestTimeConstant.ELEVEN_LAMP_RED_YELLOW_INT_0,
				lamp.getLamp(0, Colour.RED, Colour.YELLOW));
		assertEquals(BerlinClockTestTimeConstant.ELEVEN_LAMP_RED_YELLOW_INT_6,
				lamp.getLamp(6, Colour.RED, Colour.YELLOW));
	}

}

