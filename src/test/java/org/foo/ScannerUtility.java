package org.foo;

import java.util.Scanner;

public class ScannerUtility {

	public static void close(Scanner scanner) {
		if (scanner != null) {
			scanner.close();
		}
	}

	public static Scanner openScanner(String fileName) {
		Scanner scanner;
		ClassLoader classLoader = ScannerUtility.class.getClassLoader();
		scanner = new Scanner(classLoader.getResourceAsStream(fileName));
		return scanner;
	}

}
