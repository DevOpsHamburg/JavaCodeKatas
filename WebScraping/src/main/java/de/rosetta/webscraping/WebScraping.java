package de.rosetta.webscraping;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class WebScraping
{
    public static void main(final String[] args) throws Exception
    {
        String timeInUTC = getUTCTime("https://tycho.usno.navy.mil/cgi-bin/timer.pl");
        System.out.println(timeInUTC);
    }

    public static String getUTCTime(String url) throws Exception
    {
        String result = null;
        URL tycho = new URL(url);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(tycho.openStream())
        );
        String inputLine;
        while ((inputLine = in.readLine()) != null)
        {
            if (inputLine.contains("UTC"))
            {
                int begin = inputLine.indexOf('>') + 1;
                int end = inputLine.indexOf(" UTC");
                result = inputLine.substring(begin, end);
            }
        }
        in.close();

        return result;
    }
}
