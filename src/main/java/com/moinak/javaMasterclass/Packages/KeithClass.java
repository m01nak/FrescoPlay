package com.moinak.javaMasterclass.Packages;

import com.moinak.javaMasterclass.Packages.code.numbers.NumberFinder;
import com.moinak.javaMasterclass.Packages.code.string.*;


//code.numbers.NumberFinder;
//code.string.ExtractString;
//code.string.*;
//code.numbers.*;
public class KeithClass {
	public String getInput(String conversation) {
		String[] unprocessedWords = conversation.split(" ");
		String[] words = new String[unprocessedWords.length];
		for (int i = 0; i < unprocessedWords.length; i++) {
			words[i] = unprocessedWords[i].replaceAll("\\.|,|\\!|\\?", "").trim();
		}

		return ExtractString.getNumeric(words) + ExtractString.getLiteral(words);
	}
}
