package com.moinak.javaMasterclass.Regex;

import java.util.ArrayList;
import java.util.List;

public class RegEx {
	public static void main(String[] args) {
		String text = "Manager: Good morning, sir. How can I help you?\n"
				+ "Customer: Sir, the card names in my cards have got scratched, and I am unable to find their types. Would you be able to help me find the type using the card numbers, please?\n"
				+ "Manager: What are the types of cards you have, sir?\n"
				+ "Customer: I have Visa, American Express, Discover, and JCB cards.\n"
				+ "Manager: Okay, sir. Can I have your account number and mobile number?\n"
				+ "Customer: My account number is 1356798988878, and my mobile number is 8765465743.\n"
				+ "Manager: Can you tell me the card numbers, sir?\n"
				+ "Customer: The card numbers are 4769856453217,\n"
				+ "340987687654689, 213189796876789, 6011675489757876, and 3589797987979879.\n"
				+ "Manager: Please wait a minute, sir.\n"
				+ "Customer: There are two other cards as well. The numbers are 4654465765767878 and 6589456879087568.\n"
				+ "Manager: Please give me a minute, sir.";
		String cardType = "Credit";
		
		System.out.println(findCardTypeNumbers(text, cardType));
		
	}

	public static String findCardTypeNumbers(String conversation, String cardType) {

		cardType = cardType.toLowerCase();
		List<String> regex = new ArrayList<String>();
		String result = "Not a valid card type";
		int type = 0;
		
		switch (cardType) {
		case ("visa"):
			type = 1;
			regex.add("^4\\d{12}");
			regex.add("^4\\d{15}");
			break;
		case ("american express"):
			type = 2;
			regex.add("^(34)\\d{13}");
			regex.add("^(37)\\d{13}");
			break;
		case ("discover"):
			type = 3;
			regex.add("^(6011)\\d{12}");
			regex.add("^(65)\\d{14}");
			break;
		case ("jcb"):
			type = 4;
			regex.add("^(2131)\\d{11}");
			regex.add("^(1800)\\d{11}");
			regex.add("^(35)\\d{14}");
			break;
		default:
			break;
		}

		if (type != 0) {
			result = getMatches(conversation, regex);
		}
		
		return result.trim();
	}

	private static String getMatches(String text, List<String> regex) {
		
		String[] words = text.split(" ");
		List<String> numbers = getNumbers(words);
		String result = "";
		
		for(String number : numbers) {
			for(String pattern : regex) {
				if(number.matches(pattern)) {
					result += number + " "; 
				}
			}
		}
		
		return result;
	}
	
	private static List<String> getNumbers(String[] words) {
		List<String> numbers = new ArrayList<String>();
		String cleanedWord = null;
		
		
		for(int i=0; i<words.length; i++) {
			String digitOnlyRegex = "\\d{1,}";
			String nonDigitRegex = "\\D";
			cleanedWord = words[i].replaceAll(nonDigitRegex, "").trim();
			if(cleanedWord.matches(digitOnlyRegex)) {
				numbers.add(cleanedWord);
			}
		}
		
		return numbers;
	}

}
