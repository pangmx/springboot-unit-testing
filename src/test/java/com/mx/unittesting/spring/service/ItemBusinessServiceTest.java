package com.mx.unittesting.spring.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.mx.unittesting.spring.data.ItemRepository;
import com.mx.unittesting.spring.model.Item;

@ExtendWith(MockitoExtension.class)
//@RunWith(MockitoJUnitRunner.class)
class ItemBusinessServiceTest {

	@InjectMocks
	private ItemBusinessService itemBusinessService;
	
	@Mock
	private ItemRepository itemRepository;
	
	@Test
	public void retrieveAllItems_test() {
		
		when(itemRepository.findAll()).thenReturn(
				Arrays.asList(
						new Item(1,"Ball",10,10), 
						new Item(2,"Table",20,20)
						)
				);
		
		  List<Item> items = itemBusinessService.retrieveAllItems();
		  
		  assertEquals(100, items.get(0).getValue()); 
		  assertEquals(400, items.get(1).getValue());
		 
	}

}
