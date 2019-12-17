package com.mx.unittesting;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;

import com.mx.unittesting.data.SomeDataService;

public class SomeBusinessImpl {

	private SomeDataService someDataService;
	
	public void setSomeDataService(SomeDataService service) {
		this.someDataService = service;
	}
	
	public int calculateSum(int [] numbers) {
		
		int sum = Arrays.stream(numbers).sum();
		
		return sum;
	}
	
	public int calculateSumUsingDataService() {
		
		int[]data = someDataService.retrieveAllData();
		int sum = Arrays.stream(data).sum();
		
		return sum;
	}
}
