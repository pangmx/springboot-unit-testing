package com.mx.unittesting.spring.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.mx.unittesting.spring.controller.ItemController;
import com.mx.unittesting.spring.model.Item;
import com.mx.unittesting.spring.service.ItemBusinessService;

//@RunWith(SpringRunner.class)
@WebMvcTest(ItemController.class)
class ItemControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	ItemBusinessService itemBusinessService;
	
	@Test
	public void helloWorld_basic() throws Exception {
		// call GET /dummy-item application/json
		
		RequestBuilder request = MockMvcRequestBuilders
				.get("/dummy-item")
				.accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json("{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}"))
				.andReturn();
		
		// alternatively, we can take the response string and use JSONAssert
		JSONAssert.assertEquals("{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}", 
				result.getResponse().getContentAsString(), false);
		
	}
	
	@Test
	public void itemFromBusinessService_basic() throws Exception{
		
		when(itemBusinessService.retrieveHardCodedItem()).thenReturn(new Item(2,"Ball 2",10,10));
		
		RequestBuilder request = MockMvcRequestBuilders
				.get("/item-from-business-service")
				.accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json("{\"id\":2,\"name\":\"Ball 2\",\"price\":10,\"quantity\":10}"))
				.andReturn();
	}
	
	@Test
	public void retrieveAllItems_basic() throws Exception{
		
		when(itemBusinessService.retrieveAllItems())
		.thenReturn(
				Arrays.asList(
						new Item(1,"Ball",10,10), 
						new Item(2,"Table",20,20)
						)
			);
		
		RequestBuilder request = MockMvcRequestBuilders
				.get("/all-items-from-database")
				.accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json("[{id:1,name:Ball,price:10,quantity:10},{id:2,name:Table,quantity:20,price:20}]"))
				.andReturn();
	}

}
