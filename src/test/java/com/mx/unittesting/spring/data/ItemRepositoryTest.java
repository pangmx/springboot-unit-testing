package com.mx.unittesting.spring.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.mx.unittesting.spring.data.ItemRepository;
import com.mx.unittesting.spring.model.Item;

@DataJpaTest
//@RunWith(SpringRunner.class)
public class ItemRepositoryTest {

	
	@Autowired
	ItemRepository itemRepo;
	
	@Test
	public void findAllTest() {
		List<Item> items = itemRepo.findAll();
		assertNotNull(items);
		assertEquals(3, items.size());
	}
	
	@Test
	public void findByIdTest() {
		Item item = itemRepo.findById(1).get();
		assertNotNull(item);
		assertEquals("Ball",item.getName());
	}
}
