package com.mx.unittesting.spring;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ItemControllerIT {

	@Autowired
	private TestRestTemplate testRestTemplate;
	
	@Test
	public void contextLoad() throws JSONException {
		String response = 
				testRestTemplate
				.getForObject("/all-items-from-database", String.class);
		
		JSONAssert.assertEquals("[{id:3},{id:2},{id:1}]", response, false);
	}
}
