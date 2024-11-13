package com.coderscampus.assignment7;

import java.util.Arrays;

public class CustomArrayList<T> implements CustomList<T> {
		Object[] items = new Object[10];
		private int size;

		@Override
		public boolean add(T item) {
			
			ensureCapacity(); //method to "back" the Object array
			items[size++] = item; //insert element into Object array, increment the size variable
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
			
		private void ensureCapacity() { //renamed per suggestion from Assignment 5 code review
			
			if (size == items.length) {
				//double size of array
				items = Arrays.copyOf(items, items.length * 2); //using this per assignment 5 code review
				//items = backArraySize(items);
				System.out.println("\n***Increase size of array***\n" + "\n New Size: " + items.length + "\n");
			} else {
				System.out.println("No need to increase size of Array yet");
			}
			
		}
		//just in case I'm not allowed to use java.util.arrays, here is a separate method to handle the doubling of the array
//		private Object[] backArraySize(Object[] someArray) {
//			
//			//create new collection with double the size as the last
//			Object[] doubledArray = new Object[someArray.length * 2];
//			//copy elements from previous collection to new collection
//			System.out.println(doubledArray.length);
//			
//			//catch the null value at the start, use it to populate the list initially
//			if (doubledArray[0] == null) {
//				for (int i = 0; i < someArray.length; i++) {
//					doubledArray[i] = someArray[i];
//				}
//			} else { //once initial nulls are changed above, continue to populate
//				for (int i = someArray.length-1; i < doubledArray.length; i++) {
//					doubledArray[i] = someArray[i];
//				}
//			}
//				
//			//send newly copied collection			
//			return doubledArray;				
//		}

		@Override
		public boolean add(int index, T item) throws IndexOutOfBoundsException {
			
			ensureCapacity(); 
			
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

		@Override
		public T remove(int index) throws IndexOutOfBoundsException {
			
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
		
	}