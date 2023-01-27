package com.moinak.javaMasterclass.Packages.code.string;

import com.moinak.javaMasterclass.Packages.code.numbers.NumberFinder;

public class ExtractString {
	
	public static String getNumeric(String[] words) {
		String regex = "\\d{1,}";
		String numbers = "";
		
		for(String word : words) {
			if(word.matches(regex) && NumberFinder.isKeith(word) && NumberFinder.isPrime(word)) {
				numbers += word;
			}
		}
		return numbers;
	}
	
	public static String getLiteral(String[] words) {
		int sum = 0;
		
		for(String word : words) {
			if(word.toLowerCase().matches("one")) {
				sum += 1;
			} else if(word.toLowerCase().matches("two")) {
				sum += 2;
			} else if(word.toLowerCase().matches("three")) {
				sum += 3;
			} else if(word.toLowerCase().matches("four")) {
				sum += 4;
			} else if(word.toLowerCase().matches("five")) {
				sum += 5;
			} else if(word.toLowerCase().matches("six")) {
				sum += 6;
			} else if(word.toLowerCase().matches("seven")) {
				sum += 7;
			} else if(word.toLowerCase().matches("eight")) {
				sum += 8;
			} else if(word.toLowerCase().matches("nine")) {
				sum += 9;
			} 
		}
		System.out.println("sum: " + sum);
		return String.valueOf(sum);
	}
}
