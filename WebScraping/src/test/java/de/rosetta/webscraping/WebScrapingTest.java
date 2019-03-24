package de.rosetta.webscraping;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.junit.Assert.*;

import com.github.tomakehurst.wiremock.junit.WireMockRule;
import org.junit.Rule;
import org.junit.Test;

public class WebScrapingTest
{
    @Rule
    public WireMockRule wireMockRule = new WireMockRule(8089);

    @Test
    public void testUTCTime() throws Exception
    {
        String testBody = "LINE1\n<BR>Mar. 12, 04:40:21 UTC\n LINE3\n";
        stubFor(get(urlEqualTo("/cgi-bin/timer.pl"))
                .willReturn(aResponse()
                        .withHeader("Content-Type", "text/plain")
                        .withBody(testBody)));
        String utcTime = null;
        utcTime = WebScraping.getUTCTime("http://localhost:8089/cgi-bin/timer.pl");
        assertEquals("Mar. 12, 04:40:21", utcTime); // utcTime);
    }
}
