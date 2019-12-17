package com.mx.unittesting.spring.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mx.unittesting.spring.model.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {

}
