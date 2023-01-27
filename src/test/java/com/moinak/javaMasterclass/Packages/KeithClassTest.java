package com.moinak.javaMasterclass.Packages;

import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.*;

public class KeithClassTest {

	KeithClass keithObj;

	@Before
	public void setUp() throws Exception {
		keithObj = new KeithClass();
	}

	@Test
	public void importTest() throws IOException {
		File file = new File("src/main/java/com/moinak/javaMasterclass/Packages/KeithClass.java");

		String line, s = "";
		FileReader fileRead = new FileReader(file);
		BufferedReader bufferRead = new BufferedReader(fileRead);
		while ((line = bufferRead.readLine()) != null)
			s += line;

		if (s.contains("code.numbers.NumberFinder;")
				&& (s.contains("code.string.ExtractString;") || s.contains("code.string.*;"))) {
			assertEquals(0, 0);
		} else if (s.contains("code.string.ExtractString;")
				&& (s.contains("code.numbers.*;") || s.contains("code.numbers.NumberFinder;"))) {
			assertEquals(0, 0);
		} else
			assertEquals(0, 1);
	}

	@Test
	public void packageTest() {
		File f1 = new File("src/main/java/com/moinak/javaMasterclass/Packages/code/numbers/NumberFinder.java");
		File f2 = new File("src/main/java/com/moinak/javaMasterclass/Packages/code/string/ExtractString.java");

		if (f1.isFile() && f2.isFile())
			assertEquals(0, 0);
		else
			assertEquals(0, 1);
	}
	
	@Test
	public void getInputTest0() {
		String actual = keithObj.getInput("A: Hello, Priya 3 speaking. Is this Aditi? B: Yeah Priya!\n"
				+ "I am there 28. A: How are you dear? B: I am fine 19.\n"
				+ "What about you Priya 75? A: Glad to hear that! Me too fine! seven. Aditi how are your five holidays going? B:\n"
				+ "Great Priya! I am enjoying well!");
		System.out.println("0: " + actual);

	}

	@Test
	public void getInputTest1() {
		String expected = "2074622162";
		String actual = keithObj.getInput(
				"A: Hello, may I speak to Alice 14 please?  four B: This is she. How's it 19 going? A: I've been trying to call you 28 times all day B: Sorry about that. I was cleaning up 47. A: It's okay 61. B: So what were you calling 75 me about? A: Oh, I just wanted to see if you wanted to hang out 197 tomorrow. B: Sure, what did you want to do? A: Maybe we can go see a movie or something. B: That sounds like fun. Let's do it. A: I'll see you 7ytr4fhh6 tomorrow then. five B: See you then. Goodbye.");
		System.out.println("1: " + actual);
		assertEquals(expected, String.valueOf(actual.hashCode()));
	}

	@Test
	public void getInputTest2() {
		String expected = "635190962";
		String actual = keithObj.getInput(
				"A: Hi, how are you 742. Is Alice there? B: 1104 Speaking. What's up? A: Why haven't you answered 1537 the phone? B: My bad, I had two chores to do. A: That's all right. B: What was the reason for your call? A: I want to do something tomorrow with you. B: Sounds good. What did you have in mind? A: I was thinking about seeing a one movie. B: Okay, let's go see a movie. A: Until then. B: Talk to you later.");
		System.out.println("2: " + actual);
		assertEquals(expected, String.valueOf(actual.hashCode()));

	}

	@Test
	public void getInputTest3() {
		String expected = "279085604";
		String actual = keithObj.getInput(
				"A: Is Alice available? B: You're talking 2208 to her. A: I've called you a nine times today. B: I was busy doing something 2580. I apologize. A: No problem. B: Did you need 2345 something? A: Do you want to do something 48 tomorrow? B: Is there somewhere special you wanted 76 to go? A: How about a movie? B: A movie sounds good. A: Call me tomorrow three times then. B: I will see you tomorrow.");
		System.out.println("3: " + actual);
		assertEquals(expected, String.valueOf(actual.hashCode()));

	}
	
}