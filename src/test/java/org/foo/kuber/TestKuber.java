package org.foo.kuber;

import static org.junit.Assert.fail;

import java.io.File;
import java.net.URL;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

public class TestKuber {

	private static final Logger logger = LogManager.getLogger(TestKuber.class);

	@Test
	public void test() {

		logger.debug("Hello from the Junit test.");

		// Read raw data
		URL url = getClass().getResource("/data/raw/MTO/MTO_26022021.DAT");
		File file = new File(url.getPath());
		logger.debug("{}", file.getAbsolutePath());

		fail("Not yet implemented");
	}

}
