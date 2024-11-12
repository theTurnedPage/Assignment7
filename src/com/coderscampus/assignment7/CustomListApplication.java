package com.coderscampus.assignment7;

public class CustomListApplication {

	public static void main(String[] args) {
		
		CustomArrayList<String> testList = new CustomArrayList<String>();
		
		for (int i = 0; i < 40; i++) {
			testList.add("String " + i);
			//System.out.println(testList.get(i));
		}
		
		for (int i = 0; i < 40; i++) {		
			System.out.println("Element: " + testList.get(i));
		}			
	}

}
