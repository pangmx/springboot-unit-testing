package com.mx.unittesting;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class AssertJTest {

	@Test
	public void mytest() {
		List<Integer> numbers = Arrays.asList(10,15,30);
		
		assertThat(numbers)
			.hasSize(3)
			.contains(15)
			.allMatch(x -> x > 5)
			.doesNotHaveDuplicates()
			.noneMatch(x -> x < 5);
		
		assertThat("ABCD")
			.startsWith("A")
			.endsWith("CD");
	}
}
