package org.foo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class HelloWorld {

	static Logger logger = LogManager.getLogger(HelloWorld.class);

	// This is the main method.
	public static void main(String[] args) {

		// logging is critical
		logger.debug("Hello world.");

	}
}
