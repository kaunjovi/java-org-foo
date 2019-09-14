package org.foo.webscraper;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestJsoup {

	private static final Logger logger = LoggerFactory.getLogger(TestJsoup.class);

	@Test
	public void test() throws IOException {

		Document doc = Jsoup.connect("http://en.wikipedia.org/").get();
		logger.debug(doc.title());

		Elements newsHeadlines = doc.select("#mp-itn b a");
		for (Element headline : newsHeadlines) {
//			log("%s\n\t%s", headline.attr("title"), headline.absUrl("href"));
			System.out.println(headline.attr("title"));
			logger.debug(headline.attr("title"));
			logger.info(headline.absUrl("href"));
		}

		// fail("Not yet implemented");
	}

}
