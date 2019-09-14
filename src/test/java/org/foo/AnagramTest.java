package org.foo;

import static org.junit.Assert.assertTrue;

import java.util.Scanner;

import org.junit.Test;

public class AnagramTest {

	// private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Test
	public void test() {

		Scanner scanner = null;

		scanner = ScannerUtility.openScanner("AnagramTestData.txt");

//		while (scanner.hasNextLine()) {
//			System.out.println(scanner.next());
//		}

		String a = scanner.next();
		String b = scanner.next();

		ScannerUtility.close(scanner);

		boolean isAnagram = isAnagram(a, b);

		System.out.println(isAnagram ? "Anagrams" : "Not Anagrams");

		assertTrue("The words are not anagrams.", isAnagram);
	}

	private boolean isAnagram(String a, String b) {

		// If the strings are not the same length, they could not be anagram anyway.

		if (a.length() != b.length()) {
			return false;
		}

		int lengthOfAnagram = a.length();

		char[] arrayA = a.toCharArray();
		char[] characters = new char[lengthOfAnagram];
		int[] countA = new int[lengthOfAnagram];

		int countOfCharsPushed = -1;

		for (char c : arrayA) {
			// find index of c in the characters
			int indexOfCinArray = -1;
			for (int counter = 0; counter < characters.length; counter++) {
				if (c == characters[counter]) {
					indexOfCinArray = counter;
					break;
				}
			}

			// if C was not found, insert it into the array
			countOfCharsPushed++;
			indexOfCinArray = countOfCharsPushed;
			// characters[indexOfCinArray] = c

			// find the existing count of C

		}

//		char[] arrayB = b.toCharArray() ; 
//		int[] countB ; 

		return true;
	}
}
