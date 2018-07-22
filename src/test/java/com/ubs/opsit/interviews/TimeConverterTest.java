package com.ubs.opsit.interviews;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.ubs.opsit.berlinclock.BerlinClock;

@RunWith(MockitoJUnitRunner.class)
public class TimeConverterTest {

	@InjectMocks
	TimeConverter timeConverter = new TimeConverterImpl();

	@Mock
	BerlinClock berlinClock;

	@Test(expected = IllegalArgumentException.class)
	public void berlinClockWithInValidDataShouldThrowIllegalArgumentException() {
		timeConverter.convertTime("00:00");
	}

	@Test
	public void berlinClockWithInValidAndNullDataShouldThrowIllegalArgumentException() {
		try {
			timeConverter.convertTime(null);
		} catch (IllegalArgumentException e) {
			assertEquals("Invalid time format:Correct format: hh:mm:ss.", e.getMessage());
		}
	}

	@Test
	public void berlinClockWithValidInputShouldReturnResult() {

		Mockito.when(berlinClock.getClockTime(Mockito.anyString())).thenReturn(BerlinClockTestTimeConstant.time_23_59_59);
		assertEquals(BerlinClockTestTimeConstant.time_23_59_59, timeConverter.convertTime("23:59:59").toString());
		Mockito.verify(berlinClock).getClockTime("23:59:59");
	}

}
