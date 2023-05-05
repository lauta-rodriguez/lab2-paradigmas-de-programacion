package httpRequest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/* Esta clase se encarga de realizar efectivamente el pedido de feed al servidor de noticias
 * Leer sobre como hacer una http request en java
 * https://www.baeldung.com/java-http-request
 * */

public class httpRequester {

	public String getFeed(String urlFeed, String urlType) {
		String feed = null;

		if (urlType.equals("rss")) {
			feed = getFeedRss(urlFeed);
		} else if (urlType.equals("reedit")) {
			feed = getFeedReedit(urlFeed);
		}

		return feed;
	}

	public String getFeedRss(String urlFeed) {
		String feedRssXml = "";

		try {
			URL url = new URL(urlFeed);
			URLConnection urlConnection = url.openConnection(); // creating a urlconnection object

			// wrapping the urlconnection in a bufferedreader
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

			// reading from the urlconnection using the bufferedreader
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				feedRssXml = feedRssXml + line + "\n";
			}
			bufferedReader.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}

		return feedRssXml;
	}

	public String getFeedReedit(String urlFeed) {
		String feedReeditJson = null;
		return feedReeditJson;
	}

	public static void main(String[] args) {
		System.out.println("httpRequesterClass");
		httpRequester h = new httpRequester();
		String feedRssXml = h.getFeedRss("https://rss.nytimes.com/services/xml/rss/nyt/World.xml");
		System.out.println(feedRssXml);
	}

}
