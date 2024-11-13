package com.coderscampus.assignment7;

import static org.junit.jupiter.api.Assertions.*;
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
		//using public instead
		
		//Act  
		for (int i = 0; i < 20; i++) {
  			sut.should_add_items_to_list(i);
		}		
									
 		sut.should_move_items_towards_right_upon_add(5, 99);
		
		
		System.out.println("Number at Index 5:" + sut.should_get_item_at_index_from_list(5));
		sut.should_remove_item_from_list_then_push_items_left(1);
		int actualResult = sut.should_get_size_of_list();
				
		//Assert		
		assertEquals(19, actualResult);		
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
	boolean should_add_items_to_list(T item) {
				
		//initially false
		boolean actualResult = false; 		
		
		should_start_back_size();
		items[size++] = item; //insert element into Object array, increment the size variable					
		return true;
	}
	
	@Test
	boolean should_move_items_towards_right_upon_add(int index, T item) throws IndexOutOfBoundsException{
			
		 //increase size of array to avoid IndexOutOfBoundsException if possible
		should_start_back_size();
		
		if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        } else {
        	
            for (int i = size; i > index; i--) {
            	items[i] = items[i - 1];            	
            }
            items[index] = item;//after moving other elements, insert
        }               
		
		return true;			
	}
	
	@Test
	private T should_remove_item_from_list_then_push_items_left(int index) throws IndexOutOfBoundsException {
		
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        } else {
        	
            for (int i = index; i < size - 1; i++) {
            	items[i] = items[i + 1];            	
            }
            //remove last element
            items[size - 1] = null;
            size--;
        }               							
		
		return (T) items[index];
	}		
	
	@Test
	private Object[] should_back_size_of_array(Object[] someArray) {
		
		//create new collection with double the size as the last
		Object[] doubledArray = new Object[someArray.length * 2];
		//copy elements from previous collection to new collection
		System.out.println(doubledArray.length);
		
		//catch the null value at the start, use it to populate the list initially
		if (doubledArray[0] == null) {
			for (int i = 0; i < someArray.length; i++) {
				doubledArray[i] = someArray[i];
			}
		} else { //once initial nulls are changed above, continue to populate
			for (int i = someArray.length-1; i < doubledArray.length; i++) {
				doubledArray[i] = someArray[i];
			}
		}
			
		//send newly copied collection			
		return doubledArray;				
	}
	
	@Test
	private void should_start_back_size() {
		
		if (size == items.length) {
			//double size of array
			//items = Arrays.copyOf(items, items.length * 2);
			items = should_back_size_of_array(items);
			System.out.println("\n***Increase size of array***\n" + "\n New Size: " + items.length + "\n");
		} else {
			System.out.println("No need to increase size of Array yet");
		}
		
	}

}
