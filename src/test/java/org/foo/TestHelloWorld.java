package org.foo;

import static org.junit.Assert.fail;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

public class TestHelloWorld {

	private static final Logger logger = LogManager.getLogger(TestHelloWorld.class);

	@Test
	public void test() {

		logger.debug("Hello from the Junit test.");

		fail("Not yet implemented");
	}

}
