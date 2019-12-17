package com.mx.unittesting.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mx.unittesting.spring.data.ItemRepository;
import com.mx.unittesting.spring.model.Item;

@Component
public class ItemBusinessService {

	@Autowired
	private ItemRepository itemRepository;
	
	public Item retrieveHardCodedItem() {
		return new Item(1, "Ball", 10, 100);
	}
	
	public List<Item> retrieveAllItems(){
		List<Item> items = itemRepository.findAll();
		
		if(items!=null) {
			items.forEach(item -> item.setValue(item.getPrice()*item.getQuantity()));
		}else {
			System.out.println("Items are null in ItemBusinessService");
		}
		
		return items;
	}

}
