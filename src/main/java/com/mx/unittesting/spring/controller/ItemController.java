package com.mx.unittesting.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.unittesting.spring.model.Item;
import com.mx.unittesting.spring.service.ItemBusinessService;

@RestController
public class ItemController {
	
	@Autowired
	ItemBusinessService itemBusinessService;

	@GetMapping("/dummy-item")
	public Item helloWorld() {
		return new Item(1, "Ball", 10, 100);
	}
	
	@GetMapping("/item-from-business-service")
	public Item itemFromBusinessService() {
		return itemBusinessService.retrieveHardCodedItem();
	}
	
	@GetMapping("/all-items-from-database")
	public List<Item> retrieveAllItems() {
		return itemBusinessService.retrieveAllItems();
	}
}
