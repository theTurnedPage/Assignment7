package com.coderscampus.assignment7;

public class CustomListApplication {

	public static void main(String[] args) {
		
		CustomArrayList<String> testList = new CustomArrayList<String>();
		
		for (int i = 0; i < 40; i++) {
			testList.add("String " + i);
			//System.out.println(testList.get(i));
		}
		//add element
		testList.add(1, "99");
		
		for (int i = 0; i < testList.getSize(); i++) {		
			System.out.println("Element: " + testList.get(i));
		}			
		
		testList.remove(40);
		//remove element added earlier
		System.out.println("\nIndex 1 Element: " + testList.get(1));
		//after removal of element
		System.out.println("\nNew size of list: " + testList.getSize());
	}

}
