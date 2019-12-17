package com.mx.unittesting;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class SomeBusinessTest {

	@Test
	public void calculateSum_basic() {
		SomeBusinessImpl bus = new SomeBusinessImpl();
		int calculatedResult = bus.calculateSum(new int [] {1,2,3});
		int expectedResult = 6;
		assertEquals(calculatedResult, expectedResult);
	}
	
	@Test
	public void calculateSum_empty() {
		SomeBusinessImpl bus = new SomeBusinessImpl();
		int calculatedResult = bus.calculateSum(new int [] {});
		int expectedResult = 0;
		assertEquals(calculatedResult, expectedResult);
	}
	
	@Test
	public void calculateSum_one() {
		SomeBusinessImpl bus = new SomeBusinessImpl();
		int calculatedResult = bus.calculateSum(new int [] {10});
		int expectedResult = 10;
		assertEquals(calculatedResult, expectedResult);
	}
}
