package com.coderscampus.assignment7;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import com.coderscampus.assignment7.CustomArrayList;
import com.coderscampus.assignment7.CustomList;

class CustomArrayListTest<T> {
		
	public Object[] items = new Object[10];	
	private int size;	
	
	// test-driven development methodology
	// 1 write a failing test
	// 2 write the business logic to make the test pass
	// 3 refactor your code		

	@Test
	void should_kick_off_everything() {
		// Three A's
		// Arrange, Act, Assert
		
		//Arrange
		CustomArrayListTest<Integer> sut = new CustomArrayListTest<>();
		
		//Act  
		for (int i = 0; i < 40; i++) {
  			sut.should_add_items_to_list(i);
		}		
									
 		sut.should_move_items_towards_right_upon_add(5, 99);
 		int removedItem = sut.should_remove_item_from_list_then_push_items_left(5);
		
		
		System.out.println("Number at Index 5:" + sut.should_get_item_at_index_from_list(5));
		System.out.println("Removed item: " + removedItem);
		int actualResult = sut.should_get_size_of_list();
				
		//Assert		
		assertEquals(39, actualResult);
		assertEquals(99, removedItem);
	}
	
	@Test
	boolean should_add_items_to_list(T item) {					
		
		should_start_back_size();
		items[size++] = item;					
		return true;
	}
	
	@Test
	boolean should_move_items_towards_right_upon_add(int index, T item) throws IndexOutOfBoundsException{
			
		should_start_back_size();
		
		if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        } else {
        	
            for (int i = size; i > index; i--) {
            	items[i] = items[i - 1];            	
            }
            items[index] = item;
        }               
		
		return true;			
	}	
	
	@Test
	public int should_get_size_of_list() {		
		return size;	
	}
	
	@Test
	public T should_get_item_at_index_from_list(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index Out of Bounds Exception!");
		}
		return (T) items[index];
	}		
	
	@Test
	private T should_remove_item_from_list_then_push_items_left(int index) throws IndexOutOfBoundsException {
		T removedItem = (T) items[index];
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        } else {
        	
            for (int i = index; i < size - 1; i++) {
            	items[i] = items[i + 1];            	
            }
            items[size - 1] = null;
            size--;
        }               							
		
		return (T) removedItem;
	}			
	
	@Test
	private void should_start_back_size() {
		
		if (size == items.length) {
			items = Arrays.copyOf(items, items.length * 2);
			System.out.println("\n***Increase size of array***\n" + "\n New Size: " + items.length + "\n");
		} else {
			System.out.println("No need to increase size of Array yet");
		}
		
	}

}
