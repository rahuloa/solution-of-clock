package com.ubs.opsit.berlinclock;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.ubs.opsit.interviews.BerlinClockTestTimeConstant;

@RunWith(PowerMockRunner.class)
@PrepareForTest(BerlinClock.class)
public class BerlinClockTest {

	private BerlinClock berlinClock = new BerlinClock();

	@Test
	public void berlinClockWithValidInputTimeReturnBerlinClockTime() {
		LocalDateTime localDate = LocalDateTime.now();
		String time = localDate.getHour() + ":" + localDate.getMinute() + ":" + localDate.getSecond();
		String result = berlinClock.getClockTime(time);
		Assert.assertNotNull(result);
	}

	@Test
	public void berlinClockWithValidInputAnd23_59_59ReturnBerlinClockTime() throws Exception {
		BerlinClock berlinClock = PowerMockito.spy(new BerlinClock());
		PowerMockito.doReturn("O").when(berlinClock, "getFirstRow", Mockito.anyInt());
		PowerMockito.doReturn("RRRR").when(berlinClock, "getSecondRow", Mockito.anyInt(), Mockito.anyObject());
		PowerMockito.doReturn("RRRO").when(berlinClock, "getThirdRow", Mockito.anyInt(), Mockito.anyObject());
		PowerMockito.doReturn("YYRYYRYYRYY").when(berlinClock, "getFourthRow", Mockito.anyInt(), Mockito.anyObject(),
				Mockito.anyObject());
		PowerMockito.doReturn("YYYY").when(berlinClock, "getFivithRow", Mockito.anyInt(), Mockito.anyObject());
		assertEquals(BerlinClockTestTimeConstant.time_23_59_59, berlinClock.getClockTime("25:59:59").toString());
	}

	@Test
	public void berlinClockWithValidInputAnd13_17_01ReturnBerlinClockTime() throws Exception {
		BerlinClock berlinClock = PowerMockito.spy(new BerlinClock());
		PowerMockito.doReturn("O").when(berlinClock, "getFirstRow", Mockito.anyInt());
		PowerMockito.doReturn("RROO").when(berlinClock, "getSecondRow", Mockito.anyInt(), Mockito.anyObject());
		PowerMockito.doReturn("RRRO").when(berlinClock, "getThirdRow", Mockito.anyInt(), Mockito.anyObject());
		PowerMockito.doReturn("YYROOOOOOOO").when(berlinClock, "getFourthRow", Mockito.anyInt(), Mockito.anyObject(),
				Mockito.anyObject());
		PowerMockito.doReturn("YYOO").when(berlinClock, "getFivithRow", Mockito.anyInt(), Mockito.anyObject());
		assertEquals(BerlinClockTestTimeConstant.time_13_17_01, berlinClock.getClockTime("13:17:01").toString());
	}

}
