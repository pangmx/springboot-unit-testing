package com.mx.unittesting;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.mx.unittesting.data.SomeDataService;

class SomeDataServiceStub implements SomeDataService{

	@Override
	public int[] retrieveAllData() {
		return new int[] {1,2,3};
	}
	
}

class SomeDataServiceStubEmpty implements SomeDataService{

	@Override
	public int[] retrieveAllData() {
		return new int[] {};
	}
	
}

class SomeDataServiceStubOne implements SomeDataService{

	@Override
	public int[] retrieveAllData() {
		return new int[] {10};
	}
	
}


public class SomeBusinessTestStubMock {
	
	@Test
	public void calculateSumUsingDataService_basic() {
		SomeBusinessImpl bus = new SomeBusinessImpl();
		bus.setSomeDataService(new SomeDataServiceStub());		
		int calculatedResult = bus.calculateSumUsingDataService();
		int expectedResult = 6;
		assertEquals(calculatedResult, expectedResult);
	}
	
	@Test
	public void calculateSum_empty() {
		SomeBusinessImpl bus = new SomeBusinessImpl();
		bus.setSomeDataService(new SomeDataServiceStubEmpty());
		
		int calculatedResult = bus.calculateSumUsingDataService();
		int expectedResult = 0;
		assertEquals(calculatedResult, expectedResult);
	}
	
	@Test
	public void calculateSum_one() {
		SomeBusinessImpl bus = new SomeBusinessImpl();
		bus.setSomeDataService(new SomeDataServiceStubOne());
		
		int calculatedResult = bus.calculateSumUsingDataService();
		int expectedResult = 10;
		assertEquals(calculatedResult, expectedResult);
	}
}
