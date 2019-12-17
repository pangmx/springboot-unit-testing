package com.mx.unittesting;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

public class JsonPathTest {

	@Test
	public void myTest() {
		String jsonResponse = "[{\"id\":1,\"name\":\"Pencil\",\"quantity\":10},\r\n" + 
				"{\"id\":1,\"name\":\"Pen\",\"quantity\":20},\r\n" + 
				"{\"id\":1,\"name\":\"Eraser\",\"quantity\":15}]";
		
		DocumentContext context = JsonPath.parse(jsonResponse);
		int length = context.read("$.length()");
		assertThat(length).isEqualTo(3);
		
		List<String> names = context.read("$..name");
		assertThat(names).containsExactly("Pencil","Pen","Eraser");
		
		System.out.println(context.read("$.[1]").toString());
		System.out.println(context.read("$.[0:2]").toString());
		System.out.println(context.read("$.[?(@.name=='Pen')]").toString());
		
	}
}
