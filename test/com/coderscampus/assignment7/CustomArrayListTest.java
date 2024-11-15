package com.coderscampus.assignment7;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class CustomArrayListTest<T> {
		
	public Object[] items = new Object[10];	
	private int size;	
	
	// test-driven development methodology
	// 1 write a failing test
	// 2 write the business logic to make the test pass
	// 3 refactor your code		

	@Test
	void should_add_40_items_to_list() {			
		//arrange
		CustomList<Integer> sut = new CustomArrayList<>();
		//act
		for (int i = 0; i < 40; i++) {
			sut.add(i);
		}
		//assert
		assertEquals(40, sut.getSize());				
	}	
	
	@Test
	void should_add_item_at_specified_index_and_shift() {
		//arrange
		CustomList<Integer> sut = new CustomArrayList<>();
		//act
		for (int i = 0; i < 40; i++) {
			sut.add(i);
		}
		
		sut.add(5, 99);
		//assert
		assertEquals(99, sut.get(5));
		assertEquals(41, sut.getSize());					
	}	
	
	@Test
	void should_remove_item_from_list_and_return_item() {
		//arrange
		CustomList<Integer> sut = new CustomArrayList<>();
		//act
		for (int i = 0; i < 40; i++) {
			sut.add(i);
		}
		
		int actualResultInt = sut.remove(5);
		//assert
		assertEquals(39, sut.getSize());	
		assertEquals(6, sut.get(5));
		assertEquals(5, actualResultInt);
	}	

}
