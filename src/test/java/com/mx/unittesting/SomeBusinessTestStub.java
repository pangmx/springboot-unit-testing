package com.mx.unittesting;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.mx.unittesting.data.SomeDataService;


//@RunWith(MockitoJUnitRunner.class)
@ExtendWith(MockitoExtension.class)
public class SomeBusinessTestStub {
	
	@InjectMocks
	SomeBusinessImpl businessServiceToTest;
	
	// use Mockito to generate a mock service class for the SomeDataService interface
	@Mock
	SomeDataService someDataService;
	
	
	@Test
	public void calculateSumUsingDataService_basic() {
		
		when(someDataService.retrieveAllData()).thenReturn(new int[] {1,2,3});
		
		assertEquals(businessServiceToTest.calculateSumUsingDataService(), 6);
	}
	
	@Test
	public void calculateSum_empty() {
		
		when(someDataService.retrieveAllData()).thenReturn(new int[] {});
		
		assertEquals(businessServiceToTest.calculateSumUsingDataService(), 0);
	}
	
	@Test
	public void calculateSum_one() {
		
		when(someDataService.retrieveAllData()).thenReturn(new int[] {10});
		
		assertEquals(businessServiceToTest.calculateSumUsingDataService(), 10);
	}
}
