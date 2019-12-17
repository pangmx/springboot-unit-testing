package com.mx.unittesting;

import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class ListMockTestJunit5 {

	@Test
	void test() {
		ArrayList arrayListSpy = spy(ArrayList.class);
		arrayListSpy.add("SomeString1");
		arrayListSpy.add("SomeString1");
		verify(arrayListSpy,times(2)).add("SomeString1");
	}

}
