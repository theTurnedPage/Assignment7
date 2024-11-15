package com.coderscampus.assignment7;

import java.util.Arrays;

public class CustomArrayList<T> implements CustomList<T> {
		Object[] items = new Object[10];
		private int size;

		@Override
		public boolean add(T item) {
			
			ensureCapacity();
			items[size++] = item;
			return true;
		}
		
		@Override
		public boolean add(int index, T item) throws IndexOutOfBoundsException {
			
			ensureCapacity(); 
			
			if (index < 0 || index > size) {
	            throw new IndexOutOfBoundsException("Invalid index: " + index);
	        } else {
	        	
	            for (int i = size; i > index; i--) {
	            	items[i] = items[i - 1];            	
	            }
	            items[index] = item;
	        }            
			size++;	//increment!!! lol	
			return true;	
		}		

		@Override
		public int getSize() {		
			return size;
		}

		@Override
		public T get(int index) {
			if (index < 0 || index >= size) {
				throw new IndexOutOfBoundsException("Index Out of Bounds Exception!");
			}
			return (T) items[index];
		}
			
		@Override
		public T remove(int index) throws IndexOutOfBoundsException {
			
			T removedInt = (T) items[index];
	        if (index < 0 || index > size - 1) {
	            throw new IndexOutOfBoundsException("Invalid index: " + index);
	        } else {
	        	
	            for (int i = index; i < size - 1; i++) {
	            	items[i] = items[i + 1];            	
	            }
	            items[size - 1] = null;
	            size--;
	        }               										
			return removedInt;
		}
		
		private void ensureCapacity() { 
			
			if (size == items.length) {				
				items = Arrays.copyOf(items, items.length * 2);							
			}
			
		}				
	}